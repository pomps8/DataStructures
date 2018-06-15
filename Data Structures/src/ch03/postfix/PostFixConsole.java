package ch03.postfix;

import java.util.Scanner;

//Driver
public class PostFixConsole
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String line = null; // string to be evaluated
		String more = null; // used to stop or continue processing
		
		int result;			// rsult of evaluation
		
		do
		{
			// Get expression to be processed
			System.out.print("Enter a pot fix expression to be evaluated: ");
			line = input.nextLine();
			
			try
			{
				result = PostFixEvaluator.evaluate(line);
				
				// Output result
				System.out.println("\nResult = " + result);
			} 
			catch (PostFixException e)
			{
				System.out.println("\nError in expression - " + e.getMessage());
			}
			
			// Determine if there is anohter expression to process
			
			System.out.print("\nEvaluate another expression? (Y = yes) : ");
			more = input.nextLine();
			System.out.println();
			
		} while (more.equalsIgnoreCase("y"));

		System.out.println("Program completed");
	}

}
