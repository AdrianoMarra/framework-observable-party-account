package bank.model;

import java.util.HashMap;

import framework.CustomerAccountFactory;
import framework.IAccount;
import framework.ICustomer;

public class CompanySavingsFactory extends CustomerAccountFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Company(customerData);
	}

	@Override
	public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
		return new SavingsAccount(accountData, customer);
	}

}
