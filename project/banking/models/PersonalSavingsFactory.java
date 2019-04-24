package banking.models;

import java.util.HashMap;

import framework.models.CustomerAccountFactory;
import framework.models.IAccount;
import framework.models.ICustomer;

public class PersonalSavingsFactory extends CustomerAccountFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	@Override
	public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
		return new SavingsAccount(accountData, customer);
	}

}
