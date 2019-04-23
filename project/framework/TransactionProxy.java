package framework;

public class TransactionProxy implements ITransaction {

	public ITransaction transaction;

	public TransactionProxy(ITransaction transaction) {
		this.transaction = transaction;
	}
	
	@Override
	public boolean executeTransaction() 
	{		
		transaction.executeTransaction();
		Post();		
		System.out.println("Transaction Proxy Executed");		
		return true;
	}
	
	public void Post() 
	{
		IEmailManager.sendEmail("");		
	}

	@Override
	public IAccount getAccount() {
		return transaction.getAccount();
	}

	@Override
	public void setAccount(IAccount account) {
		transaction.setAccount(account);
		
	}

	@Override
	public double getAmount() {
		return transaction.getAmount();
	}
}
