package card.Model;

import framework.Account;
import framework.ICustomer;

import java.util.HashMap;

public class BronzeAccount extends CreditCardAccount {
    public BronzeAccount(HashMap<String, String> map, ICustomer customer) 
    {
        super(map, customer);
        setInterest(0.10);
    }
    
    
}
