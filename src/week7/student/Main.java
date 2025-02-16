package week7.student;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {

        try {
            SinhVienimplDAO sinhVienDAO = new SinhVienimplDAO();
            SinhVienTableModel sinhvienModel = new SinhVienTableModel(sinhVienDAO.getAll());
            SinhVienView2 sinhvienView = new SinhVienView2();
            SinhVienController2 controller = new SinhVienController2(sinhvienView, sinhvienModel);
            controller.showSinhVienView();
        } catch (SQLException e) {
            // sinhvienView.showMessage(e.toString());
        }
    }
}