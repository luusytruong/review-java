package week5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class Menu extends JFrame {
    public Menu(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        Panel p1 = new Panel();
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> {
            System.exit(0);
        });
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);

        JMenu colorMenu = new JMenu("Color");
        JMenuItem redItem = new JMenuItem("Red");
        redItem.addActionListener(e -> {
            p1.setBackground(Color.RED);
            System.out.println("red");
        });
        JMenuItem greenItem = new JMenuItem("Green");
        greenItem.addActionListener(e -> {
            p1.setBackground(Color.green);
            System.out.println("green");
        });
        JMenuItem blueItem = new JMenuItem("Blue");
        blueItem.addActionListener(e -> {
            p1.setBackground(Color.blue);
            System.out.println("blue");
        });
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        JMenu optionMenu = new JMenu("Option");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(optionMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setContentPane(p1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
    }
}
