package creditcard.models;

import framework.models.IAccount;
import framework.models.Transaction;

public class Charge extends CreditCardTransaction {
	public Charge(CreditCardAccount account, double amount) {
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
