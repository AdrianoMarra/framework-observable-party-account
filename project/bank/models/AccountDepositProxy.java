package bank.models;

import framework.models.IAccount;
import framework.models.IEmailManager;
import framework.models.ITransaction;
import framework.models.TransactionProxy;

public class AccountDepositProxy extends TransactionProxy {

	public AccountDepositProxy(ITransaction transaction) {
		super(transaction);
	}

	@Override
	public boolean executeTransaction() {
		
		boolean resp = false;
		
		if (super.getTransaction().executeTransaction()) {
			double amount = super.getTransaction().getAmount();
			
			IAccount acc = super.getTransaction().getAccount();
			if (acc.getCustomer() instanceof Person) {
				SendPersonalDepositEmail(amount, acc);
			} else {
				SendCompanyDepositEmail(amount, acc);
			}
		}
		
		return resp;
	}
	
	public void SendCompanyDepositEmail(double amount, IAccount account) 
	{
		IEmailManager.sendEmail("Company email: "+ account.getCustomer().getEmail()+"\n Account Number: " + account.getAccNumber() + "\n transaction amount: " + " +"+amount);		
	}
	
	public void SendPersonalDepositEmail(double amount, IAccount account) 
	{
		if (amount > 500) {
			IEmailManager.sendEmail("Person email: "+ account.getCustomer().getEmail()+ "Account Number: " + account.getAccNumber() + "\ntransaction amount: " + " +"+amount);		
		}
	}
}
