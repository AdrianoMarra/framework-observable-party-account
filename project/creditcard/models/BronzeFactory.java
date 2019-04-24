package creditcard.models;

import java.util.HashMap;

import framework.models.CustomerAccountFactory;
import framework.models.IAccount;
import framework.models.ICustomer;

public class BronzeFactory extends CreditCardFactory  {
	@Override
	public Person createCustomer(HashMap<String, String> customerData) {
		return new Person(customerData);
	}

	public CreditCardAccount createAccount(HashMap<String, String> accountData, Person person) {
		return new BronzeAccount(accountData, person);
	}

}
