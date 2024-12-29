package week2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
	public ArrayList<User> getAll() throws SQLException, ClassNotFoundException;
	public int insert(User user) throws SQLException, ClassNotFoundException;
	public void update(User user, int id) throws SQLException, ClassNotFoundException;
	public void delete(int id) throws SQLException, ClassNotFoundException;
}
