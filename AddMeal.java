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

    static ImageIcon newmealmenuicon = new ImageIcon("add meal.jpg");
    static ImageIcon newDessertMenuIcon = new ImageIcon("add dessert.jpg");
    static ImageIcon newDrinkMenuIcon = new ImageIcon("add drink.jpg");
    static ImageIcon newSaladMenuIcon = new ImageIcon("add salad.jpg");

    JLabel addMealIconLabel = new JLabel();
    ImageIcon addMealIcon = new ImageIcon("cart.png");

    AddMeal() {

        addMealIconLabel.setBounds(0,0,500,500);
        addMealIconLabel.setIcon(addMealIcon);

        mealtype.setBounds(200,85,90,25);
        mealtype.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));

        mealnamelabel.setBounds(100,140,120,25);
        mealnamelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnamefield.setBounds(165,142,150,23);
        mealnamefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
        mealnamefield.setCaretColor(Color.black);

        mealpricelabel.setBounds(100,200,100,25);
        mealpricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealpricefield.setBounds(160,202,75,23);
        mealpricefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
        mealpricefield.setCaretColor(Color.black);

        mealcalorielabel.setBounds(100,260,120,25);
        mealcalorielabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealcaloriefield.setBounds(185,262,75,23);
        mealcaloriefield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
        mealcaloriefield.setCaretColor(Color.black);

        mealdescriptionlabel.setBounds(100,320,150,25);
        mealdescriptionlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealdescriptionfield.setBounds(210,322,200,23);
        mealdescriptionfield.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
        mealdescriptionfield.setCaretColor(Color.black);

        submitbutton.setBounds(190,375,120,25);
        submitbutton.setFocusable(false);
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

        f.setLayout(null);
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
            } else{
                    JOptionPane.showMessageDialog(null, "Meal added.",
                            "", JOptionPane.INFORMATION_MESSAGE);
                    f.dispose();
                    // ImageIcon newmealIcon = new ImageIcon("drink1icon.jpg");
                    int price = Integer.parseInt(mealpricefield.getText());
                    int calorie = Integer.parseInt(mealcaloriefield.getText());
                    String name = mealnamefield.getText();
                    String desc = mealdescriptionfield.getText();


                    JLabel newmealLabel = new JLabel();
                    newmealNameLabel.setText(name);
                    newmealCalorieLabel.setText(String.valueOf(calorie)+" kcal");
                    newmealPriceLabel.setText(String.valueOf(price)+" $");


                    newmealLabel.add(newmealNameLabel);
                    newmealLabel.add(newmealPriceLabel);
                    newmealLabel.add(newmealCalorieLabel);
                    newmealLabel.setLayout(null);

                    if (mealtype.getSelectedItem() == "Meal") {
                        int serialnum = AllMealsFrame.meallist.size();
                        Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false, 0, "Meal");

                        newmealNameLabel.setBounds(25,30,400,50);
                        newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
                        newmealNameLabel.setForeground(new Color(255,255,255));
                        newmealNameLabel.setBackground(new Color(255, 134, 120));
                        

                        newmealPriceLabel.setBounds(188, 78, 150, 60);
                        newmealPriceLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealPriceLabel.setForeground(new Color(139, 37, 17));
                        newmealPriceLabel.setBackground(new Color(255, 134, 120));
                        newmealPriceLabel.setOpaque(true);

                        newmealCalorieLabel.setBounds(25, 78, 140, 60);
                        newmealCalorieLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealCalorieLabel.setForeground(new Color(229, 230, 202));
                        newmealCalorieLabel.setBackground(new Color(255, 134, 120));
                        newmealCalorieLabel.setOpaque(true);

                        newmealLabel.setIcon(newmealmenuicon);
                        MealOrder m = new MealOrder(true);
                        m.addMeal(newmealLabel, newMeal);

                    }
                    if (mealtype.getSelectedItem() == "Salad") {

                        int serialnum = AllMealsFrame.meallist.size();
                        Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false, 0, "Salad");

                        newmealNameLabel.setBounds(20,30,400,50);
                        newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
                        newmealNameLabel.setForeground(new Color(91,74,38));

                        newmealPriceLabel.setBounds(188, 78, 150, 60);
                        newmealPriceLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealPriceLabel.setForeground(new Color(232, 99, 73));
                        newmealPriceLabel.setBackground(new Color(166, 251, 186));
                        newmealPriceLabel.setOpaque(true);

                        newmealCalorieLabel.setBounds(25, 78, 140, 60);
                        newmealCalorieLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealCalorieLabel.setForeground(new Color(91, 74, 38));
                        newmealCalorieLabel.setBackground(new Color(166, 251, 186));
                        newmealCalorieLabel.setOpaque(true);


                        newmealLabel.setIcon(newSaladMenuIcon);
                        SaladOrder ss = new SaladOrder(true);
                        ss.addMeal(newmealLabel, newMeal);
                    }
                    if (mealtype.getSelectedItem() == "Dessert") {


                        int serialnum = AllMealsFrame.meallist.size();
                        Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false, 0, "Dessert");
                        newmealNameLabel.setBounds(20,30,400,50);
                        newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
                        newmealNameLabel.setForeground(new Color(91,74,38));

                        newmealPriceLabel.setBounds(180, 78, 150, 60);
                        newmealPriceLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealPriceLabel.setForeground(new Color(232, 99, 73));
                        newmealPriceLabel.setBackground(new Color(232, 195, 150));
                        newmealPriceLabel.setOpaque(true);

                        newmealCalorieLabel.setBounds(25, 78, 140, 60);
                        newmealCalorieLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealCalorieLabel.setForeground(new Color(91, 74, 38));
                        newmealCalorieLabel.setBackground(new Color(232, 195, 150));
                        newmealCalorieLabel.setOpaque(true);

                        newmealLabel.setIcon(newDessertMenuIcon);

                        DessertOrder d = new DessertOrder(true);
                        d.addMeal(newmealLabel, newMeal);
                    }
                    if (mealtype.getSelectedItem() == "Drink") {

                        int serialnum = AllMealsFrame.meallist.size();
                        Meal newMeal = new Meal(serialnum, price, name, desc, calorie, false, 0, "Drink");

                        newmealNameLabel.setBounds(20,30,500,50);
                        newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
                        newmealNameLabel.setForeground(new Color(224,64,78));

                        newmealPriceLabel.setBounds(188, 78, 150, 60);
                        newmealPriceLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealPriceLabel.setForeground(new Color(232, 99, 73));
                        newmealPriceLabel.setBackground(new Color(154, 232, 231));
                        newmealPriceLabel.setOpaque(true);

                        newmealCalorieLabel.setBounds(25, 78, 140, 60);
                        newmealCalorieLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                        newmealCalorieLabel.setForeground(new Color(91, 74, 38));
                        newmealCalorieLabel.setBackground(new Color(154, 232, 231));
                        newmealCalorieLabel.setOpaque(true);

                        newmealLabel.setIcon(newDrinkMenuIcon);

                        DrinksOrder d = new DrinksOrder(true);
                        d.addMeal(newmealLabel, newMeal);
                    }

                    submitbutton.setEnabled(false);
                }

            }
        }
    }