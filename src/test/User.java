package test;

public class User {
	private int ID;
	private String username;
	private String password;
	private String email;

	public User(int iD, String username, String password, String email) {
		ID = iD;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
