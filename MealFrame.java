import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;

public class MealFrame implements ActionListener{
        // Meals
    static Meal m1 = new Meal(0,23,"Healthy Steak Meal",
        "Grilled fillet, broccoli, fries, served with special sauce and rice," +
                " cooked with an aromatic bouquet.",590,false);
    static Meal m2 = new Meal(1,20,"Teryaki Chicken",
            "Chicken cooked in soy sauce,honey and apple juice, mixed with capsicum, carrot," +
            " served with rice and broccoli." ,520,false);
    static Meal m3 = new Meal(2,22,"Healthy Chicken Meal",
            "grilled chicken, grilled broccoli, grilled carrots,grilled beans,grilled fresh mushrooms,"
             +"grilled potatoes,served with special sauce and rice cooked with an aromatic bouquet.",500,false);
    static Meal m4 = new Meal(3,22,"Curry Chicken",
            "Chicken cooked with skimmed coconut milk, mixed with capsicum," +
                    "ginger, chicken broth, garlic, curry powder.",535,false);
    static Meal m5 = new Meal(4,12,"Turkey", "Tortilla bread served with turkey, rocca, "+ 
        "pickels and special yogurt sauce."
            ,525,false);
    static Meal m6 = new Meal(5,15,"Tuna", "Seven grain brown loofah bread served with olive tabinade, rocca, tomato,"+
        "lemon fillet, capers and diet tuna.",340,false);
    static Meal m7 = new Meal(6,18,"Chicken Avocado",
            "Grilled chicken, roasted red pepper, roaster mushrooms, cashew cream, avocado," +
                    " ciabatta bread seven seeds.",410,false);

        // Salads
        static Meal s1 = new Meal(7,8,"Broccoli Salad",
        "Broccoli, cherry tomato, la russo lettuce, rocca, lemon, olive oil.",160,false);
    static Meal s2 = new Meal(8,8,"Greek Salad",
        "Tomato, cucumber, mixed pepper, olive, lemon, olive oil.",275,false);  
    static Meal s3 = new Meal(9,12,"Quinoa Salad",
        "Quinoa, avocado, cherry tomato. walnut, red pepper, carrot," +
                "cucumber, mixed greens, red beans, lemon and olive oil.",490,false);
    static Meal s4 = new Meal(10,16,"Asian Salad",
        "Mixed peppers, mixed greens, artichoke, noodles, red beans, edmamme, grilled chicken served with"
        +" light soy sauce and orange.",490,false);

        //Desserts    
        static Meal dessert4 = new Meal(11,7,"Vegan Mango Shia Pudding",
        "Shia seeds, mango slices, mango juice, sugar.",200,false);
    static Meal dessert1 = new Meal(12,8,"Chocolate Shia Pudding",
        "Shia seeds, cocoa powder, banana, milk, chocolate shavings.",250,false);
    static Meal dessert2 = new Meal(13,12,"Granola Bars",
        "Shia seeds, oatmeal, raisins, almond, sunflower seeds, pumpkin seeds, coconut flakes, honey.",250,false);
    static Meal dessert3 = new Meal(14,7,"Muhalabia(arabian milk pudding)",
        "Milk, sugar, roses.",150,false);
    static Meal dessert5 = new Meal(15,8,"Flan","Milk, sugar, caramel",250,false);

        //Drinks
    static Meal drink1 = new Meal(16, 2, "Diet Coke",
     "", 1,false);
    static Meal drink2 = new Meal(17, 5, "Watermelon Strawberry Smoothie",
     "Watermelon, strawberry, sugar, lemon.", 150,false);
    static Meal drink3 = new Meal(18, 6, "Peach and Raspberry Smoothie",
     "Raspberry, peach, red orange, pomegranet, milk, sugar.", 175,false);
     static Meal drink4 = new Meal(19, 4, "Strawberry Iced Tea",
     "Strawberry, tea, sugar.", 125,false);
     static Meal drink5 = new Meal(20, 4, "Orange Coconut Water",
     "Orange, coconut, mint, sugar.", 125,false); 
     
       

    static ArrayList<Integer> order = new ArrayList<>();
    static ArrayList<Meal> meallist = new ArrayList<>(); 
    static ArrayList<Meal> newmeals = new ArrayList<>();


    int mealnum;
    Meal m;
    int num1 = order.get(mealnum);
    JLabel singlemealnumlabel = new JLabel(String.valueOf(order.get(mealnum)));
    JButton addbutton = new JButton("+");
    JButton minusbutton = new JButton("-");
    JButton deleteButton = new JButton("Delete Meal");
    JButton editButton = new JButton("Edit Meal");
    JButton backButton = new JButton("Back");
    JLabel pricelabel = new JLabel("Price : ");
    JLabel pricenumlabel = new JLabel(String.valueOf(Order.price));
    
    JFrame f = new JFrame();

    MealFrame(Integer mealnum , boolean manager){
        f.setLayout(new FlowLayout());
        mealnum--;
        this.mealnum=mealnum;
        num1 = order.get(mealnum);
        this.m=meallist.get(mealnum);

        addbutton.addActionListener(this);
        minusbutton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
        backButton.addActionListener(this);

        if(manager){
            f.add(deleteButton);
            f.add(editButton);
        }
        singlemealnumlabel.setText(String.valueOf(order.get(mealnum)));

        f.add(backButton);
        f.add(singlemealnumlabel);
        f.add(addbutton);
        f.add(minusbutton);
        f.add(pricelabel);
        f.add(pricenumlabel);
        
        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addbutton){
            Order.num++; num1++;
            // order.add(mealnum-1, num1);
            order.set(mealnum, num1);
            Order.price += m.getPrice();
            singlemealnumlabel.setText(String.valueOf(num1));
            pricenumlabel.setText(String.valueOf(Order.price));

            Order.mealnumlabel.setText(String.valueOf(Order.num));
            Order.pricenumlabel.setText(String.valueOf(Order.price));
        }
        if(e.getSource() == minusbutton && num1 > 0){
            Order.num--; num1--;
            // order.add(mealnum-1 ,num1);
            order.set(mealnum, num1);
            Order.price-= m.getPrice();
            pricenumlabel.setText(String.valueOf(Order.price));
            singlemealnumlabel.setText(String.valueOf(num1));

            Order.mealnumlabel.setText(String.valueOf(Order.num));
            Order.pricenumlabel.setText(String.valueOf(Order.price));
        }
        if(e.getSource() == deleteButton){
            // meallist.remove(mealnum);
            meallist.get(mealnum).setDeleted(true);
            JOptionPane.showMessageDialog(null, "Meal Deleted.", "Title", JOptionPane.INFORMATION_MESSAGE);
            f.dispose();
        }
        if(e.getSource()==backButton){
            f.dispose();
        }
        if(e.getSource()==editButton){
            f.dispose();
            new EditMeal(m);
        }
    }

    public static void fillLists(){
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
        for (Meal meal : newmeals) {
            meallist.add(meal);
            order.add(0);
        }
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

    public static void addMeal(int serialnum,int price,String name , String desc, int cals){
        serialnum = meallist.size()-1;
        Meal  newMeal = new Meal(serialnum, price, name, desc, cals,false);
        meallist.add(newMeal);
        newmeals.add(newMeal);
        order.add(0);
        System.out.println(meallist.size()); 
        
    }

}
