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
import java.util.Scanner;
public class SignFrame extends JFrame implements ActionListener {
    Scanner in = new Scanner(System.in);
    ArrayList<ManagementAccounts> mangeAccounts = new ArrayList<>();
    ArrayList<customerAccounts> customeAccounts = new ArrayList<>();
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
    SignFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(665, 850);
        this.setLayout(null);
        backImage = new ImageIcon("firstFrame.jpg");
        label = new JLabel();
        label.setBounds(0, 0, 800, 850);
        label.setIcon(backImage);
        signButton = new JButton("sign in");
        signButton.setBounds(210, 450, 80, 30);
        signButton.setBackground(Color.white);
        signButton.setForeground(Color.black);
        signButton.setFocusable(false);
        signButton.addActionListener(this);
        newAccountButton = new JButton("new account");
        newAccountButton.setBounds(300, 450, 110, 30);
        newAccountButton.setBackground(Color.white);
        newAccountButton.setForeground(Color.black);
        newAccountButton.setFocusable(false);
        newAccountButton.addActionListener(this);
        submitButton = new JButton("submit");
        submitButton.setBounds(340, 595, 80, 30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFocusable(false);
        submitButton.setEnabled(false);
        submitButton.addActionListener(this);
        userTextField = new JTextField();
        userTextField.setBounds(230, 491, 150, 50);
        userTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        userTextField.setBackground(Color.white);
        userTextField.setCaretColor(Color.white);
        userTextField.setText("user name");
        passwordTextField = new JTextField();
        passwordTextField.setBounds(230, 541, 150, 50);
        passwordTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        passwordTextField.setBackground(Color.white);
        passwordTextField.setCaretColor(Color.white);
        passwordTextField.setText("password");
        label.add(userTextField);
        label.add(passwordTextField);
        label.add(submitButton);
        label.add(signButton);
        label.add(newAccountButton);
        // label.add(progressBar);
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signButton) {
            signButton.setBackground(Color.green);
            newAccountButton.setBackground(Color.red);
            submitButton.setEnabled(true);
            mainCheck = true;
        }
        if (e.getSource() == newAccountButton) {
            signButton.setBackground(Color.red);
            newAccountButton.setBackground(Color.green);
            submitButton.setEnabled(true);
            mainCheck = false;
        }
        if (e.getSource() == submitButton) {
            extera();
            if (mainCheck) { // sign in
                userName = userTextField.getText();
                password = passwordTextField.getText();
                boolean check;
                if (!userName.equals("employee")) { // customer
                    check = accountsExsisted1(userName, password);
                    if (check) {
                        this.dispose();
                        new firstFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "wrong account", " ", JOptionPane.ERROR_MESSAGE);
                    }
                } else { // manager
                    employeeNumber = JOptionPane.showInputDialog("enter the employee password");
                    check = accountsExsisted2(userName, password, employeeNumber);
                    if (check) {
                        this.dispose();
                        new firstFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "wrong account", " ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else { // new account
                userName = userTextField.getText();
                password = passwordTextField.getText();
                boolean check;
                if (!userName.equals("employee")) { // customer
                    check = accountsExsisted1(userName, password);
                    if (!check) {
                        customeAccounts.add(new customerAccounts(userName, password));
                        this.dispose();
                        // new firstFrame();
                        new MealOrder();
                    } else {
                        JOptionPane.showMessageDialog(null, "change your informations", " ", JOptionPane.ERROR_MESSAGE);
                    }
                } else { // manager
                    employeeNumber = JOptionPane.showInputDialog("enter the employee password");
                    check = accountsExsisted2(userName, password, employeeNumber);
                    if (!check) {
                        mangeAccounts.add(new ManagementAccounts(password));
                        this.dispose();
                        new firstFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "change your informations", " ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } // the end of submite button's conditions
    }
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
                            break;
                        }
                    }
                }
            }
        }
        return tempoCheck;
    }
}