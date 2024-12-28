import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class AddMeal implements ActionListener {
    JTextField mealnamefield = new JTextField("Name:");
    JTextField mealdescriptionfield = new JTextField("Description:");
    JTextField mealpricefield = new JTextField("Price:");
    JTextField mealcaloriefield = new JTextField("Calories:");
    JButton submitbutton = new JButton("Submit");
    JFrame f = new JFrame("Add Meal");
    String[] types = new String[] { "Meal", "Salad", "Dessert", "Drink" };
    @SuppressWarnings("rawtypes")
    JComboBox mealtype = new JComboBox<>(types);
    JLabel newmealNameLabel = new JLabel();
    JLabel newmealPriceLabel = new JLabel();
    JLabel newmealCalorieLabel = new JLabel();

    AddMeal() {
        f.setLayout(new FlowLayout());

        submitbutton.addActionListener(this);
        f.add(mealtype);
        f.add(mealnamefield);
        f.add(mealdescriptionfield);
        f.add(mealpricefield);
        f.add(mealcaloriefield);
        f.add(submitbutton);

        f.setSize(665, 850);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbutton) {

            boolean notvalid = false;
            String s = mealpricefield.getText();
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c))
                    notvalid = true;
            }
            s = mealcaloriefield.getText();
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c))
                    notvalid = true;
            }
            if (notvalid) {
                JOptionPane.showMessageDialog(null, "Input invalid, Try again",
                        "Title", JOptionPane.OK_OPTION);
                submitbutton.setEnabled(true);
            }
            if (!notvalid) {
                System.out.println("Weeeeee");
                ImageIcon newmealIcon = new ImageIcon("");
                JLabel newmealLabel = new JLabel(newmealIcon);
                int price = Integer.parseInt(mealpricefield.getText());
                int calorie = Integer.parseInt(mealcaloriefield.getText());
                String name = mealnamefield.getText();
                String desc = mealdescriptionfield.getText();
                MealFrame.addMeal(0, price, name, desc, calorie);
                newmealNameLabel.setText(name);
                newmealCalorieLabel.setText(String.valueOf(calorie));
                newmealPriceLabel.setText(String.valueOf(price));
                newmealLabel.add(newmealNameLabel);
                newmealLabel.add(newmealPriceLabel);
                newmealLabel.add(newmealCalorieLabel);
                newmealLabel.setLayout(new FlowLayout());
                submitbutton.setEnabled(false);

                if (mealtype.getSelectedItem() == "Meal") {
                    // MealOrder.f.add(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Salad") {
                    // SaladOrder.f.add(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Dessert") {
                    // DessertOrder.f.add(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Drink") {
                    // DrinksOrder.f.add(newmealLabel);
                }
            }
        }
    }
}