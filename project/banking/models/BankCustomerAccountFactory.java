package banking.models;

import java.util.HashMap;
import framework.models.CustomerAccountFactory;

public class BankCustomerAccountFactory extends CustomerAccountFactory {

	@Override
	public BankCustomer createCustomer(HashMap<String, String> customerData) {
		return new BankCustomer(customerData);
	}

	public BankAccount createAccount(HashMap<String, String> accountData, BankCustomer customer) {
		return new BankAccount(accountData, customer);
	}
	
}
