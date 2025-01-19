import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;

public class AllMealsFrame implements ActionListener {
        // Meals
        static Meal m1 = new Meal(0, 23, "Healthy Steak Meal",
                        "Grilled fillet, broccoli, carrot, beans, served with special sauce and rice, "
                                        + " cooked with an aromatic bouquet.",
                        590, false, 0, "Meal");
        static Meal m2 = new Meal(1, 20, "Teriyaki Chicken",
                        " Chicken cooked in soy sauce, honey and apple juice,"
                                        + " mixed with capsicum, carrot, served with rice and broccoli.",
                        520, false, 0, "Meal");
        static Meal m3 = new Meal(2, 22, "Healthy Chicken Meal",
                        " Grilled chicken, grilled broccoli, grilled carrots, grilled beans,"
                                        + "grilled fresh mushrooms, grilled potatoes, served with special sauce and rice"
                                        +
                                        " cooked with an aromatic bouquet.",
                        500, false, 0, "Meal");
        static Meal m4 = new Meal(3, 22, "Curry Chicken",
                        "Chicken cooked with skimmed coconut milk, mixed with capsicum," +
                                        " ginger, chicken broth, garlic, curry powder"
                                        + " served with rice cooked with aromatic bouquet.",
                        535, false, 0, "Meal");
        static Meal m5 = new Meal(4, 12, "Turkey",
                        "Tortilla bread served with turkey, rocca, pickles and special yogurt sauce.", 225, false, 0,
                        "Meal");
        static Meal m6 = new Meal(5, 15, "Tuna",
                        "Seven grain brown loofah bread served with olive tabinade, rocca, tomato," +
                                        " lemon fillet, capers and diet tuna.",
                        340, false, 0, "Meal");
        static Meal m7 = new Meal(6, 18, "Chicken Avocado",
                        "Grilled chicken, roasted red pepper, roaster mushrooms, cashew cream, avocado,"
                                        + " ciabatta bread seven seeds.",
                        410, false, 0, "Meal");

        // Salads
        static Meal s1 = new Meal(7, 8, "Broccoli Salad",
                        "Broccoli, cherry tomato, la russo lettuce, rocca, lemon, olive oil.", 160, false, 0, "Salad");
        static Meal s2 = new Meal(8, 8, "Greek Salad",
                        "Tomato, cucumber, mixed pepper, olive, lemon, olive oil.", 275, false, 0, "Salad");
        static Meal s3 = new Meal(9, 12, "Quinoa Salad",
                        "Quinoa, avocado, cherry tomato. walnut, red pepper, carrot," +
                                        "cucumber, mixed greens, red beans, lemon and olive oil.",
                        490, false, 0, "Salad");
        static Meal s4 = new Meal(10, 16, "Asian Salad",
                        "Mixed peppers, mixed greens, artichoke, noodles, red beans" +
                                        ", edmamme, grilled chicken served with light soy sauce and orange.",
                        490, false, 0, "Salad");

        // Desserts
        static Meal dessert1 = new Meal(11, 7, "Vegan Mango Shia Pudding",
                        "Shia seeds, mango slices, mango juice, sugar.", 200, false, 0, "Dessert");
        static Meal dessert2 = new Meal(12, 8, "Chocolate Shia Pudding",
                        "Shia seeds, cocoa powder, banana, milk, chocolate shavings.", 250, false, 0, "Dessert");
        static Meal dessert3 = new Meal(13, 12, "Granola Bars",
                        "Shia seeds, oatmeal, raisins, almond, sunflower seeds, pumpkin seeds,"
                                        + " coconut flakes, honey.",
                        250, false, 0, "Dessert");
        static Meal dessert4 = new Meal(14, 7, "Muhalabia",
                        "Milk, sugar, roses.", 150, false, 0, "Dessert");
        static Meal dessert5 = new Meal(15, 8, "Flan",
                        "Milk, sugar, caramel", 250, false, 0, "Dessert");

