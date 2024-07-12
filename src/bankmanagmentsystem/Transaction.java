package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, fastCash, pinChange, cashWithdrawal, miniStatement, balanceEnquiry, moreServices, exit;
    private String pinNumber;
    public Transaction(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        // Header Text
        JLabel text = new JLabel("Please Select Your Transactions");
        text.setBounds(180, 300, 500, 50);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.white);
        img.add(text);

        // Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBounds(160, 415, 160, 30);
        deposit.setFont(new Font("System", Font.BOLD, 15));
        deposit.addActionListener(this);
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        img.add(deposit);

        // Cash Withdrawal Button
        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(350, 415, 160, 30);
        cashWithdrawal.setFont(new Font("System", Font.BOLD, 15));
        cashWithdrawal.addActionListener(this);
        cashWithdrawal.setBackground(Color.black);
        cashWithdrawal.setForeground(Color.white);
        img.add(cashWithdrawal);

        // Fast Cash Button
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160, 450, 160, 30);
        fastCash.setFont(new Font("System", Font.BOLD, 15));
        fastCash.addActionListener(this);
        fastCash.setBackground(Color.black);
        fastCash.setForeground(Color.white);
        img.add(fastCash);

        // Mini Statement Button
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(350, 450, 160, 30);
        miniStatement.setFont(new Font("System", Font.BOLD, 15));
        miniStatement.addActionListener(this);
        miniStatement.setBackground(Color.black);
        miniStatement.setForeground(Color.white);
        img.add(miniStatement);

        // Pin Change Button
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160, 485, 160, 30);
        pinChange.setFont(new Font("System", Font.BOLD, 15));
        pinChange.addActionListener(this);
        pinChange.setBackground(Color.black);
        pinChange.setForeground(Color.white);
        img.add(pinChange);

        // Balance Enquiry Button
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(350, 485, 160, 30);
        balanceEnquiry.setFont(new Font("System", Font.BOLD, 15));
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setBackground(Color.black);
        balanceEnquiry.setForeground(Color.white);
        img.add(balanceEnquiry);

        // More Services Button
        moreServices = new JButton("More Services");
        moreServices.setBounds(160, 520, 160, 30);
        moreServices.setFont(new Font("System", Font.BOLD, 15));
        moreServices.addActionListener(this);
        moreServices.setBackground(Color.black);
        moreServices.setForeground(Color.white);
        img.add(moreServices);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(350, 520, 160, 30);
        exit.setFont(new Font("System", Font.BOLD, 15));
        exit.addActionListener(this);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        img.add(exit);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            // Handle Deposit action
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
            // Open deposit window or dialog
        } else if (e.getSource() == cashWithdrawal) {
            // Handle Cash Withdrawal action
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
            // Open cash withdrawal window or dialog
        } else if (e.getSource() == fastCash) {
            // Handle Fast Cash action
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
            // Open fast cash window or dialog
        } else if (e.getSource() == miniStatement) {
            // Handle Mini Statement action
            new Ministatement(pinNumber).setVisible(true);
            // Open mini statement window or dialog
        } else if (e.getSource() == pinChange) {
            // Handle Pin Change action
            setVisible(false);
            new ChangePin(pinNumber).setVisible(true);
            // Open pin change window or dialog
        } else if (e.getSource() == balanceEnquiry) {
            // Handle Balance Enquiry action
            setVisible(false);
            new BalanaceEnquiry(pinNumber).setVisible(true);
            // Open balance enquiry window or dialog
        } else if (e.getSource() == moreServices) {
            // Handle More Services action
            JOptionPane.showMessageDialog(null, "More Services selected");
            // Open more services window or dialog
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
