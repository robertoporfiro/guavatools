package test.banking.ui;

import java.io.Console;

/**
 * Provides basic CLI for the banking app
 * @author denny
 *
 */
public class BankingApp {

	static Console console = System.console();
	
	public static void main(String[] args) {
		if(console == null){
			console = System.console();
			System.out.println("Console: "+console);
		}
		boolean loggedIn = false;

		while(!loggedIn){
			prompt("Please enter your username");
			String user = console.readLine();
			prompt("Please enter your password");
			char[] pass= console.readPassword();
			
			loggedIn = login(user,pass);
		}
	}

	private static boolean login(String user, char[] pass) {
		if(user.equals("Peet")){
			return true;
		}
		return false;
	}

	private static void prompt(String string) {
		System.out.println("DennyBank: "+string);
		System.out.println(">");
	}
	
}
