package bankmanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanaceEnquiry extends JFrame implements ActionListener {

    JButton back;
    private String pinNumber;

    public BalanaceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance RS " + balance);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setBounds(160, 300, 500, 30);
        text.setForeground(Color.white);
        img.add(text);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(350, 485, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        img.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanaceEnquiry("");
    }
}
