import java.awt.*;
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
import javax.swing.border.LineBorder;

public class Details implements ActionListener{
    JLabel detailsLabel = new JLabel();
    ImageIcon detailsIcon = new ImageIcon("your order.png");
    JFrame f = new JFrame("Your Order");
    JButton backToOrderButton = new JButton("Back to Order");
    JButton cancelButton = new JButton("Cancel Button");
    JLabel state = new JLabel("Accepting order...");
    JProgressBar detailsprogregressbar = new JProgressBar();
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);
    static int x=130 ,y=150 , xnum=350 , ynum=150,xstate=40,ystate=200,xbar=20,ybar=30;
    static int gap=30;
    SwingWorker<Void,Integer> worker;
    boolean cancelPressed=false;

    Details(ArrayList<Integer> meals){
        int index=0;
        try( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("The order.txt"),StandardCharsets.UTF_8))){
            for(int i : meals){
                writer.write(String.valueOf(index) + " ");
                writer.write(String.valueOf(i)+ "\n");
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
        detailsLabel.setBounds(0,0,600,700);
        detailsLabel.setIcon(detailsIcon);

        backToOrderButton.setBounds(225, 85, 150, 28);
        
        scrollPane.setBounds(65, 140, 470, 480);
        panelScroll.setLayout(null);
        panelScroll.setPreferredSize(new Dimension(470,700));
        panelScroll.setBackground(new Color(252,244,154));
        panelScroll.setBorder(new LineBorder(Color.white, 2));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        backToOrderButton.addActionListener(this);
        cancelButton.addActionListener(this);

        f.add(detailsLabel);
        f.setLayout(null);
        f.setSize(600,700);

        for (int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                x = xbar+115; y = ybar;
                xnum=xbar+375 ; ynum = ybar;
                break;
            }
        }

        state.setBounds(xstate, gap+30 , 100, 20);
        detailsprogregressbar.setBounds(xbar, gap, 100, 20);

        detailsprogregressbar.setValue(0);
        detailsprogregressbar.setStringPainted(true);



        panelScroll.add(cancelButton);
        panelScroll.add(state);
        panelScroll.add(detailsprogregressbar);

        f.add(scrollPane);
        y=gap; ynum=gap;
        for(int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)>0){
                JLabel mealname = new JLabel(AllMealsFrame.meallist.get(i).getName());
                JLabel mealnum = new JLabel(String.valueOf(meals.get(i)));

                mealname.setBounds(x , y, 250, 20);
                mealname.setFont(new Font("Eras Medium ITC", Font.PLAIN, 18));
                mealnum.setBounds(xnum , ynum, 50, 20);
                mealnum.setFont(new Font("Eras Medium ITC", Font.PLAIN, 18));

                panelScroll.add(mealname);
                panelScroll.add(mealnum);

                y+=70;
                ynum+=70;
                gap=ynum+70;
                }
            cancelButton.setBounds(170, y-10 , 130, 25);
            }

        panelScroll.setBounds(50,150,470,600);

        if(y>=480){
            panelScroll.setPreferredSize(new Dimension(470,y+50));}
        else
            panelScroll.setPreferredSize(new Dimension(470,480));


            worker = new SwingWorker<Void,Integer>() {
                @Override
                protected Void doInBackground() throws Exception {
                    for(int i = 0 ; i <= 100 ; i++){
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        publish(i);
                        if(!cancelButton.isEnabled() && cancelPressed){
                            break;
                        }
                    }
                    return null;
                }
                @Override
                protected void process(List<Integer> chunks) {
                    int progress = chunks.get(chunks.size()-1);
                    detailsprogregressbar.setValue(progress);
                    if(progress==10){
                        state.setText("Preparing...");
                    }
                    if(progress==75){
                        state.setText("Delivering...");
                    }
                    if(progress==50){
                        cancelButton.setEnabled(false);
                        
                    }
                    if(progress==100){
                        detailsprogregressbar.setEnabled(false);
                        
                    }
    
                }
                @Override
                protected void done() {
                    if(!cancelButton.isEnabled() && cancelPressed){
                        state.setText("Canceled");
                    } else{
                        System.out.println("completed");
                        state.setText("Done!");
                }
            }
        };

        worker.execute();

        ystate+=50;
        ybar+=50;

        f.add(backToOrderButton);
        f.setResizable(false);
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
            AllMealsFrame.meallist.clear();
            AllMealsFrame.order.clear();
            AllMealsFrame.fillLists();
            if(MealOrder.manager){
                new MealOrder(true);
            } else {
                new MealOrder(false);
            }
        }
        if(e.getSource()==cancelButton){
            AllMealsFrame.meallist.clear();
            AllMealsFrame.order.clear();
            AllMealsFrame.fillLists();
            cancelPressed=true;
            cancelButton.setEnabled(false);
        }
    }


}