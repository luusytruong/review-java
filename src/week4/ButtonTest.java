package week4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

@SuppressWarnings("unused")
class MyListenerButton implements ActionListener {
    private JFrame fJFrame;
	private Button btn1, btn2;

    public MyListenerButton(JFrame parent, Button _btn1, Button _btn2) {
        fJFrame = parent;
        btn1 = _btn1;
        btn2 = _btn2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dialog dialog = new Dialog(fJFrame, true);
        dialog.setLayout(new FlowLayout());
        if (e.getSource() == btn1) {
            dialog.add(new Label("Click btn 1"));
        } else {
            dialog.add(new Label("Click btn 2"));
        }
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

@SuppressWarnings("serial")
class MyJFrame extends JFrame {
    private Button btn1, btn2;
    private MyListenerButton myListenerButton;

    public MyJFrame(String title) {
        setTitle(title);
        btn1 = new Button("button 1");
        btn2 = new Button("button 2");

        myListenerButton = new MyListenerButton(this, btn1, btn2);
        btn1.addActionListener(myListenerButton);
        btn2.addActionListener(myListenerButton);

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(btn1);
        p1.add(btn2);
        add(p1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class ButtonTest {
    public static void main(String[] args) {
        new MyJFrame("hehehe");
    }
}
