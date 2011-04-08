package test.banking.threading;

import java.util.Stack;

public class WaitNotifyDemo {
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) throws InterruptedException {
		populateStack();
		pull();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	private static void pull() throws InterruptedException {
		while(true){
			synchronized (stack) {
				if(stack.isEmpty()){
					System.out.println("Stack is empty. Waiting...");
					stack.wait();
				}		
				System.out.println(stack.pop());
			}
		}
	}

	private static void populateStack() throws InterruptedException {
			Thread.sleep(3000);
			synchronized (stack) {
				stack.push(1);
				stack.push(2);
				stack.push(3);
				stack.notify();
		}
	}
}
