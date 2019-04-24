package creditcard.models;

import framework.models.IAccount;
import framework.models.Transaction;

public class Deposit extends CreditCardTransaction {
	public Deposit(CreditCardAccount account, double amount) {
		super(account, amount);
	}

	@Override
	public boolean executeTransaction() {
		System.out.println("Transaction Command Executed");
		getAccount().setBalance(getAccount().getBalance() - getAmount());
		getAccount().addTransaction(this);
		return true;
	}
}
