package week3;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
    public ArrayList<T> getAll() throws SQLException;

    public void insert(T obj) throws SQLException;

    public void update(T obj, int id) throws SQLException;

    public void delete(int id) throws SQLException;
}
