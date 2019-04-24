package framework.models;

import java.util.Stack;

public class TransactionManager implements ITransactionManager {

	Stack<ITransaction> transactionHistory = new Stack<>();
	ITransaction currentTransaction;

	public void setCurrentTransaction(ITransaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void execute() {
		if (currentTransaction.executeTransaction()) {
			transactionHistory.push(currentTransaction);
		}
	}

	@Override
	public void setTransaction(ITransaction transaction) {
		this.currentTransaction = transaction;
	}

}
