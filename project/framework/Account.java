package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.DoublePredicate;

public class Account implements IAccount {
	private List<ITransaction> transactions = new ArrayList<>();

	private String accNumber;
	private double balance;
	private double interest = 0;

	public Account(HashMap<String, String> map) {
		this.accNumber = map.get("accNumber");
		this.interest = Double.parseDouble(map.get("interest"));
		this.balance = 0;
	}

	public List<ITransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<ITransaction> transactions) {
		this.transactions = transactions;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void addInterest() {
	}
	
	@Override
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	@Override
	public double getInterest() {
		return this.interest;
	}

	@Override
	public void addTransaction(ITransaction transaction) {
		transactions.add(transaction);
	}
}
