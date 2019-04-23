package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Account;
import framework.IAccount;
import framework.ICustomer;
import framework.ITransaction;

public class SavingsAccount extends Account {
	
	public SavingsAccount(HashMap<String, String> accountData, ICustomer customer) {
		super(accountData, customer);
		super.setInterest(10);
	}
}
