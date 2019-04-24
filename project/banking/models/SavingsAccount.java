package banking.models;

import java.util.HashMap;

public class SavingsAccount extends BankAccount {
	
	public SavingsAccount(HashMap<String, String> accountData, BankCustomer customer) {
		super(accountData, customer);
		super.setInterest(10);
	}
}
