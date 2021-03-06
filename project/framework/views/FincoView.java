package framework.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import framework.finco;
import framework.models.AccountBuilder;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.ICustomerAccountFactory;

public class FincoView extends javax.swing.JFrame {

	protected boolean newaccount;
	protected double amountDeposit;

	protected HashMap<String, String> customerMap;
	protected HashMap<String, String> accountMap;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private DefaultTableModel model;
	private FincoView thisframe;
	private Object rowdata[];
	private ICustomerAccountFactory customerAccountFactory;

	private javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	private javax.swing.JButton JButton_NewAccount = new javax.swing.JButton();
	private javax.swing.JButton JButton_GenReport = new javax.swing.JButton();
	private javax.swing.JButton JButton_Transaction = new javax.swing.JButton();
	private javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	private javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();

	public FincoView() {
		thisframe = this;

		// set configuration form financial application
		setTitle("Financial Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(605, 350);
		setVisible(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		JScrollPane1 = new JScrollPane();

		// create table and model values
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("AccountNr");
		model.addColumn("Amount");
		JPanel1.add(JScrollPane1);

		rowdata = new Object[3];
		newaccount = false;

		// configuring jpanel and scrollpanel
		JPanel1.add(JScrollPane1);

		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		JButton_NewAccount.setText("Add Account");
		JPanel1.add(JButton_NewAccount);

		JButton_NewAccount.setBounds(24, 20, 192, 33);
		JButton_GenReport.setText("Generate Report");
		JButton_GenReport.setActionCommand("jbutton");
		JPanel1.add(JButton_GenReport);
		JButton_GenReport.setBounds(240, 20, 192, 33);
		JButton_Transaction.setText("Deposit");
		JPanel1.add(JButton_Transaction);
		JButton_Transaction.setBounds(468, 104, 110, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 110, 31);
		JButton_GenReport.setActionCommand("jbutton");
		JButton_Addinterest.setBounds(468, 20, 110, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction ISymAction = new SymAction();
		JButton_Exit.addActionListener(ISymAction);
		JButton_GenReport.addActionListener(ISymAction);
		JButton_NewAccount.addActionListener(ISymAction);
		JButton_Transaction.addActionListener(ISymAction);
		JButton_Addinterest.addActionListener(ISymAction);

		// getting factory
		customerAccountFactory = AccountBuilder.getFactoryAccount("");

	}

	private void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(WindowEvent e) {
			Object object = e.getSource();
			if (object == FincoView.this)
				FincoFrm_windowClosing(e);
		}
	}

	private void FincoFrm_windowClosing(java.awt.event.WindowEvent e) {
		FincoFrm_windowClosing_Interaction(e);
	}

	private void FincoFrm_windowClosing_Interaction(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object object = e.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(e);
			else if (object == JButton_NewAccount)
				JButtonAcc_actionPerformed(e);
			else if (object == JButton_GenReport)
				JButtonGenReport_actionPerformed(e);
			else if (object == JButton_Transaction)
				JButtonTransaction_actionPerformed(e);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(e);

		}
	}

	private void JButtonTransaction_actionPerformed(ActionEvent e) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();

		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			String accNumber = (String) model.getValueAt(selection, 1);
			IAccount found = finco.accountsManager.getAccounts().stream()
					.filter(x -> x.getAccNumber().equals(accNumber)).findFirst().orElse(null);

			// Show the dialog for adding deposit amount for the current mane
			TransactionView dep = new TransactionView(thisframe, name, found);
			dep.setBounds(430, 15, 275, 160);
			dep.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) e.getSource()));
			dep.show();

			// compute new amount
			double deposit = found.getBalance();
			double samount = Double.parseDouble((String) model.getValueAt(selection, 2));
			double currentamount = samount;
			double newamount = currentamount + deposit;

			model.setValueAt(String.valueOf(newamount), selection, 2);
		}
	}

	private void JButtonGenReport_actionPerformed(ActionEvent e) {
		GenerateReportView billFrm = new GenerateReportView(thisframe);
		billFrm.setBounds(450, 20, 810, 350);
		billFrm.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) e.getSource()));
		billFrm.show();
	}

	private void JButtonAcc_actionPerformed(ActionEvent e) {
		AddAccountView fincoAcc = new AddAccountView(thisframe);
		fincoAcc.setBounds(450, 20, 300, 300);
		fincoAcc.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) e.getSource()));
		fincoAcc.show();

		if (newaccount) {
			ICustomer customer = customerAccountFactory.createCustomer(customerMap);
			IAccount account = customerAccountFactory.createAccount(accountMap, customer);

			finco.customerList.add(customer);
			finco.accountsManager.addAccount(account);

			model.addRow(
					new Object[] { customer.getName(), account.getAccNumber(), Double.toString(account.getBalance()) });
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
			customerMap.clear();
			accountMap.clear();
		}
	}

	private void JButtonExit_actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		finco.accountsManager.updateAccountsInterest();

		for (int i = 0; i < finco.accountsManager.getAccounts().size(); i++)
			model.setValueAt(String.valueOf(finco.accountsManager.getAccounts().get(i).getBalance()), i, 2);

		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

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
