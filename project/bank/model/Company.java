package bank.model;

import java.util.HashMap;
import java.util.List;

import framework.Customer;
import framework.IAccount;

public class Company extends Customer {

	public Company(HashMap<String, String> customerData) {
		super(customerData);
	}

	@Override
	public List<IAccount> getListAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
