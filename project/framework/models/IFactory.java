package framework.models;

import java.util.HashMap;

public interface IFactory {
	public ICustomer createCustomer(HashMap<String, String> customerData);
	public IAccount createAccount(HashMap<String, String> accountData,  ICustomer customer);
}
