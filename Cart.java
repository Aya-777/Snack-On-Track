import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cart implements ActionListener {

    ArrayList<Integer> meals = new ArrayList<>();
    JFrame f = new JFrame();
    JLabel l = new JLabel("Your Order");
    JCheckBox delivery = new JCheckBox("Delivery");
    JCheckBox bankCheckBox = new JCheckBox("Bank");
    JCheckBox cashCheckBox = new JCheckBox("Cash");

    JLabel tablenumlabel;
    JLabel addresslabel;
    JTextField addressfield;
    JTextField tablenumtextfield;

    JLabel detailslabel = new JLabel("Details(optional): ");
    JTextField detailsfield = new JTextField();
    JLabel tiplabel = new JLabel("Tip(optional): ");
    JTextField tipfield = new JTextField();
    myAccount m1 = new myAccount();
    JButton continuenutton = new JButton("Continue order");
    JLabel pricelabel = new JLabel("Price : ");

    int i = 1;
    boolean openIt = false; // to open the next frame after paying with bank account

    Cart() {
    }

    Cart(ArrayList<Integer> ll) {
        meals = ll;

        f.setLayout(null);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l.setBounds(50, 50, 100, 20);

        delivery.setBounds(170, 100, 100, 20);
        delivery.setBorder(null);
        delivery.addActionListener(this);

        bankCheckBox.setBounds(200, 300, 80, 50);
        bankCheckBox.setSelected(false);
        bankCheckBox.addActionListener(this);

        cashCheckBox.setBounds(100, 300, 80, 50);
        cashCheckBox.setSelected(true);
        cashCheckBox.addActionListener(this);

        continuenutton.setBounds(180, 400, 150, 20);
        continuenutton.addActionListener(this);

        detailslabel.setBounds(50, 200, 100, 20);
        detailsfield.setBounds(150, 200, 100, 20);

        tiplabel.setBounds(50, 250, 100, 20);
        tipfield.setBounds(150, 250, 100, 20);

        tablenumlabel = new JLabel("Table number: ");
        tablenumtextfield = new JTextField();

        tablenumlabel.setBounds(50, 150, 100, 20);
        tablenumtextfield.setBounds(150, 150, 100, 20);

        tablenumlabel.setVisible(true);
        tablenumtextfield.setVisible(true);

        f.add(tablenumlabel);
        f.add(tablenumtextfield);
        f.add(bankCheckBox);
        f.add(cashCheckBox);
        f.add(detailsfield);
        f.add(detailslabel);
        f.add(l);
        f.add(delivery);
        f.add(tipfield);
        f.add(tiplabel);

        // f.add(addressfield);
        // f.add(addresslabel);
        f.add(pricelabel);
        f.add(continuenutton);

        f.setResizable(false);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == delivery) {
            i++;

            if (i % 2 == 1) {
                addresslabel.setVisible(false);
                addressfield.setVisible(false);

                tablenumlabel.setVisible(true);
                tablenumtextfield.setVisible(true);

                f.repaint();
                f.revalidate();

            } else {

                tablenumlabel.setVisible(false);
                tablenumtextfield.setVisible(false);

                addresslabel = new JLabel("Address: ");
                addressfield = new JTextField();

                addresslabel.setBounds(50, 150, 100, 20);
                addressfield.setBounds(150, 150, 100, 20);

                addresslabel.setVisible(true);
                addressfield.setVisible(true);
                f.add(addressfield);
                f.add(addresslabel);

                f.repaint();
                f.revalidate();
            }
        }

        if (e.getSource() == bankCheckBox) {
            cashCheckBox.setSelected(false);
        }
        if (e.getSource() == cashCheckBox) {
            bankCheckBox.setSelected(false);
        } // the end of check box condithions
        // ==========================================================================================================================

        if (e.getSource() == continuenutton) { // countinue button
            boolean emptyField = false;
            String details = detailsfield.getText();
            String tip = tipfield.getText();
            if (delivery.isSelected()) {
                String address = addressfield.getText();
                if (address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter the address!",
                            "Title", JOptionPane.WARNING_MESSAGE);
                    addressfield.setCaretColor(Color.red);
                } else {
                    emptyField = true;
                }
            } else {
                String table = tablenumtextfield.getText();
                if (table.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter the table number!",
                            "Title", JOptionPane.WARNING_MESSAGE);
                    tablenumtextfield.setCaretColor(Color.red);

                } else {
                    emptyField = true;
                }
            }
            if (emptyField) {
                if (bankCheckBox.isSelected()) {

                    if (m1.havingAccount()) {
                        if (m1.whichOne()) { // customer
                            if (myAccount.customer.getBankAccount() != null) {

                                try {
                                    int newBalance = myAccount.customer.getBankAccount().getBalance() - Order.price;
                                    myAccount.customer.getBankAccount().setBalance(newBalance);
                                    openIt = true;
                                    System.out.println(myAccount.customer.getBankAccount().getBalance());
                                    System.out.println("customer");
                                } catch (Exception ex) {
                                    System.out.println("cart 160");
                                }

                            } else {
                                String[] yes_no = { "Yes", "No" };
                                int wouldU = JOptionPane.showOptionDialog(null,
                                        "You have not added a bank account before , would you add one ?",
                                        "", JOptionPane.YES_NO_OPTION, 0, null, yes_no, 0);

                                if (wouldU == 0) {
                                    f.dispose();
                                    new bankFrame();
                                    new Cart(meals).f.toBack();

                                }

                            }
                        } else { // employee

                            if (myAccount.employee.getBankAccount() != null) {
                                try {
                                    int newBalance = myAccount.employee.getBankAccount().getBalance() - Order.price;
                                    myAccount.employee.getBankAccount().setBalance(newBalance);
                                    openIt = true;
                                    System.out.println(myAccount.employee.getBankAccount().getBalance());
                                    System.out.println("empolyee");
                                } catch (Exception ex) {
                                    System.out.println("cart 186");
                                }
                            } else {
                                String[] yes_no = { "Yes", "No" };
                                int wouldU = JOptionPane.showOptionDialog(null,
                                        "You have not added a bank account before , would you add one ?",
                                        "", JOptionPane.YES_NO_OPTION, 0, null, yes_no, 0);
                                        if (wouldU == 0) {
                                            new bankFrame();
                                            f.repaint();
                                            f.revalidate();
                                        }
                                    }
                                }
                            }
                            if (openIt) {
                                f.dispose();
                                new Details(meals);
                            }
                        }
                        if (cashCheckBox.isSelected()) {
                            f.dispose();
                            new Details(meals);
                        }
        
                    }
        
                }
            }
        
        }