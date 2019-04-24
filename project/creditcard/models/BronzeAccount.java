package creditcard.models;

import java.util.HashMap;

import framework.models.Account;
import framework.models.ICustomer;

public class BronzeAccount extends CreditCardAccount {
    public BronzeAccount(HashMap<String, String> map, ICustomer customer) 
    {
        super(map, customer);
        setInterest(0.10);
    }
    
    
}
