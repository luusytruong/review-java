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
            if (ta.getText().isEmpty()) {
                return;
            }
            JFileChooser jFileChooser = new JFileChooser();
            int optionSave = jFileChooser.showSaveDialog(this);
            if (optionSave == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(ta.getText());
                    JOptionPane.showMessageDialog(this, "Save successful");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } else {
            ta.setText("");
        }
    }

    public SimpleNoteApp(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
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

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
    }
}
