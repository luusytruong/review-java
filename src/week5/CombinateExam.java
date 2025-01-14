package week5;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
// import java.awt.event.*;

public class CombinateExam extends JFrame {
    public CombinateExam(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        JPanel contentPanel = new JPanel();
        JPanel databasPanel = new JPanel();
        JPanel systemPanel = new JPanel();

        contentPanel.setLayout(null);
        databasPanel.setLayout(null);
        systemPanel.setLayout(null);

        JLabel lb1 = new JLabel("Data Source Name:");
        JTextField tf1 = new JTextField();
        JLabel lb2 = new JLabel("Description:");
        JTextField tf2 = new JTextField();

        lb1.setBounds(12, 12, 120, 24);
        tf1.setBounds(12 + 120, 12, 268, 24);
        lb2.setBounds(12, 12 + 24, 120, 24);
        tf2.setBounds(12 + 120, 12 + 24, 268, 24);

        contentPanel.add(lb1);
        contentPanel.add(tf1);
        contentPanel.add(lb2);
        contentPanel.add(tf2);

        databasPanel.setBounds(12, 60 + 12, 388, 89);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Database");
        databasPanel.setBorder(titledBorder);

        JLabel lb3 = new JLabel("Database:");
        JButton btn1 = new JButton("Select");
        JButton btn2 = new JButton("Create");
        JButton btn3 = new JButton("Repair");
        JButton btn4 = new JButton("Compact");

        lb3.setBounds(12, 24, 120, 24);
        btn1.setBounds(12, 48 + 6, 80, 24);
        btn2.setBounds(24 + 80, 48 + 6, 80, 24);
        btn3.setBounds(36 + 160, 48 + 6, 80, 24);
        btn4.setBounds(48 + 240, 48 + 6, 88, 24);

        databasPanel.add(lb3);
        databasPanel.add(btn1);
        databasPanel.add(btn2);
        databasPanel.add(btn3);
        databasPanel.add(btn4);

        contentPanel.add(databasPanel);

        systemPanel.setBounds(12, 161 + 12, 388, 120);
        titledBorder = BorderFactory.createTitledBorder("System Database");
        systemPanel.setBorder(titledBorder);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRaJRadioButton1 = new JRadioButton("None");
        JRadioButton jRaJRadioButton2 = new JRadioButton("Database:");
        JLabel lb4 = new JLabel("System Database...");

        jRaJRadioButton1.setBounds(12, 24, 120, 24);
        jRaJRadioButton2.setBounds(12, 48, 120, 24);
        lb4.setBounds(388 / 2 - 90, 72 + 12, 180, 28);
        lb4.setHorizontalAlignment(JLabel.CENTER);
        lb4.setForeground(Color.gray);
        lb4.setBorder(new LineBorder(Color.gray));

        buttonGroup.add(jRaJRadioButton1);
        buttonGroup.add(jRaJRadioButton2);
        systemPanel.add(jRaJRadioButton1);
        systemPanel.add(jRaJRadioButton2);
        systemPanel.add(lb4);

        contentPanel.add(systemPanel);

        JButton btn5 = new JButton("Ok");
        JButton btn6 = new JButton("Cancel");
        JButton btn7 = new JButton("Help");
        JButton btn8 = new JButton("Advanced");
        JButton btn9 = new JButton("Options >>");

        btn5.setBounds(388 + 24, 12, 120, 24);
        btn6.setBounds(388 + 24, 12 + 24 + 12, 120, 24);
        btn7.setBounds(388 + 24, 48 + 24 + 12, 120, 24);
        btn8.setBounds(388 + 24, 84 + 24 + 12, 120, 24);
        btn9.setBounds(388 + 24, 171 + 120 - 24, 120, 24);

        contentPanel.add(btn5);
        contentPanel.add(btn6);
        contentPanel.add(btn7);
        contentPanel.add(btn8);
        contentPanel.add(btn9);

        this.setContentPane(contentPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(388 + 120 + 24 + 16 + 12, 173 + 120 + 24 + 26);
        this.setLocationRelativeTo(null);
    }
}
