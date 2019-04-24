package banking.models;

public class AccountWithdrawTransaction extends BankTransaction {

	public AccountWithdrawTransaction(BankAccount account, double amount) {
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
