import java.awt.FlowLayout;
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

public class Details {
    JProgressBar detailsprogregressbar = new JProgressBar();
    JFrame f = new JFrame();

    Details(ArrayList<Integer> meals){
        int index=0;
        
            // System.out.println(index+ " " + i);
            try( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("The order.txt"),StandardCharsets.UTF_8))){
                for(int i : meals){
                writer.write(String.valueOf(index) + " ");
                writer.write(String.valueOf(i)+ "\n");
                // writer.write("fhfi");
                // writer.close();
                index++;
                }
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

        f.setLayout(new FlowLayout());
        detailsprogregressbar.setValue(0);
        detailsprogregressbar.setStringPainted(true);

        // mealdetails();

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

}
