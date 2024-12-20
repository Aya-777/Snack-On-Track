import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DessertOrder extends Order implements MouseListener{


    JLabel dessert1label = new JLabel("0");
    JLabel dessert2label = new JLabel("0");
    JLabel dessert3label = new JLabel("0");
    JLabel dessert4label = new JLabel("0");
    JLabel dessert5label = new JLabel("0");

    static int num1=0,num2=0,num3=0 ,num4=0,num5=0;

    DessertOrder(){

        f.add(dessert1label);
        f.add(dessert2label);
        f.add(dessert3label);
        f.add(dessert4label);
        f.add(dessert5label);

        dessertsitem.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem){
            new MealOrder();
        }
        if(e.getSource() == saladsitem){
            new SaladOrder();
        }
        if(e.getSource()==drinksitem){
            new DrinksOrder();

        }
        if(e.getSource() == dessertsitem){
                JOptionPane.showMessageDialog(null,"You are already on dessert's order page.",
                        "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == viewcartbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == dessert1label){
            new MealFrame(11);
        }
        if(e.getSource() == dessert2label){
            new MealFrame(12);
        }
        if(e.getSource() == dessert3label){
            new MealFrame(13);
        }
        if(e.getSource() == dessert4label){
            new MealFrame(14);
        }
        if(e.getSource() == dessert5label){
            new MealFrame(15);
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
