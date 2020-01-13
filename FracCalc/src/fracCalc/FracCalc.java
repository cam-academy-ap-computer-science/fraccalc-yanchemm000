package fracCalc;

//I need a calculator that will except proper, improper, and integers, negative numbers included
//I have a calculator that will take apart the equation from start to the first space
//Then 3 places after that to get the operator(it'll work if its typed exactly as I want it)
//And then from the end of the operator's part to the end for the last faction

//Now I need- Find out if number is fraction and make it a fraction, make mixed fractions into improper fractions


//take the number to the left of the / and divide it by the number on the right of the /
//add number to the number before the _
//if there is no / add one and but 1 on the right side of it
//at the end change any faction with a denominator of 1 into an integer]



import java.util.*;
public class FracCalc {

	private static Scanner userinput;
//It will continue until you type in quit
	public static void main(String[] args) {
		userinput = new Scanner(System.in);
		String ContinueOrNah = "default";
		while(!ContinueOrNah.toLowerCase().equals("quit")) {
			System.out.println("CALCULATE");
			String equation = userinput.nextLine();
			if(!ContinueOrNah.toLowerCase().equals("quit")) 
				equation = produceAnswer(equation);
			System.out.println(equation);
		}
		System.out.print("Goodbye");
	}
	//I have arrays to hold the parts of the fractions. I have 3 arrays to hold 2 elements, one from the first operand and the next for the second
	public static String produceAnswer(String equation) {
		int Whole[] = new int[2];
		int Num[] = new int[2];
		int Den[] = new int[2];
		int WholeAnswer = 0;
		int NumAnswer = 0;
		int DenAnswer = 0;

//I broke the Equation into the first operand, the operator, and the second operand
		String FractionPieces = equation;
		char operator = FractionPieces.charAt(equation.indexOf(" ")+2);

		String FirstPart = FractionPieces.substring(0, equation.indexOf(' '));
		String Lastpart = FractionPieces.substring(equation.indexOf(" ")+3, equation.length());
		if(FirstPart.indexOf("_") == -1) {
//Im breaking the first operand into whole, numerator, and denomerator
			if(FirstPart.indexOf("/") != -1) {
				Whole[0] = 0;
				Num[0] = Integer.parseInt(FirstPart.substring(0, FirstPart.indexOf('/')));
				Den[0] = Integer.parseInt(FirstPart.substring(FirstPart.indexOf('/')+1, FirstPart.length()));
			}
			if(FirstPart.indexOf("/") == -1) {
				Whole[0] = Integer.parseInt(FirstPart.substring(0, FirstPart.length()));
				Num[0] = 0;
				Den[0] = 1;
			}
		}
		if(FirstPart.indexOf("_") != -1) {
			if(FirstPart.indexOf("/") !=-1) {
				Whole[0] = Integer.parseInt(FirstPart.substring(0, FirstPart.indexOf('_')));
				Num[0] = Integer.parseInt(FirstPart.substring(FirstPart.indexOf("_")+1, FirstPart.indexOf("/")));
				Den[0] = Integer.parseInt(FirstPart.substring(FirstPart.indexOf("/")+1, FirstPart.length()));

			}
			if(Whole[0]<0) {
				Num[0] = Num[0] * -1;
			}

		//NOw this is breaking the second operand into the whole numerator, denomenator
			if(Lastpart.indexOf("_") == -1) {

				if(Lastpart.indexOf("/") != -1) {
					Whole[1] = 0;
					Num[1] = Integer.parseInt(Lastpart.substring(0, Lastpart.indexOf('/')));
					Den[1] = Integer.parseInt(Lastpart.substring(Lastpart.indexOf('/')+1, Lastpart.length()));
				}
				if(Lastpart.indexOf("/") == -1) {
					Whole[1] = Integer.parseInt(Lastpart.substring(0, Lastpart.length()));
					Num[1] = 0;
					Den[1] = 1;
				}
			}
			if(Lastpart.indexOf("_") != -1) {
				if(Lastpart.indexOf("/") !=-1) {
					Whole[1] = Integer.parseInt(Lastpart.substring(0, Lastpart.indexOf('_')));
					Num[1] = Integer.parseInt(Lastpart.substring(Lastpart.indexOf("_")+1, Lastpart.indexOf("/")));
					Den[1] = Integer.parseInt(Lastpart.substring(Lastpart.indexOf("/")+1, Lastpart.length()));

				}
				//This will transfer any negetives from the wholes to the numerators
				if(Whole[1]<0) {
					Num[1] = Num[1] * -1;
				}
			}
			//This is what needs to happen if the operator is for addition
			if(operator == '+') {
				for(int i = 0; i<2; i++) {
					Num[i]= (Whole[i] * Den[i]) +Num[i];
				}
				if(Den[0] == Den[1]) {
					NumAnswer = Num[0] + Num[1];
					DenAnswer = Den[0];
					NumAnswer = NumAnswer % DenAnswer;
				}
				if(Den[0] != Den[1]) {
					int leastCommonMultiple = lcm(Den[0], Den[1]);
					DenAnswer = leastCommonMultiple;
					for(int i =0; i<2; i++) {
						Num[i] *= (DenAnswer / Den[i]);
					}
					NumAnswer = Num[0] + Num[1];
				}
			}
			//This is what needs to happen if the operator is for subtraction
			if(operator == '-') {
				for(int i = 0; i<2; i++) {
					Num[i]= (Whole[i] * Den[i]) +Num[i];
				}
				if(Den[0] == Den[1]) {
					NumAnswer = Num[0] - Num[1];
					DenAnswer = Den[0];
					NumAnswer = NumAnswer % DenAnswer;
				}
				if(Den[0] != Den[1]) {
					int leastCommonMultiple = lcm(Den[0], Den[1]);
					DenAnswer = leastCommonMultiple;
					for(int i =0; i<2; i++) {
						Num[i] *= (DenAnswer / Den[i]);          
					}
					NumAnswer = Num[0] - Num[1];
				}
				if (Math.abs(NumAnswer) >= Math.abs(DenAnswer)) {
					WholeAnswer = NumAnswer / DenAnswer;
					NumAnswer = NumAnswer % DenAnswer;
				}
				int gcd = gcd(NumAnswer, DenAnswer);
				NumAnswer = NumAnswer / gcd;
				DenAnswer = DenAnswer / gcd;
			}
		}
		//This is what needs to happen if the operator is for multiplication
		if(operator == '*') {
			for(int i = 0; i<2; i++) {
				Num[i]= (Whole[i] * Den[i]) +Num[i];
			}
			NumAnswer = Num[0] * Num[1];
			DenAnswer = Den[0] * Den[1];
			NumAnswer = NumAnswer % DenAnswer;
		}
		//This is what needs to happen if the operator is for divison
		if(operator == '/') {
			for(int i = 0; i<2; i++) {
				Num[i]= (Whole[i] * Den[i]) +Num[i];
			}
			NumAnswer = Num[0] * Den[1];
			DenAnswer = Den[0] * Num[1];
			WholeAnswer = NumAnswer / DenAnswer;
			NumAnswer = NumAnswer % DenAnswer;
		}
		//These are the forms that the answers can be in
		if(WholeAnswer == 0) {
			if(NumAnswer == 0) {
				equation = "0";
				return equation;
			}
			if(NumAnswer != 0) {
				equation = (NumAnswer + "/" + DenAnswer);
				return equation;
			}

		}
		if(WholeAnswer != 0) {
			if(NumAnswer == 0) {
				equation = WholeAnswer +"";
				return equation;
			}
			if(NumAnswer != 0) {
				equation = (WholeAnswer + "_" + NumAnswer + "/" + DenAnswer);
				return equation;
			}

		}
		return null;

	}
//This is how the internet told me to do this
public static int gcd(int a, int b) { 
	if (b ==0) {
		return a;
	}
	return Math.abs(gcd(b, a % b));
}
public static int lcm(int number1, int number2) {
	if (number1 == 0 || number2 == 0) {
		return 0;
	}
	int absNumber1 = Math.abs(number1);
	int absNumber2 = Math.abs(number2);
	int absHigherNumber = Math.max(absNumber1, absNumber2);
	int absLowerNumber = Math.min(absNumber1, absNumber2);
	int lcm = absHigherNumber;
	while (lcm % absLowerNumber != 0) {
		lcm += absHigherNumber;
	}
	return lcm;
}

	}