        // Drinks
        static Meal drink1 = new Meal(16, 2, "Diet Coke",
                        "", 1, false, 0, "Drink");
        static Meal drink2 = new Meal(17, 5, "Watermelon Strawberry",
                        "Watermelon, strawberry, sugar, lemon.", 150, false, 0, "Drink");
        static Meal drink3 = new Meal(18, 6, "Peach and Raspberry",
                        "Raspberry, peach, red orange, pomegranet, milk, sugar.", 175, false, 0, "Drink");
        static Meal drink4 = new Meal(19, 4, "Strawberry Iced Tea",
                        "Strawberry, tea, sugar.", 125, false, 0, "Drink");
        static Meal drink5 = new Meal(20, 4, "Orange Coconut Water",
                        "Orange, coconut, mint, sugar.", 125, false, 0, "Drink");

        static ArrayList<Integer> order = new ArrayList<>();
        static ArrayList<Meal> meallist = new ArrayList<>();
        static ArrayList<Meal> newmeals = new ArrayList<>();
        static ArrayList<ImageIcon> arrayMealsIcon = new ArrayList<>();
        static ArrayList<ImageIcon> arrayMenuMealsIcon = new ArrayList<>();

        int mealnum;
        Meal m;
        String type;
        int num1;
        JLabel singlemealnumlabel = new JLabel();
        JButton addbutton = new JButton("+");
        JButton minusbutton = new JButton("-");
        JButton deleteButton = new JButton("Delete Meal");
        JButton editButton = new JButton("Edit Meal");
        JButton backButton = new JButton("Back");
        JLabel pricelabel = new JLabel("Price : ");
        JLabel pricenumlabel = new JLabel(String.valueOf(Order.price));
        JLabel mealpricLabel = new JLabel();
        JLabel mealKcaloriLabel = new JLabel();
        JTextArea descTextArea = new JTextArea(5, 20);
        JTextField extraDetailsFiled = new JTextField();
        JLabel extraDetailscLabel = new JLabel("Extra details :");
        JFrame f = new JFrame();

        JLabel mainLabel = new JLabel();
        static ImageIcon drink1MainIcon = new ImageIcon("Snack-On-Track\\main drink 1.png");
        static ImageIcon drink2MainIcon = new ImageIcon("Snack-On-Track\\main drink 2.png");
        static ImageIcon drink3MainIcon = new ImageIcon("Snack-On-Track\\main drink 3.png");
        static ImageIcon drink4MainIcon = new ImageIcon("Snack-On-Track\\main drink 4.png");
        static ImageIcon drink5MainIcon = new ImageIcon("Snack-On-Track\\main drink 5.png");

        static ImageIcon dessert1MainIcon = new ImageIcon("Snack-On-Track\\main dessert 1.png");
        static ImageIcon dessert2MainIcon = new ImageIcon("Snack-On-Track\\main dessert 2.png");
        static ImageIcon dessert3MainIcon = new ImageIcon("Snack-On-Track\\main dessert 3.png");
        static ImageIcon dessert4MainIcon = new ImageIcon("Snack-On-Track\\main dessert 4.png");
        static ImageIcon dessert5MainIcon = new ImageIcon("Snack-On-Track\\main dessert 5.png");

        static ImageIcon salad1MainIcon = new ImageIcon("Snack-On-Track\\main salad 1.png");
        static ImageIcon salad2MainIcon = new ImageIcon("Snack-On-Track\\main salad 2.png");
        static ImageIcon salad3MainIcon = new ImageIcon("Snack-On-Track\\main salad 3.png");
        static ImageIcon salad4MainIcon = new ImageIcon("Snack-On-Track\\main salad 4.png");

        static ImageIcon meal1MainIcon = new ImageIcon("Snack-On-Track\\main meal 1.png");
        static ImageIcon meal2MainIcon = new ImageIcon("main meal  2.png");
        static ImageIcon meal3MainIcon = new ImageIcon("Snack-On-Track\\main meal 3.png");
        static ImageIcon meal4MainIcon = new ImageIcon("Snack-On-Track\\main meal 4.png");
        static ImageIcon meal5MainIcon = new ImageIcon("Snack-On-Track\\main meal 5.png");
        static ImageIcon meal6MainIcon = new ImageIcon("Snack-On-Track\\main meal 6.png");
        static ImageIcon meal7MainIcon = new ImageIcon("Snack-On-Track\\main meal 7.png");

