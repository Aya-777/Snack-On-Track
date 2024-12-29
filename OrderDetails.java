import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class OrderDetails implements ActionListener{

    JFrame f = new JFrame("Cart");
    JButton confirmButton = new JButton("Confirm");
    JLabel mealslabel = new JLabel("Meals :");
    static JLabel mealnumlabel = new JLabel(String.valueOf(Order.num));
    JLabel pricelabel = new JLabel("Price : ");
    static JLabel pricenumlabel = new JLabel(String.valueOf(Order.price));
    ArrayList<Integer> meals = new ArrayList<>();
    static int gap=150;
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);

    OrderDetails(ArrayList<Integer> meals){
        f.setLayout(null);
        this.meals=meals;

        scrollPane.setBounds(5, 0, 465, 400);
        panelScroll.setLayout(null);
        panelScroll.setPreferredSize(new Dimension(465,400));
        panelScroll.setBorder(new LineBorder(Color.white, 2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mealslabel.setBounds(275, 40, 100, 20);
        mealslabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnumlabel.setBounds(360, 40, 50, 20);
        mealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricelabel.setBounds(275, 75, 100, 20);
        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricenumlabel.setBounds(360, 75, 50, 20);
        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));

        confirmButton.setBounds(350, 430, 100, 20);
        confirmButton.addActionListener(this);

        f.add(scrollPane);
        panelScroll.add(mealnumlabel);
        panelScroll.add(mealslabel);
        panelScroll.add(pricelabel);
        panelScroll.add(pricenumlabel);

        int ind = 0;
        for(int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                int xx = 10 ;
                int yy = ind*30;
                JLabel mealname = new JLabel(MealFrame.meallist.get(i).getName());
                JLabel mealnum = new JLabel(String.valueOf(meals.get(i)));

                mealname.setBounds(xx , yy, 200, 20);
                mealnum.setBounds(xx+220 , yy , 50, 20);

                panelScroll.add(mealname);
                panelScroll.add(mealnum);
                ind++;
            }
        }

        f.add(confirmButton);

        f.setResizable(false);
        f.setSize(500,500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirmButton){
            new Cart(meals);
        }
    }
}