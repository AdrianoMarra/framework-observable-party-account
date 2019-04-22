package framework;

import java.util.List;

public interface ICustomer {
	List<IAccount> getListAccount();

	void add(Account acc);

	List<IAccount> getAccountList();

	void setAccountList(List<IAccount> accountList);

	String getName();

	void setName(String name);

	String getAccNum();

	void setAccNum(String accNum);

	String getStreet();

	void setStreet(String street);

	String getCity();

	void setCity(String city);

	String getState();

	void setState(String state);

	String getZip();

	void setZip(String zip);

	String getEmail();

	void setEmail(String email);

}
