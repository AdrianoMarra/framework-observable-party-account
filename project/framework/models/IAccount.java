package framework.models;

import java.util.Date;
import java.util.List;

public interface IAccount 
{
	void addTransaction(ITransaction transaction);
	
	void addInterest();	

	List<ITransaction> getTransactions();

	void setTransactions(List<ITransaction> transactions);

	String getAccNumber();

	void setAccNumber(String accNumber);

	double getBalance();

	void setBalance(double balance);
	
	void setInterest(double interest);

	double getInterest();

	ICustomer getCustomer();

	void setCustomer(ICustomer customer);

	public String report(Date date);

}
