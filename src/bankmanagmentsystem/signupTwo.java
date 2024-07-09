package bankmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class signupTwo extends JFrame implements ActionListener {

    long random;
    JTextField panNumberTextField, adharNumberTextField;
    JRadioButton yesSeniorCitizen, noSeniorCitizen, yesExistingAccount, noExistingAccount;
    JButton next;
    JComboBox<String> religionComboBox, categoryComboBox, educationComboBox, occupationComboBox, incomeComboBox;
    private String formno;

    public signupTwo(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("Page 2: Additional Details");
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(260, 60, 600, 50);
        add(additionalDetails);

        // Religion: 
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD, 18));
        religion.setBounds(140, 120, 250, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox = new JComboBox<>(valReligion);
        religionComboBox.setBounds(300, 120, 250, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        // Category: 
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Arial", Font.BOLD, 18));
        category.setBounds(140, 170, 250, 30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox<>(valCategory);
        categoryComboBox.setBounds(300, 170, 250, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        // Educational Qualification:
        JLabel ed = new JLabel("Educational");
        ed.setFont(new Font("Arial", Font.BOLD, 18));
        ed.setBounds(140, 200, 250, 30);
        add(ed);
        JLabel educationalQualification = new JLabel("Qualification: ");
        educationalQualification.setFont(new Font("Arial", Font.BOLD, 18));
        educationalQualification.setBounds(140, 220, 250, 30);
        add(educationalQualification);

        String valEducations[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctorate", "Others"};
        educationComboBox = new JComboBox<>(valEducations);
        educationComboBox.setBounds(300, 220, 250, 30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        // Occupation:
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Arial", Font.BOLD, 18));
        occupation.setBounds(140, 270, 250, 30);
        add(occupation);

        String valOccupation[] = {"Student", "Salaried", "Self-Employed", "Businessman", "Others"};
        occupationComboBox = new JComboBox<>(valOccupation);
        occupationComboBox.setBounds(300, 270, 250, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        // Income:
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Arial", Font.BOLD, 18));
        income.setBounds(140, 320, 250, 30);
        add(income);

        String valIncome[] = {"Null", "<10,000", "<250,000", "<500,000", "Upto 1,000,000"};
        incomeComboBox = new JComboBox<>(valIncome);
        incomeComboBox.setBounds(300, 320, 250, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        // PAN Number:
        JLabel panNumber = new JLabel("Pan Number: ");
        panNumber.setFont(new Font("Arial", Font.BOLD, 18));
        panNumber.setBounds(140, 370, 250, 30);
        add(panNumber);

        panNumberTextField = new JTextField();
        panNumberTextField.setBounds(300, 370, 250, 30);
        panNumberTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(panNumberTextField);

        // Aadhar Number:
        JLabel aadharNumber = new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Arial", Font.BOLD, 18));
        aadharNumber.setBounds(140, 420, 250, 30);
        add(aadharNumber);

        adharNumberTextField = new JTextField();
        adharNumberTextField.setBounds(300, 420, 250, 30);
        adharNumberTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(adharNumberTextField);

        // Senior Citizen:
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Arial", Font.BOLD, 18));
        seniorCitizen.setBounds(140, 470, 250, 30);
        add(seniorCitizen);

        yesSeniorCitizen = new JRadioButton("Yes");
        yesSeniorCitizen.setBounds(300, 470, 60, 30);
        yesSeniorCitizen.setBackground(Color.LIGHT_GRAY);
        add(yesSeniorCitizen);

        noSeniorCitizen = new JRadioButton("No");
        noSeniorCitizen.setBounds(370, 470, 80, 30);
        noSeniorCitizen.setBackground(Color.LIGHT_GRAY);
        add(noSeniorCitizen);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yesSeniorCitizen);
        seniorCitizenGroup.add(noSeniorCitizen);

        // Existing Account:
        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Arial", Font.BOLD, 18));
        existingAccount.setBounds(140, 520, 250, 30);
        add(existingAccount);

        yesExistingAccount = new JRadioButton("Yes");
        yesExistingAccount.setBounds(300, 520, 60, 30);
        yesExistingAccount.setBackground(Color.LIGHT_GRAY);
        add(yesExistingAccount);

        noExistingAccount = new JRadioButton("No");
        noExistingAccount.setBounds(370, 520, 100, 30);
        noExistingAccount.setBackground(Color.LIGHT_GRAY);
        add(noExistingAccount);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(yesExistingAccount);
        existingAccountGroup.add(noExistingAccount);

        // Next Button: 
        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(450, 570, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(800, 750);
        setLocation(350, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // Handle the button click event
            String religion = (String) religionComboBox.getSelectedItem();
            String category = (String) categoryComboBox.getSelectedItem();
            String education = (String) educationComboBox.getSelectedItem();
            String occupation = (String) occupationComboBox.getSelectedItem();
            String income = (String) incomeComboBox.getSelectedItem();
            String panNumber = panNumberTextField.getText();
            String aadharNumber = adharNumberTextField.getText();
            String seniorCitizen = yesSeniorCitizen.isSelected() ? "Yes" : "No";
            String existingAccount = yesExistingAccount.isSelected() ? "Yes" : "No";

            // Validation checks
            if (religion.isEmpty() || category.isEmpty() || education.isEmpty() || occupation.isEmpty() ||
                income.isEmpty() || panNumber.isEmpty() || aadharNumber.isEmpty() ||
                (!yesSeniorCitizen.isSelected() && !noSeniorCitizen.isSelected()) ||
                (!yesExistingAccount.isSelected() && !noExistingAccount.isSelected())) {

                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }
            
            try {
                Conn c = new Conn();
                String query = "INSERT INTO signupTwo VALUES ('" + formno + "', '" + religion + "', '" + category + "', '" + education + "', '" + occupation + "', '" + income + "', '" + panNumber + "', '" + aadharNumber + "', '" + seniorCitizen + "', '" + existingAccount +"')";
                JOptionPane.showMessageDialog(null, "Page 2: Form submitted successfully!");
                c.s.executeUpdate(query);

                new signupThree(formno).setVisible(true);
                setVisible(false);
                
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            // Proceed to the next step
            // new SignupThree(formno).setVisible(true); // Uncomment this when the SignupThree class is available
            // dispose();
        }
    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}
