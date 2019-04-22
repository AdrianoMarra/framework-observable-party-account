package framework;

public class AccountFactory implements IFactory {

	@Override
	public ICustomer createCustomer(String type) {
		
		Customer customer = new Customer();		 
		
		System.out.println("Customer created");
		
		customer.add(new Account());
		
		System.out.println("Account created");
		
		return customer;
	}

}
