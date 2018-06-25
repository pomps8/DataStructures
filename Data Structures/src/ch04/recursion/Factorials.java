package ch04.recursion;

public class Factorials {

	static String indent = "";
	public static void main(String[] args) 
	{
		recursiveFactorial(9);
	}

	// Precondition: n is nonnegative
	
	// Postcondition: Returns the value of "n!"
	public static int recursiveFactorial(int n) 
	{
		int retValue; //returned value
		System.out.println(indent + "Enter factorial " + n);
		
		indent = indent + "  ";
		
		if (n == 0)
			retValue = 1;				// base case
		else 
			retValue = n * (recursiveFactorial(n - 1)); // general case
		
		indent = indent.substring(2);
		System.out.println(indent + "Return " + retValue);
		
		return(retValue);
	}
	
	public static int iterativeFactorial(int n)
	{
		int value = n;
		int returnValue = 1;
		
		while (value != 0)
		{
			returnValue = returnValue * value;
			value = value - 1;
		}
		
		return returnValue;
	}
}
