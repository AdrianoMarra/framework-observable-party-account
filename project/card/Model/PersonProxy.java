package card.Model;

import framework.IAccount;
import framework.ITransaction;
import framework.Transaction;
import framework.TransactionProxy;

public class PersonProxy extends Transaction {


    public PersonProxy(IAccount account, double amount) {
        super(account, amount);
    }
}
