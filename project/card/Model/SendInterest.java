package card.Model;

import framework.IAccount;
import framework.InterestManager;

import java.util.List;

public class SendInterest extends InterestManager {
    public SendInterest(List<IAccount> accounts) {
        super(accounts);
    }
}
