package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ministatement extends JFrame{

    private String pinNumber;

    public Ministatement(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);
        setTitle("Mini Statement");

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(100, 30, 500, 20);
        bank.setForeground(Color.BLACK);
        bank.setFont(new Font("Arial", Font.BOLD, 20));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 400, 20);
        card.setForeground(Color.BLACK);
        card.setFont(new Font("Arial", Font.BOLD, 15));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 150, 400, 300); // Adjusted size to fit multiple lines
        mini.setForeground(Color.BLACK);
        mini.setFont(new Font("Arial", Font.BOLD, 15));
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20, 450, 300, 20);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Arial", Font.BOLD, 15));
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinNumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }

            rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            StringBuilder transactions = new StringBuilder("<html>");
            int bal = 0;
            while (rs.next()) {
                transactions.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount")).append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            transactions.append("</html>");
            mini.setText(transactions.toString());
            balance.setText("Your Current Account Balance: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(450, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ministatement("");
    }
}
