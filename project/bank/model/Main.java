package bank.model;

import java.util.HashMap;

import framework.IAccount;
import framework.ICustomer;
import framework.IFactory;

public class Main {

	private static IFactory currentFactory;
	private static HashMap<String, String> customData = new HashMap<>();
	
	public static void main(String[] args) {
		
//		customData.put("accNumber", "2122122");
//		customData.put("name", "adriano");
//		customData.put("street", "street test");
//		customData.put("city", "city test");
//		customData.put("state", "state test");
//		customData.put("zip", "31312");
//		customData.put("birthdate", "11/18/1990");
//		customData.put("email", "adriano@test");
//		
//		clickCreatePersonalAccount();
	}

	private static void clickCreatePersonalAccount() {
		currentFactory = BankCustomerAccountsBuilder.getFactoryAccount("personalCheckings");
		IAccount acc = currentFactory.createAccount(customData);
		ICustomer customer = currentFactory.createCustomer(customData);
		customer.addAccount(acc);
	}
	
	private static void clickCreateCompanyAccount() {
		currentFactory = BankCustomerAccountsBuilder.getFactoryAccount("companyCheckings");
		IAccount acc = currentFactory.createAccount(customData);
		ICustomer customer = currentFactory.createCustomer(customData);
		customer.addAccount(acc);
	}
}


