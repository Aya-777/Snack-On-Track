import java.util.ArrayList;
import javax.swing.JFrame;

class ManagerDetails{

    JFrame f = new JFrame();


    ManagerDetails(ArrayList<Meal> meals){
        f.setLayout(null);
   

        f.setResizable(false);
        f.setSize(650, 830);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        
    }

}