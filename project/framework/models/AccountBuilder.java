package framework.models;

public class AccountBuilder 
{
	public static ICustomerAccountFactory getFactoryAccount(String string) 
	{
		System.out.println("Getting Factory");
		return new CustomerAccountFactory();
	}
}