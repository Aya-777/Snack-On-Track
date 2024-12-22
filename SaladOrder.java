import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaladOrder extends Order implements MouseListener {

    JLabel salad1label = new JLabel("0");
    JLabel salad2label = new JLabel("0");
    JLabel salad3label = new JLabel("0");
    JLabel salad4label = new JLabel("0");
    boolean manager;

    static int num1=0,num2=0,num3=0,num4=0;

    SaladOrder(boolean manager){
        this.manager=manager;
        f.add(salad1label);
        f.add(salad2label);
        f.add(salad3label);
        f.add(salad4label);

        saladsitem.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem){
            f.dispose();
            new MealOrder(manager);

        }
        if(e.getSource() == saladsitem){
            JOptionPane.showMessageDialog(null,"You are already on salad's order page.",
                    "Title",JOptionPane.WARNING_MESSAGE);
        }
         if(e.getSource() == dessertsitem){
            f.dispose();
            new DessertOrder(manager);
        }
        if(e.getSource()==drinksitem){
            f.dispose();
            new DrinksOrder(manager);
        }

        if(e.getSource() == viewcartbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);}
        }
        if(e.getSource()==logoutButton){
            super.actionPerformed(e);
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == salad1label){
            if(MealFrame.s1.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(8,manager);
            }
        }
        if(e.getSource() == salad2label){
            if(MealFrame.s2.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(9,manager);
            }

        }
        if(e.getSource() == salad3label){
            if(MealFrame.s3.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(10,manager);
            }
        }
        if(e.getSource() == salad4label){
            if(MealFrame.s4.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(11,manager);
            }
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
