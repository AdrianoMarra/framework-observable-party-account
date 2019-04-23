package card.Model;

import bank.model.BankCustomerAccountsBuilder;
import framework.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Bank extends Default {

    private static IFactory currentFactory;
//


    public static void main(String[] args){
        clickPersonalCreditCard();

    }

    private static void clickAddInterested(){


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

        currentFactory = CardCustomerAccountBuilder.getFactoryAccount("creditCardGold");
        IAccount goldAccount = currentFactory.createAccount(customData);
        ICustomer customer1 = currentFactory.createCustomer(customData);

        customer1.addAccount(goldAccount);

        goldAccount.setBalance(100);


        List<ITransaction> transactionList = new ArrayList<>();
        transactionList.add(new Deposit(goldAccount, 25));
        transactionList.add(new Charge(goldAccount, 560));

        goldAccount.addTransaction(transactionList.get(0));
        goldAccount.addTransaction(transactionList.get(1));

        Date date = new Date();
        System.out.println(customer1.getAccountList().get(0).report(date));


    }
}
