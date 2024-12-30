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
            } else {
                JOptionPane.showMessageDialog(null, "Meal added.", 
                "", JOptionPane.INFORMATION_MESSAGE);
                ImageIcon newmealIcon = new ImageIcon("drink1icon.jpg");
                int price = Integer.parseInt(mealpricefield.getText());
                int calorie = Integer.parseInt(mealcaloriefield.getText());
                String name = mealnamefield.getText();
                String desc = mealdescriptionfield.getText();
                int serialnum = MealFrame.meallist.size()-1;
                // System.out.println(serialnum + " " + price + " " + calorie + " " + name);
                Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false,0);
                MealFrame.addMeal(newMeal);

                JLabel newmealLabel = new JLabel(newmealIcon);
                newmealLabel.setLayout(new FlowLayout());
                newmealNameLabel.setText(name);
                newmealCalorieLabel.setText(String.valueOf(calorie));
                newmealPriceLabel.setText(String.valueOf(price));

                newmealLabel.add(newmealNameLabel);
                newmealLabel.add(newmealPriceLabel);
                newmealLabel.add(newmealCalorieLabel);

                if (mealtype.getSelectedItem() == "Meal") {
                    MealOrder m = new MealOrder(true);
                    m.addMeal(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Salad") {
                    SaladOrder ss = new SaladOrder(true);
                    ss.addMeal(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Dessert") {
                    DessertOrder d = new DessertOrder(true);
                    d.addMeal(newmealLabel);
                }
                if (mealtype.getSelectedItem() == "Drink") {
                    DrinksOrder d = new DrinksOrder(true);
                    d.addMeal(newmealLabel);
                }

                submitbutton.setEnabled(false);
                f.dispose();

            }
        }
    }
}