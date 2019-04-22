package framework;

public class TransactionProxy implements ITransaction {

	public ITransaction transaction;

	public TransactionProxy(ITransaction transaction) {
		this.transaction = transaction;
	}

 
	@Override
	public boolean executeTransaction(IAccount account) 
	{		
		transaction.executeTransaction(account);
		Post();		
		System.out.println("Transaction Proxy Executed");		
		return true;
	}
	
	public void Post() 
	{
		IEmailManager.sendEmail("");		
	}

}
