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
    boolean manager;

    static int num1=0,num2=0,num3=0 ,num4=0,num5=0;

    DessertOrder(boolean manager){
        this.manager=manager;

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
            new MealOrder(manager);
        }
        if(e.getSource() == saladsitem){
            new SaladOrder(manager);
        }
        if(e.getSource()==drinksitem){
            new DrinksOrder(manager);

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
            if(MealFrame.dessert1.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(12,manager);
            }        
        }
        if(e.getSource() == dessert2label){
            if(MealFrame.dessert2.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(13,manager);
            }
        }
        if(e.getSource() == dessert3label){
            if(MealFrame.dessert3.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(14,manager);
            }
        }
        if(e.getSource() == dessert4label){
            if(MealFrame.dessert4.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(15,manager);
            }
        }
        if(e.getSource() == dessert5label){
            if(MealFrame.dessert5.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(16,manager);
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
