package banking.models;

import java.util.HashMap;

public class CheckingsAccount extends BankAccount {

	public CheckingsAccount(HashMap<String, String> accountData, BankCustomer customer) {
		super(accountData, customer);
		super.setInterest(5);
	}
}
