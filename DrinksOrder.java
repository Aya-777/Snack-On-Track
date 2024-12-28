import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class DrinksOrder extends Order implements MouseListener{
    JLabel drinksOrderIconLabel = new JLabel();
    ImageIcon drinksOrderIcon = new ImageIcon("main desin drinks.png");


    JLabel drink1label = new JLabel();
    JLabel drink1labelPrice = new JLabel();
    JLabel drink1labelKalori = new JLabel();
    ImageIcon drinksIcon1 = new ImageIcon("menu drinks 1.png");
    JLabel drink2label = new JLabel();
    JLabel drink2labelPrice = new JLabel();
    JLabel drink2labelKalori = new JLabel();
    ImageIcon drinksIcon2 = new ImageIcon("menu drinks 2.png");
    JLabel drink3label = new JLabel();
    JLabel drink3labelPrice = new JLabel();
    JLabel drink3labelKalori = new JLabel();
    ImageIcon drinksIcon3 = new ImageIcon("menu drinks 3.png");
    JLabel drink4label = new JLabel();
    JLabel drink4labelPrice = new JLabel();
    JLabel drink4labelKalori = new JLabel();
    ImageIcon drinksIcon4 = new ImageIcon("menu drinks 4.png");
    JLabel drink5label = new JLabel();
    JLabel drink5labelPrice = new JLabel();
    JLabel drink5labelKalori = new JLabel();
    ImageIcon drinksIcon5 = new ImageIcon("menu drinks 5.png");
    static int num1=0,num2=0,num3=0,num4=0,num5=0,yNewMealLabel=975;
    boolean manager;
    
        DrinksOrder(){}
        DrinksOrder(boolean manager){
            super(manager);
            this.manager=manager;
            drinksOrderIconLabel.setBounds(0,0,650,830);
            drinksOrderIconLabel.setIcon(drinksOrderIcon);
    
            drink1label.setBounds(260,200 , 610, 145);
            drink1label.setBorder(new LineBorder(Color.white,2));
            drink1label.setOpaque(true);
            drink1label.setIcon(drinksIcon1);
    
            drink1labelPrice.setBounds(160, 75, 150, 60);
            drink1labelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink1labelPrice.setForeground(new Color(232,99,73));
            drink1labelPrice.setText(MealFrame.drink1.getPrice()+" $");
            drink1labelPrice.setBackground(new Color(154,232,231));
            drink1labelPrice.setOpaque(true);
            drink1labelKalori.setBounds(25, 75, 110, 60);
            drink1labelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink1labelKalori.setForeground(new Color(91,74,38));
            drink1labelKalori.setText(MealFrame.drink1.getCals()+" kcal");
            drink1labelKalori.setBackground(new Color(154,232,231));
            drink1labelKalori.setOpaque(true);
    
            drink2label.setBounds(15,355 , 610, 145);
            drink2label.setBorder(new LineBorder(Color.white,2));
            drink2label.setOpaque(true);
            drink2label.setIcon(drinksIcon2);
    
            drink2labelPrice.setBounds(205, 75, 150, 60);
            drink2labelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink2labelPrice.setForeground(new Color(232,99,73));
            drink2labelPrice.setText(MealFrame.drink2.getPrice()+" $");
            drink2labelPrice.setBackground(new Color(154,232,231));
            drink2labelPrice.setOpaque(true);
            drink2labelKalori.setBounds(25, 75, 160, 60);
            drink2labelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink2labelKalori.setForeground(new Color(91,74,38));
            drink2labelKalori.setText(MealFrame.drink2.getCals()+" kcal");
            drink2labelKalori.setBackground(new Color(154,232,231));
            drink2labelKalori.setOpaque(true);
    
    
            drink3label.setBounds(15,510 , 610, 145);
            drink3label.setBorder(new LineBorder(Color.white,2));
            drink3label.setOpaque(true);
            drink3label.setIcon(drinksIcon3);
    
            drink3labelPrice.setBounds(203, 75, 150, 60);
            drink3labelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink3labelPrice.setForeground(new Color(232,99,73));
            drink3labelPrice.setText(MealFrame.drink3.getPrice()+" $");
            drink3labelPrice.setBackground(new Color(154,232,231));
            drink3labelPrice.setOpaque(true);
            drink3labelKalori.setBounds(25, 75, 160, 60);
            drink3labelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink3labelKalori.setForeground(new Color(91,74,38));
            drink3labelKalori.setText(MealFrame.drink3.getCals()+" kcal");
            drink3labelKalori.setBackground(new Color(154,232,231));
            drink3labelKalori.setOpaque(true);
    
            drink4label.setBounds(15,665, 610, 145);
            drink4label.setBorder(new LineBorder(Color.white,2));
            drink4label.setOpaque(true);
            drink4label.setIcon(drinksIcon4);
    
            drink4labelPrice.setBounds(205, 75, 150, 60);
            drink4labelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink4labelPrice.setForeground(new Color(232,99,73));
            drink4labelPrice.setText(MealFrame.drink4.getPrice()+" $");
            drink4labelPrice.setBackground(new Color(154,232,231));
            drink4labelPrice.setOpaque(true);
            drink4labelKalori.setBounds(25, 75, 160, 60);
            drink4labelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink4labelKalori.setForeground(new Color(91,74,38));
            drink4labelKalori.setText(MealFrame.drink4.getCals()+" kcal");
            drink4labelKalori.setBackground(new Color(154,232,231));
            drink4labelKalori.setOpaque(true);
    
    
            drink5label.setBounds(15,820, 610, 145);
            drink5label.setBorder(new LineBorder(Color.white,2));
            drink5label.setOpaque(true);
            drink5label.setIcon(drinksIcon5);
    
            drink5labelPrice.setBounds(205, 75, 150, 60);
            drink5labelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink5labelPrice.setForeground(new Color(232,99,73));
            drink5labelPrice.setText(MealFrame.drink5.getPrice()+" $");
            drink5labelPrice.setBackground(new Color(154,232,231));
            drink5labelPrice.setOpaque(true);
            drink5labelKalori.setBounds(25, 75, 160, 60);
            drink5labelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
            drink5labelKalori.setForeground(new Color(91,74,38));
            drink5labelKalori.setText(MealFrame.drink5.getCals()+" kcal");
            drink5labelKalori.setBackground(new Color(154,232,231));
            drink5labelKalori.setOpaque(true);
    
            drink1label.add(drink1labelPrice);
            drink2label.add(drink2labelPrice);
            drink3label.add(drink3labelPrice);
            drink4label.add(drink4labelPrice);
            drink5label.add(drink5labelPrice);
    
            drink1label.add(drink1labelKalori);
            drink2label.add(drink2labelKalori);
            drink3label.add(drink3labelKalori);
            drink4label.add(drink4labelKalori);
            drink5label.add(drink5labelKalori);
    
    
            panelScroll.add(drink1label);
            panelScroll.add(drink2label);
            panelScroll.add(drink3label);
            panelScroll.add(drink4label);
            panelScroll.add(drink5label);
    
            drink1label.addMouseListener(this);
            drink2label.addMouseListener(this);
            drink3label.addMouseListener(this);
            drink4label.addMouseListener(this);
            drink5label.addMouseListener(this);
    
            f.add(drinksOrderIconLabel);
    
            drinksitem.setEnabled(false);
    
    
        }
        @Override 
        void addMeal(JLabel newmealLabel){
            newmealLabel.setBounds(15, yNewMealLabel, 610, 145);
        yNewMealLabel+=155;
        f.add(newmealLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem){
            f.dispose();
            new MealOrder(manager);
        }
        if(e.getSource() == saladsitem){
            f.dispose();
            new SaladOrder(manager);
        }
        if(e.getSource()==drinksitem){
            JOptionPane.showMessageDialog(null,"You are already on drink's order page.",
            "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == dessertsitem){
            f.dispose();
            new DessertOrder(manager);
        }
        if(e.getSource() == viewdetailsbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new OrderDetails(MealFrame.order);
            }
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
        if(e.getSource() == drink1label){
            if(MealFrame.drink1.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(17,manager);
            }
        }
        if(e.getSource() == drink2label){
            if(MealFrame.drink2.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(18,manager);
            }
        }
        if(e.getSource() == drink3label){
            if(MealFrame.drink3.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(19,manager);
            }
        }
        if(e.getSource() == drink4label){
            if(MealFrame.drink4.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(20,manager);
            }
        }
        if(e.getSource() == drink5label){
            if(MealFrame.drink5.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new MealFrame(21,manager);
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
