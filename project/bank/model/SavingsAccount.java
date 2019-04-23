package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Account;
import framework.IAccount;
import framework.ITransaction;

public class SavingsAccount extends Account {

	public SavingsAccount(HashMap<String, String> accountData) {
		super(accountData);
	}

	@Override
	public void addInterest() {
		super.setInterest(5);
	}
}
