import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MealOrder extends Order implements MouseListener {
    JLabel mealOrderIconLabel = new JLabel();
    ImageIcon mealOrderIcon = new ImageIcon("main design meal.png");
    JLabel meal1label = new JLabel();
    ImageIcon meal1Icon = new ImageIcon("menu meal 1.png");
    JLabel meal2label = new JLabel();
    ImageIcon meal2Icon = new ImageIcon("menu meal 2.png");
    JLabel meal3label = new JLabel();
    ImageIcon meal3Icon = new ImageIcon("menu meal 3.png");
    JLabel meal4label = new JLabel();
    ImageIcon meal4Icon = new ImageIcon("menu meal 4.png");
    JLabel meal5label = new JLabel();
    ImageIcon meal5Icon = new ImageIcon("menu meal 5.png");
    JLabel meal6label = new JLabel();
    ImageIcon meal6Icon = new ImageIcon("menu meal 6.png");
    JLabel meal7label = new JLabel();
    ImageIcon meal7Icon = new ImageIcon("menu meal 7.png");

    MealOrder(boolean manager){
        super(manager);

        mealOrderIconLabel.setBounds(0,0,650,830);
        mealOrderIconLabel.setIcon(mealOrderIcon);

        meal1label.setBounds(260,200 , 610, 145);
        meal1label.setBorder(new LineBorder(Color.white,2));
        meal1label.setOpaque(true);
        meal1label.setIcon(meal1Icon);

        meal2label.setBounds(15,355,610,145);
        meal2label.setBorder(new LineBorder(Color.white,2));
        meal2label.setOpaque(true);
        meal2label.setIcon(meal2Icon);

        meal3label.setBounds(15,510,610,145);
        meal3label.setBorder(new LineBorder(Color.white,2));
        meal3label.setOpaque(true);
        meal3label.setIcon(meal3Icon);

        meal4label.setBounds(15,665,610,145);
        meal4label.setBorder(new LineBorder(Color.white,2));
        meal4label.setOpaque(true);
        meal4label.setIcon(meal4Icon);

        meal5label.setBounds(15,820,610,145);
        meal5label.setBorder(new LineBorder(Color.white,2));
        meal5label.setOpaque(true);
        meal5label.setIcon(meal5Icon);

        meal6label.setBounds(15,975,610,145);
        meal6label.setBorder(new LineBorder(Color.white,2));
        meal6label.setOpaque(true);
        meal6label.setIcon(meal6Icon);

        meal7label.setBounds(15,1130,610,145);
        meal7label.setBorder(new LineBorder(Color.white,2));
        meal7label.setOpaque(true);
        meal7label.setIcon(meal7Icon);


        panelScroll.add(meal1label);
        panelScroll.add(meal2label);
        panelScroll.add(meal3label);
        panelScroll.add(meal4label);
        panelScroll.add(meal5label);
        panelScroll.add(meal6label);
        panelScroll.add(meal7label);


        f.add(mealOrderIconLabel);

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
        if(e.getSource()==addmealButton){
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
