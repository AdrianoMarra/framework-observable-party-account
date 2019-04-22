package framework;

import java.util.List;

public class InterestManager implements IInterestManager {
	private List<IAccount> accounts;

	public InterestManager(List<IAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void setAccounts(List<IAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void notifyAccounts() {
		for (IAccount iAccount : accounts)
			iAccount.addInterest();
		
		System.out.println("Add interest to all the accounts");
	}

}
