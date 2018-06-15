package ch03.stacks;

public interface StackInterface<T>
{
	void pop() throws StackUnderflowException;
	// Throws StackUnderflowException if this stack is empty.
	// otherwise removes top element from this stack
	
	T top() throws StackUnderflowException;
	// Throws StackUnderflowException if this stack is empty.
	// other wise returns top element from this stack.
	
	boolean isEmpty();
	// returns true if this stack is empty. otherwise returns false.
}
