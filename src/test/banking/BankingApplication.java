package test.banking;

import java.util.Date;

public class BankingApplication {

	static boolean showtime = true;
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while(showtime){
					printHi();
					pause(800);
				}
			}
			
		};
		Thread t = new Thread(runnable);
		t.start();
		
		while(showtime ){
			System.out.println("The time is: "+ new Date());
			pause(1000);
		}
		System.out.println("End");
	}

	private static void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printHi(){
		System.out.println("        HI!!!!!");
	}
}
