package test.banking.threading;

import java.util.Stack;

public class WaitNotifyDemo {
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) throws InterruptedException {
		pull();
		populateStack();
	}

	private static void pull() {
		Thread t = new Thread(){
			public void run(){
		
				while(true){
					if(stack.isEmpty()){
						System.out.println("Stack is empty. Waiting...");
						synchronized (stack) {
							try {
								stack.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}		
					synchronized (stack) {
						Integer value = stack.pop();
						System.out.println(value);
					}
				
				}
			}
		};
		t.start();
	}

	private static void populateStack() throws InterruptedException {
		while (true) {
			Thread.sleep(3000);
			synchronized (stack) {
				stack.push(1);
				stack.push(2);
				stack.push(3);
				stack.notifyAll();
			}
		}
	}
}
