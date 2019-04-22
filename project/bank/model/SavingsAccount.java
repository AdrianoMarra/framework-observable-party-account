package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.IAccount;
import framework.ITransaction;

public class SavingsAccount implements IAccount {

	public SavingsAccount(HashMap<String, String> accountData) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTransaction(ITransaction transaction) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ITransaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransactions(List<ITransaction> transactions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAccNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccNumber(String accNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		
	}

}
