package week7.movie;

import java.sql.*;
import java.util.*;

public class MovieDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String sqlGetAll = "select * from movies";
	private String sqlInsert = "insert into movies (title, director, year, type) values (?,?,?,?)";
	private String sqlUpdate = "update movies set title=?, director=?, year=?, type=? where id=?";
	private String sqlDelete = "delete from movies where id=?";

	public List<Movie> getAll() {
		List<Movie> movies = new ArrayList<>();
		conn = DataSource.getInstance().getConn();
		if (conn == null) {
			return movies;
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlGetAll);
			while (rs.next()) {
				movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSource.getInstance().closeResource(rs, stmt, pstmt, conn);
		}
		return movies;
	}

	public boolean insert(Movie movie) {
		conn = DataSource.getInstance().getConn();
		if (conn == null) {
			return false;
		}
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getYear());
			pstmt.setString(4, movie.getType());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DataSource.getInstance().closeResource(rs, stmt, pstmt, conn);
		}
	}

	public boolean update(Movie movie) {
		conn = DataSource.getInstance().getConn();
		if (conn == null) {
			return false;
		}
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getYear());
			pstmt.setString(4, movie.getType());
			pstmt.setInt(5, movie.getId());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DataSource.getInstance().closeResource(rs, stmt, pstmt, conn);
		}
	}

	public boolean delete(int id) {
		conn = DataSource.getInstance().getConn();
		if (conn == null) {
			return false;
		}
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DataSource.getInstance().closeResource(rs, stmt, pstmt, conn);
		}
	}
}