import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class bankFrame extends JFrame implements ActionListener {

    ImageIcon background = new ImageIcon("bank2.jpg");
    static ArrayList<Bank> list = Bank.list;

    JTextField nameTextField;
    JTextField idTextField;
    JTextField passworJTextField;

    JLabel nameLabel = new JLabel("Bank Name");
    JLabel idLabel = new JLabel("Card ID");
    JLabel passLabel = new JLabel("Password");
    JLabel label;

    JButton submitButton;
    JButton skipButton;
    String bankName;
    String id;
    String password;
    boolean check1; // to if the operation is checking or adding new account // true for checking
    static myAccount m1 = new myAccount();

    bankFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);

        submitButton = new JButton("submit");
        submitButton.setBounds(300, 270, 80, 30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFocusable(false);
        submitButton.setEnabled(true);
        submitButton.addActionListener(this);

        skipButton = new JButton("skip");
        skipButton.setBounds(100, 270, 80, 30);
        skipButton.setBackground(Color.white);
        skipButton.setForeground(Color.red);
        skipButton.setFocusable(false);
        skipButton.setEnabled(true);
        skipButton.addActionListener(this);

        nameTextField = new JTextField();
        nameTextField.setBounds(120, 120, 150, 30);
        nameTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        nameTextField.setBackground(Color.white);
        nameTextField.setCaretColor(Color.white);

        nameLabel.setBounds(30, 120, 80, 30);
        nameLabel.setForeground(Color.WHITE);

        idTextField = new JTextField();
        idTextField.setBounds(120, 170, 150, 30);
        idTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        idTextField.setBackground(Color.white);
        idTextField.setCaretColor(Color.white);

        idLabel.setBounds(30, 170, 80, 30);
        idLabel.setForeground(Color.WHITE);

        passworJTextField = new JTextField();
        passworJTextField.setBounds(120, 220, 150, 30);
        passworJTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        passworJTextField.setBackground(Color.white);
        passworJTextField.setCaretColor(Color.white);

        passLabel.setBounds(30, 220, 80, 30);
        passLabel.setForeground(Color.WHITE);

        label = new JLabel();
        label.setBounds(0, 0, 500, 500);
        label.setIcon(background);

        label.add(nameTextField);
        label.add(idTextField);
        label.add(passworJTextField);
        label.add(nameLabel);
        label.add(idLabel);
        label.add(passLabel);
        label.add(submitButton);
        label.add(skipButton);

        this.add(label);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == skipButton) {
            this.dispose();
        }

        if (e.getSource() == submitButton) {
            bankName = nameTextField.getText();
            id = idTextField.getText();
            password = passworJTextField.getText();
            if (bankName.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your bank name and id and password",
                        " ", JOptionPane.ERROR_MESSAGE);
            } else if (bankName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your bank name ",
                        " ", JOptionPane.ERROR_MESSAGE);
            } else if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your id ",
                        " ", JOptionPane.ERROR_MESSAGE);

            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your  password",
                        " ", JOptionPane.ERROR_MESSAGE);

            } else {

                boolean exsistCheck = accountsExsisted(bankName, id, password);

                if (!exsistCheck) {
                    list.add(new Bank(bankName, id, password));
                    try {
                        if (m1.havingAccount()) {
                            if (m1.whichOne()) { // customer
                                myAccount.customer.setBankAccount(new Bank(bankName, id, password));
                            } else { // employee
                                myAccount.employee.setBankAccount(new Bank(bankName, id, password));
                            }
                        } else {

                            myAccount.bankAccount = new Bank(bankName, id, password);
                            if (myAccount.bankAccount != null) {
                                // System.out.println("added");
                                try (ObjectOutputStream oos = new ObjectOutputStream(
                                    new FileOutputStream("CustomerAccounts.dat"))) {
                                    oos.writeObject(newAccount.customeAccounts);
                                } catch (Exception ee) {
                                    ee.printStackTrace();
                                }
                            }

                        }
                    } catch (Exception ex) {
                    }
                    this.dispose();

                }

            }
        }

    }

    static boolean accountsExsisted(String name, String id, String password) {
        boolean tempoCheck = false;

        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (name.equals(list.get(i).getBankName())) {
                    if (id.equals(list.get(i).getCardID())) {
                        if (password.equals(list.get(i).getPassword())) {
                            tempoCheck = true;
                        }
                    }
                }
            }

        }

        return tempoCheck;
    }

}