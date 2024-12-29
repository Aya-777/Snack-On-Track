import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class EditMeal implements ActionListener{
    JFrame f = new JFrame("Edit Meal");
    JTextField priceTextField = new JTextField();
    JTextField calorieTextField = new JTextField();
    JTextField descriptionTextField = new JTextField();
    JLabel namelabel = new JLabel();
    JLabel pricelabel = new JLabel("Price: ");
    JLabel calorielabel = new JLabel("Calories: ");
    JLabel descriptionlabel = new JLabel("Description: ");
    JButton confirmButton = new JButton("Confirm");
    Meal m;
    int mealnum;

    EditMeal(Meal m,int mealnum){
        f.setLayout(null);

        this.m=m;
        this.mealnum=mealnum;

        confirmButton.setBounds(200,450,100,20);
        confirmButton.addActionListener(this);

        namelabel.setBounds(30,50,200,30);
        pricelabel.setBounds(50,100,80,20);
        calorielabel.setBounds(50,130,80,20);
        descriptionlabel.setBounds(50,160,80,20);

        priceTextField.setBounds(140,100,100,20);
        calorieTextField.setBounds(140,130,100,20);
        descriptionTextField.setBounds(140,160,250,100);

        namelabel.setText("Name: " + m.getName());
        priceTextField.setText(String.valueOf(m.getPrice()));
        calorieTextField.setText(String.valueOf(m.getCals()));
        descriptionTextField.setText(m.getDesc());

        f.add(namelabel);
        f.add(confirmButton);
        f.add(pricelabel);
        f.add(calorielabel);
        f.add(descriptionlabel);
        f.add(priceTextField);
        f.add(calorieTextField);
        f.add(descriptionTextField);

        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmButton){
            MealFrame.meallist.get(mealnum).setCals(Integer.parseInt(calorieTextField.getText()));
            MealFrame.meallist.get(mealnum).setPrice(Integer.parseInt(priceTextField.getText()));
            MealFrame.meallist.get(mealnum).setDesc(descriptionTextField.getText());
            confirmButton.setEnabled(false);
            f.dispose();
            new MealOrder(true);
        }
    }
}