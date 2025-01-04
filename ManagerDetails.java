import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ManagerDetails{

    JFrame f = new JFrame();
    JLabel favcustomerLabel = new JLabel("The most visiting customer : ");
    JLabel favcutomernamLabel = new JLabel();



    ManagerDetails(ArrayList<Meal> meals){
        f.setLayout(new FlowLayout());
   
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
            f.add(favcutomernamLabel);

        } catch (NullPointerException e) {
            favcustomerLabel.setText("No customers");
        }
        
        // favcustomerLabel.setBounds(min, min, min, min);
        // favcutomernamLabel.setBounds(min, min, min, min);

        f.add(favcustomerLabel);
        

        f.setResizable(false);
        f.setSize(650, 830);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        
    }

}