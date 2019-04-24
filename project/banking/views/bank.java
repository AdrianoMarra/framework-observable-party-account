package banking.views;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import banking.models.BankCustomerAccountsBuilder;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.IFactory;
import framework.models.InterestManager;

import javax.swing.*;

/**
 **
 * A basic JFC based application. 
 * 
 * */
public class bank extends javax.swing.JFrame
{
    /****
     * init variables in the object
     ****/
	protected String accountType;
	private String clientType;
	private String amountDeposit;
	protected boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private bank myframe;
    private Object rowdata[];
    
	private static IFactory currentFactoryAccount;
	protected HashMap<String, String> customData = new HashMap<>();
	private List<ICustomer> customers = new ArrayList<>();
	private InterestManager accountsManager = new InterestManager();
	
	private javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	private javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	private javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	private javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	private javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	private javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	private javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	
	public bank()
	{	
		myframe = this;

		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(600,330);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,600,330);
		
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//      	rowdata = new Object[8];
		
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(462,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,225,96,31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);
		
		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new bank()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	private void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == bank.this)
				BankFrm_windowClosing(event);
		}
	}

	private void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{			 
		BankFrm_windowClosing_Interaction1(event);
	}

	private void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    private void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	private void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		AddCompanyAccountView pac = new AddCompanyAccountView(myframe);
		pac.setBounds(450, 20, 300, 350);
		pac.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
		pac.show();

		if (newaccount) {
			
			//create new account
			String factoryType = "personal" + accountType;
			currentFactoryAccount = BankCustomerAccountsBuilder.getFactoryAccount(factoryType);
			
			ICustomer customer = customers.stream()
					.filter(cust -> cust.getName().equals(customData.get("name")) 
							&& cust.getClass().getSimpleName().equals("Person"))
					.findFirst()
					.orElse(null);
			
			if (customer == null) {
				customer = currentFactoryAccount.createCustomer(customData);
			}
						
			IAccount acc = currentFactoryAccount.createAccount(customData, customer);
			customers.add(customer);
			accountsManager.addAccount(acc);
			
            // add row to table
            rowdata[0] = acc.getAccNumber();
            rowdata[1] = customer.getName();
            rowdata[2] = customer.getCity();
            rowdata[3] = customer.getClass().getSimpleName();
            rowdata[4] = accountType;
            rowdata[5] = acc.getBalance();
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        } 
    }

	private void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		AddCompanyAccountView pac = new AddCompanyAccountView(myframe);
		pac.setBounds(450, 20, 300, 360);
		pac.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
		pac.show();
		
		if (newaccount){
			
			//create new account
			String factoryType = "company" + accountType;
			currentFactoryAccount = BankCustomerAccountsBuilder.getFactoryAccount(factoryType);
			ICustomer customer = customers.stream()
					.filter(cust -> cust.getName().equals(customData.get("name"))
							&& cust.getClass().getSimpleName().equals("Company"))
					.findFirst()
					.orElse(null);
			
			if (customer == null) {
				customer = currentFactoryAccount.createCustomer(customData);
			}

			IAccount acc = currentFactoryAccount.createAccount(customData, customer);
			customers.add(customer);
			accountsManager.addAccount(acc);
			
            // add row to table
            rowdata[0] = acc.getAccNumber();
            rowdata[1] = customer.getName();
            rowdata[2] = customer.getCity();
            rowdata[3] = customer.getClass().getSimpleName();
            rowdata[4] = accountType;
            rowdata[5] = acc.getBalance();
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

	}
	
	private void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
       
		if (selection >= 0) {
			String accNumber = (String) model.getValueAt(selection, 0);
			
			IAccount found = accountsManager.getAccounts()
					.stream().filter(x -> x.getAccNumber().equals(accNumber))
					.findFirst()
					.orElse(null);
		
			// Show the dialog for adding deposit amount for the current mane
			DepositView dep = new DepositView(myframe, accNumber, found);
			dep.setBounds(430, 15, 275, 160);
			dep.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
			dep.show();

			// get new balance
			double newBalance = found.getBalance();
			model.setValueAt(newBalance, selection, 5);
		}
	}

	private void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{		
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
       
		if (selection >= 0) {
			String accNumber = (String) model.getValueAt(selection, 0);
			
			IAccount found = accountsManager.getAccounts()
					.stream().filter(x -> x.getAccNumber().equals(accNumber))
					.findFirst()
					.orElse(null);
		
			// Show the dialog for adding deposit amount for the current mane
			WithdrawView dep = new WithdrawView(myframe, accNumber, found);
			dep.setBounds(430, 15, 275, 160);
			dep.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
			dep.show();

			// get new balance
			double newBalance = found.getBalance();
			model.setValueAt(newBalance, selection, 5);
		}
	}
	
	private void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  accountsManager.updateAccountsInterest();
		  for (int i = 0; i < accountsManager.getAccounts().size(); i++) {
			  	Double newBalance = accountsManager.getAccounts().get(i).getBalance();
				model.setValueAt(newBalance, i, 5);
		  }
		  	
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Added interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	}
}
