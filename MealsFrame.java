import javax.swing.*;
import java.awt.*;

public class MealsFrame extends AllMealsFrame {

    /*JFrame f = new JFrame();
    JLabel mealLabel = new JLabel();*/

    MealsFrame(Integer mealnum, boolean manager) {
        super(mealnum, manager);

       /* addbutton.setBounds(245, 480, 50, 30);
        singlemealnumlabel.setBounds(313, 490, 50, 20);
        minusbutton.setBounds(345, 480, 350, 0);
        singlemealnumlabel.setFont(new Font("consolas",Font.BOLD,20));
        backButton.setBounds(480, 670, 150, 30);
        pricelabel.setBounds(480, 630, 100, 30);
        pricenumlabel.setBounds(600, 630, 50, 30);
        pricelabel.setFont(new Font("consolas", Font.BOLD, 20));
        pricenumlabel.setFont(new Font("consolas", Font.BOLD, 20));
        mealpricLabel.setBounds(530, 350, 100, 30);
        mealpricLabel.setFont(new Font("consolas", Font.BOLD, 20));*/

        descTextArea.setText(m.getDesc());
        descTextArea.setWrapStyleWord(true);
        descTextArea.setLineWrap(true);
        descTextArea.setEditable(false);
        descTextArea.setFocusable(false);
        descTextArea.setOpaque(false);
        descTextArea.setBorder(null);
        descTextArea.setBounds(40, 600, 400, 300);
        descTextArea.setFont(new Font("consolas", Font.BOLD , 15));
        mainLabel.add(descTextArea);

    }
}
