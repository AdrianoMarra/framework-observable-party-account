package card.models;

import framework.models.IAccount;
import framework.models.Transaction;

public class Charge extends Transaction {
	public Charge(IAccount account, double amount) {
		super(account, amount);
	}

	@Override
	public boolean executeTransaction() {
		System.out.println("Transaction Command Executed");
		getAccount().setBalance(getAccount().getBalance() + super.getAmount());
		getAccount().addTransaction(this);
		return true;
	}
}
