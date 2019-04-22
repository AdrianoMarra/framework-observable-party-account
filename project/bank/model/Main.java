package bank.model;

import java.util.HashMap;

import framework.IAccount;
import framework.ICustomer;
import framework.IFactory;

public class Main {

	private static IFactory currentFactory;
	
	public static void main(String[] args) {
		
		clickCreatePersonalAccount();
		
	}

	private static void clickCreatePersonalAccount() {
		HashMap<String, String> customData = new HashMap<>();
		
		customData.put("accNum", "2122122");
		customData.put("name", "adriano");
		customData.put("street", "street test");
		customData.put("city", "city test");
		customData.put("state", "state test");
		customData.put("zip", "31312");
		customData.put("birthdate", "11/18/1990");
		customData.put("email", "adriano@test");

		currentFactory = BankCustomerAccountsBuilder.getFactoryAccount("personalCheckings");
		IAccount acc = currentFactory.createAccount(customData);
		ICustomer customer = currentFactory.createCustomer(customData);
		customer.addAccount(acc);
	}
}


