/*
 * --------------------------------------------------------------------------------
 * RefUnsortedList.java   									by Anthony Pompili
 * 
 * Implements the List Interface using an references (a linked list).
 * 
 * Null Elements are not permitted on a list.
 * 
 * One constructor is provided: one that creates an empty list.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

import support.LLNode;

public class RefUnsortedList<T> implements ListInterface<T>
{
	// Global Variables
	private int numElements; 	  // Number of elements in this list
	private LLNode<T> currentPos; // current position for iteration

	// Set by find method
	protected boolean found;		// True if element found, else false
	protected LLNode<T> location;	// Node containing element, if found
	protected LLNode<T> previous;	// node preceding location
	
	protected LLNode<T> list;		// first node on list
	
	// Getters and setters for global variables
	public int getNumElements()
	{
		return numElements;
	}
	
	public void setNumElements(int numElements)
	{
		this.numElements = numElements;
	}
	
	public LLNode<T> getCurrentPos()
	{
		return currentPos;
	}
	
	public void setCurrentPos(LLNode<T> currentPos)
	{
		this.currentPos = currentPos;
	}
	
	// Constructor
	public RefUnsortedList()
	{
		numElements = 0;
		list = null;
		currentPos = null;
	}
	
	// Returns the number of elements on this list.
	@Override
	public int size()
	{
		return numElements;
	}

	// Adds elements to this list
	@Override
	public void add(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numElements++;
	}
	
	/*
	 * Searches list for an occurrence of an element e such that
	 * target.equals(e). If successful, sets instance variables 
	 * found to true, location to node containing e, and previous
	 * to the node that links to location. If not successful, sets 
	 * found to false.
	 */
	protected void find(T target)
	{
		location = list;
		found = false;
		
		while(location != null)
		{
			if(location.getInfo().equals(target))
			{
				found = true;
				return;
			}
			else 
			{
				previous = location;
				location = location.getLink();
			}
		}
	}

	/*
	 * Returns true if this list contains an element e such that
	 * e.equals(element); otherwise, returns false;
	 */
	@Override
	public boolean contains(T element)
	{
		find(element);
		return found;
	}

	/*
	 * Removes an element e from this list such that e.equals(element)
	 * and returns true; if no such element exists, returns false.
	 */
	@Override
	public boolean remove(T element)
	{
		find(element);
		if(found)
		{
			if(list == location)
				list = list.getLink(); // remove first node
			else
				previous.setLink(location.getLink()); // remove node at location
			
			numElements--;
		}
		return found;
	}

	/*
	 * Returns an element e from this list such that e.equals(element);
	 * if no such element exists, returns null.
	 */
	@Override
	public T get(T element)
	{
		find(element);
		if(found)
			return location.getInfo();
		else
			return null;
	}

	/*
	 * Initializes current position for an iteration through this list,
	 * to the first element on this list.
	 */
	@Override
	public void reset()
	{
		currentPos = list;
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
		T next = currentPos.getInfo();
		if(currentPos.getLink() == null)
			currentPos = list;
		else
			currentPos = currentPos.getLink();
		return next;
	}
	
	// Returns a nicely formatted string that represents this list.
	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		logString.append("List:\n");
		
		LLNode<T> currentNode = list;
		
		while(currentNode != null)
		{
			logString.append(currentNode.getInfo() + "\n");
			currentNode = currentNode.getLink();
		}
			
		return logString.toString();
	}
	
}
