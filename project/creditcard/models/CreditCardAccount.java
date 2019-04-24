package creditcard.models;

import java.util.Date;
import java.util.HashMap;

import framework.models.Account;
import framework.models.ICustomer;

public class CreditCardAccount extends Account {

	double interestMonthlyPayment;
	double interestMinimumPayment;

	public CreditCardAccount(HashMap<String, String> map, Person person) {
		super(map, person);
	}

//    @Override
//    public void setBalance(double balance) {
//        double interest = calculateInterest();
//        super.setBalance(balance + interest);
//    }

	double sumAllDepositsOfMonth(Date date) {
		return super.getTransactions().stream()
				.filter(x -> x.getDate().getMonth() == date.getMonth() && x instanceof Deposit)
				.mapToDouble(x -> x.getAmount()).sum();

	}

	private double sumAllChargesOfMonth(Date date) {
		return super.getTransactions().stream()
				.filter(x -> x.getDate().getMonth() == date.getMonth() && x instanceof Charge)
				.mapToDouble(x -> x.getAmount()).sum();
	}

	double calculateInterest(Date date) {
		double sumAllDepositsOfMonth = sumAllDepositsOfMonth(date);
		double sumAllChargesOfMonth = sumAllChargesOfMonth(date);
		double monthlyBalance = sumAllChargesOfMonth - sumAllDepositsOfMonth;
		boolean isPositiveBalance = monthlyBalance > 0;

		if (isPositiveBalance)
			return getBalance() * (1 + getInterest());

		return getBalance();
	}

	public double getInterestMinimumPayment() {
		return interestMinimumPayment;
	}

	public void setInterestMinimumPayment(double interestMinimumPayment) {
		this.interestMinimumPayment = interestMinimumPayment;
	}

	@Override
	public String report(Date date) {
		StringBuilder str = new StringBuilder();
		double totalCredits = sumAllDepositsOfMonth(date);
		double totalCharges = sumAllChargesOfMonth(date);
		int previousBalance = 100;
		double newBalance = previousBalance - totalCredits + totalCharges + this.getInterest() * (previousBalance - totalCredits);
		str.append("previous Balance= " + previousBalance);
		str.append("\nTotal Credits= " + totalCredits);
		str.append("\nTotal Charges= " + totalCharges);
		str.append("\nNew Balance= " + newBalance);
		str.append("\nTotal amount due= " + (newBalance * this.interestMinimumPayment));
		return str.toString();
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.interestMonthlyPayment = monthlyPayment;
	}

}
