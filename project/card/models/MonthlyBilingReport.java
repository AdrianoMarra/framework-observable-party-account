package card.models;

import java.util.Date;
import java.util.List;

import framework.models.ICustomer;
import framework.models.Report;

public class MonthlyBilingReport extends Report {
    public MonthlyBilingReport(List<ICustomer> customers) {
        super(customers);
    }

    @Override
    public String generateReport(Date date) {

        return super.generateReport(date);
    }
}
