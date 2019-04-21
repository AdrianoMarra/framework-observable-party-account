package framework;

import java.util.Stack;

public class TransactionManager implements ITransactionManager {

	Stack<ITransaction> transactionHistory = new Stack<>();
	ITransaction currentTransaction;

	public void setCurrentTransaction(ITransaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void execute(IAccount account) {
		if (currentTransaction.executeTransaction(account)) {
			transactionHistory.push(currentTransaction);
			account.addTransaction(currentTransaction);			
		}
	}

	@Override
	public void setTransaction(ITransaction transaction) {
		this.currentTransaction = transaction;
	}

}
