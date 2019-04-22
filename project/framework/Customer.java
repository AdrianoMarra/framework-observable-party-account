package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer implements ICustomer {

	List<IAccount> accountList = new ArrayList<>();

	private String name;
	private String accNum;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;

	public Customer(HashMap<String, String> customerData) {
		name = customerData.get("name");
		accNum = customerData.get("accNum");
		street = customerData.get("street");
		city = customerData.get("city");
		state = customerData.get("state");
		zip = customerData.get("zip");
		email = customerData.get("email");
	}

	public void add(Account acc) {
		accountList.add(acc);
	}

	@Override
	public List<IAccount> getListAccount() {
		return accountList;
	}

	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
