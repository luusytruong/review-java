package week4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class NewJFrame extends JFrame implements ActionListener {
    private Button btnLogin, btnCancel;
    private TextField txtUsername, txtPassword;
    private Dialog dialog = new Dialog(this, true);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            dialog.add(new Label("button login click!"));
        } else {
            dialog.add(new Label("button cancel click!"));
        }
        dialog.pack();
    }

    public NewJFrame(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
        // frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // panel username
        Panel panelUsername = new Panel();
        panelUsername.setLayout(new FlowLayout());
        panelUsername.add(new Label("Username"));
        panelUsername.add(txtUsername = new TextField(20));
        // panel password
        Panel panelPassword = new Panel();
        panelPassword.setLayout(new FlowLayout());
        panelPassword.add(new Label("Password"));
        panelPassword.add(txtPassword = new TextField(20));
        // panel button
        Panel panelButton = new Panel();
        panelButton.setLayout(new FlowLayout());
        panelButton.add(btnLogin = new Button("Login"));
        panelButton.add(btnCancel = new Button("Cancel"));
        //event
        btnLogin.addActionListener(actionPerformed(ActionEvent e));
        btnCancel.addActionListener(actionPerformed(ActionEvent e));
        // add
        add(new Label("Login"));
        add(panelUsername);
        add(panelPassword);
        add(panelButton);
        // dialog
        dialog.setTitle("notify");
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        setSize(300, 188);
        setLocationRelativeTo(null);
    }
}

public class LoginFrame {
    public static void main(String[] args) {
        new NewJFrame("Login Form").setVisible(true);
    }
}
