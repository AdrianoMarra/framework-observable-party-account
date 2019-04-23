package card.Model;

import framework.IAccount;
import framework.Transaction;

public class Charge extends Transaction {
    public Charge(IAccount account, double amount) {
        super(account, amount);
    }
}
