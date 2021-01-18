package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
    	AccountHolder pers1 = new AccountHolder("Ali", "Mastrilli", 1);
    	AccountHolder pers2 = new AccountHolder("Mario", "Rossi", 2);
    	StrictBankAccount ali = new StrictBankAccount(1, 10000, 10);
    	StrictBankAccount mario = new StrictBankAccount(2, 10000, 10);
    	
    	
    	ali.deposit(1, 5000);
    	mario.withdraw(2, 50000);
    	ali.deposit(3, 1);
    	
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
}
