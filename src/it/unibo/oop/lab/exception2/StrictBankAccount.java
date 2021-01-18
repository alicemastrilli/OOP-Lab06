package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

    private final int usrID;
    private double balance;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param maximumAllowedAtmTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int maximumAllowedAtmTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.maximumAllowedATMTransactions = maximumAllowedAtmTransactions;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void deposit(final int usrID, final double amount) {
        
        	try {
				checkUser(usrID);
			} catch (WrongAccountHolderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.balance += amount;
            increaseTransactionsCount();
        
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void withdraw(final int usrID, final double amount) {
        try {
			isWithdrawAllowed(amount);
		} catch (NotEnoughFoundsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        	try {
				checkUser(usrID);
			} catch (WrongAccountHolderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.balance -= amount;
            increaseTransactionsCount();
        }
    

    /**
     * 
     * {@inheritDoc}
     */
    public void depositFromATM(final int usrID, final double amount) {
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
            increaseTransactionsCount();
        }
    }

    /**
     * 
     * {@inheritDoc}
     * @throws TransactionsOverQuotaException 
     */
    public void withdrawFromATM(final int usrID, final double amount) throws TransactionsOverQuotaException {
    	if(totalTransactionCount > maximumAllowedATMTransactions) {
    		throw new TransactionsOverQuotaException();
    	}
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getTransactionCount() {
        return totalTransactionCount;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     */
    public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (totalTransactionCount * StrictBankAccount.TRANSACTION_FEE);
        	try {
				isWithdrawAllowed(feeAmount);
			} catch (NotEnoughFoundsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	try {
				checkUser(usrID);
			} catch (WrongAccountHolderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            balance -= MANAGEMENT_FEE + totalTransactionCount * StrictBankAccount.TRANSACTION_FEE;
            totalTransactionCount = 0;
        }
    

    private void checkUser(final int id) throws WrongAccountHolderException {
        if( this.usrID != id) {
        	throw new WrongAccountHolderException();
        };
    }

    private void isWithdrawAllowed(final double amount) throws NotEnoughFoundsException {
        if( balance < amount) {
        	throw new NotEnoughFoundsException();
        };
    }

    private void increaseTransactionsCount() {
        totalTransactionCount++;
    }
}
