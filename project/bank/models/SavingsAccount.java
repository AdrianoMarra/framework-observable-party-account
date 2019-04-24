package bank.models;

import java.util.HashMap;
import java.util.List;

import framework.models.Account;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.ITransaction;

public class SavingsAccount extends Account {
	
	public SavingsAccount(HashMap<String, String> accountData, ICustomer customer) {
		super(accountData, customer);
		super.setInterest(10);
	}
}
