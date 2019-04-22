package framework;

public class CustomerAccountFactory implements IFactory {

	@Override
	public ICustomer createCustomer(String type) {
		return new Customer();
	}

	@Override
	public IAccount createAccount(String type) {
		return new Account();
	}

}
