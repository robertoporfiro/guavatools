package john.db;

import java.io.Serializable;

public class JardenAccountVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private double balance;

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
