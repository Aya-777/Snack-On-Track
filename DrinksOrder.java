import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DrinksOrder extends Order implements MouseListener{

    ImageIcon drink1icon = new ImageIcon("drink1.jpg");
    ImageIcon drink2icon = new ImageIcon("drink2.jpg");
    ImageIcon drink3icon = new ImageIcon("drink3.jpg");
    ImageIcon drink4icon = new ImageIcon("drink4.jpg");
    ImageIcon drink5icon = new ImageIcon("drink5.jpg");
    JLabel drink1label = new JLabel(drink1icon);
    JLabel drink2label = new JLabel(drink2icon);
    JLabel drink3label = new JLabel(drink3icon);
    JLabel drink4label = new JLabel(drink4icon);
    JLabel drink5label = new JLabel(drink5icon);
    boolean manager;

    static int num1=0,num2=0,num3=0,num4=0,num5=0;
    DrinksOrder(boolean manager){
        this.manager=manager;
        drink1label.setBounds(0,350 , 665, 150);
        // drink2label.setBounds(0, , 665, 150);
        drink1label.setOpaque(true);

        f.add(drink1label);
        f.add(drink2label);
        f.add(drink3label);
        f.add(drink4label);
        f.add(drink5label);

        drinksitem.setEnabled(false);


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
            JOptionPane.showMessageDialog(null,"You are already on drink's order page.",
            "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == dessertsitem){
            new DessertOrder(manager);
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
        if(e.getSource() == drink1label){
            new MealFrame(16,manager);
        }
        if(e.getSource() == drink2label){
            new MealFrame(17,manager);
        }
        if(e.getSource() == drink3label){
            new MealFrame(18,manager);
        }
        if(e.getSource() == drink4label){
            new MealFrame(19,manager);
        }
        if(e.getSource() == drink5label){
            new MealFrame(20,manager);
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
