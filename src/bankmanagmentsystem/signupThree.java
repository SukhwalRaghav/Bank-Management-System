package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener{

    JRadioButton SavingAC, CurrentAC, FixedDepositAC, RecuringAC;
    JCheckBox atmCardCheckBox, internetBankingCheckBox, mobileBankingCheckBox, emailAlertsCheckBox, chequeBookCheckBox, eStatementCheckBox, Declation;
    JButton submitButton, cancelButton;
    JLabel formNumberLabel, formNumberValue;
    private String formno;

    public signupThree(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("Page 3: Accounts Details");
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel pageTitle = new JLabel("Page 3: Accounts Details");
        pageTitle.setFont(new Font("Raleway", Font.BOLD, 30));
        pageTitle.setBounds(140, 20, 600, 50);
        add(pageTitle);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        accountTypeLabel.setBounds(100, 100, 500, 50);
        add(accountTypeLabel);

        SavingAC = new JRadioButton("Saving Account");
        SavingAC.setFont(new Font("Arial", Font.BOLD, 15));
        SavingAC.setBounds(100, 150, 150, 50);
        SavingAC.setBackground(Color.LIGHT_GRAY);
        add(SavingAC);

        CurrentAC = new JRadioButton("Current Account");
        CurrentAC.setFont(new Font("Arial", Font.BOLD, 15));
        CurrentAC.setBounds(100, 200, 150, 50);
        CurrentAC.setBackground(Color.LIGHT_GRAY);
        add(CurrentAC);

        FixedDepositAC = new JRadioButton("Fixed Deposit Account");
        FixedDepositAC.setFont(new Font("Arial", Font.BOLD, 15));
        FixedDepositAC.setBounds(400, 150, 200, 50);
        FixedDepositAC.setBackground(Color.LIGHT_GRAY);
        add(FixedDepositAC);

        RecuringAC = new JRadioButton("Recuring Deposit Account");
        RecuringAC.setFont(new Font("Arial", Font.BOLD, 15));
        RecuringAC.setBounds(400, 200, 250, 50);
        RecuringAC.setBackground(Color.LIGHT_GRAY);
        add(RecuringAC);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(SavingAC);
        accountTypeGroup.add(CurrentAC);
        accountTypeGroup.add(FixedDepositAC);
        accountTypeGroup.add(RecuringAC);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cardNumberLabel.setBounds(100, 250, 300, 50);
        add(cardNumberLabel);

        JLabel cardInfoLabel = new JLabel("Your 16 Digits Card Number");
        cardInfoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        cardInfoLabel.setBounds(100, 270, 300, 50);
        add(cardInfoLabel);

        JLabel cardNumberValue = new JLabel("XXXX-XXXX-XXXX-4156");
        cardNumberValue.setFont(new Font("Arial", Font.BOLD, 20));
        cardNumberValue.setBounds(400, 250, 300, 50);
        add(cardNumberValue);

        JLabel pinLabel = new JLabel("Pin Number:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pinLabel.setBounds(100, 300, 300, 50);
        add(pinLabel);

        JLabel pinValue = new JLabel("XXXX");
        pinValue.setFont(new Font("Arial", Font.BOLD, 20));
        pinValue.setBounds(400, 300, 300, 50);
        add(pinValue);

        JLabel serviceRequiredLabel = new JLabel("Services Required:");
        serviceRequiredLabel.setFont(new Font("Arial", Font.BOLD, 20));
        serviceRequiredLabel.setBounds(100, 350, 300, 50);
        add(serviceRequiredLabel);

        atmCardCheckBox = new JCheckBox("ATM CARD");
        atmCardCheckBox.setBackground(Color.LIGHT_GRAY);
        atmCardCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        atmCardCheckBox.setBounds(100, 400, 200, 30);
        add(atmCardCheckBox);

        internetBankingCheckBox = new JCheckBox("Internet Banking");
        internetBankingCheckBox.setBackground(Color.LIGHT_GRAY);
        internetBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        internetBankingCheckBox.setBounds(100, 450, 200, 30);
        add(internetBankingCheckBox);

        mobileBankingCheckBox = new JCheckBox("Mobile Banking");
        mobileBankingCheckBox.setBackground(Color.LIGHT_GRAY);
        mobileBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        mobileBankingCheckBox.setBounds(100, 500, 200, 30);
        add(mobileBankingCheckBox);

        emailAlertsCheckBox = new JCheckBox("EMAIL Alerts");
        emailAlertsCheckBox.setBackground(Color.LIGHT_GRAY);
        emailAlertsCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        emailAlertsCheckBox.setBounds(400, 400, 200, 30);
        add(emailAlertsCheckBox);

        chequeBookCheckBox = new JCheckBox("Cheque Book");
        chequeBookCheckBox.setBackground(Color.LIGHT_GRAY);
        chequeBookCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        chequeBookCheckBox.setBounds(400, 450, 200, 30);
        add(chequeBookCheckBox);

        eStatementCheckBox = new JCheckBox("E-Statement");
        eStatementCheckBox.setBackground(Color.LIGHT_GRAY);
        eStatementCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        eStatementCheckBox.setBounds(400, 500, 200, 30);
        add(eStatementCheckBox);


        Declation = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        Declation.setBackground(Color.WHITE);
        Declation.setFont(new Font("Raleway", Font.BOLD, 12));
        Declation.setBounds(100, 600, 600, 30);
        Declation.setBackground(Color.LIGHT_GRAY);
        add(Declation);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(200, 670, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(400, 670, 100, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(800, 750);
        setLocation(350, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == submitButton) {
                String accountType = null;
                if (SavingAC.isSelected()) {
                    accountType = "Saving Account";
                } else if (CurrentAC.isSelected()) {
                    accountType = "Current Account";
                } else if (FixedDepositAC.isSelected()) {
                    accountType = "Fixed Deposit Account";
                } else if (RecuringAC.isSelected()) {
                    accountType = "Recuring Deposit Account";
                }
    
                String services = "";
                if (atmCardCheckBox.isSelected()) {
                    services += "ATM CARD ";
                }
                if (internetBankingCheckBox.isSelected()) {
                    services += "Internet Banking ";
                }
                if (mobileBankingCheckBox.isSelected()) {
                    services += "Mobile Banking ";
                }
                if (emailAlertsCheckBox.isSelected()) {
                    services += "EMAIL Alerts ";
                }
                if (chequeBookCheckBox.isSelected()) {
                    services += "Cheque Book ";
                }
                if (eStatementCheckBox.isSelected()) {
                    services += "E-Statement ";
                }
    
                if (accountType == null || services.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn c1 = new Conn();
                    String cardNumber = generateCardNumber();  // Assuming generateCardNumber() method exists
                    String pin = generatePinNumber();  // Assuming generatePinNumber() method exists
    
                    String q1 = "INSERT INTO signupThree (formno, accountType, cardNumber, pin, facilities) VALUES ('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pin + "', '" + services + "')";
                    String q2 = "INSERT INTO login (formno, cardNumber, pin) VALUES ('" + formno + "', '" + cardNumber + "', '" + pin + "')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pin);
    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            } else if (e.getSource() == cancelButton) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);  // Generate a random digit (0-9)
            cardNumber.append(digit);
        }
        return cardNumber.toString();
    }
    
    private String generatePinNumber() {
        Random random = new Random();
        StringBuilder pinNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);  // Generate a random digit (0-9)
            pinNumber.append(digit);
        }
        return pinNumber.toString();
    }
    
    
    public static void main(String[] args) {
        new signupThree("");
    }
}
