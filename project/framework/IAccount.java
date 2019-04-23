package framework;

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
	
	public void setInterest(Integer interest);

	public double getInterest();

}
