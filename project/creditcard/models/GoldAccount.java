package creditcard.models;

import java.util.HashMap;

import framework.models.Account;
import framework.models.ICustomer;

public class GoldAccount extends CreditCardAccount {
	public GoldAccount(HashMap<String, String> map, Person person) {
		super(map, person);
		setInterest(0.06);
		setInterestMinimumPayment(0.10);
	}
}
