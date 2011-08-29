package test.banking.threading;

public class ThreadDemo {

	
	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRunnable = new MyRunnable();
		
		Thread t1 = new Thread(myRunnable,"Thread A");
		Thread t2 = new Thread(myRunnable,"Thread B");
		t1.start();
		t2.start();
		
		System.out.println("Exiting Main Thread");
	}
	
	
	static class MyRunnable implements Runnable{
		private boolean showtime=true;

		@Override
		public void run() {
			int invocationCount=0;
			while(invocationCount < 10){
				invocationCount++;
				System.out.println(invocationCount+ ": Hello from: "+Thread.currentThread().getName());
				if(Thread.currentThread().getName().equals("Thread A") && invocationCount %2 == 0){
					Thread.yield();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//ignore
				}
			}
		}
		
		public void stop(){
			System.out.println("Shutting down");
			showtime = false;
		}
	}
}
