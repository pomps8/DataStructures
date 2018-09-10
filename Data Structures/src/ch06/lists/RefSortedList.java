/*
 * --------------------------------------------------------------------------------
 * ArrayUnsortedList.java   									by Anthony Pompili
 * 
 * Only comparable elements may be added to a list.
 * 
 * One constructor is provided; one that creates an empty list.
 * --------------------------------------------------------------------------------
*/

package ch06.lists;

import support.LLNode;

public class RefSortedList<T extends Comparable<T>> extends RefUnsortedList<T> implements ListInterface<T>
{
	public RefSortedList()
	{
		super();
	}
	
	// Add elements to this list
	public void add(T element)
	{
		LLNode<T> previousLoc;  // trailing reference
		LLNode<T> location; 	// traveling reference
		T listElement;			// list element being compared
		
		// Set up search for insertion point
		location = list;
		previousLoc = null;
		
		// Find insertion point
		while( location != null)
		{
			listElement = location.getInfo();
			if(listElement.compareTo(element) < 0)
			{
				previousLoc = location;
				location = location.getLink();
			}
			else
				break;
		}
		
		// Prepare node for location
		LLNode<T> newNode = new LLNode<T>(element);
		
		// Insert node into list
		if(previousLoc == null)
		{
			// Insert as first node
			newNode.setLink(list);
			list = newNode;
		}
		else
		{
			// Insert elsewhere
			newNode.setLink(location);
			previous.setLink(newNode);
		}
		
		setNumElements(getNumElements() + 1);
	}
}
