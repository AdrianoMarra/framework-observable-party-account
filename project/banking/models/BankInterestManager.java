package banking.models;

import java.util.ArrayList;
import java.util.List;

import framework.models.InterestManager;

public class BankInterestManager extends InterestManager {

	private List<BankAccount> accounts = new ArrayList<>();

//	@Override
	public void addAccount(BankAccount account) {
		this.accounts.add(account);
	}

//	@Override
	public void updateAccountsInterest() {
		for (BankAccount iAccount : accounts)
			iAccount.addInterest();		
	}

//	@Override
	public List<BankAccount> getListAccounts() {
		return accounts;
	}
}
