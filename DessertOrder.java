import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DessertOrder extends Order implements MouseListener{

    JLabel dessertOrderIconLabel = new JLabel();
    ImageIcon dessertOrderIcon =new ImageIcon("main design sweets.png");
    JLabel dessert1label = new JLabel("11");
    JLabel dessert1LabelPrice = new JLabel();
    JLabel dessert1LabelKalori = new JLabel();
    ImageIcon dessert1Icon = new ImageIcon("menu sweets 1.png");
    JLabel dessert2label = new JLabel("12");
    JLabel dessert2LabelPrice = new JLabel();
    JLabel dessert2LabelKalori = new JLabel();
    ImageIcon dessert2Icon = new ImageIcon("menu sweets 2.png");
    JLabel dessert3label = new JLabel("13");
    JLabel dessert3LabelPrice = new JLabel();
    JLabel dessert3LabelKalori = new JLabel();
    ImageIcon dessert3Icon = new ImageIcon("menu sweets 3.png");
    JLabel dessert4label = new JLabel("14");
    JLabel dessert4LabelPrice = new JLabel();
    JLabel dessert4LabelKalori = new JLabel();
    ImageIcon dessert4Icon = new ImageIcon("menu sweets 4.png");
    JLabel dessert5label = new JLabel("15");
    JLabel dessert5LabelPrice = new JLabel();
    JLabel dessert5LabelKalori = new JLabel();
    ImageIcon dessert5Icon = new ImageIcon("menu sweets 5.png");
    static int num1=0,num2=0,num3=0 ,num4=0,num5=0;
    static ArrayList<JLabel>newmeallabels=new ArrayList<>();


    DessertOrder(boolean manager){
        super(manager);
        Order.manager=manager;

        dessertOrderIconLabel.setBounds(0,0,650,830);
        dessertOrderIconLabel.setIcon(dessertOrderIcon);


        dessert1label.setBounds(260,200,610,145);
        dessert1label.setBorder(new LineBorder(Color.white,2));
        dessert1label.setOpaque(true);
        dessert1label.setIcon(dessert1Icon);

        dessert1LabelPrice.setBounds(205, 75, 150, 60);
        dessert1LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert1LabelPrice.setForeground(new Color(232,99,73));
        dessert1LabelPrice.setText(AllMealsFrame.dessert1.getPrice()+" $");
        dessert1LabelPrice.setBackground(new Color(232,195,150));
        dessert1LabelPrice.setOpaque(true);
        dessert1LabelKalori.setBounds(23, 78, 160, 60);
        dessert1LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert1LabelKalori.setForeground(new Color(91,74,38));
        dessert1LabelKalori.setText(AllMealsFrame.dessert1.getCals()+" kcal");
        dessert1LabelKalori.setBackground(new Color(232,195,150));
        dessert1LabelKalori.setOpaque(true);


        dessert2label.setBounds(15,355,610,145);
        dessert2label.setBorder(new LineBorder(Color.white,2));
        dessert2label.setOpaque(true);
        dessert2label.setIcon(dessert2Icon);

        dessert2LabelPrice.setBounds(205, 75, 150, 60);
        dessert2LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert2LabelPrice.setForeground(new Color(232,99,73));
        dessert2LabelPrice.setText(AllMealsFrame.dessert2.getPrice()+" $");
        dessert2LabelPrice.setBackground(new Color(232,195,150));
        dessert2LabelPrice.setOpaque(true);
        dessert2LabelKalori.setBounds(23, 78, 160, 60);
        dessert2LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert2LabelKalori.setForeground(new Color(91,74,38));
        dessert2LabelKalori.setText(AllMealsFrame.dessert2.getCals()+" kcal");
        dessert2LabelKalori.setBackground(new Color(232,195,150));
        dessert2LabelKalori.setOpaque(true);

        dessert3label.setBounds(15,510,610,145);
        dessert3label.setBorder(new LineBorder(Color.white,2));
        dessert3label.setOpaque(true);
        dessert3label.setIcon(dessert3Icon);

        dessert3LabelPrice.setBounds(205, 78, 150, 60);
        dessert3LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert3LabelPrice.setForeground(new Color(232,99,73));
        dessert3LabelPrice.setText(AllMealsFrame.dessert3.getPrice()+" $");
        dessert3LabelPrice.setBackground(new Color(232,195,150));
        dessert3LabelPrice.setOpaque(true);
        dessert3LabelKalori.setBounds(23, 78, 160, 60);
        dessert3LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert3LabelKalori.setForeground(new Color(91,74,38));
        dessert3LabelKalori.setText(AllMealsFrame.dessert3.getCals()+" kcal");
        dessert3LabelKalori.setBackground(new Color(232,195,150));
        dessert3LabelKalori.setOpaque(true);

        dessert4label.setBounds(15,665,610,145);
        dessert4label.setBorder(new LineBorder(Color.white,2));
        dessert4label.setOpaque(true);
        dessert4label.setIcon(dessert4Icon);

        dessert4LabelPrice.setBounds(205, 80, 150, 60);
        dessert4LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert4LabelPrice.setForeground(new Color(232,99,73));
        dessert4LabelPrice.setText(AllMealsFrame.dessert4.getPrice()+" $");
        dessert4LabelPrice.setBackground(new Color(232,195,150));
        dessert4LabelPrice.setOpaque(true);
        dessert4LabelKalori.setBounds(23, 78, 160, 60);
        dessert4LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert4LabelKalori.setForeground(new Color(91,74,38));
        dessert4LabelKalori.setText(AllMealsFrame.dessert4.getCals()+" kcal");
        dessert4LabelKalori.setBackground(new Color(232,195,150));
        dessert4LabelKalori.setOpaque(true);

        dessert5label.setBounds(15,820,610,145);
        dessert5label.setBorder(new LineBorder(Color.white,2));
        dessert5label.setOpaque(true);
        dessert5label.setIcon(dessert5Icon);

        dessert5LabelPrice.setBounds(195, 80, 150, 60);
        dessert5LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert5LabelPrice.setForeground(new Color(232,99,73));
        dessert5LabelPrice.setText(AllMealsFrame.dessert5.getPrice()+" $");
        dessert5LabelPrice.setBackground(new Color(232,195,150));
        dessert5LabelPrice.setOpaque(true);
        dessert5LabelKalori.setBounds(23, 78, 155, 60);
        dessert5LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        dessert5LabelKalori.setForeground(new Color(91,74,38));
        dessert5LabelKalori.setText(AllMealsFrame.dessert5.getCals()+" kcal");
        dessert5LabelKalori.setBackground(new Color(232,195,150));
        dessert5LabelKalori.setOpaque(true);

        dessert1label.add(dessert1LabelPrice);
        dessert2label.add(dessert2LabelPrice);
        dessert3label.add(dessert3LabelPrice);
        dessert4label.add(dessert4LabelPrice);
        dessert5label.add(dessert5LabelPrice);

        dessert1label.add(dessert1LabelKalori);
        dessert2label.add(dessert2LabelKalori);
        dessert3label.add(dessert3LabelKalori);
        dessert4label.add(dessert4LabelKalori);
        dessert5label.add(dessert5LabelKalori);


        panelScroll.add(dessert1label);
        panelScroll.add(dessert2label);
        panelScroll.add(dessert3label);
        panelScroll.add(dessert4label);
        panelScroll.add(dessert5label);
        for (JLabel jLabel : newmeallabels) {
            panelScroll.add(jLabel);
        }

        dessert1label.addMouseListener(this);
        dessert2label.addMouseListener(this);
        dessert3label.addMouseListener(this);
        dessert4label.addMouseListener(this);
        dessert5label.addMouseListener(this);

        f.add(dessertOrderIconLabel);
        f.add(scrollPane);
        f.setTitle("Desserts");

        dessertsitem.setEnabled(false);
    }
    public DessertOrder(){}


    void fillmeallabellist(){
        Order.meallabels.add(dessert1label);
        Order.meallabels.add(dessert2label);
        Order.meallabels.add(dessert3label);
        Order.meallabels.add(dessert4label);
        Order.meallabels.add(dessert5label);

    }
    @Override
    void addMeal(JLabel newmealLabel){
        newmeals++;
        newmealLabel.addMouseListener(this);
        newmealLabel.setText(String.valueOf(newmeals));
        panelScroll.add(newmealLabel);
        newmeallabels.add(newmealLabel);
        Order.meallabels.add(newmealLabel);
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
        if(e.getSource() == viewdetailsbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new OrderDetails(AllMealsFrame.order);
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
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
