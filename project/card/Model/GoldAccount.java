package card.Model;

import framework.Account;
import framework.ICustomer;

import java.util.HashMap;

public class GoldAccount extends CreditCardAccount {
	public GoldAccount(HashMap<String, String> map, ICustomer customer) {
		super(map, customer);
		setInterest(0.06);
	}
}
