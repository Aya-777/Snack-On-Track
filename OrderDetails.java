import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class OrderDetails implements ActionListener{

    JFrame f = new JFrame("Cart");
    JLabel cartLabel = new JLabel();
    ImageIcon cartIcon = new ImageIcon("cart.png");

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

        cartLabel.setBounds(0,0,500,500);
        cartLabel.setIcon(cartIcon);

        scrollPane.setBounds(50, 10, 385, 400);
        scrollPane.setBackground(new Color(252,244,154));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelScroll.setLayout(null);
        panelScroll.setBounds(10,10,385,400);
        panelScroll.setBackground(new Color(252,244,154));
        panelScroll.setPreferredSize(new Dimension(465,40));
        panelScroll.setBorder(new LineBorder(Color.WHITE, 2));


        mealslabel.setBounds(60, 425, 100, 20);
        mealslabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnumlabel.setBounds(130, 425, 50, 20);
        mealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricelabel.setBounds(200, 425, 100, 20);
        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricenumlabel.setBounds(270, 425, 50, 20);
        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));

        confirmButton.setBounds(340, 423, 120, 25);
        confirmButton.addActionListener(this);
        confirmButton.setFocusable(false);

        pricenumlabel.setText(String.valueOf(Order.price));
        mealnumlabel.setText(String.valueOf(Order.num));


        cartLabel.add(mealnumlabel);
        cartLabel.add(mealslabel);
        cartLabel.add(pricelabel);
        cartLabel.add(pricenumlabel);

        f.add(cartLabel);
        f.add(scrollPane);


        int ind = 1;
        for(int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                int xx = 15 ;
                int yy = ind*60;
                yy-=30;
                JLabel mealname = new JLabel(AllMealsFrame.meallist.get(i).getName());
                JLabel mealnum = new JLabel(String.valueOf(meals.get(i)));

                mealname.setBounds(xx , yy, 320, 30);
                mealname.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
                mealnum.setBounds(xx+320, yy , 50, 30);
                mealnum.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));

                panelScroll.add(mealname);
                panelScroll.add(mealnum);
                ind++;

                if (yy>400){

                    panelScroll.setPreferredSize(new Dimension(385,yy));}
                else
                    panelScroll.setPreferredSize(new Dimension(385,400));

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