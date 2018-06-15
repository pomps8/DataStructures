package ch03.stacks;

import support.LLNode;

// Implements UnboundStackInterface using a linked 
// list to hold the stack elements
public class LinkedStack<T> implements UnboundedStackInterface<T>
{
	protected LLNode<T> top; // reference to the top of the stack
	
	public LinkedStack()
	{
		top = null;
	}
	@Override
	public void pop() throws StackUnderflowException
	{
		if(!isEmpty())
		{
			top = top.getLink();
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack");
		
	}

	// throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	@Override
	public T top() throws StackUnderflowException
	{
		if(!isEmpty())
		{
			return top.getInfo();
		}
		else
			throw new StackUnderflowException("Top attempted on an empty stack");
	}

	//returns true if this stack is empty, otherwise returns false.
	@Override
	public boolean isEmpty()
	{

		return (top == null);
	}

	// places element at the top of this stack.
	@Override
	public void push(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
		
	}

}
