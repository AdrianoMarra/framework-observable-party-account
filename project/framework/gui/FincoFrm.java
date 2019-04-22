package framework.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bank.bankUI.BankFrm;
import card.CardFrm;

public class FincoFrm extends javax.swing.JFrame {

	boolean newaccount;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private DefaultTableModel model;
	FincoFrm thisframe;
	private Object rowdata[];

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenReport = new javax.swing.JButton();
	javax.swing.JButton JButton_Transaction = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	public FincoFrm() {
		thisframe = this;
		
		//set configuration form financial application		
		setTitle("Financial Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);		
		
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		JScrollPane1 = new JScrollPane();
		
		//create table and model values
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("");
		model.addColumn("");
		model.addColumn("");
		model.addColumn("");
		JPanel1.add(JScrollPane1);
		rowdata = new Object[7];
		newaccount = false;		
		
		//configuring jpanel and scrollpanel
		JPanel1.add(JScrollPane1)
		
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);				
		JTable1.setBounds(0, 0, 420, 0);
		
		
		JButton_NewAccount.setText("Add Account");
		JPanel1.add(JButton_NewAccount);
		
		JButton_NewAccount.setBounds(24,20,192,33);
		JButton_GenReport.setText("Generate Report");
		JButton_GenReport.setActionCommand("jbutton");
		
		SymWindow aSymWindow = new SymWindow();			
	}

	void exitApplication() {
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
			if (object == FincoFrm.this)
				FincoFrm_windowClosing(e);
		}
	}

	void FincoFrm_windowClosing(java.awt.event.WindowEvent e) {
		FincoFrm_windowClosing_Interaction(e);
	}

	void FincoFrm_windowClosing_Interaction(java.awt.event.WindowEvent event) {
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
			
		}

		void JButtonTransaction_actionPerformed(ActionEvent e) 
		{
			
		}

		void JButtonGenReport_actionPerformed(ActionEvent e) {

		}

		void JButtonAcc_actionPerformed(ActionEvent e) {
			 JDialog_AddAccount fincoAcc = new JDialog_AddAccount(thisframe);
			 fincoAcc.setBounds(450,20,300,380);
			 fincoAcc.show();
			 
			 if (newaccount) 
			 {				 
				 model.addRow(new Customer());
				
				 JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				 newaccount = false;
			 }
		
		}

		void JButtonExit_actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {

	}

}
