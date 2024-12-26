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
    JLabel salad1LabelPrice = new JLabel();
    JLabel salad1LabelKalori = new JLabel();
    ImageIcon salad1Icon = new ImageIcon("menu salad 1.png");
    JLabel salad2label = new JLabel();
    JLabel salad2LabelPrice = new JLabel();
    JLabel salad2LabelKalori = new JLabel();
    ImageIcon salad2Icon = new ImageIcon("menu salad 2.png");
    JLabel salad3label = new JLabel();
    JLabel salad3LabelPrice = new JLabel();
    JLabel salad3LabelKalori = new JLabel();
    ImageIcon salad3Icon = new ImageIcon("menu salad 3.png");
    JLabel salad4label = new JLabel();
    JLabel salad4LabelPrice = new JLabel();
    JLabel salad4LabelKalori = new JLabel();
    ImageIcon salad4Icon = new ImageIcon("menu salad 4.png");
    boolean manager;
    static int num1=0,num2=0,num3=0,num4=0;

    SaladOrder(boolean manager){
        super(manager);
        this.manager=manager;
        saladOrderIconLabel.setBounds(0,0,650,830);
        saladOrderIconLabel.setIcon(saladOrderIcon);

        salad1label.setBounds(260,200 , 610, 145);
        salad1label.setBorder(new LineBorder(Color.white,2));
        salad1label.setOpaque(true);
        salad1label.setIcon(salad1Icon);

        salad1LabelPrice.setBounds(195, 75, 150, 60);
        salad1LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad1LabelPrice.setForeground(new Color(232,99,73));
        salad1LabelPrice.setText("8 $");
        salad1LabelPrice.setBackground(new Color(166,251,186));
        salad1LabelPrice.setOpaque(true);
        salad1LabelKalori.setBounds(23, 75, 150, 60);
        salad1LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad1LabelKalori.setForeground(new Color(91,74,38));
        salad1LabelKalori.setText("160 kcal");
        salad1LabelKalori.setBackground(new Color(166,251,186));
        salad1LabelKalori.setOpaque(true);

        salad2label.setBounds(15,355, 610, 145);
        salad2label.setBorder(new LineBorder(Color.white,2));
        salad2label.setOpaque(true);
        salad2label.setIcon(salad2Icon);

        salad2LabelPrice.setBounds(195, 75, 150, 60);
        salad2LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad2LabelPrice.setForeground(new Color(232,99,73));
        salad2LabelPrice.setText("8 $");
        salad2LabelPrice.setBackground(new Color(166,251,186));
        salad2LabelPrice.setOpaque(true);
        salad2LabelKalori.setBounds(23, 75, 150, 60);
        salad2LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad2LabelKalori.setForeground(new Color(91,74,38));
        salad2LabelKalori.setText("275 kcal");
        salad2LabelKalori.setBackground(new Color(166,251,186));
        salad2LabelKalori.setOpaque(true);


        salad3label.setBounds(15,510 , 610, 145);
        salad3label.setBorder(new LineBorder(Color.white,2));
        salad3label.setOpaque(true);
        salad3label.setIcon(salad3Icon);

        salad3LabelPrice.setBounds(195, 75, 150, 60);
        salad3LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad3LabelPrice.setForeground(new Color(232,99,73));
        salad3LabelPrice.setText("12 $");
        salad3LabelPrice.setBackground(new Color(166,251,186));
        salad3LabelPrice.setOpaque(true);
        salad3LabelKalori.setBounds(23, 75, 150, 60);
        salad3LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad3LabelKalori.setForeground(new Color(91,74,38));
        salad3LabelKalori.setText("490 kcal");
        salad3LabelKalori.setBackground(new Color(166,251,186));
        salad3LabelKalori.setOpaque(true);

        salad4label.setBounds(15,665 , 610, 145);
        salad4label.setBorder(new LineBorder(Color.white,2));
        salad4label.setOpaque(true);
        salad4label.setIcon(salad4Icon);

        salad4LabelPrice.setBounds(195, 75, 150, 60);
        salad4LabelPrice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad4LabelPrice.setForeground(new Color(232,99,73));
        salad4LabelPrice.setText("16 $");
        salad4LabelPrice.setBackground(new Color(166,251,186));
        salad4LabelPrice.setOpaque(true);
        salad4LabelKalori.setBounds(23, 75, 150, 60);
        salad4LabelKalori.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,32));
        salad4LabelKalori.setForeground(new Color(91,74,38));
        salad4LabelKalori.setText("490 kcal");
        salad4LabelKalori.setBackground(new Color(166,251,186));
        salad4LabelKalori.setOpaque(true);


        salad1label.add(salad1LabelPrice);
        salad2label.add(salad2LabelPrice);
        salad3label.add(salad3LabelPrice);
        salad4label.add(salad4LabelPrice);

        salad1label.add(salad1LabelKalori);
        salad2label.add(salad2LabelKalori);
        salad3label.add(salad3LabelKalori);
        salad4label.add(salad4LabelKalori);


        panelScroll.add(salad1label);
        panelScroll.add(salad2label);
        panelScroll.add(salad3label);
        panelScroll.add(salad4label);

        salad1label.addMouseListener(this);
        salad2label.addMouseListener(this);
        salad3label.addMouseListener(this);
        salad4label.addMouseListener(this);

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
