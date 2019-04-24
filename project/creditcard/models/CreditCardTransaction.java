package creditcard.models;

import java.util.Date;

import framework.models.IAccount;
import framework.models.ITransaction;
import framework.models.Transaction;

public class CreditCardTransaction extends Transaction {

	private CreditCardAccount currentCreditCardAccount;

	public CreditCardTransaction(CreditCardAccount account, double amount) {
		super(account, amount);
		this.currentCreditCardAccount = account;
	}

	@Override
	public boolean executeTransaction() {
		System.out.println("Transaction Command Executed");
		currentCreditCardAccount.setBalance(currentCreditCardAccount.getBalance() + getAmount());
		currentCreditCardAccount.addTransaction(this);
		return true;
	}

	@Override
	public CreditCardAccount getAccount() {
		return currentCreditCardAccount;
	}

	public void setAccount(CreditCardAccount account) {
		currentCreditCardAccount = account;
	}

	public CreditCardTransaction getTransaction() {
		return this;
	}

}
