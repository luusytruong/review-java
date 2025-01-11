package week5;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TitledBorder Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Tên Khung");
        panel.setBorder(titledBorder);

        panel.add(new JLabel("Nội dung bên trong khung."));

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
