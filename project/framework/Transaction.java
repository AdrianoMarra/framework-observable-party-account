package framework;

import java.util.Date;

public class Transaction implements ITransaction {

	private double amount;
	private Date date;
	private IAccount currentAccount;
	
	
	public Transaction(IAccount account) {
		currentAccount = account;
	}
	
	@Override
	public boolean executeTransaction()
	{		
		System.out.println("Transaction Command Executed");
		currentAccount.addTransaction(this);
		return true;
	}

	@Override
	public IAccount getAccount() {
		return currentAccount;
	}

	@Override
	public void setAccount(IAccount account) {
		currentAccount = account;
	}

}
