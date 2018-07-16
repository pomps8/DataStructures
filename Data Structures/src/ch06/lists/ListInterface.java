/*
 * --------------------------------------------------------------------------------
 * ListInterface.java   										by Anthony Pompili
 * 
 * This LIsts are unbounded and allow duplicate elements, but do not allow null
 * elements. As a general precondition, null elements are not passed as 
 * arguments to any of the methods.
 * 
 * The list has a property called the current position - the position 
 * of the next element to be accessed by getNext during an iteration 
 * through the list. Only reset and getNext affect the current position.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

public interface ListInterface<T>
{
	// Returns the number of elements on this list.
	int size();
	
	// Adds element to this list
	void add(T element);
	
	// Returns true if this list contains an element e such that
	// e.equals(element); otherwise, returns false.
	boolean contains(T element);
	
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, returns false.
	boolean remove(T element);
	
	// Returns an element e from this list such that e.equals(element);
	// if no such element exists, returns null.
	T get(T element);
	
	// Initializes current position for an iteration through this list,
	// to the first element on this list.
	void reset();
	
	/*
	 * Preconditions: The list is not empty
	 * 				  The list has been reset
	 * 				  The list has not been modified since most reset reset
	 * 
	 * Returns the element at the current position on this list.
	 * If the current position is the last element, then it advances the value
	 * of the current position to the first element; otherwise, it advances 
	 * the value of the current position to the next element 
	 */
	T getNext();
}
