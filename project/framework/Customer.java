package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer implements ICustomer {

	List<IAccount> accountList = new ArrayList<>();
	
	private String name;
	private String accNum;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
		
	public Customer(HashMap<String, String> customerData) {
		name = customerData.get("name");
		accNum = customerData.get("accNum");
		street = customerData.get("street");
		city = customerData.get("city");
		state = customerData.get("state");
		zip = customerData.get("zip");
		email = customerData.get("email");
	}

	public void add(Account acc) 
	{
		
		accountList.add(acc);		
	}

	@Override
	public List<IAccount> getListAccount() {
		return accountList; 
	}
}
