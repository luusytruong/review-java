package week2;

import java.text.MessageFormat;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;

	public User() {
	}

	// constructor full
	public User(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// constructor without id
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String toString() {
		return MessageFormat.format("id: {0}, username: {1}, password: {2}, email: {3}", id, username, password, email);
	}
}
