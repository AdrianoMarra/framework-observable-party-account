package banking.models;

import framework.models.IAccount;
import framework.models.ITransaction;
import framework.models.Transaction;

public class AccountWithdrawTransaction extends Transaction {

	public AccountWithdrawTransaction(IAccount account, double amount) {
		super(account, amount);
	}

	@Override
	public boolean executeTransaction()
	{		
		super.getAccount().setBalance(super.getAccount().getBalance() - super.getAmount());		
		super.getAccount().addTransaction(this);
		return true;
	}
}
