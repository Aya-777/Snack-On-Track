import java.awt.event.ActionEvent;
import javax.swing.JButton;

class MealOrderManager extends MealOrder{

    JButton addmealButton = new JButton("Add Meal");

    MealOrderManager(boolean m){
        super(m);
        addmealButton.setBounds(400, 200, 100, 20);
        addmealButton.addActionListener(this);

        f.add(addmealButton);
   

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addmealButton){
            new AddMeal();
        }
    }
}