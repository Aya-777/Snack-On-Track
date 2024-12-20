import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class firstFrame extends JFrame {
    ImageIcon frontImage;
    JLabel label;
    firstFrame() {
        frontImage = new ImageIcon("frontFrame.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(665, 850);
        this.setLayout(null);
        label = new JLabel();
        label.setBounds(0, 0, 800, 850);
        label.setIcon(frontImage);
        label.setOpaque(true);
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}