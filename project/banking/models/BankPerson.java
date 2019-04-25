package banking.models;

import java.util.HashMap;

import framework.models.Person;

public class BankPerson extends Person {

	private String birthDate;
	
	public BankPerson(HashMap<String, String> customerData) {
		super(customerData);
		this.birthDate = customerData.get("birthDate");
	}	
}
