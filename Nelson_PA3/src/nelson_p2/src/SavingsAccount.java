package nelson_p2.src;

public class SavingsAccount {
	
	//----------STATIC----------
	
	//stores the anual interest rate for all accounts (defaults to 0.0)
	private static double anualInterestRate = 0.0;
	
	//sets the anual interest rate to the specified value
	public static void modifyInterestRate(double newVal) {
		anualInterestRate = newVal;
	}
	
	
	//----------INSTANCE----------
	
	//stores the balance for each account
	private double savingsBalance;
	
	
	//Constructor allows user to specify starting balance (defaults to 0)
	public SavingsAccount(double startingBalance) {
		savingsBalance = startingBalance;
	}
	public SavingsAccount() {this(0.0);}
	
	
	//returns the current savings balance
	public double getBalance() {
		return savingsBalance;
	}
	
	//adds the specified amount to the current balance (amount can be negative)
	public void addBalance(double delta) {
		savingsBalance+=delta;
	}
	
	//calculates the monthly interest and sets the new savings balance accordingly
	public void calculateMonthlyInterest() {
		savingsBalance += anualInterestRate * savingsBalance / 12.0;
	}
	
	//returns a string representation of the balance
	public String toString() {
		//Only display up to 2 decimal points:
		return "$"+(((int)(savingsBalance*100))/100.0);
	}
}
