import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DessertOrder extends Order implements MouseListener{

    JLabel dessertOrderIconLabel = new JLabel();
    ImageIcon dessertOrderIcon =new ImageIcon("main design sweets.png");
    JLabel dessert1label = new JLabel();
    ImageIcon dessert1Icon = new ImageIcon("menu sweets 1.png");
    JLabel dessert2label = new JLabel();
    ImageIcon dessert2Icon = new ImageIcon("menu sweets 2.png");
    JLabel dessert3label = new JLabel();
    ImageIcon dessert3Icon = new ImageIcon("menu sweets 3.png");
    JLabel dessert4label = new JLabel();
    ImageIcon dessert4Icon = new ImageIcon("menu sweets 4.png");
    JLabel dessert5label = new JLabel();
    ImageIcon dessert5Icon = new ImageIcon("menu sweets 5.png");

    boolean manager;

    static int num1=0,num2=0,num3=0 ,num4=0,num5=0;

    DessertOrder(boolean manager){
        super(manager);
        this.manager=manager;
        dessertOrderIconLabel.setBounds(0,0,650,830);
        dessertOrderIconLabel.setIcon(dessertOrderIcon);

        dessert1label.setBounds(260,200,610,145);
        dessert1label.setBorder(new LineBorder(Color.white,2));
        dessert1label.setOpaque(true);
        dessert1label.setIcon(dessert1Icon);

        dessert2label.setBounds(15,355,610,145);
        dessert2label.setBorder(new LineBorder(Color.white,2));
        dessert2label.setOpaque(true);
        dessert2label.setIcon(dessert2Icon);

        dessert3label.setBounds(15,510,610,145);
        dessert3label.setBorder(new LineBorder(Color.white,2));
        dessert3label.setOpaque(true);
        dessert3label.setIcon(dessert3Icon);

        dessert4label.setBounds(15,665,610,145);
        dessert4label.setBorder(new LineBorder(Color.white,2));
        dessert4label.setOpaque(true);
        dessert4label.setIcon(dessert4Icon);

        dessert5label.setBounds(15,820,610,145);
        dessert5label.setBorder(new LineBorder(Color.white,2));
        dessert5label.setOpaque(true);
        dessert5label.setIcon(dessert5Icon);


        panelScroll.add(dessert1label);
        panelScroll.add(dessert2label);
        panelScroll.add(dessert3label);
        panelScroll.add(dessert4label);
        panelScroll.add(dessert5label);
        dessert1label.addMouseListener(this);
        dessert2label.addMouseListener(this);
        dessert3label.addMouseListener(this);
        dessert4label.addMouseListener(this);
        dessert5label.addMouseListener(this);

         f.add(dessertOrderIconLabel);

        dessertsitem.setEnabled(false);
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
            f.dispose();
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
        if(e.getSource()==logoutButton){
            super.actionPerformed(e);
        }
        if(e.getSource()==addmealButton){
            super.actionPerformed(e);
        }
        if(e.getSource()==myordersButton){
            super.actionPerformed(e);
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
