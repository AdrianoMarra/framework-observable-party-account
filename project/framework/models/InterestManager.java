package framework.models;

import java.util.ArrayList;
import java.util.List;

public class InterestManager implements IInterestManager {
	private List<IAccount> accounts = new ArrayList<>();

	@Override
	public void addAccount(IAccount account) {
		this.accounts.add(account);
	}

	@Override
	public void updateAccountsInterest() {
		for (IAccount iAccount : accounts)
			iAccount.addInterest();		
	}

	@Override
	public List<IAccount> getAccounts() {
		return accounts;
	}
}
