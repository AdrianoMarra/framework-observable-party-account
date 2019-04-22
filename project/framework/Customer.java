package framework;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {

	List<IAccount> accountList = new ArrayList<>();
		
	public void add(Account acc) 
	{
		
		accountList.add(acc);		
	}

	@Override
	public List<IAccount> getListAccount() {
		return accountList; 
	}
}
