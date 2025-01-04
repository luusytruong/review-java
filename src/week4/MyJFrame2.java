package week4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class RegisterJFrame extends JFrame implements ActionListener {
    private Button btnRegister, btnLogin;
    private Label lbTitle, lbEmail, lbPassword, lbRepeatPassword;
    private TextField tfEmail, tfPassword, tfRepeatPassword;
    private Font font1 = new Font("SansSerif", Font.BOLD, 20);
    private Font font2 = new Font("SansSerif", Font.PLAIN, 16);

    public RegisterJFrame(String title) {
        super(title);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnRegister) {
            System.out.println("Register button clicked");
        } else {
            System.out.println("Login button clicked");
        }
    }

    private static final long serialVersionUID = 1L;

    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel p1 = new Panel();
        this.setContentPane(p1);
        // layout for p1
        p1.setLayout(null);
        // setup
        lbTitle = new Label("Register");
        lbTitle.setFont(font1);

        lbEmail = new Label("Email");
        lbEmail.setFont(font2);

        lbPassword = new Label("Password");
        lbPassword.setFont(font2);

        lbRepeatPassword = new Label("Repeat");
        lbRepeatPassword.setFont(font2);

        tfEmail = new TextField();
        tfEmail.setFont(font2);

        tfPassword = new TextField();
        tfPassword.setEchoChar('*');
        tfPassword.setFont(font2);

        tfRepeatPassword = new TextField();
        tfRepeatPassword.setEchoChar('*');
        tfRepeatPassword.setFont(font2);

        btnRegister = new Button("Register");
        btnRegister.setFont(font2);

        btnLogin = new Button("Login");
        btnLogin.setFont(font2);
        // set bounds
        lbTitle.setBounds(250, 30, 100, 30);
        lbEmail.setBounds(100, 100, 100, 30);
        lbPassword.setBounds(100, 150, 100, 30);
        lbRepeatPassword.setBounds(100, 200, 100, 30);
        tfEmail.setBounds(250, 100, 200, 30);
        tfPassword.setBounds(250, 150, 200, 30);
        tfRepeatPassword.setBounds(250, 200, 200, 30);
        btnRegister.setBounds(300, 280, 100, 30);
        btnLogin.setBounds(150, 280, 100, 30);
        // add to p1
        p1.add(lbTitle);
        p1.add(lbEmail);
        p1.add(lbPassword);
        p1.add(lbRepeatPassword);
        p1.add(tfEmail);
        p1.add(tfPassword);
        p1.add(tfRepeatPassword);
        p1.add(btnRegister);
        p1.add(btnLogin);
        // add action listener

        this.setSize(600, 400);
        this.setResizable(false);

    }

}

public class MyJFrame2 {
    public static void main(String[] args) {
        new RegisterJFrame("Register Form").setVisible(true);
    }
}