// By Anthony Pompili
package ch03.stacks;

public interface UnboundedStackInterface<T> extends StackInterface<T>
{
	void push(T element);
	// PLaces element at the top of the stack
}
