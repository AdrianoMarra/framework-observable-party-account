package framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Default {

	public static ITransactionManager transactionManager = new TransactionManager();

	public static List<IAccount> accs = new ArrayList<>();
	public static List<ICustomer> customers = new ArrayList<>();

	public static void main(String[] args) 
	{		
		IFactory f = AccountBuilder.getFactoryAccount("");
		ICustomer c = f.createCustomer("");
		customers.add(c);

		accs.add(c.getListAccount().get(c.getListAccount().size() - 1));
		
		ITransaction transaction = new Transaction();
		ITransaction proxy = new TransactionProxy(transaction);

		transactionManager.setTransaction(proxy);
		transactionManager.execute(c.getListAccount().get(0));
				
		IInterestManager interestManager = new InterestManager(accs);
		interestManager.notifyAccounts();
		
		IReport report = new Report(customers);
		report.generateReport(new Date());	
		System.out.println("Executed");
	}

	public void createAccount(String type, String customer) {

	}

	public void executeTransaction(String type, double amount) {

	}

	public void generateReports() 
	{

	}

}
