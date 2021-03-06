package creditcard.views;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.*;
import java.util.Date;
 

import javax.swing.*;

import creditcard.ccard;
import creditcard.models.CreditCardAccount;
import creditcard.models.Person;

public class GenBillView extends javax.swing.JDialog {

	private String reportString = "";
	// {{DECLARE_CONTROLS
	private JScrollPane JScrollPane1 = new JScrollPane();
	private JTextArea JTextField1 = new JTextArea();
	private JButton JButton_OK = new JButton();

	public GenBillView(Frame parent) {
		super(parent);

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses your Java file into its visual envirenment.
		// {{ INIT_CONTROLS
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
		for (Person customer : ccard.customersList) {
		
			reportString += "Name = " + customer.getName() + "\n";
			reportString += "Address = " + customer.getStreet() + "," + customer.getCity() + "," + customer.getState()
					+ "," + customer.getZip() + "\n";
			for (CreditCardAccount account : customer.getCreditCardAccountList())
				reportString += account.report(new Date()) + "\n";		
			
			reportString += "-----------------------------------\n";
		}

		JTextField1.setText(reportString);
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		// }}
	}

	public GenBillView() {
		this((Frame) null);
	}
	// }}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}
}