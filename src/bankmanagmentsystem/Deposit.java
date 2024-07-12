package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    private String pinNumber;

    public Deposit(String pinNumber){

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
        JLabel text = new JLabel("Please Enter Your Amount to Deposit");
        text.setBounds(200, 300, 500, 50);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.white);
        img.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setBounds(170,360,320,25);
        img.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial",Font.BOLD,20));
        deposit.setBounds(355,420,150,30);
        deposit.addActionListener(this);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        img.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,20));
        back.setBounds(355,460,150,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        img.add(back);

         // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Amount");
            }else{
                try {
                    Conn c = new Conn();
                    String query = "Insert into bank values('"+pinNumber+"','"+date+"', 'Deposit', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS "+number+ " is Sucessfully Deposited");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
