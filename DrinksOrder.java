import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class DrinksOrder extends Order {
    JLabel drinksOrderIconLabel = new JLabel();
    ImageIcon drinksOrderIcon = new ImageIcon("main desin drinks.png");
    JLabel mealprice;
    JLabel mealcalorie;

    DrinksOrder() {
    }

    DrinksOrder(boolean manager) {
        super(manager);
        Order.manager = manager;
        meallabels.clear();

        drinksOrderIconLabel.setBounds(0, 0, 650, 830);
        drinksOrderIconLabel.setIcon(drinksOrderIcon);

        for (int i = 16; i < 21; i++) {
            JLabel jLabel = new JLabel(String.valueOf(i));
            jLabel.setIcon(AllMealsFrame.arrayMenuMealsIcon.get(i));
            mealprice = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getPrice() + " $"));
            mealcalorie = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getCals() + " kcal ,"));

            jLabel.setBorder(new LineBorder(Color.white, 2));
            jLabel.setOpaque(true);

            mealprice.setBounds(170, 78, 150, 60);
            mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealprice.setForeground(new Color(232, 99, 73));
            mealprice.setBackground(new Color(154, 232, 231));
            mealprice.setOpaque(true);

            mealcalorie.setBounds(25, 78, 150, 60);
            mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealcalorie.setForeground(new Color(91, 74, 38));
            mealcalorie.setBackground(new Color(154, 232, 231));
            mealcalorie.setOpaque(true);

            jLabel.add(mealprice);
            jLabel.add(mealcalorie);
            jLabel.addMouseListener(this);
            panelScroll.add(jLabel);
            meallabels.add(jLabel);    

        }
        for (Meal m : AllMealsFrame.meallist) {
            if (m.getType().equals("Drink") && m.getSerialnum() >= 20) {
                JLabel jLabel = new JLabel(String.valueOf(m.getSerialnum()));
                jLabel.setIcon(AllMealsFrame.arrayMenuMealsIcon.get(21));
                mealprice = new JLabel(String.valueOf(
                        AllMealsFrame.meallist.get(m.getSerialnum()).getPrice()) + " $");
                mealcalorie = new JLabel(String.valueOf(
                        AllMealsFrame.meallist.get(m.getSerialnum()).getCals()) + " kcal");

                jLabel.setBorder(new LineBorder(Color.white, 2));
                jLabel.setOpaque(true);

                mealprice.setBounds(188, 78, 150, 60);
                mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealprice.setForeground(new Color(232, 99, 73));
                mealprice.setBackground(new Color(154, 232, 231));
                mealprice.setOpaque(true);

                mealcalorie.setBounds(25, 78, 140, 60);
                mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealcalorie.setForeground(new Color(91, 74, 38));
                mealcalorie.setBackground(new Color(154, 232, 231));
                mealcalorie.setOpaque(true);

                jLabel.add(mealprice);
                jLabel.add(mealcalorie);
                jLabel.addMouseListener(this);
                panelScroll.add(jLabel);
                meallabels.add(jLabel);    

            }
        }

        f.add(drinksOrderIconLabel);
        f.add(scrollPane);
        f.setTitle("Drinks");

        drinksitem.setEnabled(false);

    }


    @Override
    void addMeal(JLabel newmealLabel, Meal newMeal) {
        newmeals++;
        newmealLabel.addMouseListener(this);
        newmealLabel.setText(String.valueOf(newmeals));
        panelScroll.add(newmealLabel);
        Order.meallabels.add(newmealLabel);
        AllMealsFrame.order.add(0);
        AllMealsFrame.meallist.add(newMeal);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Meals.dat"))) {
            oos.writeObject(AllMealsFrame.meallist);
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        AllMealsFrame.fillLists();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mealsitem) {
            f.dispose();
            new MealOrder(manager);
        }
        if (e.getSource() == saladsitem) {
            f.dispose();
            new SaladOrder(manager);
        }
        if (e.getSource() == drinksitem) {
            JOptionPane.showMessageDialog(null, "You are already on drink's order page.",
                    "Title", JOptionPane.WARNING_MESSAGE);
        }
        if (e.getSource() == dessertsitem) {
            f.dispose();
            new DessertOrder(manager);
        }
        if (e.getSource() == viewdetailsbutton) {
            if (Order.num == 0) {
                JOptionPane.showMessageDialog(null, "You have to select meals to buy.", "Title",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                new OrderDetails(AllMealsFrame.order);
            }
        }
        if (e.getSource() == logoutitem) {
            super.actionPerformed(e);
        }
        if (e.getSource() == addmealitem) {
            super.actionPerformed(e);
        }

        if (e.getSource() == addmealitem) {
            super.actionPerformed(e);
        }
        if (e.getSource() == manageritem) {
            super.actionPerformed(e);
        }
        if (e.getSource() == recommendationsitem) {
            super.actionPerformed(e);
        }
        if(e.getSource() == myordersitem){
            super.actionPerformed(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
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
