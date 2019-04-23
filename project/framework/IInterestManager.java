package framework;

import java.util.List;

public interface  IInterestManager 
{
	void addAccount(IAccount account);
	void updateAccountsInterest();
	List<IAccount> getAccounts();
}
