package card.Model;

import framework.IAccount;
import framework.IEmailManager;
import framework.ITransaction;
import framework.Transaction;
import framework.TransactionProxy;

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
