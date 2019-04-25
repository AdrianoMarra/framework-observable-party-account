package banking;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import banking.models.BankCustomer;
import banking.models.BankInterestManager;
import banking.views.BankView;
import creditcard.ccard;
import framework.finco;
import framework.models.Customer;
import framework.models.InterestManager;
import framework.views.FincoView;

public class bank extends finco {

	public static BankInterestManager accountsManager = new BankInterestManager();
	public static List<BankCustomer> customers = new ArrayList<>();

	public static void main(String[] args) {
		try {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it visible.
			(new BankView()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
