package bank.models;

import framework.models.AccountBuilder;
import framework.models.IFactory;

public class BankCustomerAccountsBuilder extends AccountBuilder {

	public static IFactory getFactoryAccount(String string) {
		IFactory factory = null;

		switch (string) {
		case "personalCheckings":
			factory = new PersonalCheckingsFactory();
			break;
		case "personalSavings":
			factory = new PersonalSavingsFactory();
			break;
		case "companyCheckings":
			factory = new CompanyCheckingsFactory();
			break;
		case "companySavings":
			factory = new CompanySavingsFactory();
			break;
		default:
			break;
		}

		return factory;
	}

}
