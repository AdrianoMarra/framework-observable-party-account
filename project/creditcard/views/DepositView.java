package creditcard.views;

import creditcard.models.Deposit;
import framework.models.*;

import javax.swing.*;

public class DepositView extends javax.swing.JDialog {
    // {{DECLARE_CONTROLS
    private JLabel JLabel1 = new JLabel();
    private JLabel JLabel2 = new JLabel();
    private JTextField JTextField_NAME = new JTextField();
    private JButton JButton_OK = new JButton();
    private JButton JButton_Cancel = new JButton();
    private JTextField JTextField_Deposit = new JTextField();
    private ccard parentframe;
    private String name;
    private IAccount acc;
    ITransactionManager transactionManager = new TransactionManager();

    public DepositView(ccard parent, String aname, IAccount acc) {
        super(parent);
        parentframe = parent;
        this.name = aname;
        this.acc = acc;
        // This code is automatically generated by Visual Cafe when you add
        // components to the visual environment. It instantiates and initializes
        // the components. To modify the code, only use code syntax that matches
        // what Visual Cafe can generate, or Visual Cafe may be unable to back
        // parses your Java file into its visual envirenment.
        // {{ INIT_CONTROLS
        setTitle("Deposit");
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
    // }}

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Cancel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        double newBalance = acc.getBalance() - Double.parseDouble(JTextField_Deposit.getText());
        if (newBalance < 0) {
            JOptionPane.showMessageDialog(this,
                    "You are not able to do a deposit because your balance is going to get negative.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ITransaction transaction = new Deposit(acc, Double.parseDouble(JTextField_Deposit.getText()));
        transaction = new TransactionProxy(transaction);
        transactionManager.setTransaction(transaction);
        transactionManager.execute();
        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }
}