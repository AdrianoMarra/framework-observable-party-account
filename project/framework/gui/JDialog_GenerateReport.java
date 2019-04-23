package framework.gui;

import javax.swing.JDialog;

public class JDialog_GenerateReport extends JDialog {

	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	String reportString;

	public JDialog_GenerateReport(FincoFrm parent) {
		super(parent);
		getContentPane().setLayout(null);
		setSize(405, 367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 358, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 355, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156, 276, 96, 24);

		reportString = "Name= John White\r\n";
		reportString += "Address= 1000 Main, Fairfield, IA, 52556\r\n";
		reportString += "CC number= 2341 3421 4444 5689\r\n";
		reportString += "CC type= GOLD\r\n";
		reportString += "Previous balance = $ 100.00\r\n";
		reportString += "Total Credits = $ 25.00\r\n";
		reportString += "Total Charges = $ 560.00\r\n";
		reportString += "New balance = $ 638.75\r\n";
		reportString += "Total amount due = $ 63.88\r\n";
		reportString += "\r\n";
		reportString += "\r\n";
		reportString += "Name= Frank Summer\r\n";
		reportString += "Address= 1000 N, 4th St, Fairfield, IA, 52556\r\n";
		reportString += "CC number= 0099 3421 4321 6577\r\n";
		reportString += "CC type= BRONZE\r\n";
		reportString += "Previous balance = $ 200.00\r\n";
		reportString += "Total Credits = $ 45.00\r\n";
		reportString += "Total Charges = $ 150.00\r\n";
		reportString += "New balance = $ 313.53\r\n";
		reportString += "Total amount due = $ 34.49\r\n";
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

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}
