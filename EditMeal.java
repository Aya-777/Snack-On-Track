import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class EditMeal implements ActionListener{
    JFrame f = new JFrame("Edit Meal");
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

        this.m=m;
        this.mealnum=mealnum;
        this.type=type;

        confirmButton.setBounds(200,450,100,20);
        confirmButton.addActionListener(this);

        namelabel.setBounds(30,50,200,30);
        pricelabel.setBounds(50,100,80,20);
        calorielabel.setBounds(50,130,80,20);
        descriptionlabel.setBounds(50,160,80,20);

        priceTextField.setBounds(140,100,100,20);
        calorieTextField.setBounds(140,130,100,20);

        namelabel.setText("Name: " + m.getName());
        priceTextField.setText(String.valueOf(m.getPrice()));
        calorieTextField.setText(String.valueOf(m.getCals()));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(m.getDesc());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(140,160, 300, 50);

        f.add(scrollPane);
        f.add(namelabel);
        f.add(confirmButton);
        f.add(pricelabel);
        f.add(calorielabel);
        f.add(descriptionlabel);
        f.add(priceTextField);
        f.add(calorieTextField);

        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmButton){
            int price = Integer.parseInt(priceTextField.getText());
            int calorie = Integer.parseInt(calorieTextField.getText());
            String desc = textArea.getText();
            MealFrame.meallist.get(mealnum).setCals(calorie);
            MealFrame.meallist.get(mealnum).setPrice(price);
            MealFrame.meallist.get(mealnum).setDesc(desc);
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
            
        }
    }
}