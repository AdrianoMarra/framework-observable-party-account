package card.Model;



import framework.Customer;
import framework.IAccount;

import java.util.HashMap;
import java.util.List;

public class Person extends Customer {
    public Person(HashMap<String, String> customerData) {
        super(customerData);
    }


    @Override
    public List<IAccount> getListAccount() {
        // TODO Auto-generated method stub
        return null;
    }

}
