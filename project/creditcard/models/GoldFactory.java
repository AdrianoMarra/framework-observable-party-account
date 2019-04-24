package creditcard.models;

import java.util.HashMap;

import framework.models.IAccount;
import framework.models.ICustomer;

public class GoldFactory extends CreditCardFactory {

	@Override
	public Person createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	public CreditCardAccount createAccount(HashMap<String, String> accountData, Person person) {
		return new GoldAccount(accountData, person);
	}
}
