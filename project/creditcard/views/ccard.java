package creditcard.views;

import creditcard.models.CardCustomerAccountBuilder;
import framework.models.IAccount;
import framework.models.ICustomer;
import framework.models.IFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A basic JFC based application.
 **/
public class ccard extends javax.swing.JFrame {
    protected HashMap<String, String> customData = new HashMap<>();
    private String interest = "0.0";
    protected boolean newaccount;
    private static boolean debug = true;
    private static List<IAccount> accountsList = new ArrayList<>();
    protected static List<ICustomer> customersList = new ArrayList<>();
    private ccard thisframe;
    protected String accountType;
    private static IFactory currentFactory;
    private JPanel JPanel1 = new JPanel();
    private JButton JButton_NewCCAccount = new JButton();
    private JButton JButton_GenBill = new JButton();
    private JButton JButton_Deposit = new JButton();
    private JButton JButton_Charge = new JButton();
    private JButton JButton_Exit = new JButton();
    static DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object rowdata[];

    public ccard() {
        thisframe = this;
        setTitle("Credit-card processing Application.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(600, 320);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 600, 320);
        /*
         * /Add five buttons on the pane /for Adding personal account, Adding company
         * account /Deposit, Withdraw and Exit from the system
         */
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[5];
        newaccount = false;
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
        JButton_NewCCAccount.setText("Add Credit-card account");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24, 20, 192, 33);
        JButton_GenBill.setText("Generate Monthly bills");
        JButton_GenBill.setActionCommand("jbutton");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Charge.setText("Charge");
        JPanel1.add(JButton_Charge);
        JButton_Charge.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 218, 96, 31);
        JButton_GenBill.setActionCommand("jbutton");
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(lSymAction);
        JButton_GenBill.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Charge.addActionListener(lSymAction);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    /*****************************************************
     * The entry point for this application. Sets the Look and Feel to the System
     * Look and Feel. Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
            // Create a new instance of our application's frame, and make it visible.
            (new ccard()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    void exitApplication() {
        try {
            this.setVisible(false); // hide the Frame
            this.dispose(); // free the system resources
            System.exit(0); // close the application
        } catch (Exception e) {
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.
        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    // When the Exit button is pressed this code gets executed
    // this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
        /*
         * JDialog_AddPAcc type object is for adding personal information construct a
         * JDialog_AddPAcc type object set the boundaries and show it
         */
        AddCCAccountView ccac = new AddCCAccountView(thisframe);
        ccac.setBounds(450, 20, 300, 400);
        ccac.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
        ccac.show();
        if (newaccount) {
            // add row to table
            customData.put("interest", interest);
            currentFactory = CardCustomerAccountBuilder.getFactoryAccount(accountType);
            ICustomer customer = currentFactory.createCustomer(customData);
            IAccount account = currentFactory.createAccount(customData, customer);
            String formated = "";
            switch (accountType) {
                case "creditCardGold":
                    formated += "Gold";
                    break;
                case "creditCardSilver":
                    formated += "Silver";
                    break;
                case "creditCardBronze":
                    formated += "Bronze";
                    break;
                default:
                    break;
            }
            customersList.add(customer);
            accountsList.add(account);
            model.addRow(
                    new Object[]{customer.getName(), account.getAccNumber(), customer.getEmail(), formated, "0"});
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }
    }

    void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
        GenBillView billFrm = new GenBillView();
        billFrm.setBounds(450, 20, 810, 350);
        billFrm.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
        billFrm.show();
    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);
            String accNumber = (String) model.getValueAt(selection, 1);
            IAccount found = accountsList.stream().filter(x -> x.getAccNumber().equals(accNumber)).findFirst()
                    .orElse(null);
            // Show the dialog for adding deposit amount for the current mane
            DepositView dep = new DepositView(thisframe, name, found);
            dep.setBounds(430, 15, 275, 170);
            dep.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
            dep.show();
            // compute new amount
            double deposit = found.getBalance();
            model.setValueAt(String.valueOf(found.getBalance()), selection, 4);
        }
    }

    void JButtonCharge_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);
            String accNumber = (String) model.getValueAt(selection, 1);
            IAccount found = accountsList.stream().filter(x -> x.getAccNumber().equals(accNumber)).findFirst()
                    .orElse(null);
            // Show the dialog for adding withdraw amount for the current mane
            ChargeView wd = new ChargeView(thisframe, name, found);
            wd.setBounds(430, 15, 275, 170);
            wd.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) event.getSource()));
            wd.show();
            // compute new amount
            double newamount = found.getBalance();
            model.setValueAt(String.valueOf(newamount), selection, 4);
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == ccard.this)
                BankFrm_windowClosing(event);
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_NewCCAccount)
                JButtonNewCCAC_actionPerformed(event);
            else if (object == JButton_GenBill)
                JButtonGenerateBill_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Charge)
                JButtonCharge_actionPerformed(event);
        }
    }
}
