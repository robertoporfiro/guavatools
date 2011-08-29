package test.banking;

public class SavingsAccount extends Account {

	protected static final long serialVersionUID = 1L;
	
	private double interestRate;

	public void setInterestRate(double d) {
		if(d<0.0){
			throw new InterestException(" rate is smaller than zero");
	 	}
		this.interestRate = d;
	}

	public SavingsAccount(String accountNumber) {
		super(accountNumber);
	}



	public double getInterestRate() {
		return interestRate;
	}

	public void applyInterest() {
		balance = this.getBalance() * (interestRate/365)	;	
	}

}
