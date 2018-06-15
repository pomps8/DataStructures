package ch03.stacks;

public class Balanced
{
	private String openSet;
	private String closeSet;

	public Balanced(String openSet, String closeSet)
	{
		// Precondition: No character is contained more that once in the
		// combined openSet and closeSet strings.
		// The size of Open set = size of closeSet
		this.openSet = openSet;
		this.closeSet = closeSet;
	}

	// returns 0 if expression is balanced
	// returns 1 if the expression has unbalanced symbols.
	// returns 2 if expression came to end premature
	public int test(String expression)
	{
		char currChar; 			//current expression character being studied
		int currCharIndex; 		// index of current character
		int lastCharIndex;		// index of last character in the expression
		
		int openIndex;			// index of current character in openSet
		int closeIndex;			// index of current character in closeSet
		
		boolean stillBalanced = true;
		
		//holds unmatched symbols
		BoundedStackInterface<Integer> stack = new ArrayStack<Integer>(expression.length());
		
		currCharIndex = 0;
		lastCharIndex = expression.length() - 1;
		
		//while the expression is still balanced and not at the end of expression
		while(stillBalanced && (currCharIndex <= lastCharIndex))
		{
			currChar = expression.charAt(currCharIndex);
			openIndex = openSet.indexOf(currChar);
			
			if(openIndex != -1) 						// if the current character is in the openSet
			{
														//push onto stack
				stack.push(openIndex);
			}
			else
			{
				closeIndex = closeSet.indexOf(currChar);
				
				if(closeIndex != -1) 					// if the current character is in the closeSet
				{
					try 								// try to pop an index off the stack
					{
						openIndex = stack.top(); 		// get top index
						stack.pop(); 					// get rid of top index		
						
						if(openIndex != closeIndex) 	// no matching in pairing
						{
							stillBalanced = false;
							break;
						}
					} 
					catch (StackUnderflowException e) 	// if stack was empty
					{
						stillBalanced = false;
					}
				}
			}
			
			currCharIndex++;
		}
		
		if (!stillBalanced)
			return 1;				//unbalanced symbol
		else	
			if (!stack.isEmpty())	
				return 2;			// premature end of expression
			else 
				return 0;			// expression is balanced

	}
}
