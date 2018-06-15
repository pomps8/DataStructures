package ch03.stacks;

public class ArrayStack<T> implements BoundedStackInterface<T>
{

	protected final int DEFAULT_CAPACITY = 100; // default capacity
	protected T[] stack; // holds stack elements
	protected int topIndex = -1; // index of top element in stack

	public ArrayStack()
	{
		stack = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public ArrayStack(int maxSize)
	{
		stack = (T[]) new Object[maxSize];
	}

	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	@Override
	public void pop() throws StackUnderflowException
	{
		if (!isEmpty())
		{
			stack[topIndex] = null;
			topIndex--;
		} else
			throw new StackUnderflowException("Pop attempted on an empty stack");

	}

	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	@Override
	public T top() throws StackUnderflowException
	{
		T topOfStack = null;

		if (!isEmpty())
		{
			topOfStack = stack[topIndex];
		} else
			throw new StackUnderflowException("Top attempted on an empty stack");
		
		return topOfStack; //if exception is thrown, want to return null in case that there is nothing to return
	}

	// returns true if this stack is empty, otherwise returns false
	@Override
	public boolean isEmpty()
	{
		return (topIndex == -1);
	}

	// throws staockOverflowException if this stack is full,
	// otherwise places element at the top of this stack.
	@Override
	public void push(T element) throws StackOverflowException
	{
		if (!isFull())
		{
			topIndex++;
			stack[topIndex] = element;
		} else
		{
			throw new StackOverflowException("Push attempted on a full stack.");
		}

	}

	@Override
	public boolean isFull()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
