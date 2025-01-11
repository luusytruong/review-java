package week5;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class CombinateExam extends JFrame {
    public CombinateExam(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        JPanel contentPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel databasPanel = new JPanel();
        JPanel systemPanel = new JPanel();

        contentPanel.setLayout(null);
        rightPanel.setLayout(null);
        databasPanel.setLayout(null);
        systemPanel.setLayout(null);

        JLabel lb1 = new JLabel("Data Source Name:");
        JTextField tf1 = new JTextField();
        JLabel lb2 = new JLabel("Description:");
        JTextField tf2 = new JTextField();

        lb1.setBounds(12, 12, 120, 24);
        tf1.setBounds(12 + 120, 12, 260, 24);
        lb2.setBounds(12, 12 + 24, 120, 24);
        tf2.setBounds(12 + 120, 12 + 24, 260, 24);

        contentPanel.add(lb1);
        contentPanel.add(tf1);
        contentPanel.add(lb2);
        contentPanel.add(tf2);

        databasPanel.setBounds(12, 60 + 12, 380, 89);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Database");
        databasPanel.setBorder(titledBorder);

        JLabel lb3 = new JLabel("Database:");
        JButton btn1 = new JButton("Select");
        JButton btn2 = new JButton("Create");
        JButton btn3 = new JButton("Repair");
        JButton btn4 = new JButton("Compact");

        lb3.setBounds(12, 24, 120, 24);
        btn1.setBounds(12 , 48+6, 80, 24);
        btn2.setBounds(24+80 , 48+6, 80, 24);
        btn3.setBounds(36+160 , 48+6, 80, 24);
        btn4.setBounds(48+240 , 48+6, 80, 24);

        databasPanel.add(lb3);
        databasPanel.add(btn1);
        databasPanel.add(btn2);
        databasPanel.add(btn3);
        databasPanel.add(btn4);

        contentPanel.add(databasPanel);

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
