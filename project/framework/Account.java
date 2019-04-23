package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.DoublePredicate;

public class Account implements IAccount {
	private List<ITransaction> transactions = new ArrayList<>();

	private ICustomer customer;
	private String accNumber;
	private double balance;
	private double interest = 2;

	public Account(HashMap<String, String> map, ICustomer customer) {
		this.accNumber = map.get("accNumber");
		this.customer = customer;
 		this.balance = 0;
 		customer.addAccount(this);
	}

	@Override
	public List<ITransaction> getTransactions() {
		return transactions;
	}

	@Override
	public void setTransactions(List<ITransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String getAccNumber() {
		return accNumber;
	}

	@Override
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	
	@Override
	public void addInterest() { 
		double newBalance = ((interest / 100) * balance) + balance;
		this.balance = newBalance;
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
