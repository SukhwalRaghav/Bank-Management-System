package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {

    long random;
    JTextField namTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, countryTextField, pincodeTextField;
    JRadioButton male, female, other, married, unmarried;
    JButton next;
    JDateChooser dateChooser;

    public signupOne() {

        setLayout(null);
        setTitle("Page 1: Personal Details");
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Random Form Button: 
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("Application Form No: " + random);
        formNo.setFont(new Font("Arial", Font.BOLD, 40));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(260, 60, 600, 50);
        add(personalDetails);

        // Name: 
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(140, 120, 250, 30);
        add(name);

        namTextField = new JTextField();
        namTextField.setBounds(300, 120, 250, 30);
        namTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(namTextField);

        // Father Name: 
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Arial", Font.BOLD, 18));
        fname.setBounds(140, 170, 250, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 170, 250, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnameTextField);

        // Date of Birth: 
        JLabel dob = new JLabel("DOB: ");
        dob.setFont(new Font("Arial", Font.BOLD, 18));
        dob.setBounds(140, 220, 250, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 250, 30);
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 18));
        gender.setBounds(140, 270, 250, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 270, 60, 30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(370, 270, 80, 30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(460, 270, 80, 30);
        other.setBackground(Color.LIGHT_GRAY);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        // Email ID:
        JLabel email = new JLabel("Email ID: ");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setBounds(140, 320, 250, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 320, 250, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailTextField);

        // Marital Status:
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Arial", Font.BOLD, 18));
        marital.setBounds(140, 370, 250, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 370, 100, 30);
        married.setBackground(Color.LIGHT_GRAY);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 370, 100, 30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        // Address: 
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Arial", Font.BOLD, 18));
        address.setBounds(140, 420, 250, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 420, 250, 30);
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(addressTextField);

        // City:
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setBounds(140, 470, 250, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 470, 250, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cityTextField);

        // State: 
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setBounds(140, 520, 250, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 520, 250, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(stateTextField);

        // Country: 
        JLabel country = new JLabel("Country: ");
        country.setFont(new Font("Arial", Font.BOLD, 18));
        country.setBounds(140, 570, 250, 30);
        add(country);

        countryTextField = new JTextField();
        countryTextField.setBounds(300, 570, 250, 30);
        countryTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(countryTextField);

        // Pincode: 
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Arial", Font.BOLD, 18));
        pincode.setBounds(140, 620, 250, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 620, 250, 30);
        pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pincodeTextField);

        // Next Button: 
        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(450, 670, 100, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);


        setSize(800, 750);
        setLocation(350, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = "" + random;
        String name = namTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(other.isSelected()){
            gender = "Other";
        }

        String email = emailTextField.getText();

        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String country = countryTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if(gender == null){
                JOptionPane.showMessageDialog(null,"Gender is Required");
            }else if(marital == null){
                JOptionPane.showMessageDialog(null,"Marital Status is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if(country.equals("")){
                JOptionPane.showMessageDialog(null,"Country is Required");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode is Required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES ('" + formNo + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + country + "', '" + pincode + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Page 1: Form submitted successfully!");
                setVisible(false);

                new signupTwo(formNo).setVisible(true);
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public static void main(String[] args) {
        new signupOne();
    }
}
