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
		super.setInterest(10);
	}
}
