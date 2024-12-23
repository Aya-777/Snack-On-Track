import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrinksOrder extends Order implements MouseListener{
    JLabel drinksOrderIconLabel = new JLabel();
    ImageIcon drinksOrderIcon = new ImageIcon("main desin drinks.png");

    JLabel drink1label = new JLabel();
    ImageIcon drinksIcon1 = new ImageIcon("menu drinks 1.png");
    JLabel drink2label = new JLabel();
    ImageIcon drinksIcon2 = new ImageIcon("menu drinks 2.png");
    JLabel drink3label = new JLabel();
    ImageIcon drinksIcon3 = new ImageIcon("menu drinks 3.png");
    JLabel drink4label = new JLabel();
    ImageIcon drinksIcon4 = new ImageIcon("menu drinks 4.png");
    JLabel drink5label = new JLabel();
    ImageIcon drinksIcon5 = new ImageIcon("menu drinks 5.png");

    static int num1=0,num2=0,num3=0,num4=0,num5=0;
    DrinksOrder(){
        drinksOrderIconLabel.setBounds(0,0,650,830);
        drinksOrderIconLabel.setIcon(drinksOrderIcon);

        drink1label.setBounds(260,200 , 610, 145);
        drink1label.setBorder(new LineBorder(Color.white,2));
        drink1label.setOpaque(true);
        drink1label.setIcon(drinksIcon1);

        drink2label.setBounds(15,355 , 610, 145);
        drink2label.setBorder(new LineBorder(Color.white,2));
        drink2label.setOpaque(true);
        drink2label.setIcon(drinksIcon2);


        drink3label.setBounds(15,510 , 610, 145);
        drink3label.setBorder(new LineBorder(Color.white,2));
        drink3label.setOpaque(true);
        drink3label.setIcon(drinksIcon3);

        drink4label.setBounds(15,665, 610, 145);
        drink4label.setBorder(new LineBorder(Color.white,2));
        drink4label.setOpaque(true);
        drink4label.setIcon(drinksIcon4);

        drink5label.setBounds(15,820, 610, 145);
        drink5label.setBorder(new LineBorder(Color.white,2));
        drink5label.setOpaque(true);
        drink5label.setIcon(drinksIcon5);

        panelScroll.add(drink1label);
        panelScroll.add(drink2label);
        panelScroll.add(drink3label);
        panelScroll.add(drink4label);
        panelScroll.add(drink5label);

        f.add(drinksOrderIconLabel);

        drinksitem.setEnabled(false);


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
            JOptionPane.showMessageDialog(null,"You are already on drink's order page.",
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
                new Cart(MealFrame.order);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == drink1label){
            new MealFrame(16);
        }
        if(e.getSource() == drink2label){
            new MealFrame(17);
        }
        if(e.getSource() == drink3label){
            new MealFrame(18);
        }
        if(e.getSource() == drink4label){
            new MealFrame(19);
        }
        if(e.getSource() == drink5label){
            new MealFrame(20);
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
