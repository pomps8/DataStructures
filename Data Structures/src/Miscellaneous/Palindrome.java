package Miscellaneous;
// Provides a method tot test whether a string is a palindrome.
// Non-letters are skipped (spaces and special characters).

import ch03.stacks.*;
import ch05.queues.*;
public class Palindrome
{
	// Returns true if candidate is a palindrome, false otherwise.
	public static boolean test(String candidate)
	{
		char ch; 					// current candidate character being processed
		int length;			    	// length of candidate string
		int numLetters;				// number of letters in candidate string
		int charCount;				// number of characters checked so far
		
		char fromStack;				// current character popped from stack
		char fromQueue = ' ';				// current character dequeued from queue
		boolean stillPalindrome;	// true if string might still be a palindrome
		
		BoundedStackInterface<Character> stack; // string characters
		BoundedQueueInterface<Character> queue; // string characters
		
		// Initialize variables and structures
		length = candidate.length();
		stack = new ArrayStack<Character>(length);
		queue = new ArrayBoundQueue<Character>(length);
		numLetters = 0;
		
		// obtain and handle characters
		for(int i = 0; i < length; i++)
		{
			ch = candidate.charAt(i);
			if(Character.isLetter(ch))
			{
				numLetters++;
				ch = Character.toLowerCase(ch);
				try
				{
					queue.enqueue(ch);
				}
				catch(QueueOverflowException e)
				{
					e.printStackTrace();
					System.exit(1);
				}
				
				stack.push(ch);
			}
		}
		
		// determine if palindrome
		stillPalindrome = true;
		charCount = 0;
		
		while(stillPalindrome && (charCount < numLetters ))
		{
			fromStack = stack.top();
			stack.pop();
			try
			{
				fromQueue = queue.dequeue();
			} 
			catch (QueueUnderflowException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
			if(fromStack != fromQueue)
			{
				stillPalindrome = false;
			}
			charCount++;
			
		}
		
		// Return result
		return stillPalindrome;
	}
}
