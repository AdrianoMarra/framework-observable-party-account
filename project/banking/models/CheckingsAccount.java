package banking.models;

import java.util.HashMap;
import java.util.List;

import framework.models.Account;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.ITransaction;

public class CheckingsAccount extends Account {

	public CheckingsAccount(HashMap<String, String> accountData, ICustomer customer) {
		super(accountData, customer);
		super.setInterest(5);
	}
}
