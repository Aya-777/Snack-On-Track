import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaladOrder extends Order {
    JLabel saladOrderIconLabel = new JLabel();
    ImageIcon saladOrderIcon = new ImageIcon("main design salad.png");
    JLabel mealprice;
    JLabel mealcalorie;
    ImageIcon newSaladMenuIcon = new ImageIcon("add salad.png");
    JLabel newmealNameLabel;

    SaladOrder() {
    }

    SaladOrder(boolean manager) {
        super(manager);
        Order.manager = manager;
        meallabels.clear();

        saladOrderIconLabel.setBounds(0, 0, 650, 830);
        saladOrderIconLabel.setIcon(saladOrderIcon);

        for (int i = 7; i < 11; i++) {
            JLabel jLabel = new JLabel(String.valueOf(i));
            jLabel.setIcon(AllMealsFrame.arrayMenuMealsIcon.get(i));
            mealprice = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getPrice()) + " $");
            mealcalorie = new JLabel(String.valueOf(AllMealsFrame.meallist.get(i).getCals()) + " kcal , ");

            jLabel.setBorder(new LineBorder(Color.white, 2));
            jLabel.setOpaque(true);




            mealprice.setBounds(180, 78, 150, 60);
            mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealprice.setForeground(new Color(232, 99, 73));
            mealprice.setBackground(new Color(166, 251, 186));
            mealprice.setOpaque(true);

            mealcalorie.setBounds(25, 78, 160, 60);
            mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
            mealcalorie.setForeground(new Color(91, 74, 38));
            mealcalorie.setBackground(new Color(166, 251, 186));
            mealcalorie.setOpaque(true);


            jLabel.add(mealprice);
            jLabel.add(mealcalorie);
            jLabel.addMouseListener(this);
            panelScroll.add(jLabel);
            meallabels.add(jLabel);

        }
        for (Meal m : AllMealsFrame.meallist) {
            if (m.getType().equals("Salad") && m.getSerialnum() >= 20) {
                JLabel jLabel = new JLabel(String.valueOf(m.getSerialnum()));
                jLabel.setIcon(newSaladMenuIcon);
                newmealNameLabel=new JLabel((AllMealsFrame.meallist.get(m.getSerialnum()).getName()));
                mealprice = new JLabel(String.valueOf(
                        AllMealsFrame.meallist.get(m.getSerialnum()).getPrice()) + " $");
                mealcalorie = new JLabel(String.valueOf(
                        AllMealsFrame.meallist.get(m.getSerialnum()).getCals()) + " kcal");

                jLabel.setBorder(new LineBorder(Color.white, 2));
                jLabel.setOpaque(true);

                newmealNameLabel.setBounds(20,30,400,50);
                newmealNameLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 40));
                newmealNameLabel.setForeground(new Color(91,74,38));

                mealprice.setBounds(188, 78, 150, 60);
                mealprice.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealprice.setForeground(new Color(232, 99, 73));
                mealprice.setBackground(new Color(166, 251, 186));
                mealprice.setOpaque(true);

                mealcalorie.setBounds(25, 78, 140, 60);
                mealcalorie.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
                mealcalorie.setForeground(new Color(91, 74, 38));
                mealcalorie.setBackground(new Color(166, 251, 186));
                mealcalorie.setOpaque(true);

                jLabel.add(newmealNameLabel);
                jLabel.add(mealprice);
                jLabel.add(mealcalorie);
                jLabel.addMouseListener(this);
                panelScroll.add(jLabel);
                meallabels.add(jLabel);

            }
        }

        f.add(saladOrderIconLabel);
        f.add(scrollPane);
        f.setTitle("Salads");

        saladsitem.setEnabled(false);
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
            JOptionPane.showMessageDialog(null, "You are already on salad's order page.",
                    "Title", JOptionPane.WARNING_MESSAGE);
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
