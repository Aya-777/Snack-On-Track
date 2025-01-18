import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class AddMeal implements ActionListener {
    JTextField mealnamefield = new JTextField();
    JLabel mealnamelabel = new JLabel("Name:");
    JTextField mealdescriptionfield = new JTextField();
    JLabel mealdescriptionlabel = new JLabel("Description:");
    JTextField mealpricefield = new JTextField();
    JLabel mealpricelabel = new JLabel("Price:");
    JTextField mealcaloriefield = new JTextField();
    JLabel mealcalorielabel = new JLabel("Calories:");
    JButton submitbutton = new JButton("Submit");
    JFrame f = new JFrame("Add Meal");
    String[] types = new String[] { "Meal", "Salad", "Dessert", "Drink" };
    @SuppressWarnings("rawtypes")
    JComboBox mealtype = new JComboBox<>(types);
    JLabel newmealNameLabel = new JLabel();
    JLabel newmealPriceLabel = new JLabel();
    JLabel newmealCalorieLabel = new JLabel();

    ArrayList<ImageIcon> newMealsIconArray = new ArrayList<>();
    ImageIcon newMealMenuIcon = new ImageIcon("add meal.png");
    ImageIcon newSaladMenuIcon = new ImageIcon("add salad.png");
    ImageIcon newDessertMenuIcon = new ImageIcon("add dessert.png");
    ImageIcon newDrinkMenuIcon = new ImageIcon("add drink.png");

    JLabel addMealIconLabel = new JLabel();
    ImageIcon addMealIcon = new ImageIcon("cart.png");
    AddMeal() {
        f.setLayout(new FlowLayout());

        addMealIconLabel.setBounds(0,0,500,500);
        addMealIconLabel.setIcon(addMealIcon);

        mealtype.setBounds(200,85,90,25);
        mealtype.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));

        mealnamelabel.setBounds(100,140,120,25);
        mealnamelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnamefield.setBounds(165,142,150,23);
        mealnamefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        mealpricelabel.setBounds(100,200,100,25);
        mealpricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealpricefield.setBounds(160,202,75,23);
        mealpricefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        mealcalorielabel.setBounds(100,260,120,25);
        mealcalorielabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealcaloriefield.setBounds(185,262,75,23);
        mealcaloriefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        mealdescriptionlabel.setBounds(100,320,150,25);
        mealdescriptionlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealdescriptionfield.setBounds(210,322,200,23);
        mealdescriptionfield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        submitbutton.setBounds(190,375,120,25);
        //submitbutton.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));


        submitbutton.addActionListener(this);

        addMealIconLabel.add(mealtype);
        addMealIconLabel.add(mealnamefield);
        addMealIconLabel.add(mealnamelabel);
        addMealIconLabel.add(mealdescriptionfield);
        addMealIconLabel.add(mealdescriptionlabel);
        addMealIconLabel.add(mealpricefield);
        addMealIconLabel.add(mealpricelabel);
        addMealIconLabel.add(mealcaloriefield);
        addMealIconLabel.add(mealcalorielabel);
        addMealIconLabel.add(submitbutton);

        f.add(addMealIconLabel);
        f.setSize(500, 485);
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
                JOptionPane.showMessageDialog(null, "Meal added.",
                "", JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                ImageIcon newmealIcon = new ImageIcon("drink1icon.jpg");
                int price = Integer.parseInt(mealpricefield.getText());
                int calorie = Integer.parseInt(mealcaloriefield.getText());
                String name = mealnamefield.getText();
                String desc = mealdescriptionfield.getText();


                JLabel newmealLabel = new JLabel(newmealIcon);
                newmealLabel.setLayout(new FlowLayout());
                newmealNameLabel.setText(name);
                newmealCalorieLabel.setText(String.valueOf(calorie));
                newmealPriceLabel.setText(String.valueOf(price));

                newmealLabel.add(newmealNameLabel);
                newmealLabel.add(newmealPriceLabel);
                newmealLabel.add(newmealCalorieLabel);

                if (mealtype.getSelectedItem() == "Meal") {
                    int serialnum = AllMealsFrame.meallist.size()-1;
                    Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false,0,"Meal");
                    // AllMealsFrame.addMeal(newMeal);
                    MealOrder m = new MealOrder(true);
                    m.addMeal(newmealLabel,newMeal);

                }
                if (mealtype.getSelectedItem() == "Salad") {

                    int serialnum = AllMealsFrame.meallist.size()-1;
                    Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false,0,"Salad");
                    // AllMealsFrame.addMeal(newMeal);
                    SaladOrder ss = new SaladOrder(true);
                    ss.addMeal(newmealLabel,newMeal);
                }
                if (mealtype.getSelectedItem() == "Dessert") {


                    int serialnum = AllMealsFrame.meallist.size()-1;
                    Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false,0,"Dessert");
                    // AllMealsFrame.addMeal(newMeal);
                    DessertOrder d = new DessertOrder(true);
                    d.addMeal(newmealLabel,newMeal);
                }
                if (mealtype.getSelectedItem() == "Drink") {

                    int serialnum = AllMealsFrame.meallist.size()-1;
                    Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false,0,"Drink");
                    // AllMealsFrame.addMeal(newMeal);
                    DrinksOrder d = new DrinksOrder(true);
                    d.addMeal(newmealLabel,newMeal);
                }

                submitbutton.setEnabled(false);

            }
        }
    }
}