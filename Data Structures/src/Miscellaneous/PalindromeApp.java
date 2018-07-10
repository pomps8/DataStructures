// Checks for string that are palindromes using Palindrome.java class.
// Input consists of a sequence of strings.
// Output consists of whether the input string is a palindrome.

package Miscellaneous;

import java.util.*;

public class PalindromeApp
{

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		String candidate = null;	// string to be evaluated
		String more = null;			// used to stop or continue processing
		
		do
		{
			// Get next candidate string to be processed.
			System.out.print("Enter a string to be evaluated: ");
			candidate = in.nextLine();
			
			// Obtain and output result of palindrome testing.
			if(Palindrome.test(candidate))
				System.out.println("is a palindrome");
			else
				System.out.println("is not a palindrome \n");
			
			// Determine if there is another candidate string to process
			System.out.print("Evaluate another string? (Y = yes):");
			more = in.nextLine();
			System.out.println();
		} while(more.equalsIgnoreCase("y"));
	}
}
