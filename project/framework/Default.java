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
		IFactory factory = AccountBuilder.getFactoryAccount("");
		ICustomer customer = factory.createCustomer("");

		customers.add(customer);
		
		accs.add(customer.getListAccount().get(customer.getListAccount().size() - 1));
		
		//Proxy pattern
		ITransaction transaction = new Transaction(customer.getListAccount().get(0));
		transaction = new TransactionProxy(transaction);
		
		// Command pattern
		transactionManager.setTransaction(transaction);
		transactionManager.execute();
		
		// Observer pattern		
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
