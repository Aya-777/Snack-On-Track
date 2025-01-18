import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

class EditMeal implements ActionListener{
    JFrame f = new JFrame("Edit Meal");
    JLabel editMealIconLabel = new JLabel();
    ImageIcon editMealIcon = new ImageIcon("cart.png");
    JTextField priceTextField = new JTextField();
    JTextField calorieTextField = new JTextField();
    JLabel namelabel = new JLabel();
    JLabel pricelabel = new JLabel("Price: ");
    JLabel calorielabel = new JLabel("Calories: ");
    JLabel descriptionlabel = new JLabel("Description: ");
    JButton confirmButton = new JButton("Confirm");
    JTextArea textArea = new JTextArea(5,20);
    Meal m;
    int mealnum;
    String type;

    EditMeal(Meal m,int mealnum,String type){
        f.setLayout(null);

        editMealIconLabel.setBounds(0,0,500,500);
        editMealIconLabel.setIcon(editMealIcon);


        this.m=m;
        this.mealnum=mealnum;
        this.type=type;

        confirmButton.setBounds(190,375,120,25);
        confirmButton.addActionListener(this);
        confirmButton.setFocusable(false);

        namelabel.setBounds(80,95,400,22);
        namelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));

        pricelabel.setBounds(80,160,120,25);
        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        priceTextField.setBounds(150,162,70,23);
        priceTextField.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        calorielabel.setBounds(80,220,100,25);
        calorielabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        calorieTextField.setBounds(175,222,70,23);
        calorieTextField.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));

        descriptionlabel.setBounds(80,290,120,25);
        descriptionlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));

        namelabel.setText("Name: " + m.getName());
        priceTextField.setText(String.valueOf(m.getPrice()));
        calorieTextField.setText(String.valueOf(m.getCals()));
        textArea.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(m.getDesc());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(200,280, 270, 50);

        editMealIconLabel.add(scrollPane);
        editMealIconLabel.add(namelabel);
        editMealIconLabel.add(confirmButton);
        editMealIconLabel.add(pricelabel);
        editMealIconLabel.add(calorielabel);
        editMealIconLabel.add(descriptionlabel);
        editMealIconLabel.add(priceTextField);
        editMealIconLabel.add(calorieTextField);


        f.add(editMealIconLabel);
        f.setResizable(false);
        f.setSize(500,500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmButton){
            int price = Integer.parseInt(priceTextField.getText());
            int calorie = Integer.parseInt(calorieTextField.getText());
            String desc = textArea.getText();
            AllMealsFrame.meallist.get(mealnum).setCals(calorie);
            AllMealsFrame.meallist.get(mealnum).setPrice(price);
            AllMealsFrame.meallist.get(mealnum).setDesc(desc);
            confirmButton.setEnabled(false);
            f.dispose();
            if (type=="Meal") {
                new MealOrder(true);
            }
            else if (type=="Salad") {
                new SaladOrder(true);
            }
            else if (type=="Dessert") {
                new DessertOrder(true);
            }
            else if(type=="Drink"){
                new DrinksOrder(true);
            }
            else{
                new MealOrder(true);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Meals.dat"))){
                oos.writeObject(AllMealsFrame.meallist);
                } catch (Exception ee) {
                   ee.printStackTrace();
                }

        }
    }
}