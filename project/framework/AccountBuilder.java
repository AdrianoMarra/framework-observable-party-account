package framework;

public class AccountBuilder 
{
	public static IFactory getFactoryAccount(String string) 
	{
		System.out.println("Getting Factory");
		return new CustomerAccountFactory();
	}
}