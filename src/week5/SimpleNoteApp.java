package week5;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

import javax.swing.*;

public class SimpleNoteApp extends JFrame implements ActionListener {
    private Label lb;
    private TextArea ta;
    private Button btnSave, btnClear;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnSave) {
            JFileChooser jfc = new JFileChooser();
            int option = jfc.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(this.ta.getText());
                    JOptionPane.showMessageDialog(this, "Save successful");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } else {
            this.ta.setText("");
        }
    }

    public SimpleNoteApp(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel p1 = new Panel();

        lb = new Label("Notepad");
        lb.setAlignment(Label.CENTER);

        ta = new TextArea();

        btnSave = new Button("Save");
        btnSave.addActionListener(this);

        btnClear = new Button("Clear");
        btnClear.addActionListener(this);

        p1.add(btnSave);
        p1.add(btnClear);

        this.add(lb, BorderLayout.NORTH);
        this.add(ta, BorderLayout.CENTER);
        this.add(p1, BorderLayout.SOUTH);

        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
    }
}
