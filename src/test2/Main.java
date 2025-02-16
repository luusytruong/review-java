package test2;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

	public Main() {

        setLayout(new GridLayout(2, 3));
        for (int i = 0; i < 11; i++) {
            add(new Button("Button " + (i + 1)));
        }
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
