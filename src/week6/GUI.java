package week6;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener, MouseListener {
    private JTable table;
    private JTextField tfID, tfFullName, tfAge, tfPhoneNumber;
    private Choice cAddress;
    private JButton btnLoad, btnSave, btnAdd, btnDelete;

    private GridBagConstraints gbc = new GridBagConstraints();

    private ArrayList<Student> students = new ArrayList<>();
    private int lastRow = -1;

    public GUI(String title) {
        super(title);
        initComponents();
    }

    public void properties(int x, int y, int top, int left, int bottom, int right) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(top, left, bottom, right);
    }

    public void initComponents() {
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel p1 = new JPanel(new GridBagLayout());

        JLabel lb1 = new JLabel("ID");
        properties(0, 0, 12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(lb1, gbc);

        tfID = new JTextField(20);
        tfID.setEnabled(false);
        properties(1, 0, 12, 0, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(tfID, gbc);

        JLabel lb2 = new JLabel("Full name");
        properties(2, 0, 12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(lb2, gbc);

        tfFullName = new JTextField(20);
        properties(3, 0, 12, 0, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(tfFullName, gbc);

        JLabel lb12 = new JLabel("Age");
        properties(0, 1, 12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(lb12, gbc);

        tfAge = new JTextField(20);
        properties(1, 1, 12, 0, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(tfAge, gbc);

        JLabel lb4 = new JLabel("Phone number");
        properties(2, 1, 12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(lb4, gbc);

        tfPhoneNumber = new JTextField(20);
        properties(3, 1, 12, 0, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(tfPhoneNumber, gbc);

        JLabel lb5 = new JLabel("Address");
        properties(0, 2, 12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(lb5, gbc);

        cAddress = new Choice();
        cAddress.add("Thai Nguyen");
        cAddress.add("Bac Kan");
        cAddress.add("Thai Binh");
        cAddress.add("Phu Luong");
        cAddress.add("Phu Binh");
        cAddress.add("Bac Giang");
        cAddress.add("Vinh Phuc");
        properties(1, 2, 12, 0, 12, 12);
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        p1.add(cAddress, gbc);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));

        btnLoad = new JButton("Load Data");
        btnLoad.addActionListener(this);
        p2.add(btnLoad);

        btnAdd = new JButton("Add New");
        btnAdd.addActionListener(this);
        p2.add(btnAdd);

        btnSave = new JButton("Save Data");
        btnSave.addActionListener(this);
        p2.add(btnSave);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        p2.add(btnDelete);

        properties(0, 3, 0, 12, 12, 12);
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        p1.add(p2, gbc);

        table = new JTable();
        table.addMouseListener(this);
        JScrollPane jScrollPane = new JScrollPane(table);

        this.add(p1, BorderLayout.NORTH);
        this.add(jScrollPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.pack();
        this.setLocationRelativeTo(null);

    }

    public void showDataGetAll() throws SQLException {
        students = StudentDAO.getInstance().getAll();
        String[] columnNames = { "Ma SV", "Ho va ten", "Tuoi", "So dien thoai", "Dia chi" };
        String[][] data = new String[students.size()][columnNames.length];

        for (int i = 0; i < students.size(); i++) {
            data[i][0] = Integer.toString(students.get(i).getId());
            data[i][1] = students.get(i).getFullName();
            data[i][2] = Integer.toString(students.get(i).getAge());
            data[i][3] = students.get(i).getPhoneNumber();
            data[i][4] = students.get(i).getAddress();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);

        showDataToField(0);
    }

    public String[] getDataClicked(int rowID) {
        int columnCount = table.getColumnCount();
        String[] student = new String[columnCount];

        student[0] = Integer.toString(students.get(rowID).getId());
        student[1] = students.get(rowID).getFullName();
        student[2] = Integer.toString(students.get(rowID).getAge());
        student[3] = students.get(rowID).getPhoneNumber();
        student[4] = students.get(rowID).getAddress();
        System.out.println(Arrays.toString(student));
        return student;
    }

    public void showDataToField(int rowID) {
        String[] student = getDataClicked(rowID);

        tfID.setText(student[0]);
        tfFullName.setText(student[1]);
        tfAge.setText(student[2]);
        tfPhoneNumber.setText(student[3]);
        cAddress.select(student[4]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Object source = e.getSource();
            if (source == btnLoad) {
                System.out.println("load");
                showDataGetAll();
            } else if (source == btnAdd) {
                System.out.println("add");
            } else if (source == btnSave) {
                System.out.println("save");
            } else if (source == btnDelete) {
                System.out.println("delete");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == table) {
            int rowID = table.getSelectedRow();
            if (rowID != lastRow) {
                showDataToField(rowID);
                lastRow = rowID;
            }
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
}
