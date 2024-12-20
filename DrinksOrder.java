import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DrinksOrder extends Order implements MouseListener{

    JLabel drink1label = new JLabel("0");
    JLabel drink2label = new JLabel("0");
    JLabel drink3label = new JLabel("0");
    JLabel drink4label = new JLabel("0");
    JLabel drink5label = new JLabel("0");

    static int num1=0,num2=0,num3=0,num4=0,num5=0;
    DrinksOrder(){

        f.add(drink1label);
        f.add(drink2label);
        f.add(drink3label);
        f.add(drink4label);
        f.add(drink5label);

        drinksitem.setEnabled(false);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mealsitem){
            new MealOrder();
        }
        if(e.getSource() == saladsitem){
            new SaladOrder();
        }
        if(e.getSource()==drinksitem){
            JOptionPane.showMessageDialog(null,"You are already on drink's order page.",
            "Title",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == dessertsitem){
            new DessertOrder();
        }
        if(e.getSource() == viewcartbutton){
            if(Order.num == 0){
                JOptionPane.showMessageDialog(null,"You have to select meals to buy."
                        ,"Title",JOptionPane.ERROR_MESSAGE);
            }
            else {
                new Cart(MealFrame.order);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == drink1label){
            new MealFrame(16);
        }
        if(e.getSource() == drink2label){
            new MealFrame(17);
        }
        if(e.getSource() == drink3label){
            new MealFrame(18);
        }
        if(e.getSource() == drink4label){
            new MealFrame(19);
        }
        if(e.getSource() == drink5label){
            new MealFrame(20);
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
