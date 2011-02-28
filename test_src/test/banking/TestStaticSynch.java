package test.banking;

import java.util.Date;

public class TestStaticSynch {

	
	public static void main(String[] args) throws InterruptedException {
		getLockOnClass();
		attemptToGetLockOnClass();
	}

	private static void attemptToGetLockOnClass() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("attempting to get lock");
		synchronized (new Date()) {
			System.out.println("Got lock");
		}
	}

	private static void getLockOnClass() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				synchronized (Date.class) {
					try {
						System.out.println("wait for 5 secs");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("Interrunpted: "+e);
					}
					System.out.println("wait period finished");
				}
				
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}
