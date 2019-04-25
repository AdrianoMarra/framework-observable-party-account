package framework.models;

import java.util.HashMap;

public class CustomerAccountFactory implements ICustomerAccountFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Customer(customerData);
	}

	@Override
	public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
		return new Account(accountData, customer);
	}

}
