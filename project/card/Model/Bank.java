package card.Model;

import bank.model.BankCustomerAccountsBuilder;
import framework.Default;
import framework.IAccount;
import framework.ICustomer;
import framework.IFactory;

import java.util.HashMap;

public class Bank extends Default {

    private static IFactory currentFactory;
//


    public static void main(String[] args){
        clickPersonalCreditCard();

    }

    private static void clickPersonalCreditCard() {
        HashMap<String, String> customData = new HashMap<>();

        customData.put("accNumber", "2122122");
        customData.put("name", "adriano");
        customData.put("street", "street test");
        customData.put("city", "city test");
        customData.put("state", "state test");
        customData.put("zip", "31312");
        customData.put("birthdate", "11/18/1990");
        customData.put("email", "adriano@test");

        currentFactory = CardCustomerAccountBuilder.getFactoryAccount("creditCardSilver");
        IAccount silverAccount = currentFactory.createAccount(customData);
        ICustomer customer1 = currentFactory.createCustomer(customData);

        customer1.addAccount(silverAccount);

        int debug = 1;



    }
}
