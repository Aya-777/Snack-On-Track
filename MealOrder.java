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
    JLabel meal1LabelPrice = new JLabel();
    JLabel meal1LabelKalori = new JLabel();
    ImageIcon meal1Icon = new ImageIcon("menu meal 1.png");
    JLabel meal2label = new JLabel();
    JLabel meal2LabelPrice = new JLabel();
    JLabel meal2LabelKalori = new JLabel();
    ImageIcon meal2Icon = new ImageIcon("menu meal 2.png");
    JLabel meal3label = new JLabel();
    JLabel meal3LabelPrice = new JLabel();
    JLabel meal3LabelKalori = new JLabel();
    ImageIcon meal3Icon = new ImageIcon("menu meal 3.png");
    JLabel meal4label = new JLabel();
    JLabel meal4LabelPrice = new JLabel();
    JLabel meal4LabelKalori = new JLabel();
    ImageIcon meal4Icon = new ImageIcon("menu meal 4.png");
    JLabel meal5label = new JLabel();
    JLabel meal5LabelPrice = new JLabel();
    JLabel meal5LabelKalori = new JLabel();
    ImageIcon meal5Icon = new ImageIcon("menu meal 5.png");
    JLabel meal6label = new JLabel();
    JLabel meal6LabelPrice = new JLabel();
    JLabel meal6LabelKalori = new JLabel();
    ImageIcon meal6Icon = new ImageIcon("menu meal 6.png");
    JLabel meal7label = new JLabel();
    JLabel meal7LabelPrice = new JLabel();
    JLabel meal7LabelKalori = new JLabel();
    ImageIcon meal7Icon = new ImageIcon("menu meal 7.png");
    static boolean added=false;
    static JPanel panelScroll = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(panelScroll);

    MealOrder(){}
    MealOrder(boolean manager){
        super(manager);
        Order.manager=manager;

        scrollPane.setBounds(10, 190, 615, 600);
        panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
        panelScroll.setBorder(new LineBorder(Color.white, 2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mealOrderIconLabel.setBounds(0,0,650,830);
        mealOrderIconLabel.setIcon(mealOrderIcon);


        meal1label.setBorder(new LineBorder(Color.white,2));
        meal1label.setOpaque(true);
        meal1label.setIcon(meal1Icon);

        meal1LabelPrice.setBounds(188, 78, 150, 60);
        meal1LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal1LabelPrice.setForeground(new Color(139,37,17));
        meal1LabelPrice.setText(String.valueOf(AllMealsFrame.m1.getPrice())+" $");
        meal1LabelPrice.setBackground(new Color(255,134,120));
        meal1LabelPrice.setOpaque(true);
        meal1LabelKalori.setBounds(25, 78, 140, 60);
        meal1LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal1LabelKalori.setForeground(new Color(229,230,202));
        meal1LabelKalori.setText(String.valueOf(AllMealsFrame.m1.getCals())+" kcal");
        meal1LabelKalori.setBackground(new Color(255,134,120));
        meal1LabelKalori.setOpaque(true);



        meal2label.setBorder(new LineBorder(Color.white,2));
        meal2label.setOpaque(true);
        meal2label.setIcon(meal2Icon);

        meal2LabelPrice.setBounds(195, 78, 150, 60);
        meal2LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal2LabelPrice.setForeground(new Color(139,37,17));
        meal2LabelPrice.setText(String.valueOf(AllMealsFrame.m2.getPrice())+" $");
        meal2LabelPrice.setBackground(new Color(255,134,120));
        meal2LabelPrice.setOpaque(true);
        meal2LabelKalori.setBounds(25, 78, 155, 60);
        meal2LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal2LabelKalori.setForeground(new Color(229,230,202));
        meal2LabelKalori.setText(String.valueOf(AllMealsFrame.m2.getCals())+" kcal");
        meal2LabelKalori.setBackground(new Color(255,134,120));
        meal2LabelKalori.setOpaque(true);


        meal3label.setBorder(new LineBorder(Color.white,2));
        meal3label.setOpaque(true);
        meal3label.setIcon(meal3Icon);

        meal3LabelPrice.setBounds(195, 78, 120, 60);
        meal3LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal3LabelPrice.setForeground(new Color(139,37,17));
        meal3LabelPrice.setText(String.valueOf(AllMealsFrame.m3.getPrice())+" $");
        meal3LabelPrice.setBackground(new Color(255,134,120));
        meal3LabelPrice.setOpaque(true);

        meal3LabelKalori.setBounds(25, 78, 155, 60);
        meal3LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal3LabelKalori.setForeground(new Color(229,230,202));
        meal3LabelKalori.setText(String.valueOf(AllMealsFrame.m3.getCals())+" kcal");
        meal3LabelKalori.setBackground(new Color(255,134,120));
        meal3LabelKalori.setOpaque(true);



        meal4label.setBorder(new LineBorder(Color.white,2));
        meal4label.setOpaque(true);
        meal4label.setIcon(meal4Icon);

        meal4LabelPrice.setBounds(195, 78, 150, 60);
        meal4LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal4LabelPrice.setForeground(new Color(139,37,17));
        meal4LabelPrice.setText(String.valueOf(AllMealsFrame.m4.getPrice())+" $");

        meal4LabelPrice.setBackground(new Color(255,134,120));
        meal4LabelPrice.setOpaque(true);
        meal4LabelKalori.setBounds(25, 78, 155, 60);
        meal4LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal4LabelKalori.setForeground(new Color(229,230,202));
        meal4LabelKalori.setText(String.valueOf(AllMealsFrame.m4.getCals())+" kcal");
        meal4LabelKalori.setBackground(new Color(255,134,120));
        meal4LabelKalori.setOpaque(true);



        meal5label.setBorder(new LineBorder(Color.white,2));
        meal5label.setOpaque(true);
        meal5label.setIcon(meal5Icon);

        meal5LabelPrice.setBounds(188, 78, 150, 60);
        meal5LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal5LabelPrice.setForeground(new Color(139,37,17));
        meal5LabelPrice.setText(String.valueOf(AllMealsFrame.m5.getPrice())+" $");
        meal5LabelPrice.setBackground(new Color(255,134,120));
        meal5LabelPrice.setOpaque(true);
        meal5LabelKalori.setBounds(25, 78, 140, 60);
        meal5LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal5LabelKalori.setForeground(new Color(229,230,202));
        meal5LabelKalori.setText(String.valueOf(AllMealsFrame.m5.getCals())+" kcal");
        meal5LabelKalori.setBackground(new Color(255,134,120));
        meal5LabelKalori.setOpaque(true);


        meal6label.setBorder(new LineBorder(Color.white,2));
        meal6label.setOpaque(true);
        meal6label.setIcon(meal6Icon);

        meal6LabelPrice.setBounds(188, 78, 150, 60);
        meal6LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal6LabelPrice.setForeground(new Color(139,37,17));
        meal6LabelPrice.setText(String.valueOf(AllMealsFrame.m6.getPrice())+" $");
        meal6LabelPrice.setBackground(new Color(255,134,120));
        meal6LabelPrice.setOpaque(true);
        meal6LabelKalori.setBounds(25, 78, 140, 60);
        meal6LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal6LabelKalori.setForeground(new Color(229,230,202));
        meal6LabelKalori.setText(String.valueOf(AllMealsFrame.m6.getCals())+" kcal");
        meal6LabelKalori.setBackground(new Color(255,134,120));
        meal6LabelKalori.setOpaque(true);


        meal7label.setBorder(new LineBorder(Color.white,2));
        meal7label.setOpaque(true);
        meal7label.setIcon(meal7Icon);

        meal7LabelPrice.setBounds(188, 78, 150, 55);
        meal7LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal7LabelPrice.setForeground(new Color(139,37,17));
        meal7LabelPrice.setText(String.valueOf(AllMealsFrame.m7.getPrice())+" $");
        meal7LabelPrice.setBackground(new Color(255,134,120));
        meal7LabelPrice.setOpaque(true);
        meal7LabelKalori.setBounds(25, 78, 140, 60);
        meal7LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        meal7LabelKalori.setForeground(new Color(229,230,202));
        meal7LabelKalori.setText(String.valueOf(AllMealsFrame.m7.getCals())+" kcal");
        meal7LabelKalori.setBackground(new Color(255,134,120));
        meal7LabelKalori.setOpaque(true);


        meal1label.add(meal1LabelKalori);
        meal2label.add(meal2LabelKalori);
        meal3label.add(meal3LabelKalori);
        meal4label.add(meal4LabelKalori);
        meal5label.add(meal5LabelKalori);
        meal6label.add(meal6LabelKalori);
        meal7label.add(meal7LabelKalori);

        meal1label.add(meal1LabelPrice);
        meal2label.add(meal2LabelPrice);
        meal3label.add(meal3LabelPrice);
        meal4label.add(meal4LabelPrice);
        meal5label.add(meal5LabelPrice);
        meal6label.add(meal6LabelPrice);
        meal7label.add(meal7LabelPrice);

        meal1label.addMouseListener(this);
        meal2label.addMouseListener(this);
        meal3label.addMouseListener(this);
        meal4label.addMouseListener(this);
        meal5label.addMouseListener(this);
        meal6label.addMouseListener(this);
        meal7label.addMouseListener(this);

        if(!added){
            panelScroll.add(meal1label);
            panelScroll.add(meal2label);
            panelScroll.add(meal3label);
            panelScroll.add(meal4label);
            panelScroll.add(meal5label);
            panelScroll.add(meal6label);
            panelScroll.add(meal7label);
            added=true;
        }

        f.add(scrollPane);
        f.add(mealOrderIconLabel);
        f.setTitle("Meals");
        mealsitem.setEnabled(false);


    }

    @Override
     void addMeal( JLabel newmealLabel){
        newmealLabel.addMouseListener(this);
        panelScroll.add(newmealLabel);
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

        if(e.getSource() == viewdetailsbutton){
            if(num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new OrderDetails(AllMealsFrame.order);}
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
            if(AllMealsFrame.m1.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(0,manager);
            }
        }
        if(e.getSource() == meal2label){
            if(AllMealsFrame.m2.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(1,manager);
            }
        }
        if(e.getSource() == meal3label){
            if(AllMealsFrame.m3.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(2,manager);
            }
        }
        if(e.getSource() == meal4label){
            if(AllMealsFrame.m4.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(3,manager);
            }
        }
        if(e.getSource() == meal5label){
            if(AllMealsFrame.m5.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(4,manager);
            }
        }
        if(e.getSource() == meal6label){
            if(AllMealsFrame.m6.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(5,manager);
            }
        }
        if(e.getSource() == meal7label){
            if(AllMealsFrame.m7.getDeleted()){
                JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
            } else{
                new AllMealsFrame(6,manager);
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
