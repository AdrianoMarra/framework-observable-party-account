package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Account;
import framework.IAccount;
import framework.ITransaction;

public class CheckingsAccount extends Account {

	public CheckingsAccount(HashMap<String, String> accountData) {
		super(accountData);
	}

	@Override
	public void addInterest() {
		double interest = super.getInterest();
		double balance = super.getBalance();
		double newBalance = ((interest/100) * balance) + balance;

		super.setBalance(newBalance);
	}
}
