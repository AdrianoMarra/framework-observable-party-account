package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Customer;
import framework.IAccount;
import framework.ICustomer;

public class Person extends Customer {	
	public Person(HashMap<String, String> customerData) {
		super(customerData);
	}
}
