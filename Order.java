import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Order implements ActionListener, MouseListener{

    static int num = 0, price = 0, newmeals=MealFrame.meallist.size()-1;
    JFrame f = new JFrame();
    JLabel mealslabel = new JLabel("Meals :");
    static JLabel mealnumlabel = new JLabel(String.valueOf(num));
    JLabel pricelabel = new JLabel("Price : ");
    static JLabel pricenumlabel = new JLabel(String.valueOf(price));
    JButton viewdetailsbutton = new JButton("View details");
    JButton logoutButton = new JButton("Log out");
    JButton addmealButton = new JButton("Add Meal");
    JButton ordersButton = new JButton("Orders");
    JMenuBar mealsbar = new JMenuBar();
    JMenuItem mealsitem = new JMenuItem("Meals");
    JMenuItem saladsitem = new JMenuItem("Salads");
    JMenuItem dessertsitem = new JMenuItem("Desserts");
    JMenuItem drinksitem = new JMenuItem("Drinks");;
    static boolean manager;
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);
    static ArrayList<JLabel>meallabels=new ArrayList<>();

    Order(){}
    Order(boolean manager) {
        f.setLayout(null);

        this.manager = manager;
        if (manager) {
            ordersButton.setBounds(400,40,130,30);
            addmealButton.setBounds(400, 80, 130, 30);
            f.add(ordersButton);
            f.add(addmealButton);
            ordersButton.addActionListener(this);
            addmealButton.addActionListener(this);
            ordersButton.setFocusable(false);
            addmealButton.setFocusable(false);
        }

        scrollPane.setBounds(10, 190, 615, 600);
        panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
        panelScroll.setBorder(new LineBorder(Color.white, 2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        mealsbar.add(mealsitem);
        mealsbar.add(saladsitem);
        mealsbar.add(dessertsitem);
        mealsbar.add(drinksitem);

        viewdetailsbutton.setBounds(260, 115, 130, 30);
        viewdetailsbutton.setFocusable(false);
        mealslabel.setBounds(275, 40, 100, 20);
        mealslabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnumlabel.setBounds(360, 40, 50, 20);
        mealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricelabel.setBounds(275, 75, 100, 20);
        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricenumlabel.setBounds(360, 75, 50, 20);
        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealsbar.setBounds(0, 160, 665, 25);
        mealsbar.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 200));

        logoutButton.setBounds(400, 115, 130, 30);
        logoutButton.setFocusable(false);

        f.add(viewdetailsbutton);
        f.add(mealnumlabel);
        f.add(mealslabel);
        f.add(pricelabel);
        f.add(pricenumlabel);
        f.add(mealsbar);
        f.add(logoutButton);

        viewdetailsbutton.addActionListener(this);
        mealsitem.addActionListener(this);
        saladsitem.addActionListener(this);
        dessertsitem.addActionListener(this);
        drinksitem.addActionListener(this);
        logoutButton.addActionListener(this);

        f.setResizable(false);
        f.setSize(650, 830);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }
    void addMeal(JLabel newmealLabel){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            f.dispose();
            price = 0;
            num = 0;
            mealnumlabel.setText(String.valueOf(num));
            pricenumlabel.setText(String.valueOf(price));
            AllMealsFrame.meallist.clear();
            AllMealsFrame.fillLists();
            new SignFrame();
        }
        if (e.getSource() == addmealButton) {
            new AddMeal();
        }
        if(e.getSource()==ordersButton){
            

        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof JLabel){
            // System.out.println(((JLabel) e.getSource()).getText());
            for (JLabel jLabel : Order.meallabels) {
                if(jLabel.getText()==((JLabel) e.getSource()).getText()){
                    int mealnum=Integer.parseInt(jLabel.getText());
                    Meal m = MealFrame.meallist.get(mealnum);
                    if(m.getDeleted()){
                        JOptionPane.showMessageDialog(null,"This meal is not available.",
                    "Title",JOptionPane.OK_OPTION);
                    } else{
                        if(m.getType()=="Meal"){
                            new MealFrame(mealnum,manager ,1 );
                        }else if(m.getType()=="Salad"){
                            new MealFrame(mealnum,manager ,2 );
                        }else if(m.getType()=="Dessert"){
                            new MealFrame(mealnum,manager ,3 );
                        }else if(m.getType()=="Drink"){
                            new MealFrame(mealnum,manager ,4 );
                        }
                        break;
                    }
                }
            }
        }
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
