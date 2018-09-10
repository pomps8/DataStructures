/*
 * --------------------------------------------------------------------------------
 * ArrayRefSortedStringList.java   									by Anthony Pompili
 * 
 * Implements an array-based sorted linked list of strings.
 * Design focuses on Strings to avoid issues with generics and
 * arrays, thus we can focus strictly on the list definition itself.
 * --------------------------------------------------------------------------------
*/
package ch07.array;

import ch06.lists.ListInterface;

public class ArrayRefSortedStringList implements ListInterface<String>
{
	protected static final int NUL = -1;
	
	protected class AListNode
	{
		private String info; // The info in a list node
		private int next;    // A link to the next node on the list
	}
	
	protected AListNode[] nodes;  // Array of AListNode holds the linked list
	
	protected int list;			  // Reference to first node on the list
	protected int free;			  // Reference to first node on the free list
	
	protected int numElements;	  // Number of elements in the list
	protected int currentPos;	  // Current position for iteration
	
	// set by find method
	protected boolean found; 	  // True if element found else false
	protected int location;		  // node containing element, if found
	protected int previous;		  // node preceding location
	
	// Instantiates and returns a reference to an empty list object with
	// room for maxElements elements.
	public ArrayRefSortedStringList(int maxElements)
	{
		nodes = new AListNode[maxElements];
		for(int index = 0; index < maxElements; index++)
			nodes[index] = new AListNode();
		
		// Link together the free nodes.
		for(int index = 0; index < maxElements; index++)
			nodes[index - 1].next = NUL;
		
		list = NUL;
		free = 0;
		numElements = 0;
		currentPos = NUL;
	}
	
	// Returns the index of the next available node from the free list
	// and updates the free list index.
	protected int getNode()
	{
		int hold;
		hold = free;
		free = nodes[free].next;
		return hold;
	}
	
	// Frees the node at array index by linked it into
	// the free list
	protected void freeNode(int index)
	{
		nodes[index].next = free;
		free = index;
	}
	
	// Returns whether this list is full
	public boolean isFull()
	{
		return (free == NUL);	
	}
	
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, returns false
	@Override
	public boolean remove(String element)
	{
		int hold; 	// to remember removed node index
		find(element);
		if(found)
		{
			hold = location;
			if(list == location)
				list = nodes[list].next = nodes[location].next;
			freeNode(hold);
			
		}
		return found;
	}
	
	public int find(String element)
	{
		return 0;
	}
	
	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public void add(String element)
	{
	}

	@Override
	public boolean contains(String element)
	{
		return false;
	}

	@Override
	public String get(String element)
	{
		return null;
	}

	@Override
	public void reset()
	{
	}

	@Override
	public String getNext()
	{
		return null;
	}

}
