package card.Model;

import framework.IAccount;
import framework.Transaction;

public class Deposit extends Transaction {
    public Deposit(IAccount account, double amount) {
        super(account, amount);
    }    
	
	@Override
	public boolean executeTransaction()
	{		
		System.out.println("Transaction Command Executed");
		super.getAccount().setBalance(super.getAccount().getBalance() - super.getAmount());		
		super.getAccount().addTransaction(this);
		return true;
	}
}
