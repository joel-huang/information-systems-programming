// Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.Date;

public class Account {

	public int id = 0;
	public double balance = 0;
	public double annualInterestRate = 0;
	public Date dateCreated;

	// No-arg constructor.
	Account() {

		this.dateCreated = new Date();

		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	// Args constructor.
	Account(int inputID, double inputBalance) {
		this.id = inputID;
		this.balance = inputBalance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}

	// Mutator methods for ID, balance, and annualInterestRate.
	public void setID (int newID) {
		this.id = newID;
	}

	public void setBalance (double newBalance) {
		this.balance = newBalance;
	}

	public void setAnnualInterestRate(double newAnnualInterestRate) {
		this.annualInterestRate = newAnnualInterestRate;
	}

	// Accessor methods.
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public int getID() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	// Returns the monthly interest rate
	public double getMonthlyInterestRate() {
		double rate = getAnnualInterestRate()/12;
		return rate;
	}

	// Returns the monthly interest
	public double getMonthlyInterest() {
		double interest = this.balance * this.getMonthlyInterestRate()/100;
		return interest;
	}

	// Withdraws a double from the balance.
	public void withdraw(double withdrawAmount) {
		this.balance -= withdrawAmount;
	}

	// Deposits a double to the balance.
	public void deposit(double depositAmount) {
		this.balance += depositAmount;
	}
}




//===============================================
// test case
//===============================================

/*

public class TestAccount{
  public static void main (String[] args) {
    Account account = new Account(1122, 20000);
    Account.setAnnualInterestRate(4.5);
    
    account.withdraw(2500);
    account.deposit(3000);
    System.out.println("Balance is " + account.getBalance());
    System.out.println("Monthly interest is " +
      account.getMonthlyInterest());
  }	
}

Expected output

Balance is 20500.0
Monthly interest is 76.875

*/

