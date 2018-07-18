/*
 * --------------------------------------------------------------------------------
 * ArrayUnsortedList.java   									by Anthony Pompili
 * 
 * Implements the List Interface using an array.
 * 
 * Null Elements are not permitted on a list.
 * 
 * Two constructors are provided: one that creates a list of a default 
 * original capacity, and one that allows the calling program to specify 
 * the original capacity.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

public class ArrayUnsortedList<T> implements ListInterface<T>
{

	private final int DEFAULT_CAPACITY = 100; 
	private int origCap; 						// original capacity
	protected T[] list;							// array to hold this list's elements
	private int numElements;					// number of elements in this list
	private int currentPos;						// current position for iteration
	
	// set by find method
	private boolean found;						// true if element found, otherwise false
	private int location;						// indicates location of element if found
	
	public ArrayUnsortedList()
	{
		list = (T[]) new Object[origCap];
	}
	
	public ArrayUnsortedList(int origCap)
	{
		this.origCap = origCap;
	}
	
	// Increments the capacity of the list by an amount
	// equal to the original capacity.
	public void enlarge()
	{
		// larger array to replace old array
		T[] biggerList;
		biggerList = (T[]) new Object[list.length + origCap]; 
		
		for(int i = 0; i < numElements; i ++)
			biggerList[i] = list[i];
		
		// Reassign list reference.
		list = biggerList;	
	} 
	
	/*
	 * Searches list for an occurence of an element e such that
	 * e.equals(target). If successful, sets instance variables
	 * found to true and location to the array index of e. If
	 * not successful, sets found to false.
	 */
	private void find(T target)
	{
		location = 0;
		found = false;
		
		while( location < numElements)
		{
			if(list[location].equals(target))
			{
				found = true;
				return;
			}
			location++;
		}
	}
	
	// Return the number of elements in this list.
	@Override
	public int size()
	{
		return numElements;
	}

	// Adds elements to this list.
	@Override
	public void add(T element)
	{
		if (numElements == list.length)
			enlarge();
		list[numElements] = element;
		numElements++;
	}
	// Returns true if this list contains an element e such that 
	// e.equals(element); otherwise, returns false;
	@Override
	public boolean contains(T element)
	{
		find(element);
		return found;
	}

	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, returns false.
	@Override
	public boolean remove(T element)
	{
		find(element);
		if(found)
		{
			// move the last element to where we removed our element
			list[location] = list[numElements - 1]; 
			list[numElements - 1] = null;
			numElements--;
		}
		return found;
	}

	// Returns an element e from this list such that e.equals(element);
	// if no such element exists, returns null.
	@Override
	public T get(T element)
	{
		find(element);
		if(found)
			return list[location];
		
		return null;
	}
	
	// Initializes current position for an iteration through this list, 
	// to the first element on this list.
	@Override
	public void reset()
	{
		location = 0;
	}

	/*
	 * Preconditions:   The list is not empty
	 * 					The list has been reset
	 * 					The list has not been modified since the most recent reset
	 * 
	 * Returns the element at the current position on this list.
	 * If the current position is the last element, it advances the value
	 * of the current position to the first element; otherwise, it advances
	 * the value of the current position to the next element.
	 */
	@Override
	public T getNext()
	{
		T next = list[currentPos];
		if(currentPos == (numElements - 1))
			currentPos = 0;
		else
			currentPos++;
		return next;
	}

	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		logString.append("List:\n");
		
		for(int i = 0; i <= numElements; i++)
			logString.append(list[i] + " ");
			
		return logString.toString();
	}
}
