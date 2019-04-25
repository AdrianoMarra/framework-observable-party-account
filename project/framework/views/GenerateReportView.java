package framework.views;

import java.util.Date;

import javax.swing.JDialog;

import framework.finco;
import framework.models.IAccount;
import framework.models.ICustomer;

public class GenerateReportView extends JDialog {

	private javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	private javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
	private javax.swing.JButton JButton_OK = new javax.swing.JButton();
	private String reportString = "";

	public GenerateReportView(FincoView parent) {
		super(parent);
		getContentPane().setLayout(null);
		setSize(405, 367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 758, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 755, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(296, 276, 196, 24);

		for (ICustomer customer : finco.customerList) {
			reportString += "Name = " + customer.getName() + "\n";
			reportString += "Address = " + customer.getStreet() + "," + customer.getCity() + "," + customer.getState()
					+ "," + customer.getZip() + "\n";

			for (IAccount acc : customer.getAccountList()) {
				reportString += "Account Number = " + acc.getAccNumber() + "\n";
				reportString += "Amount = $" + acc.getBalance();
			}

			reportString += "\n-----------------------------------\n";
		}

		JTextField1.setText(reportString);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	private void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}
