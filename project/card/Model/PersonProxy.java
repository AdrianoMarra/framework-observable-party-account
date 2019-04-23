package card.Model;

import framework.ITransaction;
import framework.TransactionProxy;

public class PersonProxy extends TransactionProxy {
    public PersonProxy(ITransaction transaction) {
        super(transaction);
    }
}
