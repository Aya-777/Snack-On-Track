import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class newAccount extends JFrame implements ActionListener {

    static ArrayList<ManagementAccounts> mangeAccounts = new ArrayList<>();
    static ArrayList<customerAccounts> customeAccounts = new ArrayList<>();

    Border border = BorderFactory.createLineBorder(Color.red, 3); // will be added to the empty text field
    ImageIcon backImage;
    JLabel label;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton submitButton;
    JButton addBankButton;
    JCheckBox checkBox;
    boolean mainCheck; // to check if the operation is sign in or to make a new account
    boolean emptyCheck = true; // tho check if the text field is empty or not
    String userName;
    String password;
    String employeeNumber;
    boolean userCheck;
    boolean passwordCheck;
    boolean employeeNumberCheck;

    static myAccount m1 = new myAccount();

    JLabel userLabel;
    JLabel passLabel;

    newAccount() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 830);
        this.setLayout(null);

        backImage = new ImageIcon("firstFrame.png");

        label = new JLabel();
        label.setBounds(0, 0, 800, 830);
        label.setIcon(backImage);

        submitButton = new JButton("submit");
        submitButton.setBounds(340, 595, 80, 30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFocusable(false);
        submitButton.setEnabled(true);
        submitButton.addActionListener(this);

        addBankButton = new JButton("Bank account");
        addBankButton.setBounds(120, 595, 120, 30);
        addBankButton.setBackground(Color.BLACK);
        addBankButton.setForeground(Color.white);
        addBankButton.setFocusable(false);
        addBankButton.setEnabled(true);
        addBankButton.addActionListener(this);

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
        label.add(userLabel);
        label.add(passLabel);
        label.add(addBankButton);

        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBankButton) {
            new bankFrame();
        }

        if (e.getSource() == submitButton) {
            userName = userTextField.getText();
            password = passwordTextField.getText();
            if (userName.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your username and password",
                        " ", JOptionPane.ERROR_MESSAGE);
            } else if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your username ",
                        " ", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your  password",
                        " ", JOptionPane.ERROR_MESSAGE);

            } else {
                boolean check;
                if (!userName.equals("employee")) { // customer
                    check = accountsExsisted1(userName, password);
                    if (!check) {
                        customeAccounts.add(new customerAccounts(userName, password));
                        myAccount.customer = customeAccounts.get(customeAccounts.size() - 1);
                        myAccount.customer.setBankAccount(myAccount.bankAccount);

                        if (myAccount.customer.getBankAccount() == null) {
                            System.out.println("it is null");
                        } else {
                            System.out.println("it is not null");
                        }
                        this.dispose();
                        new MealOrder(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "change your informations", " ", JOptionPane.ERROR_MESSAGE);
                    }
                } else { // manager
                    employeeNumber = JOptionPane.showInputDialog("enter the employee password");
                    if (employeeNumber.equals("7879")) {

                        check = accountsExsisted2(userName, password, employeeNumber);
                        if (!check) {
                            mangeAccounts.add(new ManagementAccounts(password));
                            myAccount.employee = mangeAccounts.get(mangeAccounts.size() - 1);
                            myAccount.employee.setBankAccount(myAccount.bankAccount);

                            this.dispose();
                            new MealOrder(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "change your informations", " ",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "wronge password", " ", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        }
    }

    boolean accountsExsisted1(String user, String pass) { // customers
        boolean tempoCheck = false;
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