import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MealOrder extends Order implements MouseListener {
    
    ImageIcon meal = new ImageIcon("meal1icon.jpg");
    JLabel meal1label = new JLabel(meal);
    JLabel meal2label = new JLabel("0");
    JLabel meal3label = new JLabel("0");
    JLabel meal4label = new JLabel("0");
    JLabel meal5label = new JLabel("0");
    JLabel meal6label = new JLabel("0");
    JLabel meal7label = new JLabel("0");
    boolean manager;

    MealOrder(boolean manager){
        this.manager=manager;
        meal1label.setBounds(-7,350 , 665, 150);
        // meal1label.setBackground(Color.red);
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
            f.dispose();
            new SaladOrder(manager);
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
            if(num == 0){
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
        if(e.getSource() == meal1label){
            // System.out.println(MealFrame.m1.getDeleted());
            if(MealFrame.m1.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(1,manager);
            }
        }
        if(e.getSource() == meal2label){
            if(MealFrame.m2.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(2,manager);
            }
        }
        if(e.getSource() == meal3label){
            if(MealFrame.m3.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(3,manager);
            }
        }
        if(e.getSource() == meal4label){
            if(MealFrame.m4.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(4,manager);
            }
        }
        if(e.getSource() == meal5label){
            if(MealFrame.m5.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(5,manager);
            }
        }
        if(e.getSource() == meal6label){
            if(MealFrame.m6.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(6,manager);
            }
        }
        if(e.getSource() == meal7label){
            if(MealFrame.m7.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(7,manager);
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
