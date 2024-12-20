import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cart implements ActionListener {

    Integer[] meals = new Integer[7];
    JFrame f = new JFrame();
    JLabel l = new JLabel("Your Order");
    JCheckBox delivery = new JCheckBox("Delivery");
    JButton checkboxbutton = new JButton("submit");
    JTextField addressfield = new JTextField();
    JLabel addresslabel = new JLabel("Address: ");
    JLabel detailslabel = new JLabel("Details(optional): ");
    JTextField detailsfield = new JTextField();
    JLabel tiplabel = new JLabel("Tip(optional): ");
    JTextField tipfield = new JTextField();
    JLabel tablenumlabel = new JLabel("Table number: ");
    JTextField tablenumtextfield = new JTextField();
    JButton continuenutton = new JButton("Continue order");
    JLabel pricelabel = new JLabel("Price : ");


    int i = 1;
    Cart(){}
    Cart(Integer[] ll) {
        meals=ll;
        f.setLayout(null);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l.setBounds(50, 50, 100, 20);

        delivery.setBounds(170, 100, 100, 20);

        checkboxbutton.setBounds(180, 150, 100, 20);
        checkboxbutton.addActionListener(this);
        continuenutton.setBounds(180,400,150,20);
        continuenutton.addActionListener(this);


        addresslabel.setBounds(50, 200, 100, 20);
        addressfield.setBounds(100, 200, 100, 20);

        tablenumlabel.setBounds(50, 200, 100, 20);
        tablenumtextfield.setBounds(150, 200, 100, 20);

        detailslabel.setBounds(50, 250, 100, 20);
        detailsfield.setBounds(150, 250, 100, 20);
        tiplabel.setBounds(50, 300, 100, 20);
        tipfield.setBounds(130, 300, 100, 20);

        // tiplabel.setVisible(false);
        // tipfield.setVisible(false);
        addresslabel.setVisible(false);
        addressfield.setVisible(false);
        // detailsfield.setVisible(false);
        // detailslabel.setVisible(false);
        // tablenumlabel.setVisible(false);
        // tablenumtextfield.setVisible(false);

        f.add(detailsfield);
        f.add(detailslabel);
        f.add(l);
        f.add(delivery);
        f.add(checkboxbutton);
        f.add(tipfield);
        f.add(tiplabel);
        f.add(tablenumlabel);
        f.add(tablenumtextfield);
        f.add(addressfield);
        f.add(addresslabel);
        f.add(pricelabel);
        f.add(continuenutton);

        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkboxbutton) {
            // if(e.getSource()==delivery){
            System.out.println("kkk");
            i++;
            if (i % 2 != 0) {
                detailsfield.setVisible(true);
                detailslabel.setVisible(true);
                addressfield.setVisible(false);
                addresslabel.setVisible(false);
                tiplabel.setVisible(true);
                tipfield.setVisible(true);
                tablenumtextfield.setVisible(true);
                tablenumlabel.setVisible(true);
            } else {
                addresslabel.setVisible(true);
                addressfield.setVisible(true);
                tiplabel.setVisible(true);
                tipfield.setVisible(true);
                tablenumtextfield.setVisible(false);
                tablenumlabel.setVisible(false);
                detailsfield.setVisible(true);
                detailslabel.setVisible(true);
            }
            f.revalidate();
            f.repaint();

        }
    
        if (e.getSource() == continuenutton) {
            String details = detailsfield.getText();
            String tip = tipfield.getText();
            if(delivery.isSelected()){
                String address = addressfield.getText();
                if( address.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter the address!",
                    "Title",JOptionPane.WARNING_MESSAGE);
                    addressfield.setCaretColor(Color.red);
                } else{
                    new Details(meals);
                    // for(Meal i : order){
                    //     System.out.println(i.getNum());}
                }
            } else{
                String table = tablenumtextfield.getText();
                if( table.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter the table number!",
                    "Title",JOptionPane.WARNING_MESSAGE);
                    tablenumtextfield.setCaretColor(Color.red);
                } else{
                    new Details(meals);
                }
            }
            
        }
    }
}
