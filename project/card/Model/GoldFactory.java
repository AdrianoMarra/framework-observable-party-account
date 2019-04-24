package card.Model;

import framework.IAccount;
import framework.ICustomer;

import java.util.HashMap;

public class GoldFactory implements framework.IFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	@Override
	public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
		return new GoldAccount(accountData, customer);
	}

}
