package card.Model;

import framework.Account;

import java.util.Date;
import java.util.HashMap;

public class CreditCardAccount extends Account {

    double minimumPayment = .25;
    double interestMonthlyPayment;
    double interestMinimumPayment;

    public CreditCardAccount(HashMap<String, String> map) {
        super(map);
    }

//    @Override
//    public void setBalance(double balance) {
//        double interest = calculateInterest();
//        super.setBalance(balance + interest);
//    }

    double sumAllDepositsOfMonth(Date date) {
        return super.getTransactions()
                .stream()
                .filter(x -> x.getDate().getMonth() == date.getMonth()
                        && x instanceof Deposit
                )
                .mapToDouble(x -> x.getAmount()).sum();

    }

    private double sumAllChargesOfMonth(Date date) {
        return super.getTransactions()
                .stream()
                .filter(x -> x.getDate().getMonth() == date.getMonth()
                        && x instanceof Charge
                )
                .mapToDouble(x -> x.getAmount()).sum();
    }


    double calculateInterest(Date date) {
        double sumAllDepositsOfMonth = sumAllDepositsOfMonth(date);
        double sumAllChargesOfMonth = sumAllChargesOfMonth(date);
        double monthlyBalance = sumAllChargesOfMonth - sumAllDepositsOfMonth;
        boolean isPositiveBalance = monthlyBalance > 0;
        setBalance(getBalance() - sumAllDepositsOfMonth + sumAllChargesOfMonth);
        if (isPositiveBalance)
            setBalance(getBalance() *  (1 + getInterest()));

        return getBalance();
    }

    @Override
    public String report(Date date) {
        StringBuilder str = new StringBuilder();
        str.append("previous Balance" + getBalance());
        str.append("\nTotal Credits=" + sumAllDepositsOfMonth(date));
        str.append("\nTotal Charges=" + sumAllChargesOfMonth(date));
        str.append("\nNew Balance=" + calculateInterest(date));
//        str.append("\nTotal amount due=" + getBalance());
        return str.toString();
    }




    public void setMonthlyPayment(double monthlyPayment) {
        this.interestMonthlyPayment = monthlyPayment;
    }


}
