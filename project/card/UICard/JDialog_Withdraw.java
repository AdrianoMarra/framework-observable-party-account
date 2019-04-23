package card.UICard;


public class JDialog_Withdraw extends javax.swing.JDialog {

    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_AMT = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
    private CardFrm parentframe;
    private String name;
    public JDialog_Withdraw(CardFrm parent, String aname) {
        super(parent);
        parentframe = parent;
        name = aname;

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
        parentframe.amountDeposit = JTextField_AMT.getText();
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