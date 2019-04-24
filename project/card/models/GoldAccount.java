package card.models;

import java.util.HashMap;

import framework.models.Account;
import framework.models.ICustomer;

public class GoldAccount extends CreditCardAccount {
	public GoldAccount(HashMap<String, String> map, ICustomer customer) {
		super(map, customer);
		setInterest(0.06);
	}
}
