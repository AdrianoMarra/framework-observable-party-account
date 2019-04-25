package framework.models;

import java.util.HashMap;
import java.util.List;

public class Person extends Customer implements IPerson {

	private String birthDate;

	public Person(HashMap<String, String> customerData) {
		super(customerData);
		this.birthDate = customerData.get("birthDate");
	}
	
	@Override
	public List<IAccount> getAccountList() {
		return super.getAccountList();
	}

	@Override
	public void addAccount(IAccount acc) {
		super.addAccount(acc);
	}

	@Override
	public void setAccountList(List<IAccount> accountList) {
		super.setAccountList(accountList);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getStreet() {
		return super.getState();
	}

	@Override
	public void setStreet(String street) {
		super.setStreet(street);
	}

	@Override
	public String getCity() {
		return super.getCity();
	}

	@Override
	public void setCity(String city) {
		super.setCity(city);
	}

	@Override
	public String getState() {
		return super.getState();
	}

	@Override
	public void setState(String state) {
		super.setState(state);
	}

	@Override
	public String getZip() {
		return super.getZip();
	}

	@Override
	public void setZip(String zip) {
		super.setZip(zip);
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}

}
