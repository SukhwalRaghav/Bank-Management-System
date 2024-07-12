package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton one, two, three, four, five, six, back;
    private String pinNumber;

    public FastCash(String pinNumber) {
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
        JLabel text = new JLabel("Please Select Amount for FastCash");
        text.setBounds(180, 300, 500, 50);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.white);
        img.add(text);

        // Deposit Button
        one = new JButton("RS 100");
        one.setBounds(160, 415, 160, 30);
        one.setFont(new Font("System", Font.BOLD, 15));
        one.addActionListener(this);
        one.setBackground(Color.black);
        one.setForeground(Color.white);
        img.add(one);

        // Cash Withdrawal Button
        two = new JButton("RS 500");
        two.setBounds(350, 415, 160, 30);
        two.setFont(new Font("System", Font.BOLD, 15));
        two.addActionListener(this);
        two.setBackground(Color.black);
        two.setForeground(Color.white);
        img.add(two);

        // Fast Cash Button
        three = new JButton("RS 1000");
        three.setBounds(160, 450, 160, 30);
        three.setFont(new Font("System", Font.BOLD, 15));
        three.addActionListener(this);
        three.setBackground(Color.black);
        three.setForeground(Color.white);
        img.add(three);

        // Mini Statement Button
        four = new JButton("RS 2000");
        four.setBounds(350, 450, 160, 30);
        four.setFont(new Font("System", Font.BOLD, 15));
        four.addActionListener(this);
        four.setBackground(Color.black);
        four.setForeground(Color.white);
        img.add(four);

        // Pin Change Button
        five = new JButton("RS 5000");
        five.setBounds(160, 485, 160, 30);
        five.setFont(new Font("System", Font.BOLD, 15));
        five.addActionListener(this);
        five.setBackground(Color.black);
        five.setForeground(Color.white);
        img.add(five);

        // Balance Enquiry Button
        six = new JButton("RS 10000");
        six.setBounds(350, 485, 160, 30);
        six.setFont(new Font("System", Font.BOLD, 15));
        six.addActionListener(this);
        six.setBackground(Color.black);
        six.setForeground(Color.white);
        img.add(six);

        // Exit Button
        back = new JButton("Back");
        back.setBounds(350, 520, 160, 30);
        back.setFont(new Font("System", Font.BOLD, 15));
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        img.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else {
            String number = ((JButton)e.getSource()).getText().substring(3);
            int amountToWithdraw = Integer.parseInt(number);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(balance < amountToWithdraw){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }else{
                    Date date = new Date();
                    String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + amountToWithdraw + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + amountToWithdraw + " is Successfully Withdrawn");

                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }

            } catch (Exception ee) {
                System.out.println(ee);
            }
        } 
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
