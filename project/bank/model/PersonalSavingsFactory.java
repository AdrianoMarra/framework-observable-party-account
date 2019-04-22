package bank.model;

import java.util.HashMap;

import framework.CustomerAccountFactory;
import framework.IAccount;
import framework.ICustomer;

public class PersonalSavingsFactory extends CustomerAccountFactory {
	

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	@Override
	public IAccount createAccount(String accNumber) {
		return new SavingsAccount();
	}
	
}
