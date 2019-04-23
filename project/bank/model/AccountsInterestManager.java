package bank.model;

import framework.IAccount;
import framework.InterestManager;

public class AccountsInterestManager extends InterestManager {
	
	@Override
	public void addAccount(IAccount account) {
		super.addAccount(account);
	}

	@Override
	public void notifyAccounts() {
		for (IAccount account : super.getAccounts())
			account.addInterest();
	}
}
