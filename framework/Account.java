package framework;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	private List<ITransaction> transactions = new ArrayList<>();

	@Override
	public void addInterest() {

	}

	@Override
	public void addTransaction(ITransaction transaction) {
		transactions.add(transaction);
	}
}
