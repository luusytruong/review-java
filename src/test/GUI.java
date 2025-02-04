package test;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	private TextField tfID, tfUsername, tfPassword, tfEmail;
	private Button btnAddNew, btnSave, btnDelete;
	private JTable table;

	private static GUI instance;

	private ArrayList<User> users;
	private int lastRow = 0;

	public GUI(String title) {
		super(title);
		initComponents();
	}

	public static synchronized GUI getInstance() {
		if (instance == null) {
			instance = new GUI("User Managent");
		}
		return instance;
	}

	public void initComponents() {
		Panel p1 = new Panel(new FlowLayout(FlowLayout.CENTER, 12, 12));
		Panel p2 = new Panel(new GridLayout(4, 2));
		Panel p3 = new Panel(new FlowLayout(FlowLayout.CENTER, 12, 0));
		Panel p4 = new Panel(new FlowLayout(FlowLayout.CENTER, 12, 12));

		Label lbId = new Label("ID");
		p2.add(lbId);
		tfID = new TextField(20);
		tfID.setEnabled(false);
		p2.add(tfID);

		Label lbUsername = new Label("Username");
		p2.add(lbUsername);
		tfUsername = new TextField();
		p2.add(tfUsername);

		Label lbPassword = new Label("Password");
		p2.add(lbPassword);
		tfPassword = new TextField();
		p2.add(tfPassword);

		Label lbEmail = new Label("Email");
		p2.add(lbEmail);
		tfEmail = new TextField();
		p2.add(tfEmail);

		btnAddNew = new Button("Add New");
		btnAddNew.addActionListener(this);
		p3.add(btnAddNew);

		btnSave = new Button("Save");
		btnSave.addActionListener(this);
		p3.add(btnSave);

		btnDelete = new Button("Delete");
		btnDelete.addActionListener(this);
		p3.add(btnDelete);

		table = new JTable();
		table.addMouseListener(this);
		JScrollPane jScrollPane = new JScrollPane(table);

		p1.add(p2);
		p4.add(jScrollPane);

		add(p1, BorderLayout.NORTH);
		add(p3, BorderLayout.CENTER);
		add(p4, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public String[] getDataClicked(int rowIndex) {
		int columnCount = table.getColumnCount();
		String[] user = new String[columnCount];

		user[0] = Integer.toString(users.get(rowIndex).getID());
		user[1] = users.get(rowIndex).getUsername();
		user[2] = users.get(rowIndex).getPassword();
		user[3] = users.get(rowIndex).getEmail();

		return user;
	}

	public void showDataClicked(int rowIndex) {
		String[] user = getDataClicked(rowIndex);

		if (user.length > 0) {
			tfID.setText(user[0]);
			tfUsername.setText(user[1]);
			tfPassword.setText(user[2]);
			tfEmail.setText(user[3]);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		if (rowIndex != lastRow) {
			showDataClicked(rowIndex);
			lastRow = rowIndex;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void showDataGetAll() {
		users = UserDAO.getInstance().getAll();

		if (users == null) {
			return;
		}

		if (users.isEmpty()) {
			JOptionPane.showMessageDialog(GUI.getInstance(), "Khong co du lieu", "Thong bao", 1);
			return;
		}

		String[] columnNames = { "ID", "Ten nguoi dung", "Mat khau", "Email" };
		String[][] data = new String[users.size()][columnNames.length];

		for (int i = 0; i < users.size(); i++) {
			data[i][0] = Integer.toString(users.get(i).getID());
			data[i][1] = users.get(i).getUsername();
			data[i][2] = users.get(i).getPassword();
			data[i][3] = users.get(i).getEmail();
		}

		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		table.setModel(model);

		try {
			showDataClicked(lastRow);
		} catch (Exception e) {
			showDataClicked(0);
		}
	}

	public User getUser(boolean id) {
		if (id) {
			return new User(Integer.parseInt(tfID.getText()), tfUsername.getText(), tfPassword.getText(),
					tfEmail.getText());
		}
		return new User(tfUsername.getText(), tfPassword.getText(), tfEmail.getText());
	}

	public void actionCRUD(int option) {
		if (option == 3) {
			if (tfID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui long chon mot User", "Thong bao", 1);
				return;
			}

			int choose = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?", "Thong bao",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				UserDAO.getInstance().delete(getUser(true));
			}
		}
		if (option == 2) {
			if (tfID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui long chon mot User", "Thong bao", 1);
				return;
			}

			UserDAO.getInstance().update(getUser(true));
		}
		if (tfUsername.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Username khong duoc bo trong", "Thong bao", 1);
			return;
		}

		if (tfPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Password khong duoc bo trong", "Thong bao", 1);
			return;
		}

		if (tfEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Email khong duoc bo trong", "Thong bao", 1);
			return;
		}

		if (option == 1) {
			UserDAO.getInstance().insert(getUser(false));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnAddNew) {
				System.out.println("add new");
				actionCRUD(1);
			} else if (e.getSource() == btnSave) {
				System.out.println("save");
				actionCRUD(2);
			} else if (e.getSource() == btnDelete) {
				System.out.println("delete");
				actionCRUD(3);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
