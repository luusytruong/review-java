package week5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("unused")
public class ChoiceDemo extends JFrame {
    private Choice choice;
    private Label lb;
    private Color color;

    public ChoiceDemo(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        Panel p1 = new Panel();
        p1.setLayout(null);

        choice = new Choice();
        choice.addItem("background: default");
        choice.addItem("background: green");
        choice.addItem("background: blue");
        choice.addItem("background: pink");
        choice.addItem("background: gray");

        choice.addItemListener(e -> {
            lb.setText(choice.getSelectedItem().replaceAll("background: ", ""));
            int i = choice.getSelectedIndex();
            if (i == 1) {
                color = (Color.GREEN);
            } else if (i == 2) {
                color = (Color.BLUE);
            } else if (i == 3) {
                color = (Color.PINK);
            } else if (i == 4) {
                color = (Color.GRAY);
            } else {
                color = (new Color(243, 245, 246));
            }
            p1.setBackground(color);
        });

        lb = new Label();
        lb.setBackground(Color.LIGHT_GRAY);

        lb.setText(choice.getSelectedItem().replaceAll("background: ", ""));

        // set bounds
        choice.setBounds(12, 12, 200, 0);

        lb.setBounds(12, 46, 200, 30);

        // add to p1
        p1.add(choice);
        p1.add(lb);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(p1);
        this.setSize(224 + 16, 46 + 30 + 34 + 16);
        this.setLocationRelativeTo(null);
    }
}
