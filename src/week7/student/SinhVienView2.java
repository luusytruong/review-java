package week7.student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class SinhVienView2 extends JFrame {

    private static final long serialVersionUID = 1L;
	JButton btnThem, btnSua, btnXoa, btnClear;
    JTextField txtID, txtHoten, txtDiachi, txtLop, txtNamsinh;
    JScrollPane tblPane;
    Panel southPane, textPane, buttonPane;
    JTable table;

    public void showListSinhVien(SinhVienTableModel sinhvienModel) {
        //table = new JTable(sinhvienModel);
        table.setModel(sinhvienModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);

        // System.out.println("chay showlistSinhVien");
        // thiet lap do rong cot cho Table
        //this.setLayout(new BorderLayout());
       // this.repaint();
    }
public void showSinhVien(SinhVien sv) {
        txtID.setText("" + sv.getId());
        txtHoten.setText(sv.getHoTen());
        txtDiachi.setText("" + sv.getDiaChi());
        txtLop.setText(sv.getTenLop());
        txtNamsinh.setText("" + sv.getNamSinh());
        // enable Edit and Delete buttons
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        // disable Add button
        btnThem.setEnabled(false);
    }
    public SinhVienView2() {
        table = new JTable();
        buttonPane = new Panel(new FlowLayout());
        btnThem = new JButton("Thêm");
        //btnThem.addActionListener(this);
        btnSua = new JButton("Sửa");
        //btnSua.addActionListener(this);
        btnXoa = new JButton("Xóa");
        // btnXoa.addActionListener(this);
        btnClear = new JButton("Clear");
        // btnHuy.addActionListener(this);     
        buttonPane.add(btnThem);
        buttonPane.add(btnSua);
        buttonPane.add(btnXoa);
        buttonPane.add(btnClear);        
        textPane = new Panel(new GridLayout(5, 2));
        txtID = new JTextField(5);
        txtHoten = new JTextField(15);
        txtDiachi = new JTextField(15);
        txtLop = new JTextField(10);
        txtNamsinh = new JTextField(15);
        textPane.add(new JLabel("ID:"));
        textPane.add(txtID);
        txtID.setEnabled(false);
        textPane.add(new JLabel("Họ Tên:"));
        textPane.add(txtHoten);
        textPane.add(new JLabel("Dia Chi:"));
        textPane.add(txtDiachi);
        textPane.add(new JLabel("Lớp:"));
        textPane.add(txtLop);
        textPane.add(new JLabel("Nam Sinh"));
        textPane.add(txtNamsinh);
        //ButtonJTextFieldControl(0);
        southPane = new Panel(new BorderLayout());
        southPane.add(buttonPane, BorderLayout.NORTH);
        southPane.add(textPane, BorderLayout.CENTER);
        //this.getContentPane().add(tblPane, BorderLayout.CENTER);
        tblPane = new JScrollPane(table);
        this.getContentPane().add(tblPane, BorderLayout.CENTER);
        this.getContentPane().add(southPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
    }

    public void fillSinhVienFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtID.setText(table.getModel().getValueAt(row, 0).toString());
            txtHoten.setText(table.getModel().getValueAt(row, 1).toString());
            txtDiachi.setText(table.getModel().getValueAt(row, 2).toString());
            txtLop.setText(table.getModel().getValueAt(row, 3).toString());
            txtNamsinh.setText(table.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            btnThem.setEnabled(false);
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
            btnClear.setEnabled(true);
           
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void clearSinhVientInfo() {
        txtID.setText("");
        txtHoten.setText("");
        txtDiachi.setText("");
        txtLop.setText("");
        txtNamsinh.setText("");
        // disable Edit and Delete buttons
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        // enable Add button
        btnThem.setEnabled(true);
    }

    public SinhVien getSinhVienInfo() {
        // validate student        
        try {
            SinhVien sv = new SinhVien();
            if (txtID.getText() != null && !"".equals(txtID.getText())) {
                sv.setId(Integer.parseInt(txtID.getText()));
            }
            sv.setHoTen(txtHoten.getText().trim());
            sv.setDiaChi(txtDiachi.getText().trim());
            sv.setTenLop(txtLop.getText().trim());
            sv.setNamSinh(txtNamsinh.getText().trim());
            return sv;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public void addInsertSinhVientListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    public void addUpdateSinhVienListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    public void addDeleteSinhVientListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
        //   System.out.println("run delete");
    }
    public void addClearSinhVientListener(ActionListener listener) {
        btnClear.addActionListener(listener);
        //   System.out.println("run delete");
    }

    public void addListSinhVienSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}
