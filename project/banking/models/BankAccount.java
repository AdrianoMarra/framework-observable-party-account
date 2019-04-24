package banking.models;

import java.util.HashMap;
import framework.models.Account;

public class BankAccount extends Account {

	public BankAccount(HashMap<String, String> map, BankCustomer customer) {
		super(map, customer);
	}
}
