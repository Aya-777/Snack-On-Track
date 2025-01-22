import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class OrderManagment extends JFrame {

    ArrayList<OrderFile> list;
    int y = 0;
    JLabel emptyLabel;
    JLabel detailsLabel;
    JLabel mainJLabel = new JLabel();
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);
    ImageIcon mainicon = new ImageIcon("OrderMangement.jpg");

    OrderManagment() {

        this.setSize(600, 500);
        this.setLayout(null);

        list = Details.saveFileArray;
        int size = list.size();

        detailsLabel = mainLabel(list);
        mainJLabel.setBounds(0, 0, 600, 500);

        emptyLabel = new JLabel("There is no order for today until now");
        emptyLabel.setBounds(-50, y, 600, 50);
        emptyLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        emptyLabel.setHorizontalAlignment(JLabel.CENTER);
        emptyLabel.setVerticalAlignment(JLabel.CENTER);

        scrollPane.setBounds(30, 52, 530, 400);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelScroll.setLayout(null);
        panelScroll.setBounds(0, 0, 550, 448);
        panelScroll.setPreferredSize(new Dimension(600, 430));
        panelScroll.setBorder(new LineBorder(Color.WHITE, 2));

        boolean mealsexist = false;
        for (int i = 0; i < size; i++) {

            if (list.get(i).getDate().equals(LocalDate.now())) {

                String userName = list.get(i).getUsername();
                String date = list.get(i).getDate().toString();
                String status = list.get(i).getStatus();

                panelScroll.add(launchLabel(userName, date, status));
                mealsexist =true;
            }
        }

        if(!mealsexist){
            panelScroll.add(emptyLabel);
        }

        mainJLabel.setIcon(mainicon);

        mainJLabel.add(scrollPane);
        mainJLabel.add(detailsLabel);
        this.add(mainJLabel);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    JLabel mainLabel(ArrayList<OrderFile> list) {
        int size = list.size();
        int dailyOrders =0;
        int dailyPrice = 0;
        for (int i = 0; i < size; i++) {
            if (LocalDate.now().equals(list.get(i).getDate())) {
                dailyPrice += list.get(i).getOrderPrice();
                dailyOrders +=1;
            }
        }

        JLabel howManyOrdersLabel = new JLabel();
        howManyOrdersLabel.setBounds(10, 10, 200, 50);
        howManyOrdersLabel.setText("Orders :" + dailyOrders);
        howManyOrdersLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        howManyOrdersLabel.setHorizontalAlignment(JLabel.CENTER);
        howManyOrdersLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel pricLabel = new JLabel();
        pricLabel.setBounds(180, 10, 400, 50);
        pricLabel.setText("Daily income :" + dailyPrice);
        pricLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        pricLabel.setHorizontalAlignment(JLabel.CENTER);
        pricLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel mainLabel = new JLabel();
        mainLabel.setBounds(0, 0, 600, 50);
        mainLabel.add(howManyOrdersLabel);
        mainLabel.add(pricLabel);
        return mainLabel;
    }

    JLabel launchLabel(String name, String date, String status) {

        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(10, 20, 200, 20);
        nameLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        nameLabel.setForeground(Color.black);
        nameLabel.setHorizontalAlignment(JLabel.LEFT);

        JLabel dateLabel = new JLabel(date);
        dateLabel.setBounds(170, 20, 200, 20);
        dateLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        dateLabel.setForeground(Color.black);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setBounds(350, 20, 200, 20);
        statusLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        
        if (status.equals("Done")) {
            statusLabel.setForeground(Color.green);
        } else if (status.equals("Preparing")) {
            statusLabel.setForeground(Color.orange);
        }else if(status.equals("Delivering")){
            statusLabel.setForeground(Color.YELLOW);

        }else {
            statusLabel.setForeground(Color.gray);
        }

        JLabel label = new JLabel();
        label.setLayout(null);
        label.setBounds(0, y, 600, 50);
        label.add(nameLabel);
        label.add(dateLabel);
        label.add(statusLabel);
        y += 52;

        return label;
    }

}
