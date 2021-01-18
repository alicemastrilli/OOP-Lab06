package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionsOverQuotaException() {
		super();
		System.out.println("Limite superato");
		// TODO Auto-generated constructor stub
	}
	
}
