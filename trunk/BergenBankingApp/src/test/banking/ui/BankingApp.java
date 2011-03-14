package test.banking.ui;

import java.io.Console;

import test.banking.Account;
import test.banking.AccountService;
import test.banking.AccountServiceFactory;

/**
 * Provides basic CLI for the banking app
 * @author denny
 *
 */
public class BankingApp {

	private static final String CREDIT_COMMAND = "credit";
	private static final String DETAIL_STRING = "detail";
	Console console = System.console();
	private boolean showtime = true;
	private AccountService accountService = AccountServiceFactory.getAccountService();
	
	public static void main(String[] args) {
		BankingApp app = new BankingApp();
		app.launch();
	}

	private void launch() {
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
		
		while(showtime ){
			prompt("Please enter an action (list, add, detail, exit)");
			String action=console.readLine();
			performAction(action);
		}
	}

	private void performAction(String action) {
		action = action.trim();
		if(action.equalsIgnoreCase("list")){
			printAccountDetails();
		}
		if(action.equalsIgnoreCase("exit")){
			exit();
		}
		if(action.contains(DETAIL_STRING)){
			getDetails(action);
		}
	}

	private void getDetails(String request) {
		String accNo = getNonCommandPortion(request, DETAIL_STRING);
		Account account = accountService.getAccountByNumber(accNo);
		if(account != null){
			runDetailsLoop(account);
		}else{
			System.out.println("No account could be found with number "+accNo);
		}
	}

	private void runDetailsLoop(Account account) {
		boolean runDetailsLoop=true;
		while(runDetailsLoop){
			System.out.println(account);
			prompt("What would you like to do now? (debit, credit, back)");
			String command = console.readLine();
			if(command.contains(CREDIT_COMMAND)){
				String amount = getNonCommandPortion(command, CREDIT_COMMAND);
				System.out.println("crediting accou8nt by GBP"+amount);
				double amtAsNumber = Double.parseDouble(amount);
				account.credit(amtAsNumber);
			}
			if(command.contains("back")){
				runDetailsLoop=false;
			}
		}
	}

	private String getNonCommandPortion(String request, String command) {
		return request.replace(command, "").trim();
	}

	private void exit() {
		System.out.println("Thanks for banking with DennyBank");
		System.exit(0);
	}

	private void printAccountDetails() {
		System.out.println("----Printin all account details-----");
		for(Account account: accountService.getAccounts()){
			System.out.println(account);
		}
	}

	private boolean login(String user, char[] pass) {
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