        static ImageIcon meal1Icon = new ImageIcon("Snack-On-Track\\menu meal 1.png");
        static ImageIcon meal2Icon = new ImageIcon("Snack-On-Track\\menu meal 2.png");
        static ImageIcon meal3Icon = new ImageIcon("Snack-On-Track\\menu meal 3.png");
        static ImageIcon meal4Icon = new ImageIcon("Snack-On-Track\\menu meal 4.png");
        static ImageIcon meal5Icon = new ImageIcon("Snack-On-Track\\menu meal 5.png");
        static ImageIcon meal6Icon = new ImageIcon("Snack-On-Track\\menu meal 6.png");
        static ImageIcon meal7Icon = new ImageIcon("Snack-On-Track\\menu meal 7.png");

        static ImageIcon salad1Icon = new ImageIcon("Snack-On-Track\\menu salad 1.png");
        static ImageIcon salad2Icon = new ImageIcon("Snack-On-Track\\menu salad 2.png");
        static ImageIcon salad3Icon = new ImageIcon("Snack-On-Track\\menu salad 3.png");
        static ImageIcon salad4Icon = new ImageIcon("Snack-On-Track\\menu salad 4.png");

        static ImageIcon dessert1Icon = new ImageIcon("Snack-On-Track\\menu sweets 1.png");
        static ImageIcon dessert2Icon = new ImageIcon("Snack-On-Track\\menu sweets 2.png");
        static ImageIcon dessert3Icon = new ImageIcon("Snack-On-Track\\menu sweets 3.png");
        static ImageIcon dessert4Icon = new ImageIcon("Snack-On-Track\\menu sweets 4.png");
        static ImageIcon dessert5Icon = new ImageIcon("Snack-On-Track\\menu sweets 5.png");

        static ImageIcon drinksIcon1 = new ImageIcon("Snack-On-Track\\menu drinks 1.png");
        static ImageIcon drinksIcon2 = new ImageIcon("Snack-On-Track\\menu drinks 2.png");
        static ImageIcon drinksIcon3 = new ImageIcon("Snack-On-Track\\menu drinks 3.png");
        static ImageIcon drinksIcon4 = new ImageIcon("Snack-On-Track\\menu drinks 4.png");
        static ImageIcon drinksIcon5 = new ImageIcon("Snack-On-Track\\menu drinks 5.png");

