package framework;

import java.util.Date;

public class Transaction implements ITransaction {

	private double amount;
	private Date date;
	private IAccount currentAccount;
	
	
	public Transaction(IAccount account, double amount) {
		this.currentAccount = account;
		this.amount = amount;
		this.date = new Date();
	}
	
	@Override
	public boolean executeTransaction()
	{		
		System.out.println("Transaction Command Executed");
		currentAccount.setBalance(currentAccount.getBalance() + amount);		
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

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public double getAmount() {
		return amount;
	}

}
