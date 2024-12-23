import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaladOrder extends Order implements MouseListener {
    JLabel saladOrderIconLabel = new JLabel();
    ImageIcon saladOrderIcon = new ImageIcon("main design salad.png");
    JLabel salad1label = new JLabel();
    ImageIcon salad1Icon = new ImageIcon("menu salad 1.png");
    JLabel salad2label = new JLabel();
    ImageIcon salad2Icon = new ImageIcon("menu salad 2.png");
    JLabel salad3label = new JLabel();
    ImageIcon salad3Icon = new ImageIcon("menu salad 3.png");
    JLabel salad4label = new JLabel();
    ImageIcon salad4Icon = new ImageIcon("menu salad 4.png");
    boolean manager;
    static int num1=0,num2=0,num3=0,num4=0;

    SaladOrder(boolean manager){
        super(manager);
        saladOrderIconLabel.setBounds(0,0,650,830);
        saladOrderIconLabel.setIcon(saladOrderIcon);

        salad1label.setBounds(260,200 , 610, 145);
        salad1label.setBorder(new LineBorder(Color.white,2));
        salad1label.setOpaque(true);
        salad1label.setIcon(salad1Icon);

        salad2label.setBounds(15,355, 610, 145);
        salad2label.setBorder(new LineBorder(Color.white,2));
        salad2label.setOpaque(true);
        salad2label.setIcon(salad2Icon);

        salad3label.setBounds(15,510 , 610, 145);
        salad3label.setBorder(new LineBorder(Color.white,2));
        salad3label.setOpaque(true);
        salad3label.setIcon(salad3Icon);

        salad4label.setBounds(15,665 , 610, 145);
        salad4label.setBorder(new LineBorder(Color.white,2));
        salad4label.setOpaque(true);
        salad4label.setIcon(salad4Icon);

        panelScroll.add(salad1label);
        panelScroll.add(salad2label);
        panelScroll.add(salad3label);
        panelScroll.add(salad4label);


        f.add(saladOrderIconLabel);


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
        if(e.getSource()==addmealButton){
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
