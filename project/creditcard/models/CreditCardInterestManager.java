package creditcard.models;

import java.util.ArrayList;
import java.util.List;

import framework.models.InterestManager;

public class CreditCardInterestManager extends InterestManager {

	private List<CreditCardAccount> creditCardAccountList = new ArrayList<>();

	public void addAccount(CreditCardAccount account) {
		creditCardAccountList.add(account);
	}

	public void updateAccountsInterest() {
		for (CreditCardAccount acc : creditCardAccountList)
			acc.addInterest();
	}

	public List<CreditCardAccount> getCreditCardAccountList() {
		return creditCardAccountList;
	}

}
