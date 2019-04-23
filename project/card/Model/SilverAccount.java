package card.Model;


import framework.Account;
import framework.IAccount;
import framework.ICustomer;
import framework.ITransaction;

import java.util.HashMap;

public class SilverAccount extends Account {


    public SilverAccount(HashMap<String, String> accountData) {
        super(accountData);
    }

    @Override
    public void addTransaction(ITransaction transaction) {

    }

    @Override
    public void addInterest() {

    }
}
