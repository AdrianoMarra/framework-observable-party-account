package banking.models;

import framework.models.AccountBuilder;

public class BankCustomerAccountsBuilder extends AccountBuilder {

	public static BankCustomerAccountFactory getFactoryAccount(String string) {
		BankCustomerAccountFactory factory = null;

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
