//I need a calculator that will except proper, improper, and integers, negitive numbers included
//I have a calc that will take apart the equation from start to the first space
//Then 3 places after that to get the operator(it'll work if its typed exactly as I want it)
//And then from the end of the operator's part to the end for the last faction

//Now I need- Find out if number is fraction and make it a fraction, make mixed fractions into improper fractions

//This is for a little later  [
//take the number to the left of the / and divide it by the number on the right of the /
//add number to the number before the _
//if there is no / add one and but 1 on the right side of it
//at the end change any faction with a denominator of 1 into an integer]



package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner userinput = new Scanner(System.in);
    	System.out.println("CALCULATE");
    	String equation = userinput.nextLine();
    	produceAnswer(equation);
    	
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    public static String produceAnswer(String equation) {
    	String FirstPart = equation.substring(0, equation.indexOf(' '));
    	improperFractions(FirstPart);
    	String Operator = equation.substring(equation.indexOf(" ")+1, equation.indexOf(" ")+3);
    	String Lastpart = equation.substring(equation.indexOf(" ")+3);
    	System.out.println(FirstPart);
    	return "";
    }
    public static String improperFractions(String fraction) {
    	if(fraction.indexOf("/") == -1) {
    		fraction = (fraction + "/1");
    	}
    	
    	System.out.println(fraction);
    	return ("");
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

    { 
        // TODO: Implement this function to produce the solution to the input
        
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
