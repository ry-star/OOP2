package nelson_p1;

//This class contains the encrypt method, which encrypts a 4-digit integer
public class Encrypter {
	
	//>>>>>(pseudocode is the in-line comments)<<<<<
	
	
	//encrypts a 4-digit integer
	//(any extra digits are ignored)
	public static int encrypt(int number) {
		//declare variables:
		int[] digits = new int[4];
		int temp;
		
		//get digits:
		for(int i=0; i<4; i++) {
			digits[i] = (number/((int)Math.pow(10, 3-i)))%10;//get the digit (1st digit is 1000s place)
			digits[i] = (digits[i] + 7)%10;//encrypt the digit
		}
		
		//swap 1st with 3rd
		temp = digits[0];
		digits[0] = digits[2];
		digits[2] = temp;
		
		//swap 2nd with 4th
		temp = digits[1];
		digits[1] = digits[3];
		digits[3] = temp;
		
		//return encrypted 4-digit integer
		//(this could be a for loop, but just writing it out was quicker)
		return (1000*digits[0])+(100*digits[1])+(10*digits[2])+(1*digits[3]);
	}
	
}
