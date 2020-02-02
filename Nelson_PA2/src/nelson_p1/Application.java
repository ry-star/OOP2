package nelson_p1;



//Import Scanner because it's much nicer and easier to deal with than a raw BufferedInputStream
//(Instructions and rubric never said how we had to take in input, so I chose Scanner)
import java.util.Scanner;

public class Application {
	
	//>>>>>(pseudocode is the in-line comments)<<<<<
	
	public static void main(String[] args) {
		//create scanner
		Scanner scan = new Scanner(System.in);
		
		//main loop
		while(true) {
			//declare temp vars
			String choice;
			int in, out;
			
			//Main menu:
			System.out.println("\nEncrypt (e), Decrypt (d), or Quit (q)?");
			System.out.print(">>>");
			choice = scan.nextLine();
			
			//Quit:
			if(choice.equals("q")) break;
			
			//Encrypt:
			if(choice.equals("e")) {
				//get input integer
				System.out.println("\nEnter a 4-digit number to encrypt.");
				System.out.print(">>>");
				in = scan.nextInt();
				scan.nextLine();//(clears the extra "\n" from the input stream)
				//If input is invalid, say so, then go back to main menu
				if(in<0 || in>9999) {
					System.out.println("\nInvalid input! You must input a positive 4-digit integer!");
					continue;//back to main menu
				}
				//Encrypt x, then print it to the screen (with some formatting so it shows leading zeroes)
				out = Encrypter.encrypt(in);
				System.out.println("\nEncrypted "+String.format("%04d", in)+" into "+String.format("%04d", out));
				
			}
			
			//Decrypt:
			if(choice.equals("d")) {
				//get input integer
				System.out.println("\nEnter a 4-digit number to decrypt.");
				System.out.print(">>>");
				in = scan.nextInt();
				scan.nextLine();//(clears the extra "\n" from the input stream)
				//If input is invalid, say so, then go back to main menu
				if(in<0 || in>9999) {
					System.out.println("\nInvalid input! You must input a positive 4-digit integer!");
					continue;//back to main menu
				}
				//Decrypt x, then print it to the screen (with some formatting so it shows leading zeroes)
				out = Decrypter.decrypt(in);
				System.out.println("\nDecrypted "+String.format("%04d", in)+" back into "+String.format("%04d", out));
				
			}
		}
		//close scanner:
		scan.close();
	}
}
