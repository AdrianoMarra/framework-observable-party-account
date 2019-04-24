package creditcard.views;

import creditcard.models.Charge;
import creditcard.models.ChargeProxy;
import creditcard.models.CreditCardAccount;
import creditcard.models.CreditCardTransaction;
import creditcard.models.CreditCardTransactionManager;
import framework.models.IAccount;
import framework.models.ITransaction;
import framework.models.ITransactionManager;
import framework.models.TransactionManager;
import framework.models.TransactionProxy;

import javax.swing.*;

public class ChargeView extends javax.swing.JDialog {

	private JLabel JLabel1 = new JLabel();
	private JLabel JLabel2 = new JLabel();
	private JTextField JTextField_NAME = new JTextField();
	private JTextField JTextField_AMT = new JTextField();
	private JButton JButton_OK = new JButton();
	private JButton JButton_Calcel = new JButton();
	private CardView parentframe;
	private String name;
	private CreditCardAccount acc;
	CreditCardTransactionManager transactionManager = new CreditCardTransactionManager();


	public ChargeView(CardView parent, String aname, CreditCardAccount acc) {
		super(parent);
		this.parentframe = parent;
		this.name = aname;
		this.acc = acc;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses your Java file into its visual envirenment.

		setTitle("Charge Account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(277, 134);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 36, 48, 24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 156, 20);
		getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84, 36, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 84, 84, 24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156, 84, 84, 24);

		JTextField_NAME.setText(name);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);

	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		CreditCardTransaction transaction = new Charge(acc, Double.parseDouble(JTextField_AMT.getText())); 	
 		transaction = new ChargeProxy(transaction, transaction.getAccount(), transaction.getAmount());
 		transactionManager.setTransaction(transaction);
 		transactionManager.execute();
 		
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}
}