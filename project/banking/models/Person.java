package banking.models;

import java.util.HashMap;
import java.util.List;

import framework.models.Customer;
import framework.models.IAccount;
import framework.models.ICustomer;

public class Person extends Customer {
	public Person(HashMap<String, String> customerData) {
		super(customerData);
	}
}
