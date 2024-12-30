package test_awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextField textField = new JTextField(20);
        JButton button = new JButton("Hiển thị");
        button.setSize(280, 40);
        JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                label.setText("Xin chào " + name + "!");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Nhập tên của bạn:"));
        panel.add(textField);
        panel.add(button);
        panel.add(label);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
