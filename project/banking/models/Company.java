package banking.models;

import java.util.HashMap;

public class Company extends BankCustomer 
{
	String numOfEmployees;	

	public Company(HashMap<String, String> customerData) {
		super(customerData);
		this.numOfEmployees = customerData.get("numOfEmployees");
	}
}
