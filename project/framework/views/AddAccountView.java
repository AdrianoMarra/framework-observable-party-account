package framework.views;

import java.util.HashMap;
import java.util.Map;

import framework.models.IFactory;

public class AddAccountView extends javax.swing.JDialog {

	private FincoView parentFrame;

	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ACCNR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_Email = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();

	public AddAccountView(FincoView thisframe) {
		super(thisframe);
		parentFrame = thisframe;

		setTitle("Add account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(301, 233);
		setVisible(false);

		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 10, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 34, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 60, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 84, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 108, 48, 24);
		JLabel6.setText("AccountNr");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 130, 96, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 154, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 14, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 38, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 62, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 86, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 110, 156, 20);
		getContentPane().add(JTextField_ACCNR);
		JTextField_ACCNR.setBounds(84, 134, 156, 20);
		getContentPane().add(JTextField_Email);
		JTextField_Email.setBounds(84, 158, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 210, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 210, 84, 24);

		// }}

		// {{REGISTER_LISTENERS

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCancel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		parentFrame.customerMap = new HashMap<>();
		parentFrame.accountMap = new HashMap<>();

		parentFrame.customerMap.put("name", JTextField_NAME.getText());
		parentFrame.customerMap.put("street", JTextField_STR.getText());
		parentFrame.customerMap.put("city", JTextField_CT.getText());
		parentFrame.customerMap.put("zip", JTextField_ZIP.getText());
		parentFrame.customerMap.put("state", JTextField_ST.getText());
		parentFrame.customerMap.put("email", JTextField_Email.getText());
		parentFrame.accountMap.put("accNumber", JTextField_ACCNR.getText());
		parentFrame.accountMap.put("interest", "5.0");

		parentFrame.newaccount = true;
		dispose();
	}

	void JButtonCancel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}

}
