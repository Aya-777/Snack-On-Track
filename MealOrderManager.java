import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

        if(e.getSource() == mealsitem){
            new MealOrder(manager);
        }
        if(e.getSource() == saladsitem){
            new SaladOrder(manager);
        }
        if(e.getSource()==drinksitem){
            JOptionPane.showMessageDialog(null,"You are already on drink's order page.",
            "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == dessertsitem){
            new DessertOrder(manager);
        }
        if(e.getSource() == viewcartbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);
            }
        }
        
        if(e.getSource()==addmealButton){
            new AddMeal();
        }
    }
}