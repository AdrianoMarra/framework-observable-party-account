package creditcard.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import framework.models.Customer;
import framework.models.IAccount;

public class Person extends Customer 
{
	List<CreditCardAccount> creditCardAccountList = new ArrayList<>();
	
    public Person(HashMap<String, String> customerData) {
        super(customerData);
    }


    public String generateBillMonthlyReport(Date date) {
        StringBuilder st = new StringBuilder();
        st.append(this.toString());
        return st.toString();
    }
    
 	public void addCreditCardAccountAccount(CreditCardAccount acc) {
 		creditCardAccountList.add(acc);
	}


    @Override
    public String toString() {
        return super.toString();
    }
    
    
	public List<CreditCardAccount> getCreditCardAccountList() {
		return creditCardAccountList;
	}
}
