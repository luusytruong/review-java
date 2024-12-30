package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

@SuppressWarnings("unused")
public class MyJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JDialog jDialog = new MyJDialog();

	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel lbTitle;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnLogin;

	private Font fontBigBold = new Font("Calibri", Font.BOLD, 20);
	private Font fontNormal = new Font("Calibri", Font.PLAIN, 14);

	public MyJFrame() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public <T extends JComponent> void properties(int x, int y, int w, int top, int left, int bot, int right, Font font,
			T com) {
		com.setFont(font);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.insets = new Insets(top, left, bot, right);
		add(com, gbc);
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login form");
		setLayout(new GridBagLayout());

		// init, append component
		gbc.fill = GridBagConstraints.HORIZONTAL;

		lbTitle = new JLabel("Login Form");
		lbTitle.setFont(fontBigBold);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		properties(0, 0, 2, 12, 12, 12, 12, fontBigBold, lbTitle);

		lbUsername = new JLabel("Username");
		lbUsername.setFont(fontNormal);
		properties(0, 1, 1, 4, 12, 4, 12, fontNormal, lbUsername);

		txtUsername = new JTextField(16);
		txtUsername.setFont(fontNormal);
		properties(1, 1, 1, 4, 12, 4, 12, fontNormal, txtUsername);

		lbPassword = new JLabel("Password");
		lbPassword.setFont(fontNormal);
		properties(0, 2, 1, 4, 12, 4, 12, fontNormal, lbPassword);

		txtPassword = new JPasswordField(16);
		txtPassword.setFont(fontNormal);
		properties(1, 2, 1, 4, 12, 4, 12, fontNormal, txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setFont(fontNormal);
		btnLogin.setPreferredSize(new Dimension(0, 28));
		btnLogin.setBackground(Color.white);
		btnLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		properties(0, 3, 2, 12, 12, 12, 12, fontNormal, btnLogin);
		btnLogin.addActionListener(e->{
			System.out.println(txtPassword.getText());
		});
	}
}
