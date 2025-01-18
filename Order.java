import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Order implements ActionListener, MouseListener{

    static int num = 0, price = 0, newmeals=AllMealsFrame.meallist.size()-1;
    JFrame f = new JFrame();
    JLabel mealslabel = new JLabel("Meals :");
    static JLabel mealnumlabel = new JLabel(String.valueOf(num));
    JLabel pricelabel = new JLabel("Price : ");
    static JLabel pricenumlabel = new JLabel(String.valueOf(price));
    JButton viewdetailsbutton = new JButton("View details");
    // JButton myordersButton = new JButton("My Orders");
    JMenuBar mealsbar = new JMenuBar();
    JMenuItem mealsitem = new JMenuItem("Meals");
    JMenuItem saladsitem = new JMenuItem("Salads");
    JMenuItem dessertsitem = new JMenuItem("Desserts");
    JMenuItem drinksitem = new JMenuItem("Drinks");
    JMenuBar menuBar= new JMenuBar();
    JMenu menu = new JMenu("|||");
    JMenuItem recommendationsitem = new JMenuItem("Recommendations");
    JMenuItem logoutitem = new JMenuItem("Log out");
    JMenuItem addmealitem = new JMenuItem("Add meal");
    JMenuItem manageritem = new JMenuItem("Manager details");
    JMenuItem myordersitem = new JMenuItem("My Orders");
    static boolean manager;
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);
    static ArrayList<JLabel>meallabels=new ArrayList<>();

    
    Order(){}
    Order(boolean manager) {
        f.setLayout(null);

        Order.manager = manager;
        if (manager) {
            menu.add(addmealitem);
            menu.add(manageritem);
        }

        menuBar.setBounds(0, 0, 635 , 15);
        menuBar.add(menu);
        menu.add(myordersitem);
        menu.add(recommendationsitem);
        menu.add(logoutitem);

        scrollPane.setBounds(10, 190, 615, 600);
        panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
        panelScroll.setBorder(new LineBorder(Color.white, 2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        mealsbar.add(mealsitem);
        mealsbar.add(saladsitem);
        mealsbar.add(dessertsitem);
        mealsbar.add(drinksitem);

        viewdetailsbutton.setBounds(300, 110, 200, 33);
        viewdetailsbutton.setFocusable(false);
        mealslabel.setBounds(420, 75, 100, 20);
        mealslabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealnumlabel.setBounds(510, 75, 50, 20);
        mealnumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricelabel.setBounds(275, 75, 100, 20);
        pricelabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        pricenumlabel.setBounds(360, 75, 50, 20);
        pricenumlabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        mealsbar.setBounds(0, 160, 665, 25);
        mealsbar.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 200));

        mealnumlabel.setText(String.valueOf(num));
        pricenumlabel.setText(String.valueOf(price));

        f.add(viewdetailsbutton);
        f.add(mealnumlabel);
        f.add(mealslabel);
        f.add(pricelabel);
        f.add(pricenumlabel);
        f.add(menuBar);
        f.add(mealsbar);

        viewdetailsbutton.addActionListener(this);
        mealsitem.addActionListener(this);
        saladsitem.addActionListener(this);
        dessertsitem.addActionListener(this);
        drinksitem.addActionListener(this);
        addmealitem.addActionListener(this);
        recommendationsitem.addActionListener(this);
        logoutitem.addActionListener(this);
        manageritem.addActionListener(this);
        myordersitem.addActionListener(this);


        f.setResizable(false);
        f.setSize(650, 830);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }
    void addMeal(JLabel newmealLabel , Meal newMeal){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutitem) {
            f.dispose();
            price = 0;
            num = 0;
            Details.gap=30;
            Details.x=130; Details.y=150; Details.xnum=350; Details.ynum=150;
            Details.xstate=40; Details.ystate=200; Details.xbar=20; Details.ybar=30;
            Details.panelScroll=new JPanel();
            mealnumlabel.setText(String.valueOf(num));
            pricenumlabel.setText(String.valueOf(price));
            // AllMealsFrame.meallist.clear();
            AllMealsFrame.order.clear();
            AllMealsFrame.fillLists();
            new SignFrame();
        }
        if (e.getSource() == addmealitem){
            new AddMeal();
        }
        if(e.getSource()==manageritem){
            new ManagerDetails(AllMealsFrame.meallist);
        }
        if(e.getSource() == recommendationsitem){
            new Recommendations(AllMealsFrame.meallist);
        }
        if(e.getSource() == myordersitem){
            new Details(new ArrayList<>());
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof JLabel){
            for (JLabel jLabel : meallabels) {
                if(jLabel.getText().equals(((JLabel) e.getSource()).getText())){
                    int mealnum=Integer.parseInt(jLabel.getText());
                    Meal m = AllMealsFrame.meallist.get(mealnum);
                    if(m.getDeleted()){
                        if(myAccount.customer != null){ //customer
                            JOptionPane.showMessageDialog(null,"This meal is not available.",
                        "Title",JOptionPane.OK_OPTION);
                        
                        } else{ //employee
                            int yes = JOptionPane.showConfirmDialog(null,"This meal is not available, Do you want to restore it?",
                        "Title",JOptionPane.YES_NO_OPTION);
                            // System.out.println(yes);
                            if (yes==0){
                                m.setDeleted(false);
                                JOptionPane.showMessageDialog(null,"Meal Restored.",
                            "Title",JOptionPane.INFORMATION_MESSAGE);
                                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Meals.dat"))){
                                oos.writeObject(AllMealsFrame.meallist);
                                } catch (Exception ee) {
                                    ee.printStackTrace();
                                }
                            }
                        }
                        break;
                    } else{
                        new AllMealsFrame(mealnum,manager ,m.getType());
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
