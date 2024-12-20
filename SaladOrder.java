import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaladOrder extends Order implements MouseListener {

    JLabel salad1label = new JLabel("0");
    JLabel salad2label = new JLabel("0");
    JLabel salad3label = new JLabel("0");
    JLabel salad4label = new JLabel("0");

    static int num1=0,num2=0,num3=0,num4=0;

    SaladOrder(){

        f.add(salad1label);
        f.add(salad2label);
        f.add(salad3label);
        f.add(salad4label);

        saladsitem.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem){
            new MealOrder();

        }
        if(e.getSource() == saladsitem){
            JOptionPane.showMessageDialog(null,"You are already on salad's order page.",
                    "Title",JOptionPane.WARNING_MESSAGE);
        }
         if(e.getSource() == dessertsitem){
            new DessertOrder();
        }

        if(e.getSource() == viewcartbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);}
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == salad1label){
            new MealFrame(8);

        }
        if(e.getSource() == salad2label){
            new MealFrame(9);

        }
        if(e.getSource() == salad3label){
            new MealFrame(10);


        }
        if(e.getSource() == salad4label){
            new MealFrame(11);
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
