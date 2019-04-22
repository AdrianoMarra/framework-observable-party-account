package framework;

import java.util.Date;

public class Transaction implements ITransaction {

	private double amount;
	private Date date;
 
	@Override
	public boolean executeTransaction(IAccount account)
	{		
		System.out.println("Transaction Command Executed");
		return true;
	}

}
