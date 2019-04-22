package framework;

import java.util.HashMap;

public class CustomerAccountFactory implements IFactory {

	@Override
	public ICustomer createCustomer(HashMap<String, String> customerData) {
		return new Customer(customerData);
	}

	@Override
	public IAccount createAccount(String accNum) {
		return new Account();
	}

}