        AllMealsFrame(Integer mealnum, boolean manager, String type) {
                f.setLayout(null);
                this.mealnum = mealnum;
                num1 = order.get(mealnum);
                this.m = meallist.get(mealnum);
                this.type = type;

                mainLabel.setBounds(0, 0, 650, 830);
                try {
                        mainLabel.setIcon(arrayMealsIcon.get(mealnum));
                } catch (IndexOutOfBoundsException e) {
                        System.out.println("wee");
                        // mainLabel.setIcon(); // new meal icon
                }

                mainLabel.setLayout(null);
                f.add(mainLabel);

                if (manager) {
                        deleteButton.setBounds(240, 30, 150, 30);
                        editButton.setBounds(240, 70, 150, 30);
                        mainLabel.add(deleteButton);
                        mainLabel.add(editButton);
                }

                singlemealnumlabel.setText(String.valueOf(num1));
                // mealpricLabel = new JLabel(String.valueOf(
                // AllMealsFrame.meallist.get(mealnum).getPrice())+" $");
                mealpricLabel = new JLabel(String.valueOf(m.getPrice()));
                mealKcaloriLabel = new JLabel(String.valueOf(m.getCals()) + " kcal");
                descTextArea.setText(m.getDesc());
                backButton.setBounds(250, 720, 150, 30);
                mainLabel.add(backButton);

                if (type.equals("Meal")) {
                        addbutton.setBounds(245, 615, 50, 30);
                        singlemealnumlabel.setBounds(313, 620, 50, 20);
                        minusbutton.setBounds(345, 615, 50, 30);
                        singlemealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
                        pricelabel.setBounds(265, 110, 100, 30);
                        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        pricenumlabel.setBounds(380, 110, 50, 30);
                        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        mealKcaloriLabel.setBounds(480, 290, 150, 40);
                        mealKcaloriLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealKcaloriLabel.setForeground(Color.WHITE);
                        mealpricLabel.setBounds(510, 335, 100, 50);
                        mealpricLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealpricLabel.setForeground(new Color(210, 48, 11));
                        extraDetailsFiled.setBounds(200, 670, 320, 25);
                        extraDetailscLabel.setBounds(85, 670, 250, 25);
                        extraDetailscLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
                        descTextArea.setWrapStyleWord(true);
                        descTextArea.setLineWrap(true);
                        descTextArea.setEditable(false);
                        descTextArea.setFocusable(false);
                        descTextArea.setOpaque(false);
                        descTextArea.setBorder(null);
                        descTextArea.setBounds(55, 450, 560, 300);
                        descTextArea.setFont(new Font("MV Boli", Font.BOLD, 22));
                        descTextArea.setForeground(new Color(75, 59, 9));
                        mainLabel.add(addbutton);
                        mainLabel.add(minusbutton);
                        mainLabel.add(extraDetailscLabel);
                        mainLabel.add(extraDetailsFiled);
                        mainLabel.add(mealKcaloriLabel);
                        mainLabel.add(descTextArea);
                        mainLabel.add(singlemealnumlabel);
                        mainLabel.add(pricelabel);
                        mainLabel.add(pricenumlabel);
                        mainLabel.add(mealpricLabel);

                }
                if (type.equals("Salad")) {
                        addbutton.setBounds(245, 575, 50, 30);
                        singlemealnumlabel.setBounds(313, 580, 50, 20);
                        minusbutton.setBounds(345, 575, 50, 30);
                        singlemealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
                        pricelabel.setBounds(265, 110, 100, 30);
                        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        pricenumlabel.setBounds(380, 110, 50, 30);
                        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        mealKcaloriLabel.setBounds(480, 290, 150, 40);
                        mealKcaloriLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealKcaloriLabel.setForeground(new Color(75, 59, 9));
                        mealpricLabel.setBounds(510, 335, 100, 50);
                        mealpricLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealpricLabel.setForeground(new Color(210, 48, 11));
                        extraDetailsFiled.setBounds(200, 630, 320, 25);
                        extraDetailscLabel.setBounds(85, 630, 250, 25);
                        extraDetailscLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
                        descTextArea.setText(m.getDesc());
                        descTextArea.setWrapStyleWord(true);
                        descTextArea.setLineWrap(true);
                        descTextArea.setEditable(false);
                        descTextArea.setFocusable(false);
                        descTextArea.setOpaque(false);
                        descTextArea.setBorder(null);
                        descTextArea.setBounds(55, 450, 560, 300);
                        descTextArea.setFont(new Font("MV Boli", Font.BOLD, 22));
                        descTextArea.setForeground(new Color(75, 59, 9));
                        mainLabel.add(addbutton);
                        mainLabel.add(minusbutton);
                        mainLabel.add(extraDetailscLabel);
                        mainLabel.add(extraDetailsFiled);
                        mainLabel.add(mealKcaloriLabel);
                        mainLabel.add(descTextArea);
                        mainLabel.add(singlemealnumlabel);
                        mainLabel.add(pricelabel);
                        mainLabel.add(pricenumlabel);
                        mainLabel.add(mealpricLabel);
                }
                if (type.equals("Dessert")) {
                        addbutton.setBounds(245, 590, 50, 30);
                        singlemealnumlabel.setBounds(313, 595, 50, 20);
                        minusbutton.setBounds(345, 590, 50, 30);
                        singlemealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
                        pricelabel.setBounds(265, 100, 100, 30);
                        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        pricenumlabel.setBounds(380, 100, 50, 30);
                        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        mealKcaloriLabel.setBounds(480, 250, 150, 40);
                        mealKcaloriLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealKcaloriLabel.setForeground(new Color(75, 59, 9));
                        mealpricLabel.setBounds(510, 280, 100, 50);
                        mealpricLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealpricLabel.setForeground(new Color(210, 48, 11));
                        extraDetailsFiled.setBounds(200, 650, 320, 25);
                        extraDetailscLabel.setBounds(85, 650, 250, 25);
                        extraDetailscLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
                        descTextArea.setText(m.getDesc());
                        descTextArea.setWrapStyleWord(true);
                        descTextArea.setLineWrap(true);
                        descTextArea.setEditable(false);
                        descTextArea.setFocusable(false);
                        descTextArea.setOpaque(false);
                        descTextArea.setBorder(null);
                        descTextArea.setBounds(110, 350, 220, 500);
                        descTextArea.setFont(new Font("MV Boli", Font.BOLD, 22));
                        descTextArea.setForeground(new Color(75, 59, 9));
                        mainLabel.add(addbutton);
                        mainLabel.add(minusbutton);
                        mainLabel.add(extraDetailscLabel);
                        mainLabel.add(extraDetailsFiled);
                        mainLabel.add(mealKcaloriLabel);
                        mainLabel.add(descTextArea);
                        mainLabel.add(singlemealnumlabel);
                        mainLabel.add(pricelabel);
                        mainLabel.add(pricenumlabel);
                        mainLabel.add(mealpricLabel);
                }
                if (type.equals("Drink")) {
                        addbutton.setBounds(245, 605, 50, 30);
                        singlemealnumlabel.setBounds(313, 610, 50, 20);
                        minusbutton.setBounds(345, 605, 50, 30);
                        singlemealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
                        pricelabel.setBounds(265, 100, 100, 30);
                        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        pricenumlabel.setBounds(380, 100, 50, 30);
                        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
                        mealKcaloriLabel.setBounds(480, 245, 150, 40);
                        mealKcaloriLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealKcaloriLabel.setForeground(new Color(75, 59, 9));
                        mealpricLabel.setBounds(510, 275, 100, 50);
                        mealpricLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                        mealpricLabel.setForeground(new Color(210, 48, 11));
                        extraDetailsFiled.setBounds(200, 650, 320, 25);
                        extraDetailscLabel.setBounds(85, 650, 250, 25);
                        extraDetailscLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
                        descTextArea.setText(m.getDesc());
                        descTextArea.setWrapStyleWord(true);
                        descTextArea.setLineWrap(true);
                        descTextArea.setEditable(false);
                        descTextArea.setFocusable(false);
                        descTextArea.setOpaque(false);
                        descTextArea.setBorder(null);
                        descTextArea.setBounds(110, 350, 220, 500);
                        descTextArea.setFont(new Font("MV Boli", Font.BOLD, 22));
                        descTextArea.setForeground(new Color(75, 59, 9));
                        mainLabel.add(addbutton);
                        mainLabel.add(minusbutton);
                        mainLabel.add(extraDetailscLabel);
                        mainLabel.add(extraDetailsFiled);
                        mainLabel.add(mealKcaloriLabel);
                        mainLabel.add(descTextArea);
                        mainLabel.add(singlemealnumlabel);
                        mainLabel.add(pricelabel);
                        mainLabel.add(pricenumlabel);
                        mainLabel.add(mealpricLabel);
                }
                addbutton.addActionListener(this);
                minusbutton.addActionListener(this);
                deleteButton.addActionListener(this);
                editButton.addActionListener(this);
                backButton.addActionListener(this);

                f.setTitle(m.getName());
                f.setResizable(false);
                f.setSize(650, 830);
                f.setVisible(true);
                f.setLocationRelativeTo(null);

        }

