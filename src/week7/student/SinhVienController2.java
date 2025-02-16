package week7.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class SinhVienController2 {

    SinhVienimplDAO DAO;
    private SinhVienTableModel sinhvienModel;
    private SinhVienView2 sinhvienView;

    public SinhVienController2(SinhVienView2 _sinhvienView, SinhVienTableModel _sinhvienModel) {
        this.sinhvienView = _sinhvienView;
        sinhvienModel = _sinhvienModel;
        DAO = new SinhVienimplDAO();
    }

    public void showSinhVienView() {
            sinhvienView.showListSinhVien(sinhvienModel);
            sinhvienView.addListSinhVienSelectionListener(new ListStudentSelectionListener());
            sinhvienView.addDeleteSinhVientListener(new DeleteStudentListener());
            sinhvienView.addUpdateSinhVienListener(new UpdateSinhVienListener());
            sinhvienView.addInsertSinhVientListener(new InsertSinhVientListener());
            sinhvienView.addClearSinhVientListener(new ClearStudentListener());
            sinhvienView.setVisible(true);
            sinhvienView.setEnabled(true);
            } 
   

        class ListStudentSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                sinhvienView.fillSinhVienFromSelectedRow();
            }
        }

        class ClearStudentListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                sinhvienView.clearSinhVientInfo();
            }
        }

        class InsertSinhVientListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                SinhVien sv = sinhvienView.getSinhVienInfo();
                if (sv != null) {
                    try {
                        DAO.insert(sv);
                        sinhvienView.clearSinhVientInfo();
                        sinhvienView.showListSinhVien(new SinhVienTableModel(DAO.getAll()));
                       
                        sinhvienView.showMessage("Thêm thành công!");
                    } catch (SQLException e1) {
                        sinhvienView.showMessage(e1.toString());
                    }
                }
            }
        }

        class DeleteStudentListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                SinhVien sv = sinhvienView.getSinhVienInfo();

                if (sv != null) {
                    try {
                        DAO.Delete(sv);
                        sinhvienView.clearSinhVientInfo();
                        ArrayList<SinhVien> ds = DAO.getAll();
                        if (ds != null) {
                            sinhvienView.showListSinhVien(new SinhVienTableModel(ds));
                        } else {
                            sinhvienView.showMessage("Dữ liệu rỗng");
                        }
                        sinhvienView.showMessage("Xóa thành công!");
                    } catch (SQLException e1) {
                        sinhvienView.showMessage(e1.toString());
                    }
                }
            }
        }
            class UpdateSinhVienListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    SinhVien sv = sinhvienView.getSinhVienInfo();
                    if (sv != null) {
                        try {
                            DAO.update(sv);
                            // sinhvienView.showStudent(sv);
                            sinhvienView.showListSinhVien(new SinhVienTableModel(DAO.getAll()));
                            sinhvienView.showMessage("Cập nhật thành công!");
                        } catch (SQLException e1) {
                            sinhvienView.showMessage(e1.toString());
                        }
                    } 
                }
            }
        }
    