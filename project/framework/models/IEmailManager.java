package framework.models;
public interface IEmailManager {

	public static void sendEmail(String str) 
	{
		System.out.println("Send Email: \n"+ str);
	}

}
