package banking.models;

import java.util.HashMap;

public class PersonalCheckingsFactory extends BankCustomerAccountFactory {

	@Override
	public BankCustomer createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	@Override
	public BankAccount createAccount(HashMap<String, String> accountData, BankCustomer customer) {
		return new CheckingsAccount(accountData, customer);
	}

}
