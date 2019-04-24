package card.models;

import java.util.HashMap;

import framework.models.Account;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.ITransaction;

public class SilverAccount extends CreditCardAccount {

	public SilverAccount(HashMap<String, String> accountData, ICustomer customer) {
		super(accountData, customer);
		setInterest(Double.valueOf(0.08));
	}

	@Override
	public void addTransaction(ITransaction transaction) {

	}

	@Override
	public void addInterest() {

	}
}
