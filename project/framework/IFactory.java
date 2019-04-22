package framework;
public interface IFactory {

	public abstract ICustomer createCustomer(String type);
	public abstract IAccount createAccount(String type);


}
