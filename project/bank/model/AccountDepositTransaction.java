package bank.model;

import framework.IAccount;
import framework.Transaction;

public class AccountDepositTransaction extends Transaction {

	public AccountDepositTransaction(IAccount account, double amount) {
		super(account, amount);
	}
	
	@Override
	public boolean executeTransaction()
	{		
		super.getAccount().setBalance(super.getAccount().getBalance() + super.getAmount());		
		super.getAccount().addTransaction(this);
		return true;
	}
	
}