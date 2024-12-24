import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Details implements ActionListener{
    static JFrame f = new JFrame();
    JButton backToOrderButton = new JButton("Back to Order");
    JLabel state = new JLabel("Accepting order...");
    JProgressBar detailsprogregressbar = new JProgressBar();
    static int x=200 ,y = 150 , xnum=400 , ynum=150,xstate=70,ystate=200,xbar=70,ybar=150;

    Details(ArrayList<Integer> meals){
        int index=0;
        try( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("The order.txt"),StandardCharsets.UTF_8))){
            for(int i : meals){
                writer.write(String.valueOf(index) + " ");
                writer.write(String.valueOf(i)+ "\n");
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
        
        backToOrderButton.addActionListener(this);

        f.setLayout(null);

        state.setBounds(xstate, ystate , 100, 20);
        detailsprogregressbar.setBounds(xbar, ybar, 100, 20);

        index=0;
        f.add(state);
        f.add(detailsprogregressbar);
        for(int i =0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                JLabel mealname = new JLabel(MealFrame.meallist.get(index).getName());
                JLabel mealnum = new JLabel(String.valueOf(meals.get(i)));

                detailsprogregressbar.setValue(0);
                detailsprogregressbar.setStringPainted(true);

                mealname.setBounds(x , y, 200, 20);
                mealnum.setBounds(xnum , ynum, 50, 20);

                f.add(mealname);
                f.add(mealnum);

                SwingWorker<Void,Integer> worker = new SwingWorker<Void,Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for(int i = 0 ; i <= 100 ; i++){
                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                            publish(i);
                        }
                        return null;
                    }
                    @Override
                    protected void process(List<Integer> chunks) {
                        int progress = chunks.get(chunks.size()-1);
                        detailsprogregressbar.setValue(progress);
                        if(progress==10){
                            state.setText("Preparing...");}
                        if(progress==75){
                            state.setText("Delivering...");
                        }
                        if(progress==50){
                            
                        }
                        if(progress==100){
                            detailsprogregressbar.setEnabled(false);
                            
                        }
        
                    }
                    @Override
                    protected void done() {
                        System.out.println("completed");
                        state.setText("Done!");
                    }
                };

                worker.execute();
                // x+=100;
                y+=50;
                ynum+=50;
                }
                index++;
            }
        ystate+=100;
        ybar+=100;

        f.add(backToOrderButton);
        f.setResizable(false);
        f.setSize(665,850);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backToOrderButton){
            f.dispose();
            Order.price=0;
            Order.num=0;
            Order.mealnumlabel.setText(String.valueOf(Order.num));
            Order.pricenumlabel.setText(String.valueOf(Order.price));
            // MealFrame.meallist.clear();
            // MealFrame.fillLists();
            if(MealOrder.manager){
                new MealOrder(true);
            } else {
                new MealOrder(false);
            }
        }
    }


}