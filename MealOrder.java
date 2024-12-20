import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MealOrder extends Order implements MouseListener {
    
    JLabel meal1label = new JLabel();
    JLabel meal2label = new JLabel("0");
    JLabel meal3label = new JLabel("0");
    JLabel meal4label = new JLabel("0");
    JLabel meal5label = new JLabel("0");
    JLabel meal6label = new JLabel("0");
    JLabel meal7label = new JLabel("0");


    MealOrder(){
        meal1label.setBounds(20,350 , 100, 20);
        meal1label.setBackground(Color.red);
        meal1label.setOpaque(true);
        meal1label.addMouseListener(this);

        f.add(meal1label);
        f.add(meal2label);
        f.add(meal3label);
        f.add(meal4label);
        f.add(meal5label);
        f.add(meal6label);
        f.add(meal7label);

        mealsitem.setEnabled(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem ){
            JOptionPane.showMessageDialog(null,"You are already on meal's order page.",
                    "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == saladsitem){
            new SaladOrder();
        }
        if(e.getSource() == dessertsitem){
            new DessertOrder();
        }
        if(e.getSource()==drinksitem){
            new DrinksOrder();
        }

        if(e.getSource() == viewcartbutton){
            if(num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);}
        }


    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == meal1label){
            new MealFrame(1);
        }
        if(e.getSource() == meal2label){
            new MealFrame(2);
        }
        if(e.getSource() == meal3label){
            new MealFrame(3);
        }
        if(e.getSource() == meal4label){
            new MealFrame(4);
        }
        if(e.getSource() == meal5label){
            new MealFrame(5);
        }
        if(e.getSource() == meal6label){
            new MealFrame(6);
        }
        if(e.getSource() == meal7label){
            new MealFrame(7);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
