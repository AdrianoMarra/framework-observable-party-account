package framework;
public interface ITransaction {

	public boolean executeTransaction();
	public IAccount getAccount();
	public void setAccount(IAccount account);
	double getAmount();

}
