package creditcard.models;

import java.util.HashMap;

import framework.models.Account;
import framework.models.ICustomer;

public class BronzeAccount extends CreditCardAccount {
	public BronzeAccount(HashMap<String, String> map, Person person) {
		super(map, person);
		setInterest(0.10);
		setInterestMinimumPayment(0.14);
	}

}
