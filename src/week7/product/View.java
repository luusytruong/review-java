package week7.product;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

class NumberFilter extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
        }
    }
}

public class View extends JFrame {
    private static final long serialVersionUID = 1L;
	private JTable table;
    private JButton btnAdd, btnEdit, btnDelete;
    private JTextField txtId, txtName, txtPrice, txtStock;

    public View() {
        super("Quan ly san pham");
    }

    public void initComponents() {
        JPanel p1 = new JPanel(new GridLayout(4, 2));
        p1.setBorder(new EmptyBorder(8, 8, 8, 8));

        txtId = new JTextField();
        txtName = new JTextField();
        txtPrice = new JTextField();
        txtStock = new JTextField();

        txtId.setEnabled(false);
        txtPrice.addKeyListener(new NumberFilter());
        txtStock.addKeyListener(new NumberFilter());

        p1.add(new JLabel("Ma san pham"));
        p1.add(txtId);
        p1.add(new JLabel("Ten san pham"));
        p1.add(txtName);
        p1.add(new JLabel("Gia"));
        p1.add(txtPrice);
        p1.add(new JLabel("So luong"));
        p1.add(txtStock);

        JPanel p2 = new JPanel();
        btnAdd = new JButton("Them");
        btnEdit = new JButton("Sua");
        btnDelete = new JButton("Xoa");

        btnAdd.setActionCommand("CREATE");
        btnEdit.setActionCommand("UPDATE");
        btnDelete.setActionCommand("DELETE");

        btnAdd.addActionListener(Controller.getInstance());
        btnEdit.addActionListener(Controller.getInstance());
        btnDelete.addActionListener(Controller.getInstance());

        p2.add(btnAdd);
        p2.add(btnEdit);
        p2.add(btnDelete);

        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p1, BorderLayout.SOUTH);
        p3.add(p2, BorderLayout.CENTER);

        add(p3, BorderLayout.SOUTH);

        table = new JTable();

        table.addMouseListener(Controller.getInstance());

        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Danh sach san pham", 2, 2));

        add(sp, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Product getObj() {
        int id = txtId.getText() != null && !txtId.getText().isBlank() ? Integer.parseInt(txtId.getText()) : 0;
        String name = txtName.getText() != null && !txtName.getText().isBlank() ? txtName.getText() : null;
        int price = txtPrice.getText() != null && !txtPrice.getText().isBlank() ? Integer.parseInt(txtPrice.getText())
                : 0;
        int stock = txtStock.getText() != null && !txtStock.getText().isBlank() ? Integer.parseInt(txtStock.getText())
                : 0;
        return new Product(id, name, price, stock);
    }

    public void render(DefaultTableModel model) {
        table.setModel(model);
    }

    public void setDataToField(Object[] obj) {
        txtId.setText(obj[0].toString());
        txtName.setText(obj[1].toString());
        txtPrice.setText(obj[2].toString());
        txtStock.setText(obj[2].toString());
    }

    public void clearDataFromField() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtStock.setText("");
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }
}
