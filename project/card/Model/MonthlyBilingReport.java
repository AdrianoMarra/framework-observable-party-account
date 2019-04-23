package card.Model;

import framework.ICustomer;
import framework.Report;

import java.util.Date;
import java.util.List;

public class MonthlyBilingReport extends Report {
    public MonthlyBilingReport(List<ICustomer> customers) {
        super(customers);
    }

    @Override
    public String generateReport(Date date) {

        return super.generateReport(date);
    }
}
