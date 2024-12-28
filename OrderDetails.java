import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class OrderDetails implements ActionListener{

    JFrame f = new JFrame();
    JButton confirmButton = new JButton("Confirm");
    ArrayList<Integer> meals = new ArrayList<>();
    int x=200 ,y = 150 , xnum=400 , ynum=150;
    static int gap=150;

    OrderDetails(ArrayList<Integer> meals){
        f.setLayout(null);
        this.meals=meals;

        confirmButton.setBounds(300, 300, 100, 20);
        confirmButton.addActionListener(this);

        for(int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                JLabel mealname = new JLabel(MealFrame.meallist.get(i).getName());
                JLabel mealnum = new JLabel(String.valueOf(meals.get(i)));

                mealname.setBounds(x , y, 200, 20);
                mealnum.setBounds(xnum , ynum, 50, 20);

                f.add(mealname);
                f.add(mealnum);
                
                y+=50;
                ynum+=50;
                gap=ynum+50;
            }
        }


        f.add(confirmButton);

        f.setResizable(false);
        f.setSize(500,500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmButton){
            new Cart(meals);
        }
    }
}