package banking.models;

import framework.models.Transaction;

public class BankTransaction extends Transaction {
	
	BankAccount ba;
	
	public BankTransaction(BankAccount account, double amount) {
		super(account, amount);
		ba = account;
	}
	
	@Override
	public Transaction getTransaction() {
		return this;
	}
	
	@Override
	public BankAccount getAccount() {
		return ba;
	}
}
