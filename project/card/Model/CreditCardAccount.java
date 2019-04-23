package card.Model;

import framework.Account;
import framework.ITransaction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardAccount extends Account {

    double minimumPayment = .25;
    double interestMonthlyPayment;
    double interestMinimumPayment;
    public CreditCardAccount(HashMap<String, String> map) {
        super(map);
    }

    @Override
    public void setBalance(double balance)
    {
        double interest = calculateInterest();
        super.setBalance(balance + interest);
    }

    double calculateInterest()
    {
        int month = new Date().getMonth();
        List<ITransaction> transactionsPaid = super.getTransactions().stream().filter(x -> x.getDate().getMonth() == month && x instanceof Deposit).collect(Collectors.toList());
        List<ITransaction> transactionsCharged = super.getTransactions().stream().filter(x -> x.getDate().getMonth() == month && x instanceof Charge).collect(Collectors.toList());

        double sumAllDepositsOfMonth =   transactionsPaid.stream().mapToDouble(x -> x.getAmount()).sum();
        double sumAllChargesOfMonth =   transactionsCharged.stream().mapToDouble(x -> x.getAmount()).sum();

        double monthlyBalance =  sumAllChargesOfMonth - sumAllDepositsOfMonth;

        if(monthlyBalance > 0){
            return monthlyBalance * (1 + getInterest());
        }
        return 0;
    }




    public void setMonthlyPayment(double monthlyPayment) {
        this.interestMonthlyPayment = monthlyPayment;
    }


}
