package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
    	
    	AccountHolder bank1 = new AccountHolder("Ali", "Mast ", 1);
    	AccountHolder bank2 = new AccountHolder("Dani", "Mast ", 2);
    	StrictBankAccount bali  = new StrictBankAccount(bank1.getUserID(), 10000, 10);
    	StrictBankAccount bdani  = new StrictBankAccount(bank2.getUserID(), 10000, 10);
    	
    	try {
    		bali.withdraw(2, 5000);
    	} catch(WrongAccountHolderException e) {
    		System.out.println("usr sbagliato");
    		};
    	}
    	//bali.withdraw(1, 50000);
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    
}
