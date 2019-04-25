package framework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import framework.models.ICustomer;
import framework.models.InterestManager;
import framework.views.FincoView;

public class finco {

	public static InterestManager accountsManager = new InterestManager();
	public static List<ICustomer> customerList = new ArrayList<>();

	public static void main(String[] args) {
		try {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it visible.
			(new FincoView()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
