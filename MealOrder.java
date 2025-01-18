import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MealOrder extends Order {
    JLabel mealOrderIconLabel = new JLabel();
    ImageIcon mealOrderIcon = new ImageIcon("main design meal.png");
    static int index = 0;

    JLabel mealprice;
    JLabel mealcalorie;
    ImageIcon newmealmenuicon = new ImageIcon("add meal.png");
    JLabel newmealNameLabel;

    MealOrder() {}

    MealOrder(boolean manager) {
        super(manager);
        Order.manager = manager;
        index = 0;
        meallabels.clear();

        mealOrderIconLabel.setBounds(0, 0, 650, 830);
        mealOrderIconLabel.setIcon(mealOrderIcon);

        for (int i = 0 ; i < 7 ; i++) {
            JLabel jLabel = new JLabel(String.valueOf(i));
            jLabel.setIcon(AllMealsFrame.arrayMenuMealsIcon.get(i));
            mealprice = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getPrice())+ " $");
            mealcalorie = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getCals())+ " kcal ,");

            jLabel.setBorder(new LineBorder(Color.white, 2));
            jLabel.setOpaque(true);

            mealprice.setBounds(175 , 78, 150, 60);
            mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealprice.setForeground(new Color(139, 37, 17));
            mealprice.setBackground(new Color(255, 134, 120));
            mealprice.setOpaque(true);

            mealcalorie.setBounds(25, 78, 150, 60);
            mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealcalorie.setForeground(new Color(229, 230, 202));
            mealcalorie.setBackground(new Color(255, 134, 120));
            mealcalorie.setOpaque(true);
            index++;

            meallabels.add(jLabel);    
            jLabel.add(mealprice);
            jLabel.add(mealcalorie);
            jLabel.addMouseListener(this);
            panelScroll.add(jLabel);
        }
        for (Meal m : AllMealsFrame.meallist) {
            if (m.getType().equals("Meal") && m.getSerialnum() >= 20) {
                JLabel jLabel = new JLabel(String.valueOf(m.getSerialnum()));
                jLabel.setIcon(newmealmenuicon);

                newmealNameLabel=new JLabel((AllMealsFrame.meallist.get(m.getSerialnum()).getName()));
                mealprice = new JLabel(String.valueOf(
                    AllMealsFrame.meallist.get(m.getSerialnum()).getPrice()) + " $");
                mealcalorie = new JLabel(String.valueOf(
                    AllMealsFrame.meallist.get(m.getSerialnum()).getCals()) + " kcal");

                jLabel.setBorder(new LineBorder(Color.white, 2));
                jLabel.setOpaque(true);

                newmealNameLabel.setBounds(20,30,400,50);
                newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 40));
                newmealNameLabel.setBackground( Color.white);

                mealprice.setBounds(188, 78, 150, 60);
                mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealprice.setForeground(new Color(139, 37, 17));
                mealprice.setBackground(new Color(255, 134, 120));
                mealprice.setOpaque(true);

                mealcalorie.setBounds(25, 78, 140, 60);
                mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealcalorie.setForeground(new Color(229, 230, 202));
                mealcalorie.setBackground(new Color(255, 134, 120));
                mealcalorie.setOpaque(true);

                jLabel.add(newmealNameLabel);
                jLabel.add(mealprice);
                jLabel.add(mealcalorie);
                jLabel.addMouseListener(this);
                panelScroll.add(jLabel);
                meallabels.add(jLabel);

            }
        }

        f.add(mealOrderIconLabel);
        f.add(scrollPane);
        f.setTitle("Meals");
        mealsitem.setEnabled(false);

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
            JOptionPane.showMessageDialog(null, "You are already on meal's order page.",
                    "Title", JOptionPane.WARNING_MESSAGE);
        }
        if (e.getSource() == saladsitem) {
            f.dispose();
            new SaladOrder(manager);
        }
        if (e.getSource() == dessertsitem) {
            f.dispose();
            new DessertOrder(manager);
        }
        if (e.getSource() == drinksitem) {
            f.dispose();
            new DrinksOrder(manager);
        }

        if (e.getSource() == viewdetailsbutton) {
            if (num == 0) {
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
