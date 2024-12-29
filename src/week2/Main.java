package week2;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	public static void showAll(ArrayList<User> list) {
		System.out.println("===================show=========================================================");
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("===================endl=========================================================");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		showAll(userDAO.getAll());
		User newUser = new User("daovanngoc", "rau123", "rau@gmail.com");
		int key = userDAO.insert(newUser);
		showAll(userDAO.getAll());
		User updateUser = new User("nguyenchieungu", "chiuhihi", "hihi@gmail.com");
		userDAO.update(updateUser, key);
		showAll(userDAO.getAll());
		userDAO.delete(key);
		showAll(userDAO.getAll());
	}
}
