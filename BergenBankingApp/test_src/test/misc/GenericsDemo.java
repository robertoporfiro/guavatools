package test.misc;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo<A> {
	
	static class Account{}
	
	static class SavingsAccount extends Account{}
	
	public void setupAccount(List<? extends Account> accounts){
		
	}
	
	public static void main(String[] args) {
		List<? extends Account> list = new ArrayList<Account>();
		GenericsDemo<Account> demo = new GenericsDemo<GenericsDemo.Account>();
		demo.setupAccount(new ArrayList<SavingsAccount>());
	}

}
