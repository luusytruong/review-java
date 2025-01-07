package week5;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class TextEditorApp extends JFrame implements ActionListener {
    private TextField tf1;
    private Button btn1;
    private TextArea ta;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn1) {
            ta.append(tf1.getText() + "\n");
        }
    }

    public TextEditorApp(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        p2.setLayout(new BorderLayout());

        tf1 = new TextField(32);

        btn1 = new Button("Add text");
        btn1.addActionListener(this);

        ta = new TextArea();

        p1.add(tf1);
        p1.add(btn1);
        p2.add(ta, BorderLayout.CENTER);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);

        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }
}
