package card.Model;

import framework.Account;


import java.util.HashMap;

public class GoldAccount extends CreditCardAccount {
    public GoldAccount(HashMap<String, String> map) {
        super(map);
        setInterest(6);
    }
}
