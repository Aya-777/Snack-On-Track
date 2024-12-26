import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bankFrame extends JFrame implements ActionListener {

    JTextField nameTextField;
    JTextField idTextField;
    JTextField passworJTextField;

    JLabel nameLabel = new JLabel("Bank Name");
    JLabel idLabel = new JLabel("Card ID");
    JLabel passLabel = new JLabel("Password");

    JLabel label;
    ImageIcon background = new ImageIcon("bank2.jpg");

    bankFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);

        nameTextField = new JTextField();
        nameTextField.setBounds(120, 120, 150, 30);
        nameTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        nameTextField.setBackground(Color.white);
        nameTextField.setCaretColor(Color.white);

        nameLabel.setBounds(30, 120, 80, 30);
        nameLabel.setForeground(Color.WHITE);

        idTextField = new JTextField();
        idTextField.setBounds(120, 170, 150, 30);
        idTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        idTextField.setBackground(Color.white);
        idTextField.setCaretColor(Color.white);

        idLabel.setBounds(30, 170, 80, 30);
        idLabel.setForeground(Color.WHITE);

        passworJTextField = new JTextField();
        passworJTextField.setBounds(120, 220, 150, 30);
        passworJTextField.setFont(new Font("consolas", Font.PLAIN, 15));
        passworJTextField.setBackground(Color.white);
        passworJTextField.setCaretColor(Color.white);

        passLabel.setBounds(30, 220, 80, 30);
        passLabel.setForeground(Color.WHITE);

        label = new JLabel();
        label.setBounds(0, 0, 500, 500);
        label.setIcon(background);

        label.add(nameTextField);
        label.add(idTextField);
        label.add(passworJTextField);
        label.add(nameLabel);
        label.add(idLabel);
        label.add(passLabel);

        this.add(label);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
