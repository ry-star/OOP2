package nelson_p1.src;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	
	//----------MAIN----------
	
	//Tests the program by making an object of this class and running the quiz
	public static void main(String args[]) {
		CAI3 instance = new CAI3();
		instance.quiz();
	}
	
	
	
	
	//----------Static Methods and Variables----------
	
	//Stores the Scanner object so that it is only created once during the life of the entire program
	private static final Scanner scan = new Scanner(System.in);
	
	//Stores the SecureRandom object so that it is only created once during the life of the entire program
	private static final SecureRandom rand = new SecureRandom();
	
	
	//Returns a random integer in range [min,max] (inclusive)
	//if max<min, returns min
	private static int randInt(int min, int max) {
		if(max<min) return min;
		return (Math.abs(rand.nextInt())%(max-min+1))+min;
	}
	
	
	
	
	//----------Class Methods and Variables----------
	
	public void quiz() {
		//variables
		int a, b, response;
		int numCorrect = 0;
		
		//ask 10 questions
		for(int i=0; i<10; i++) {
			//generate operands:
			a = randInt(0,9);
			b = randInt(0,9);
			
			//ask question and get answer
			askQuestion(a,b);
			response = readResponse();
			
			//if user is correct, say so and record it as a correct answer
			if(isAnswerCorrect(a,b,response)) {
				displayCorrectResponse();
				numCorrect++;
			}
			
			//if user is incorrect, say so
			else displayIncorrectResponse();
		}
		
		//At the end, display user's score:
		displayCompletionMessage(numCorrect/10.0);
		
		//Ask user if they want to take the quiz again:
		System.out.println("\nDo you want to take the quiz again? (y/n)");
		System.out.print(">>>");
		
		//Sometimes the first attempt of nextLine() fails becasue there's an extra leading \n in the input stream
		//So this throws away everything but a valid response
		String quizAgain;
		do {
			quizAgain = scan.nextLine();
		} while(!quizAgain.equals("y") && !quizAgain.equals("n"));
		
		//If they say yes, run this method again (recursion :) )
		//NOTE: Technically this could result in a StackOverflow error,
		//but this method would have to run over 11,400 times (at least on my computer),
		//and I'm assuming no one is going to answer literally hundreds of thousands of questions in one session
		if(quizAgain.equals("y")) quiz();
	}
	
	//Given the two operands, this prints the multiplication problem to the screen
	private void askQuestion(int a, int b) {
		System.out.println("\nHow much is "+a+" times "+b+"?");
	}
	
	//Prompts, reads and returns the user's response to the question
	private int readResponse() {
		System.out.print(">>>");
		//keep looping until user enters an integer:
		while(true) {
			if(scan.hasNextInt()) return scan.nextInt();//user entered an integer, so return it
			else scan.nextLine();//If the user entered a non-integer, consume it and try again
		}
	}
	
	//Given the two operands and the user's response, this returns if the user was correct
	private boolean isAnswerCorrect(int a, int b, int response) {
		return a*b==response;
	}
	
	//tells the user that they got the right answer
	private void displayCorrectResponse() {
		switch(randInt(1,4)) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	//tells the user that they got the wrong answer
	private void displayIncorrectResponse() {
		switch(randInt(1,4)) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don’t give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	private void displayCompletionMessage(double score) {
		System.out.println("\nYou got a "+(int)(score*100)+"%");
		if(score>=0.75) System.out.println("Congratulations, you are ready to go to the next level!");
		else System.out.println("Please ask your teacher for extra help.");
	}
	
	
	
	

}
