package banking.models;
import framework.models.IEmailManager;

public class AccountWithdrawProxy extends BankTransaction {

	private BankTransaction bt;
	
	public AccountWithdrawProxy(BankTransaction transaction) {
		super(transaction.getAccount(), transaction.getAmount());
		bt = transaction;
	}

	@Override
	public boolean executeTransaction() {
		
		boolean resp = false;
		
		if (bt.executeTransaction()) {
			double amount = bt.getAmount();
			
			BankAccount acc = bt.getAccount();
			if (acc.getCustomer() instanceof Person) {
				SendPersonalDepositEmail(amount, acc);
			} else {
				SendCompanyDepositEmail(amount, acc);
			}
		}
		
		return resp;
	}
	
	public void SendCompanyDepositEmail(double amount, BankAccount account) 
	{
		IEmailManager.sendEmail("Company email: "+ account.getCustomer().getEmail()+"\n Account Number: " + account.getAccNumber() + "\n transaction amount: " + " -"+amount);		
	}
	
	public void SendPersonalDepositEmail(double amount, BankAccount account) 
	{
		if (account.getBalance() < 0) {
			IEmailManager.sendEmail("Person email: "+ account.getCustomer().getEmail()+ "Account Number: " + account.getAccNumber() + "\ntransaction amount: " + " -"+amount + "\n your balance now is in: "+ account.getBalance());		
		}
	}
}
