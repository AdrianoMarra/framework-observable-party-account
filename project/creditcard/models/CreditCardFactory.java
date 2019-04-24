package creditcard.models;

import java.util.HashMap;

import framework.models.CustomerAccountFactory;

public class CreditCardFactory extends CustomerAccountFactory {

	@Override
	public Person createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	public CreditCardAccount createAccount(HashMap<String, String> accountData, Person person) {
		return new CreditCardAccount(accountData, person);
	}

}
