package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Account;
import framework.IAccount;
import framework.ITransaction;

public class SavingsAccount extends Account {
	
	public SavingsAccount(HashMap<String, String> accountData) {
		super(accountData);
		super.setInterest(10);
	}

	@Override
	public void addInterest() {		
		double interest = super.getInterest();
		double balance = super.getBalance();
		double newBalance = ((interest/100) * balance) + balance;

		super.setBalance(newBalance);
	}
}
