package bank.model;

import framework.CustomerAccountFactory;
import framework.IAccount;
import framework.ICustomer;

public class PersonalSavingsCustomerAccount extends CustomerAccountFactory {
	

	@Override
	public ICustomer createCustomer(String type) {
		return new Person();
	}

	@Override
	public IAccount createAccount(String type) {
		return new SavingsAccount();
	}
	
}
