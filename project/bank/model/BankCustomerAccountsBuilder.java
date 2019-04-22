package bank.model;

import framework.AccountBuilder;
import framework.IFactory;

public class BankCustomerAccountsBuilder extends AccountBuilder {

	public static IFactory getFactoryAccount(String string) 
	{
		IFactory factory = null;
		
		switch (string) {
		case "personalCheckings":
			factory = new PersonalCheckingsFactory();
		case "personalSavings":
			factory = new PersonalSavingsFactory();
		case "companyCheckings":
			factory = new CompanyCheckingsFactory();
		case "companySavings":
			factory = new CompanySavingsFactory();
		default:
			break;
		}
		
		return factory;
	}
	
}
