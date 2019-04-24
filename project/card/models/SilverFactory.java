package card.models;

import java.util.HashMap;

import framework.models.IAccount;
import framework.models.ICustomer;

public class SilverFactory implements framework.models.IFactory {
    @Override
    public ICustomer createCustomer(HashMap<String, String> customerData) {
        return new Person(customerData);
    }

    @Override
    public IAccount createAccount(HashMap<String, String> accountData,ICustomer customer) {
        return new SilverAccount(accountData, customer);
    }

}
