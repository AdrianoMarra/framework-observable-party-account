package card.Model;


import framework.Customer;

import java.util.Date;
import java.util.HashMap;

public class Person extends Customer {
    public Person(HashMap<String, String> customerData) {
        super(customerData);
    }


    public String generateBillMonthlyReport(Date date) {
        StringBuilder st = new StringBuilder();
        st.append(this.toString());
        return st.toString();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
