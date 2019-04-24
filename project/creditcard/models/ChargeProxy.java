package creditcard.models;

import framework.models.IAccount;
import framework.models.IEmailManager;
import framework.models.ITransaction;
import framework.models.Transaction;
import framework.models.TransactionProxy;

public class ChargeProxy extends TransactionProxy {

	public ChargeProxy(ITransaction transaction) {
		super(transaction);
	}

	@Override
	public boolean executeTransaction() {
		transaction.executeTransaction();
		if (getAmount() > 400) 
			this.Post();
		
		System.out.println("Transaction Proxy Executed");
		return true;
	}
	
	@Override
	public void Post() {
		IEmailManager.sendEmail("Because the amount is greater than 400...");
	}

}
