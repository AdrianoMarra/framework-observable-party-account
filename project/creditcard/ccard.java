package creditcard;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import creditcard.models.CreditCardAccount;
import creditcard.models.Person;
import creditcard.views.CardView;
import framework.finco;
import framework.models.Customer;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.InterestManager;

public class ccard extends finco {

	public static List<CreditCardAccount> accountsList = new ArrayList<>();
	public static List<Person> customersList = new ArrayList<>();

	public static void main(String[] args) {
		try {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it visible.
			(new CardView()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
