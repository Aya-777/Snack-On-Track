import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cart implements ActionListener {

    ArrayList<Integer> meals = new ArrayList<>();
    JFrame f = new JFrame();

    JLabel cartLabel = new JLabel();
    ImageIcon cartIcon = new ImageIcon("cart.png");

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

    JButton continuenutton = new JButton("Continue order");
    JLabel pricelabel = new JLabel("Price : ");

    int i = 1;

    Cart() {
    }

    Cart(ArrayList<Integer> ll) {
        meals = ll;
        f.setLayout(null);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartLabel.setBounds(0,0,500,500);
        cartLabel.setIcon(cartIcon);
        cartLabel.setOpaque(true);

        l.setBounds(178, 85, 400, 40);
        l.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));

        delivery.setBounds(200, 135, 100, 20);
        delivery.setBackground(new Color(252,244,154));
        delivery.setBorder(null);
        delivery.addActionListener(this);

        bankCheckBox.setBounds(315, 330, 80, 50);
        bankCheckBox.setBackground(new Color(252,244,154));
        bankCheckBox.setSelected(false);
        bankCheckBox.addActionListener(this);

        cashCheckBox.setBounds(150, 330, 80, 50);
        cashCheckBox.setBackground(new Color(252,244,154));
        cashCheckBox.setSelected(true);
        cashCheckBox.addActionListener(this);

        continuenutton.setBounds(175, 400, 150, 25);
        continuenutton.addActionListener(this);

        detailslabel.setBounds(80, 235, 350, 20);
        detailslabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        detailsfield.setBounds(262, 237, 100, 20);

        tiplabel.setBounds(80, 290, 200, 20);
        tiplabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        tipfield.setBounds(225, 292, 100, 20);

        tablenumlabel = new JLabel("Table number: ");
        tablenumtextfield = new JTextField();

        tablenumlabel.setBounds(80, 180, 300, 20);
        tablenumlabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        tablenumtextfield.setBounds(232, 182, 100, 20);

        tablenumlabel.setVisible(true);
        tablenumtextfield.setVisible(true);


        cartLabel.add(tablenumlabel);
        cartLabel.add(tablenumtextfield);
        cartLabel.add(bankCheckBox);
        cartLabel.add(cashCheckBox);
        cartLabel.add(detailsfield);
        cartLabel.add(detailslabel);
        cartLabel.add(l);
        cartLabel.add(delivery);
        cartLabel.add(tipfield);
        cartLabel.add(tiplabel);

        // f.add(addressfield);
        // f.add(addresslabel);
        cartLabel.add(pricelabel);
        cartLabel.add(continuenutton);
        f.add(cartLabel);

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

                System.out.println("here1");
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
                System.out.println("here2");
                f.repaint();
                f.revalidate();
            }
        }

        if (e.getSource() == bankCheckBox) {
            cashCheckBox.setSelected(false);
        }
        if (e.getSource() == cashCheckBox) {
            bankCheckBox.setSelected(false);
        }

        if (e.getSource() == continuenutton) {
            String details = detailsfield.getText();
            String tip = tipfield.getText();
            if (delivery.isSelected()) {
                String address = addressfield.getText();
                if (address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter the address!",
                            "Title", JOptionPane.WARNING_MESSAGE);
                    addressfield.setCaretColor(Color.red);
                } else {
                    f.dispose();
                    new Details(meals);
                }
            } else {
                String table = tablenumtextfield.getText();
                if (table.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter the table number!",
                            "Title", JOptionPane.WARNING_MESSAGE);
                    tablenumtextfield.setCaretColor(Color.red);
                } else {
                    f.dispose();
                    new Details(meals);

                }
            }

        }
    }
}
