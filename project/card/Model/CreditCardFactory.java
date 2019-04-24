package card.Model;

import bank.model.Person;
import framework.CustomerAccountFactory;
import framework.IAccount;
import framework.ICustomer;

import java.util.HashMap;

public class CreditCardFactory extends CustomerAccountFactory {

    @Override
    public ICustomer createCustomer(HashMap<String, String> customerData) {
        return new Person(customerData);
    }

    @Override
    public IAccount createAccount(HashMap<String, String> accountData, ICustomer customer) {
        return new SilverAccount(accountData, customer);
    }
}
