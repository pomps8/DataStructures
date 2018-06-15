//By Anthony Pompili
package ch03.stacks;

import java.util.*;

public class ArrayListStack<T> implements UnboundedStackInterface<T>
{
	protected ArrayList<T> stack; //arraylist that holds stack elements
	
	public ArrayListStack()
	{
		stack = new ArrayList<T>();
	}
	
	// Throws StackUnderflowException if this stack is empty.
	// otherwise returns top element from this stack.
	@Override
	public void pop() throws StackUnderflowException
	{
		if(isEmpty())
		{
			stack.remove(stack.size() -1);
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack");
		
	}

	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	@Override
	public T top() throws StackUnderflowException
	{
		T topOfStack = null;
		
		if(!isEmpty())
		{
			topOfStack = stack.get(stack.size() - 1);
		} 
			else throw new StackUnderflowException("Top attempted on an empty stack");
		
		return topOfStack;
	}

	//returns true if this stack is empty, otherwise returns false.
	@Override
	public boolean isEmpty()
	{
		return (stack.size() == 0);
	}

	//places elements at the top of this stack
	@Override
	public void push(T element)
	{
		stack.add(element);
		
	}

}
