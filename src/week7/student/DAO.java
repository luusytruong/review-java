package week7.student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DAO {
    public ArrayList<SinhVien> getAll()throws SQLException;
    public void insert(SinhVien sv)throws SQLException;
    public void update(SinhVien sv)throws SQLException;
    public boolean Delete(SinhVien sv)throws SQLException;
    public SinhVien findByID(int id)throws SQLException;
    public SinhVien findByName(String name)throws SQLException;
}