package nelson_p1.src;

//Contains the decrypt method, which decrypts an encrypted integer
public class Decrypter {
	
	//>>>>>(pseudocode is the in-line comments)<<<<<
	
	//LITERALLY THe EXACT SAME AS Encrypter.encrypt(int), except it has "+3" instead of "+7"
	//(the encrypt and decrypt methods could so easily be the same method with a boolean encrypt/decrypt parameter)
	//---------------------------------------------
	//Returns the original integer, given the positive 4-digit encrypted integer
	//(extra digits are ignored)
	public static int decrypt(int number) {
		//Declare variables:
		int[] digits = new int[4];
		int temp;
		
		//get digits:
		for(int i=0; i<4; i++) {
			digits[i] = (number/((int)Math.pow(10, 3-i)))%10;//get the digit (1st digit is 1000s place)
			digits[i] = (digits[i] + 3)%10;//decrypt the digit (the +3 comes from -7 (decrypt) then +10 (fix negative digits))
		}
		
		//swap 1st with 3rd
		temp = digits[0];
		digits[0] = digits[2];
		digits[2] = temp;
		
		//swap 2nd with 4th
		temp = digits[1];
		digits[1] = digits[3];
		digits[3] = temp;
		
		//return decrypted 4-digit integer
		//(this could be a for loop, but just writing it out was quicker)
		return (1000*digits[0])+(100*digits[1])+(10*digits[2])+(1*digits[3]);
	}
	
}

