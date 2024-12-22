import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.*;

public class Details implements ActionListener{
    JProgressBar detailsprogregressbar = new JProgressBar();
    JFrame f = new JFrame();
    JButton backToOrderButton = new JButton("Back to Order");

    Details(ArrayList<Integer> meals){
        int index=0;
        try( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("The order.txt"),StandardCharsets.UTF_8))){
            for(int i : meals){
                writer.write(String.valueOf(index) + " ");
                writer.write(String.valueOf(i)+ "\n");
                if(i!=0){
                    JLabel meal = new JLabel(MealFrame.meallist.get(index).getName());
                    meal.setBounds(200, 150, 200, 20);
                    f.add(meal);
                }
                index++;
            }
            writer.close();
            }catch(Exception e){
                System.out.println(e.getStackTrace());
            }
            

        try(BufferedReader r = new BufferedReader(new FileReader("The order.txt"))) {
            String line;
            while((line=r.readLine()) != null){
            System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        backToOrderButton.setBounds(50, 100, 150, 20);
        detailsprogregressbar.setBounds(70, 150, 100, 20);
        
        backToOrderButton.addActionListener(this);

        f.setLayout(null);
        detailsprogregressbar.setValue(0);
        detailsprogregressbar.setStringPainted(true);

        // mealdetails();

        f.add(backToOrderButton);
        f.add(detailsprogregressbar);
        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

    public void mealdetails(){
        int counter = 0 ;
        while (counter < 101) {
            detailsprogregressbar.setValue(counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter+=20;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backToOrderButton){
            f.dispose();
            Order.price=0;
            Order.num=0;
            Order.mealnumlabel.setText(String.valueOf(Order.num));
            Order.pricenumlabel.setText(String.valueOf(Order.price));
            MealFrame.meallist.clear();
            MealFrame.fillLists();
            if(MealOrder.manager){
                new MealOrder(true);
            } else {
                new MealOrder(false);
            }
        }
    }

}
