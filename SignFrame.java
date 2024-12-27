import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignFrame extends JFrame implements ActionListener {

    ArrayList<ManagementAccounts> mangeAccounts = newAccount.mangeAccounts;
    ArrayList<customerAccounts> customeAccounts = newAccount.customeAccounts;

    Border border = BorderFactory.createLineBorder(Color.red, 3); // will be added to the empty text field
    ImageIcon backImage;
    JLabel label;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton submitButton;
    JButton signButton;
    JButton newAccountButton;
    JCheckBox checkBox;
    boolean mainCheck; // to check if the operation is sign in or to make a new account
    boolean emptyCheck = true; // tho check if the text field is empty or not
    String userName;
    String password;
    String employeeNumber;
    boolean userCheck;
    boolean passwordCheck;
    boolean employeeNumberCheck;

    JLabel userLabel;
    JLabel passLabel;

    SignFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 830);
        this.setLayout(null);

        backImage = new ImageIcon("firstFrame.png");

        label = new JLabel();
        label.setBounds(0, 0, 800, 830);
        label.setIcon(backImage);

        newAccountButton = new JButton("new account");
        newAccountButton.setBounds(220, 595, 110, 30);
        newAccountButton.setBackground(Color.black);
        newAccountButton.setForeground(Color.BLUE);
        newAccountButton.setFocusable(false);
        newAccountButton.addActionListener(this);

        submitButton = new JButton("submit");
        submitButton.setBounds(340, 595, 80, 30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFocusable(false);
        submitButton.setEnabled(true);
        submitButton.addActionListener(this);

        userTextField = new JTextField();
        userTextField.setBounds(220, 491, 170, 50);
        userTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        userTextField.setBackground(Color.white);
        userTextField.setCaretColor(Color.white);

        userLabel = new JLabel("User Name");
        userLabel.setBounds(130, 491, 70, 40);
        userLabel.setForeground(Color.BLACK);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(220, 541, 170, 50);
        passwordTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        passwordTextField.setBackground(Color.white);
        passwordTextField.setCaretColor(Color.white);

        passLabel = new JLabel("Password");
        passLabel.setBounds(130, 541, 70, 40);
        passLabel.setForeground(Color.BLACK);

        label.add(userTextField);
        label.add(passwordTextField);
        label.add(submitButton);
        label.add(newAccountButton);
        label.add(userLabel);
        label.add(passLabel);

        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newAccountButton) {
            new newAccount();
            this.dispose();
        }
        if (e.getSource() == submitButton) {

            userName = userTextField.getText();
            password = passwordTextField.getText();

            if(userName.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter your username and password", 
                    " ", JOptionPane.ERROR_MESSAGE);
            } else{

            boolean check;
            if (!userName.equals("employee")) { // customer
                check = accountsExsisted1(userName, password);
                if (check) {
                    // customerAccounts.howManyTimes += 1;
                    this.dispose();
                    // System.out.println(customerAccounts.howManyTimes);
                    new MealOrder(false);
                } else {
                    JOptionPane.showMessageDialog(null, "wrong account", 
                    " ", JOptionPane.ERROR_MESSAGE);
                }
            } else { // manager
                employeeNumber = JOptionPane.showInputDialog("enter the employee password");
                check = accountsExsisted2(userName, password, employeeNumber);
                if (check) {

                    // System.out.println(ManagementAccounts.howManyTimes);
                    this.dispose();
                    // new firstFrame();
                    new MealOrder(true);
                } else {
                    JOptionPane.showMessageDialog(null, "wrong account", 
                    " ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    } // the end of submite button's conditions

    void extera() {
        if (userTextField.getText().isEmpty()) {
            userTextField.setBorder(border);
            userTextField.setText("enter a user name");
            emptyCheck = false;
        }
        if (passwordTextField.getText().isEmpty()) {
            passwordTextField.setBorder(border);
            passwordTextField.setText("enter a password");
            emptyCheck = false;
        }
    }

    boolean accountsExsisted1(String user, String pass) { // customers
        boolean tempoCheck = false;
        // boolean justForUser = user.equals("user name") || user.equals("enter a user
        // name");
        if (!customeAccounts.isEmpty()) {
            for (int n = 0; n < customeAccounts.size(); n++) {
                if (user.equals(customeAccounts.get(n).getName())) {
                    if (pass.equals(customeAccounts.get(n).getPassword())) {
                        tempoCheck = true;
                        customeAccounts.get(n).setHowManyTimes(customeAccounts.get(n).getHowManyTimes() + 1);
                        break;
                    }
                }
            }
        }
        return tempoCheck;
    }

    boolean accountsExsisted2(String user, String pass, String employeeNum) { // manager
        boolean tempoCheck = false;
        if (!mangeAccounts.isEmpty()) {
            for (int n = 0; n < mangeAccounts.size(); n++) {
                if (user.equals("employee")) {
                    if (pass.equals(mangeAccounts.get(n).getPassword())) {
                        if (employeeNum.equals("7879")) {
                            tempoCheck = true;
                            mangeAccounts.get(n).setHowManyTimes(mangeAccounts.get(n).getHowManyTimes() + 1);

                            break;
                        }
                    }
                }
            }
        }
        return tempoCheck;
    }
}