import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order implements ActionListener {

   
    static int num=0,price=0;
    JFrame f = new JFrame();
    static JLabel mealnumlabel = new JLabel(String.valueOf(num));
    JLabel pricelabel = new JLabel("Price : ");
    static JLabel pricenumlabel = new JLabel(String.valueOf(price));
    JButton viewcartbutton = new JButton("View cart");
    JLabel mealslabel = new JLabel("Meals :");
    
    JMenuBar mealsbar = new JMenuBar();
    JMenuItem mealsitem = new JMenuItem("Meals");
    JMenuItem saladsitem = new JMenuItem("Salads");
    JMenuItem dessertsitem = new JMenuItem("Desserts");
    JMenuItem drinksitem = new JMenuItem("Drinks");


    Order(){
        f.setLayout(null);

        mealsbar.add(mealsitem);
        mealsbar.add(saladsitem);
        mealsbar.add(dessertsitem);
        mealsbar.add(drinksitem);

        viewcartbutton.setBounds(50,200 , 130, 30);
        mealslabel.setBounds(200, 212, 100, 20);
        mealslabel.setFont(new Font("Consolas", Font.PLAIN ,20));
        mealnumlabel.setBounds(295 , 212 , 50, 20);
        mealnumlabel.setFont(new Font("Consolas", Font.PLAIN ,20));
        pricelabel.setBounds(360, 212, 100, 20);
        pricelabel.setFont(new Font("Consolas",Font.PLAIN,20));
        pricenumlabel.setBounds(460, 212, 50, 20);
        pricenumlabel.setFont(new Font("Consolas",Font.PLAIN,20));
        mealsbar.setBounds(0, 250, 665, 50);
        mealsbar.setFont(new Font("Consolas",Font.PLAIN,200));

        f.add(viewcartbutton);
        f.add(mealnumlabel);
        f.add(mealslabel);
        f.add(pricelabel);
        f.add(pricenumlabel);
        f.add(mealsbar);

        viewcartbutton.addActionListener(this);
        mealsitem.addActionListener(this);
        saladsitem.addActionListener(this);
        dessertsitem.addActionListener(this);
        drinksitem.addActionListener(this);
      
        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
