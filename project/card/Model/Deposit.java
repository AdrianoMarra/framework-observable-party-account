package card.Model;

import framework.IAccount;
import framework.Transaction;

public class Deposit extends Transaction {
    public Deposit(IAccount account, double amount) {
        super(account, amount);
    }
}
