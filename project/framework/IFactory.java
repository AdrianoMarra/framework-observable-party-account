package framework;

import java.util.HashMap;

public interface IFactory {
	public ICustomer createCustomer(HashMap<String, String> customerData);
	public IAccount createAccount(String accNum);
}
