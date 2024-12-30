package test_awt;

import java.awt.*;
import java.awt.event.*;

class NewFrame extends Frame {
    private Button button;
    private Dialog dialog;
    private TextField textField;
    private GridBagConstraints gbc = new GridBagConstraints();

    public NewFrame() {
        this.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents() {
        button = new Button();
        button.setLabel("Great");
        button.setSize(32, 16);
        button.addActionListener(e -> {
            String name = textField.getText();
            Label label = new Label("hi guy!");

            if (name.isEmpty()) {
                label.setText("you must enter your name");
            } else {
                label.setText("hello " + name + ", have a good day!");
            }
            
            dialog = new Dialog(this, "greating", true);
            dialog.setLayout(new GridBagLayout());
            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(12, 12, 12, 12);
            dialog.add(label, gbc);

            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dialog.setVisible(false);
                }
            });
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
        Label labelInput = new Label("input your name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(12, 12, 0, 0);
        this.add(labelInput, gbc);

        textField = new TextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(12, 0, 0, 12);
        this.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 12, 12, 12);
        this.add(button, gbc);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

public class Main {
    public static void main(String[] args) {
        new NewFrame();
    }
}
