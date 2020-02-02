package nelson_p2.src;



//Import Scanner because it's much nicer and easier to deal with than a raw BufferedInputStream
//(Instructions and rubric never said how we had to take in input, so I chose Scanner)
import java.util.Scanner;

public class BMICalculator {
	
	//>>>>>(pseudocode is the in-line comments)<<<<<
	
	//Copied from instructions:
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
	
	
	
	
	//scan stores the scanner and is a global variable so that all the input methods can easily use it
	private Scanner scan;
	
	//weight stores the weight value read from the user
	private double weight = 0;
	//height stores the height value read from the user
	private double height = 0;
	//type stores whether weight and height are in metric (true) or imperial (false) units
	private boolean type = true;
	
	//bmi stores the calculated bmi
	private double bmi = 0;
	//bmiCat stores the bmi category (0=underweight,1=normal,2=overweight,3=obese)
	private int bmiCat = 0;
	
	
	
	//Reads user data using the supporting methods below
	public void readUserData() {
		scan = new Scanner(System.in);//create scanner
		this.type = readUnitType();//get type
		readMeasuremntData(this.type);//get measurements
		scan.close();//close scanner
	}
	//Returns true if unit is metric, false if unit is imperial
	private boolean readUnitType() {
		//menu loop
		while(true) {
			//get user's choice
			System.out.println("\nPick a unit type: Metric (m) or Imperial (i)");
			System.out.print(">>>");
			String choice = scan.nextLine();
			//If user picks metric, return true
			if(choice.equals("m")) return true;
			//if user picks imperial, return false
			if(choice.equals("i")) return false;
			//just keep asking until user gives a valid input
		}
	}
	//gets measurement data from user and stores it into global variables
	//(types specifies if this should read metric (true) or imperial (false)
	private void readMeasuremntData(boolean type) {
		if(type) readMetricData();//if it's metric, use the metric one
		else readImperialData();//if not metric, then it's imperial, use the imperial one
	}
	//These get weight/height from user (these could so easily be the same method with a boolean parameter)
	private void readMetricData() {
		//get weight from user:
		System.out.println("\nEnter a weight (in kilograms)");
		System.out.print(">>>");
		double weight = scan.nextDouble();
		if(weight<0) System.exit(1);//if weight is invalid, quit program
		setWeight(weight);//otherwise store weight into global var
		//get height from the user:
		System.out.println("\nEnter a height (in meters)");
		System.out.print(">>>");
		double height = scan.nextDouble();
		if(height<0) System.exit(1);//if height is invalid, quit program
		setHeight(height);//otherwise store height into global var
	}
	private void readImperialData() {
		//get weight from user:
		System.out.println("\nEnter a weight (in pounds)");
		System.out.print(">>>");
		double weight = scan.nextDouble();
		if(weight<0) System.exit(1);//if weight is invalid, quit program
		setWeight(weight);//otherwise store weight into global var
		//get height from the user:
		System.out.println("\nEnter a height (in inches)");
		System.out.print(">>>");
		double height = scan.nextDouble();
		if(height<0) System.exit(1);//if height is invalid, quit program
		setHeight(height);//otherwise store height into global var
	}
	
	
	
	//Calculates the BMI and BMI category using global variables
	public void calculateBmi() {
		//If weight is zero, don't do math (anything times zero equals 0)
		//If height is zero, don't do math (avoid a divide by 0 error!)
		if(getWeight()==0 || getHeight()==0) {
			bmi = 0;
			bmiCat = 0;
			return;
		}
		//If type==false, multiply by 703 for imperial units
		bmi = (type?1:703) * (getWeight() / (getHeight() * getHeight()));
		calculateBmiCategory();//calculate category
	}
	//Calculates the BMI category using global varialbes
	//(why does this method exist???? code could easily be included in "calculateBmi()")
	public void calculateBmiCategory() {
		//logic from website
		if(bmi<18.5) bmiCat = 0;
		else if(bmi<25) bmiCat = 1;
		else if(bmi<30) bmiCat = 2;
		else bmiCat = 3;
	}
	
	
	//displays the results
	public void displayBmi() {
		System.out.print("\n\n\n");//3 empty lines for spacing
		//display weight, height, gmi, and bmi category
		System.out.println("Weight: "+String.format("%.0f", getWeight())+(type?"kg":"lbs"));
		System.out.println("Height: "+String.format("%.0f", getHeight())+(type?"m":"in"));
		System.out.println("BMI: "+String.format("%.2f", bmi));
		System.out.println("BMI Category: "+getCategory());
	}
	//returns the category's name based on the value of bmiCat
	public String getCategory() {
		//convert bmiCat into a string
		if(bmiCat==0) return "Underweight";
		if(bmiCat==1) return "Normal Weight";
		if(bmiCat==2) return "Overweight";
		if(bmiCat==3) return "Obese";
		return "(Invalid)";//error case (this line should never run)
	}
	
	
	
	//
	//WHAT DO THESE EVEN EXIST??????
	//Why does the rubric say we need these methods when you can just get/set the global variables
	//directly in the other methods???
	//
	private double getWeight() {
		return this.weight;//return global weight
	}
	private void setWeight(double weight) {
		this.weight = weight;//set global weight
	}
	private double getHeight() {
		return this.height;//return global height
	}
	private void setHeight(double height) {
		this.height = height;//set global height
	}
}
