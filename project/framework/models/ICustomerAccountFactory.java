package framework.models;

import java.util.HashMap;

public interface ICustomerAccountFactory {
	public ICustomer createCustomer(HashMap<String, String> customerData);
	public IAccount createAccount(HashMap<String, String> accountData,  ICustomer customer);
}
