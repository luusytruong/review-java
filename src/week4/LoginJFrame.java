package week4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginJFrame extends JFrame implements ActionListener {
	// khai bao seri tranh canh bao jframe
	private static final long serialVersionUID = 1L;
	// khai bao cac thanh phan trong jframe
	private Label lbTitle, lbEmail, lbPassword;
	private TextField tfEmail, tfPassword;
	private Button btnLogin;
	// khoi tao font chu
	private Font font1 = new Font("Times New Roman", Font.BOLD, 20);
	// khoi tao account
	private String email = "truong@gmail.com";
	private String password = "truong123";
	// khoi tao dialog
	private JDialog dialogLogin;
	//khoi tao nhan thong bao trong dialog
	private Label lbnotify;

	// ghi de phuong thuc xu ly su kien
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			System.out.println(this.tfEmail.getText() + " || " + this.tfPassword.getText());
			if (this.tfEmail.getText().equals(this.email) && this.tfPassword.getText().equals(this.password)) {
				this.lbnotify.setText("login thanh cong");
			} else {
				this.lbnotify.setText("tai khoan khong chinh xac");
			}
			dialogLogin.pack();
			dialogLogin.setLocationRelativeTo(this);
			dialogLogin.setVisible(true);
		}

	}

	// ham khoi tao cua class
	public LoginJFrame(String title) {
		super(title);
		initComponents();
	}

	// ham khoi tao cac thanh phan
	@SuppressWarnings("deprecation")
	public void initComponents() {
		// thuoc tinh tat chuong trinh khi nhan x
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// khai bao panel
		Panel p1 = new Panel();
		p1.setLayout(null);
		p1.setBackground(new Color(243, 245, 246));
		// gan noi dung cua jframe la p1
		this.setContentPane(p1);
		// dat kich thuoc cua jframe
		this.setResizable(false);
		this.setSize(415, 300);
		this.setLocationRelativeTo(null);
		// khoi tao cac thanh phan
		lbTitle = new Label("Login Form");
		lbTitle.setFont(font1);
		lbTitle.setAlignment(Label.CENTER);

		lbEmail = new Label("Email");

		lbPassword = new Label("Password");

		tfEmail = new TextField();

		tfPassword = new TextField();
		tfPassword.setEchoCharacter('•');

		btnLogin = new Button("Login now");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(this);
		// dat vi tri hien thi tren form
		lbTitle.setBounds(100, 20, 200, 30);

		lbEmail.setBounds(50, 80, 100, 30);

		tfEmail.setBounds(150, 80, 200, 30);

		lbPassword.setBounds(50, 130, 100, 30);

		tfPassword.setBounds(150, 130, 200, 30);

		btnLogin.setBounds(50, 180, 300, 40);
		// them cac thanh phan vao p1
		p1.add(lbTitle);
		p1.add(lbEmail);
		p1.add(tfEmail);
		p1.add(lbPassword);
		p1.add(tfPassword);
		p1.add(btnLogin);

		// khoi tao hop thoai dialog
		dialogLogin = new JDialog(this, true);
		dialogLogin.setTitle("Notify");
		//khai bao panel 2
		Panel p2 = new Panel();
		p2.setLayout(new FlowLayout());
		//gan p2 lam noi dung dialog login
		dialogLogin.setContentPane(p2);
		//khai bao nhan hien thi thong bao
		p2.add(lbnotify = new Label());
	}
}
