import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Order implements ActionListener {

   
    static int num=0,price=0;
    JFrame f = new JFrame();
    static JLabel mealnumlabel = new JLabel(String.valueOf(num));
    JLabel pricelabel = new JLabel("Price : ");
    static JLabel pricenumlabel = new JLabel(String.valueOf(price));
    JButton viewcartbutton = new JButton("View cart");
    JButton logoutButton = new JButton("Log out");
    JButton addmealButton = new JButton("Add Meal");

    JLabel mealslabel = new JLabel("Meals :");
    
    JMenuBar mealsbar = new JMenuBar();
    JMenuItem mealsitem = new JMenuItem("Meals");
    JMenuItem saladsitem = new JMenuItem("Salads");
    JMenuItem dessertsitem = new JMenuItem("Desserts");
    JMenuItem drinksitem = new JMenuItem("Drinks");
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);
    static boolean manager;

    Order(boolean manager){
        f.setLayout(null);

        this.manager=manager;
        if (manager) {
            f.add(addmealButton);
        }

        mealsbar.add(mealsitem);
        mealsbar.add(saladsitem);
        mealsbar.add(dessertsitem);
        mealsbar.add(drinksitem);

        viewcartbutton.setBounds(260,115 , 130, 30);
        viewcartbutton.setFocusable(false);
        mealslabel.setBounds(275, 40, 100, 20);
        mealslabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,20));
        mealnumlabel.setBounds(360, 40, 50, 20);
        mealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN ,20));
        pricelabel.setBounds(275, 75, 100, 20);
        pricelabel.setFont(new Font("Franklin Gothic Demi",Font.PLAIN,20));
        pricenumlabel.setBounds(360, 75, 50, 20);
        pricenumlabel.setFont(new Font("Franklin Gothic Demi",Font.PLAIN,20));
        mealsbar.setBounds(0, 160, 665, 25);
        mealsbar.setFont(new Font("Franklin Gothic Demi",Font.PLAIN,200));
        scrollPane.setBounds(10,190,615,600);
        panelScroll.setLayout(new BoxLayout(panelScroll,BoxLayout.Y_AXIS));
        panelScroll.setBorder(new LineBorder(Color.white,2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        logoutButton.setBounds(400, 115, 130, 30);;
        logoutButton.setFocusable(false);

        f.add(viewcartbutton);
        f.add(mealnumlabel);
        f.add(mealslabel);
        f.add(pricelabel);
        f.add(pricenumlabel);
        f.add(mealsbar);
        f.add(logoutButton);
        f.add(scrollPane);

        viewcartbutton.addActionListener(this);
        mealsitem.addActionListener(this);
        saladsitem.addActionListener(this);
        dessertsitem.addActionListener(this);
        drinksitem.addActionListener(this);
        logoutButton.addActionListener(this);

        f.setResizable(false);
        f.setSize(650,830);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logoutButton){
            f.dispose();
            price=0;
            num=0;
            mealnumlabel.setText(String.valueOf(num));
            pricenumlabel.setText(String.valueOf(price));
            MealFrame.meallist.clear();
            MealFrame.fillLists();
            new SignFrame();
        }
        if(e.getSource()==addmealButton){
            new AddMeal();
        }

    }
}
