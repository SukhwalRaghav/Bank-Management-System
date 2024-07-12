package bankmanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener {

    JPasswordField newfield, refield;
    JButton changePin, back;
    private String pinNumber;

    public ChangePin(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        JLabel text = new JLabel("Change your Pin");
        text.setBounds(230, 280, 500, 50);
        text.setFont(new Font("System", Font.BOLD, 25));
        text.setForeground(Color.white);
        img.add(text);

        JLabel newpin = new JLabel("New Pin: ");
        newpin.setBounds(180, 350, 300, 35);
        newpin.setFont(new Font("System", Font.BOLD, 20));
        newpin.setForeground(Color.white);
        img.add(newpin);

        newfield = new JPasswordField();
        newfield.setBounds(280, 355, 200, 30);
        newfield.setFont(new Font("Raleway", Font.BOLD, 20));
        img.add(newfield);

        JLabel repin = new JLabel("Re-Pin: ");
        repin.setBounds(180, 400, 300, 35);
        repin.setFont(new Font("System", Font.BOLD, 20));
        repin.setForeground(Color.white);
        img.add(repin);

        refield = new JPasswordField();
        refield.setBounds(280, 405, 200, 30);
        refield.setFont(new Font("Raleway", Font.BOLD, 20));
        img.add(refield);

        changePin = new JButton("Change Pin");
        changePin.setFont(new Font("Arial", Font.BOLD, 20));
        changePin.setBounds(160, 460, 150, 30);
        changePin.addActionListener(this);
        changePin.setBackground(Color.BLACK);
        changePin.setForeground(Color.white);
        img.add(changePin);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(350, 460, 150, 30);
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
        if (e.getSource() == changePin) {
            try {
                String npin = newfield.getText();
                String rnpin = refield.getText();

                if (!npin.equals(rnpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the New PIN");
                    return;
                } else if (rnpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the RE-PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin='" + npin + "' where pin='" + pinNumber + "'";
                String query2 = "update login set pin='" + npin + "' where pin='" + pinNumber + "'";
                String query3 = "update signupThree set pin='" + npin + "' where pin='" + pinNumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transaction(npin).setVisible(true);

            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
