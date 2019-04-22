package framework;

import java.util.Date;
import java.util.List;

public class Report implements IReport {
	private List<ICustomer> customers;

	public Report(List<ICustomer> customers) {
		this.customers = customers;
	}

	@Override
	public String generateReport(Date date) 
	{
		System.out.println("Report generated");
		return null;
	}

	@Override
	public void setCustomers(List<ICustomer> customers) {
		this.customers = customers;
	}

}