        @Override

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addbutton) {
                        Order.num++;
                        num1++;
                        order.set(mealnum, num1);
                        Order.price += m.getPrice();
                        singlemealnumlabel.setText(String.valueOf(num1));
                        pricenumlabel.setText(String.valueOf(Order.price));

                        Order.mealnumlabel.setText(String.valueOf(Order.num));
                        Order.pricenumlabel.setText(String.valueOf(Order.price));
                        m.setPopularity(m.getPopularity() + 1);
                }
                if (e.getSource() == minusbutton && num1 > 0) {
                        Order.num--;
                        num1--;
                        order.set(mealnum, num1);
                        Order.price -= m.getPrice();
                        pricenumlabel.setText(String.valueOf(Order.price));
                        singlemealnumlabel.setText(String.valueOf(num1));

                        Order.mealnumlabel.setText(String.valueOf(Order.num));
                        Order.pricenumlabel.setText(String.valueOf(Order.price));
                        m.setPopularity(m.getPopularity() - 1);
                }
                if (e.getSource() == deleteButton) {
                        meallist.get(mealnum).setDeleted(true);
                        JOptionPane.showMessageDialog(null, "Meal Deleted.", "Title",
                                        JOptionPane.INFORMATION_MESSAGE);
                        f.dispose();
                }
                if (e.getSource() == backButton) {
                        f.dispose();
                }
                if (e.getSource() == editButton) {
                        f.dispose();
                        new EditMeal(m, mealnum, type);
                }
        }

        public static void restartapp() {
                meallist.add(m1);
                meallist.add(m2);
                meallist.add(m3);
                meallist.add(m4);
                meallist.add(m5);
                meallist.add(m6);
                meallist.add(m7);
                meallist.add(s1);
                meallist.add(s2);
                meallist.add(s3);
                meallist.add(s4);
                meallist.add(dessert1);
                meallist.add(dessert2);
                meallist.add(dessert3);
                meallist.add(dessert4);
                meallist.add(dessert5);
                meallist.add(drink1);
                meallist.add(drink2);
                meallist.add(drink3);
                meallist.add(drink4);
                meallist.add(drink5);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
                order.add(0);
        }

        public static void fillLists() {
                arrayMealsIcon.clear();
                arrayMealsIcon.add(meal1MainIcon);
                arrayMealsIcon.add(meal2MainIcon);
                arrayMealsIcon.add(meal3MainIcon);
                arrayMealsIcon.add(meal4MainIcon);
                arrayMealsIcon.add(meal5MainIcon);
                arrayMealsIcon.add(meal6MainIcon);
                arrayMealsIcon.add(meal7MainIcon);

                arrayMealsIcon.add(salad1MainIcon);
                arrayMealsIcon.add(salad2MainIcon);
                arrayMealsIcon.add(salad3MainIcon);
                arrayMealsIcon.add(salad4MainIcon);

                arrayMealsIcon.add(dessert1MainIcon);
                arrayMealsIcon.add(dessert2MainIcon);
                arrayMealsIcon.add(dessert3MainIcon);
                arrayMealsIcon.add(dessert4MainIcon);
                arrayMealsIcon.add(dessert5MainIcon);

                arrayMealsIcon.add(drink1MainIcon);
                arrayMealsIcon.add(drink2MainIcon);
                arrayMealsIcon.add(drink3MainIcon);
                arrayMealsIcon.add(drink4MainIcon);
                arrayMealsIcon.add(drink5MainIcon);

                arrayMenuMealsIcon.clear();
                arrayMenuMealsIcon.add(meal1Icon);
                arrayMenuMealsIcon.add(meal2Icon);
                arrayMenuMealsIcon.add(meal3Icon);
                arrayMenuMealsIcon.add(meal4Icon);
                arrayMenuMealsIcon.add(meal5Icon);
                arrayMenuMealsIcon.add(meal6Icon);
                arrayMenuMealsIcon.add(meal7Icon);

                arrayMenuMealsIcon.add(salad1Icon);
                arrayMenuMealsIcon.add(salad2Icon);
                arrayMenuMealsIcon.add(salad3Icon);
                arrayMenuMealsIcon.add(salad4Icon);

                arrayMenuMealsIcon.add(dessert1Icon);
                arrayMenuMealsIcon.add(dessert2Icon);
                arrayMenuMealsIcon.add(dessert3Icon);
                arrayMenuMealsIcon.add(dessert4Icon);
                arrayMenuMealsIcon.add(dessert5Icon);

                arrayMenuMealsIcon.add(drinksIcon1);
                arrayMenuMealsIcon.add(drinksIcon2);
                arrayMenuMealsIcon.add(drinksIcon3);
                arrayMenuMealsIcon.add(drinksIcon4);
                arrayMenuMealsIcon.add(drinksIcon5);

                arrayMenuMealsIcon.add(Order.newmealIcon);
                for (Meal m : meallist) {
                        order.add(0);
                }

                // Order.meallabels.clear();
                // new MealOrder().fillmeallabellist();
                // new SaladOrder().fillmeallabellist();
                // new DessertOrder().fillmeallabellist();
                // new DrinksOrder().fillmeallabellist();

        }

}
