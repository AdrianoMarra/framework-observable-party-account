package framework.views;

import javax.swing.JDialog;

import framework.models.IAccount;
import framework.models.ITransaction;
import framework.models.ITransactionManager;
import framework.models.Transaction;
import framework.models.TransactionManager;
import framework.models.TransactionProxy;

 
public class TransactionView extends JDialog {

	private FincoView parentFrame;
	private String name;
	private IAccount acc;

	private javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	private javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	private javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	private javax.swing.JButton JButton_OK = new javax.swing.JButton();
	private javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	private javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
	private ITransactionManager transactionManager = new TransactionManager();

	public TransactionView(FincoView parent, String name, IAccount acc) 
	{
		super(parent);
		this.parentFrame = parent;
		this.name = name;
		this.acc = acc;
		setTitle("Transaction");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268, 126);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84, 48, 144, 24);
		// }}
		JTextField_NAME.setText(name);

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	private void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
 		ITransaction transaction = new Transaction(acc, Double.parseDouble(JTextField_Deposit.getText())); 	
 		transaction = new TransactionProxy(transaction);
 		transactionManager.setTransaction(transaction);
 		transactionManager.execute();
 		
		dispose();
	}

	private void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}
