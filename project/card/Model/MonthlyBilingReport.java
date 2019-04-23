package card.Model;

import framework.ICustomer;
import framework.Report;

import java.util.List;

public class MonthlyBilingReport extends Report {
    public MonthlyBilingReport(List<ICustomer> customers) {
        super(customers);
    }
}
