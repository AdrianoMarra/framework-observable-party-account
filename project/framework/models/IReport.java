package framework.models;

import java.util.Date;
import java.util.List;

public interface IReport {

	abstract String generateReport(Date date);

	void setCustomers(List<ICustomer> customers);

}
