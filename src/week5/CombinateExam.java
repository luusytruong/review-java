package week5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinateExam extends JFrame {
    public CombinateExam(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        Panel contentPanel = new Panel();
        Panel rightPanel = new Panel();
        Panel databasPanel = new Panel();
        Panel systemPanel = new Panel();

        contentPanel.setLayout(null);

        JLabel lb1 = new JLabel("Data Source Name:");
        JTextField tf1 = new JTextField();
        JLabel lb2 = new JLabel("Description:");
        JTextField tf2 = new JTextField();

        lb1.setBounds(12, 12, 120, 25);
        tf1.setBounds(12 + 120, 12, 300, 25);
        lb2.setBounds(12, 12 + 25, 120, 25);
        tf2.setBounds(12 + 120, 12 + 25, 300, 25);

        contentPanel.add(lb1);
        contentPanel.add(tf1);
        contentPanel.add(lb2);
        contentPanel.add(tf2);

        rightPanel.setBackground(Color.lightGray);

        this.add(contentPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        // this.add(databasPanel);
        // this.add(systemPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
    }
}
