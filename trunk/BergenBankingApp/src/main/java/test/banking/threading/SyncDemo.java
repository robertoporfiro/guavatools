package test.banking.threading;

import java.util.Random;

import test.banking.Account;
import test.banking.CheckingAccount;

public class SyncDemo {

	Random random = new Random();
	public static void main(String[] args) {
		SyncDemo demo = new SyncDemo();
		demo.launch();
	}

	private void launch() {
		Account a = new CheckingAccount("1234");
		a.credit(300);
		AccountDebiter accountDebiter = new AccountDebiter(a);
		Thread debiter = new Thread(accountDebiter);
		Thread debiter2 = new Thread(accountDebiter);
		debiter.start();
		debiter2.start();
		
	}


	private void pause(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class AccountDebiter implements Runnable{
		private Account a;
		public AccountDebiter(Account a){
			this.a = a;
			
		}
		public void run() {
			while(true){
				a.debit(random.nextInt(100));
				pause(2);
				System.out.println("Balance: "+a.getBalance());
			}
		}

	}
	
}
