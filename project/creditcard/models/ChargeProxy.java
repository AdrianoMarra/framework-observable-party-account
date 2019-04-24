package creditcard.models;

import framework.models.IAccount;
import framework.models.IEmailManager;
import framework.models.ITransaction;
import framework.models.Transaction;
import framework.models.TransactionProxy;

public class ChargeProxy extends CreditCardTransaction {

	private CreditCardTransaction transaction;

	public ChargeProxy(CreditCardTransaction transaction, CreditCardAccount account, double amount) {
		super(account, amount);
		this.transaction = transaction;
	}

	@Override
	public boolean executeTransaction() {
		transaction.executeTransaction();
		if (getAmount() > 400)
			this.Post();

		System.out.println("Transaction Proxy Executed");
		return true;
	}

	public void Post() {
		IEmailManager.sendEmail("Executing\n Email sent because the amount is greater than 400!!");
	}

}
