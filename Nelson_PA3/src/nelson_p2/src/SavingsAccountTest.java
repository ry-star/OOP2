package nelson_p2.src;

public class SavingsAccountTest {
	
	//Tests the SavingsAccount class
	public static void main(String args[]) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.println("Month: saver1 | saver2");
		for(int i=1; i<=12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			//uggghhh so messy
			if(i==1)System.out.print("January:   ");
			if(i==2)System.out.print("Febuary:   ");
			if(i==3)System.out.print("March:     ");
			if(i==4)System.out.print("April:     ");
			if(i==5)System.out.print("May:       ");
			if(i==6)System.out.print("June:      ");
			if(i==7)System.out.print("July:      ");
			if(i==8)System.out.print("August:    ");
			if(i==9)System.out.print("September: ");
			if(i==10)System.out.print("October:   ");
			if(i==11)System.out.print("November:  ");
			if(i==12)System.out.print("December:  ");
			System.out.println(saver1+" | "+saver2);
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.println("Next month (5%): "+saver1+" | "+saver2);
	}
}
