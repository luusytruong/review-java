package week5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ListDemo extends JFrame implements ActionListener, ItemListener {
    private List list1;
    private Button btn1;
    private Label lbShow;

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.list1) {
            String[] selects = this.list1.getSelectedItems();
            String selectText = "";
            for (String select : selects) {
                selectText += select + ", ";
            }
            selectText = selectText.trim();
            this.lbShow.setText(selectText);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn1) {
            String[] selects = this.list1.getSelectedItems();
            String selectText = "";
            for (String select : selects) {
                selectText += select + ", ";
            }
            selectText = selectText.trim();
            this.lbShow.setText(selectText);
        }
    }

    public ListDemo(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel p1 = new Panel();
        p1.setLayout(null);

        this.setContentPane(p1);

        list1 = new List(5, true);
        list1.add("ca phe");
        list1.add("banh mi");
        list1.add("mi tom");
        list1.add("tra");
        list1.add("banh dau xanh");
        list1.addItemListener(this);

        btn1 = new Button("show select");
        btn1.addActionListener(this);

        lbShow = new Label();
        lbShow.setBackground(Color.LIGHT_GRAY);

        //set bound
        list1.setBounds(12, 12, 300, 100);

        btn1.setBounds(12, 132, 300, 30);

        lbShow.setBounds(12, 182, 300, 30);

        // add
        p1.add(list1);
        p1.add(btn1);
        p1.add(lbShow);

        // final
        this.setSize(338, 259);
        this.setLocationRelativeTo(null);
    }
}
