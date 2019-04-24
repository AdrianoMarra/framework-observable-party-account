package banking.models;

import java.util.HashMap;

import framework.models.CustomerAccountFactory;
import framework.models.IAccount;
import framework.models.ICustomer;

public class CompanyCheckingsFactory extends CustomerAccountFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Company(customerData);
	}

	@Override
	public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
		return new CheckingsAccount(accountData, customer);
	}

}
