package banking.models;

import java.util.HashMap;

import framework.models.Company;

public class BankCompany extends Company {

	String numOfEmployees;	
	public BankCompany(HashMap<String, String> customerData) {
		super(customerData);
		this.numOfEmployees = customerData.get("numOfEmployees");
	}

}
