package framework;
public interface ITransactionManager 
{
	public void execute();
	
	public void setTransaction(ITransaction transaction);

}
