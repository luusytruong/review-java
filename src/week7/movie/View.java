package week7.movie;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    private JTable table;
    private JTextField tfId, tfTitle, tfDirector, tfYear;
    private JComboBox<String> cbType;
    private JButton btnInsert, btnUpdate, btnDelete;

    private static View instance;

    private View() {
        super("Quan ly phim");
    }

    public synchronized static View getInstance() {
        // nếu thể hiện chưa được tạo, khởi tạo
        if (instance == null) {
            instance = new View();
        }
        // trả về thể hiện
        return instance;
    }

    public void initComponents() {
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        p1.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        tfId = new JTextField();
        tfId.setEnabled(false);

        tfTitle = new JTextField();
        tfDirector = new JTextField();

        tfYear = new JTextField();
        tfYear.addKeyListener(Controller.getInstance());
        
        cbType = new JComboBox<>();
        cbType.addItem("Hoat hinh");
        cbType.addItem("Sieu nhan");

        p1.add(new JLabel("Ma Phim"));
        p1.add(tfId);
        p1.add(new JLabel("Ten phim"));
        p1.add(tfTitle);
        p1.add(new JLabel("Dao dien"));
        p1.add(tfDirector);
        p1.add(new JLabel("Phat hanh"));
        p1.add(tfYear);
        p1.add(new JLabel("The loai"));
        p1.add(cbType);

        JPanel p2 = new JPanel();

        btnInsert = new JButton("Them");
        btnUpdate = new JButton("Sua");
        btnDelete = new JButton("Xoa");

        btnInsert.setActionCommand("INSERT");
        btnUpdate.setActionCommand("UPDATE");
        btnDelete.setActionCommand("DELETE");

        btnInsert.addActionListener(Controller.getInstance());
        btnUpdate.addActionListener(Controller.getInstance());
        btnDelete.addActionListener(Controller.getInstance());

        p2.add(btnInsert);
        p2.add(btnUpdate);
        p2.add(btnDelete);

        JPanel p3 = new JPanel(new BorderLayout());

        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.CENTER);

        table = new JTable();
        table.addMouseListener(Controller.getInstance());
        JScrollPane sp = new JScrollPane(table);

        add(p3, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);

        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(DefaultTableModel model) {
        table.setModel(model);
    }

    public int getRowClicked() {
        return table.getSelectedRow();
    }

    public void setDataToField(Object[] movie) {
        tfId.setText(movie[0].toString());
        tfTitle.setText(movie[1].toString());
        tfDirector.setText(movie[2].toString());
        tfYear.setText(movie[3].toString());
        cbType.setSelectedItem(movie[4].toString());
    }
    // public void setDataToField(Movie movie) {
    // tfId.setText(Integer.toString(movie.getId()));
    // tfTitle.setText(movie.getTitle());
    // tfDirector.setText(movie.getDirector());
    // tfYear.setText(movie.getYear());
    // cbType.setSelectedItem(movie.getType());
    // }

    public Movie getMovie() {
        if (tfTitle.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong Ten phim", "Thong bao", 0);
            return null;
        }
        if (tfDirector.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong Ten tac gia", "Thong bao", 0);
            return null;
        }
        if (tfYear.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong nam phat hanh", "Thong bao", 0);
            return null;
        }
        return new Movie(
                tfId.getText().isBlank() ? 0 : Integer.parseInt(tfId.getText()),
                tfTitle.getText(),
                tfDirector.getText(),
                tfYear.getText(),
                cbType.getSelectedItem().toString());
    }
}
