package framework;
public interface ITransactionManager 
{
	public void execute(IAccount account);
	
	public void setTransaction(ITransaction transaction);

}
