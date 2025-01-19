import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class OrderManagment extends JFrame {

    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
    ArrayList<OrderFile> list;
    int y = 52;
    JLabel emptyLabel;
    JLabel detailsLabel;
    JPanel panelScroll = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panelScroll);

    OrderManagment() {

        this.setSize(600, 500);
        this.setLayout(null);
        this.setBackground(Color.GREEN);

        list = Details.saveFileArray;
        int size = list.size();

        detailsLabel = mainLabel(list);

        emptyLabel = new JLabel("There is no order for today until now");
        emptyLabel.setBounds(0, y, 600, 50);
        emptyLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        emptyLabel.setHorizontalAlignment(JLabel.CENTER);
        emptyLabel.setVerticalAlignment(JLabel.CENTER);

        scrollPane.setBounds(0, 52, 580, 448);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelScroll.setLayout(null);
        panelScroll.setBounds(0, 0, 550, 448);
        panelScroll.setBackground(Color.white);
        // panelScroll.setPreferredSize(new Dimension(600, 448));
        panelScroll.setBorder(new LineBorder(Color.WHITE, 2));

        for (int i = 0; i < size; i++) {

            if (list.get(i).getDate().equals(LocalDate.now())) {

                String userName = list.get(i).getUsername();
                String date = list.get(i).getDate().toString();
                String status = list.get(i).getStatus();

                panelScroll.add(launchLabel(userName, date, status));
            }
        }

        if (list.isEmpty()) {
            panelScroll.add(emptyLabel);
            // System.out.println("gigi is empty");
        }

        this.add(scrollPane);
        this.add(detailsLabel);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    JLabel mainLabel(ArrayList<OrderFile> list) {
        int size = list.size();
        int dailyPrice = 0;
        for (int i = 0; i < size; i++) {
            if (LocalDate.now().equals(list.get(i).getDate())) {
                dailyPrice += list.get(i).getOrderPrice();
            }
        }

        JLabel howManyOrdersLabel = new JLabel();
        howManyOrdersLabel.setBounds(0, 0, 200, 50);
        howManyOrdersLabel.setText("Orders :" + size);
        howManyOrdersLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        howManyOrdersLabel.setHorizontalAlignment(JLabel.CENTER);
        howManyOrdersLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel pricLabel = new JLabel();
        pricLabel.setBounds(200, 0, 400, 50);
        pricLabel.setText("Daily price :" + dailyPrice);
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
        nameLabel.setBounds(0, 0, 200, 50);
        nameLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        nameLabel.setForeground(Color.black);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.BOTTOM);

        JLabel dateLabel = new JLabel(date);
        dateLabel.setBounds(200, 0, 200, 50);
        dateLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        dateLabel.setForeground(Color.black);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.BOTTOM);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setBounds(400, 0, 200, 50);
        statusLabel.setFont(new Font("consolas", Font.PLAIN, 30));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setVerticalAlignment(JLabel.BOTTOM);
        if (status.equals("Done")) {
            statusLabel.setForeground(Color.green);
        } else if (status.equals("Prepering")) {
            statusLabel.setForeground(Color.orange);
        } else {
            statusLabel.setForeground(Color.red);
        }

        JLabel label = new JLabel();
        label.setBounds(0, y, 600, 50);
        label.setBorder(border);
        label.add(nameLabel);
        label.add(dateLabel);
        label.add(statusLabel);
        y += 52;

        return label;
    }

}
