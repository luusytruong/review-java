package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
    private JButton btnReg;
    private JTextField tfUsername, tfPassword, tfRepeatPassword;
    private EventButton event = new EventButton(this, btnReg, tfUsername, tfPassword, tfRepeatPassword);

    public MyFrame(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        JPanel p1 = new JPanel(new GridLayout(3, 2));

        JLabel lbUsername = new JLabel("Username");
        p1.add(lbUsername);

        tfUsername = new JTextField(20);
        p1.add(tfUsername);

        JLabel lbPassword = new JLabel("Password");
        p1.add(lbPassword);

        tfPassword = new JTextField(20);
        p1.add(tfPassword);

        JLabel lbRepeatPassword = new JLabel("Repeat");
        p1.add(lbRepeatPassword);

        tfRepeatPassword = new JTextField(20);
        p1.add(tfRepeatPassword);

        JPanel p2 = new JPanel();

        btnReg = new JButton("Register");
        btnReg.addActionListener(event);
        p2.add(btnReg);

        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
