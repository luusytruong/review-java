package swingdesign;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyJFrame frame = new MyJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyJFrame() {
		setBackground(new Color(243, 245, 246));
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(243, 245, 246));
		GridBagConstraints gbConstraints = new GridBagConstraints();
		gbConstraints.fill = GridBagConstraints.HORIZONTAL;
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel innerPane = new JPanel();
		innerPane.setBorder(UIManager.getBorder("Button.border"));
		innerPane.setBackground(new Color(255, 255, 255));
		innerPane.setBounds(160, 110, 290, 126);
		innerPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		contentPane.add(innerPane);
		innerPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 14, 58, 18);
		innerPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPassword.setBounds(15, 56, 53, 18);
		innerPane.add(lblPassword);

		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setBounds(78, 11, 200, 24);
		textField.setColumns(10);
		innerPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(78, 53, 200, 24);
		innerPane.add(textField_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 88, 268, 26);
		innerPane.add(btnNewButton);
	}
}
