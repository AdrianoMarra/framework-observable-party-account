package bank.models;

import java.util.HashMap;
import java.util.List;

import framework.models.Customer;
import framework.models.IAccount;

public class Company extends Customer {

	public Company(HashMap<String, String> customerData) {
		super(customerData);
	}
}
