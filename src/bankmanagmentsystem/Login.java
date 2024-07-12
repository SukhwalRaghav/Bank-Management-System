package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, reset;
    JTextField cardTextfield;
    JPasswordField pinTextfield;

    public Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel titleText = new JLabel("Welcome to ATM", SwingConstants.CENTER);
        titleText.setFont(new Font("Osward", Font.BOLD, 40));
        titleText.setBounds(200, 40, 400, 40);
        add(titleText);

        JLabel cardText = new JLabel("Card No:");
        cardText.setFont(new Font("Raleway", Font.BOLD, 20));
        cardText.setBounds(200, 150, 150, 30);
        add(cardText);

        cardTextfield = new JTextField();
        cardTextfield.setBounds(300, 150, 250, 30);
        cardTextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextfield);

        JLabel pinText = new JLabel("PIN:");
        pinText.setFont(new Font("Raleway", Font.BOLD, 20));
        pinText.setBounds(200, 220, 150, 30);
        add(pinText);

        pinTextfield = new JPasswordField();
        pinTextfield.setBounds(300, 220, 250, 30);
        pinTextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextfield);

        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        reset = new JButton("RESET");
        reset.setBounds(450, 300, 100, 30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        signUp = new JButton("Create Account");
        signUp.setBounds(300, 350, 250, 30);
        signUp.setFont(new Font("Arial",Font.BOLD,15));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 450);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            Conn c = new Conn();
            String cardNumber = cardTextfield.getText().trim();
            String pinNumber = new String(pinTextfield.getPassword()).trim();
            String query = "SELECT * FROM login WHERE cardNumber = ? AND pin = ?";

            try (PreparedStatement pst = c.c.prepareStatement(query)) {
                pst.setString(1, cardNumber);
                pst.setString(2, pinNumber);
                ResultSet result = pst.executeQuery();

                if (result.next()) {
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == signUp) {
            setVisible(false);
            new signupOne().setVisible(true);
        } else if (e.getSource() == reset) {
            cardTextfield.setText("");
            pinTextfield.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
