// Question 3
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================
import java.util.Date;

public class CheckingAccount extends Account{

	public double overdraft = 5000;

	// No-arg constructor.
	CheckingAccount() {

		this.dateCreated = new Date();

		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	// Args constructor.
	CheckingAccount(int inputID, double inputBalance) {
		this.id = inputID;
		this.balance = inputBalance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}

	// Withdraws a double from the balance. Includes the limit.
	public void withdraw(double withdrawAmount) {

		// Allow withdrawal if balance after withdrawing is equal or greater than -5000.
		if (this.balance - withdrawAmount >= -overdraft) {
			this.balance -= withdrawAmount;
		}
		else {
			System.out.println("over limit");
		}
	}

	// Test case.
	public static void main(String[] args) {
		CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
		myCheckAcc.deposit(2000);
		myCheckAcc.withdraw(15000);

		System.out.println(myCheckAcc.getBalance());
		myCheckAcc.withdraw(200);
		System.out.println(myCheckAcc.getBalance());	
		myCheckAcc.deposit(7000);
		myCheckAcc.withdraw(200);
		System.out.println(myCheckAcc.getBalance());	
	}
}




//===============================================
// test case
//===============================================

/*

Input:

public class TestCheckingAccount {

	public static void main(String[] args) {

		CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
		myCheckAcc.deposit(2000);
		myCheckAcc.withdraw(15000);

		System.out.println(myCheckAcc.getBalance());
		myCheckAcc.withdraw(200);
		System.out.println(myCheckAcc.getBalance());	
		myCheckAcc.deposit(7000);
		myCheckAcc.withdraw(200);
		System.out.println(myCheckAcc.getBalance());		
	}

}


Expected Output: 

-5000.0
over limit
-5000.0
1800.0
*/

