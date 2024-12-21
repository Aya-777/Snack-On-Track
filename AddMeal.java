import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class AddMeal implements ActionListener{
        JTextField mealnamefield = new JTextField("Name:");
        JTextField mealdescriptionfield = new JTextField("Description:");
        JTextField mealpricefield = new JTextField("Price:");
        JTextField mealcaloriefield = new JTextField("Calories:");
        JButton submitbutton = new JButton("Submit");
        JFrame f = new JFrame("Add Meal");

    AddMeal(){
        f.setLayout(new FlowLayout());

        submitbutton.addActionListener(this);
        f.add(mealnamefield);
        f.add(mealdescriptionfield);
        f.add(mealpricefield);
        f.add(mealcaloriefield);
        f.add(submitbutton);

         
        f.setSize(665,850);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitbutton){
            int price = Integer.parseInt(mealpricefield.getText());
            int calorie = Integer.parseInt(mealcaloriefield.getText());
            MealFrame.addMeal(0,price,mealnamefield.getText(),mealdescriptionfield.getText(),calorie);
            submitbutton.setEnabled(false);
        }
    }
}