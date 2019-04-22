package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account implements IAccount {
	private List<ITransaction> transactions = new ArrayList<>();

	private String accNumber;
	private double balance;

	public Account(HashMap<String, String> map) {
		this.accNumber = map.get("accNumber");
		this.balance = Double.parseDouble(map.get("balance"));
	}

	@Override
	public void addInterest() {

	}

	@Override
	public void addTransaction(ITransaction transaction) {
		transactions.add(transaction);
	}
}
