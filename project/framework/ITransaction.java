package framework;

import java.util.Date;

public interface ITransaction {

	public boolean executeTransaction();
	public ITransaction getTransaction();
	public IAccount getAccount();
	public void setAccount(IAccount account);
	public Date getDate();
	double getAmount();
}
