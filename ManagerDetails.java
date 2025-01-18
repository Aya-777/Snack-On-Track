import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class ManagerDetails{

    JFrame f = new JFrame();
    JLabel favcustomerLabel = new JLabel("The most visiting customer : ");
    JLabel favcutomernamLabel = new JLabel();
    JLabel backGroundLabel = new JLabel();
    ImageIcon backGroundIcon = new ImageIcon("cart.png");



    ManagerDetails(ArrayList<Meal> meals){
        f.setLayout(new FlowLayout());
        backGroundLabel.setBounds(0,0,500,500);
        backGroundLabel.setIcon(backGroundIcon);

        favcustomerLabel.setBounds(80,90,300,30);
        favcustomerLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        favcutomernamLabel.setBounds(360,90,200,30);
        favcutomernamLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        f.add(backGroundLabel);
   
        int min=0;
        String name ="";
        for (customerAccounts c : newAccount.customeAccounts) {
            if(c.getHowManyTimes()>min){
                System.out.println(c.getName());
                name=c.getName();
                min=c.getHowManyTimes();
            }
        }
        try {
            favcutomernamLabel.setText(name);
            backGroundLabel.add(favcutomernamLabel);

        } catch (NullPointerException e) {
            favcustomerLabel.setText("No customers");
        }
        
        // favcustomerLabel.setBounds(min, min, min, min);
        // favcutomernamLabel.setBounds(min, min, min, min);

        backGroundLabel.add(favcustomerLabel);
        

        f.setResizable(false);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        
    }

}