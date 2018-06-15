package ch03.postfix;

import ch03.stacks.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class PostFixEvaluator
{
	public static int evaluate(String expression) throws PostFixException
	{
		BoundedStackInterface<Integer> stack = new ArrayStack<Integer>(50); 
		
		int value;
		String operator;
		
		int operator1;
		int operator2;
		
		int result = 0;
		Scanner tokenizer = new Scanner(expression);
		 
		while(tokenizer.hasNext()) //there is more input
		{ 
			if(tokenizer.hasNextInt()) //the character is an integer
			{
				// Process OPERAND.
				value = tokenizer.nextInt(); // get the integer
				if(stack.isFull())
				{
					throw new PostFixException("Too many operands - stack overflow");
				}
				stack.push(value); // no overflow, add to stack
			}
			else 
			{
				// Process OPERATOR.
				operator = tokenizer.next();
				
				// Obtain second operand from stack.
				if(stack.isEmpty())
				{
					throw new PostFixException("Not Enough operands - stack underflow");
				}
				
				operator2 = stack.top();
				stack.pop();
				
				if(stack.isEmpty())
				{
					throw new PostFixException("Not Enough operands - stack underflow");
				}
				
				operator1 = stack.top();
				stack.pop();
				
				// Perform operation
				if (operator.equals("/"))
					result = operator1 / operator2;
				else if (operator.equals("*"))
					result = operator1 * operator2;
				else if (operator.equals("+"))
					result = operator1 + operator2;
				else if (operator.equals("-"))
					result = operator1 - operator2;
				else 
					throw new PostFixException("Illegal symbol: " + operator);
				
				stack.push(result);
					
			}
		}
		
		//obtain final result from stack
		if(stack.isEmpty()) // nothing to compute
			throw new PostFixException("Not enough operands - stack underflow");
		
		result = stack.top();
		stack.pop();
		
		// Stack should now be empty
		if(!stack.isEmpty())
			throw new PostFixException("Too many operands - operands left over");
		
		// Resturn the final result
		return result;
	}
}
