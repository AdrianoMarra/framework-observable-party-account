package banking.models;

import java.util.HashMap;

public class Person extends BankCustomer {
	private String birthDate;

	public Person(HashMap<String, String> customerData) {
		super(customerData);
		this.birthDate = customerData.get("birthDate");
	}
}