/*
 * --------------------------------------------------------------------------------
 * ArraySortedList.java   									by Anthony Pompili
 * 
 * Implements the List Interface using an array. It is kept in increasing
 * order as defined by the compareTo method of the added elements. Only 
 * Comparable elements may be added to a list.
 * 
 * Null Elements are not permitted on a list.
 * 
 * Two constructors are provided: one that creates a list of a default 
 * original capacity, and one that allows the calling program to specify 
 * the original capacity.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

public class ArraySortedList<T> extends ArrayUnsortedList<T> implements ListInterface<T>
{
	public ArraySortedList()
	{
		super();
	}
	
	public ArraySortedList(int origCap)
	{
		super(origCap);
	}
	
	// Precondition: element is Comparable
	//
	// Postcondition: Adds element to list
	@Override
	public void add(T element)
	{
		T listElement;
		int location = 0;
		
		if(numElements == list.length)
			enlarge();
		
		// Search for position in array.
		// If the element we compare to is > or == to it
		// then we are going to insert the new element 
		// at this location
		while(location < numElements)
		{
			listElement = (T)list[location];
			// list element < add element
			if(((Comparable)listElement).compareTo(element) < 0)
				location++;
			// list element >= add element
			else
				break;
		}
		
		// shift all the elements from the end to the insertion point
		// to the right to make room for a new element.
		for(int index = super.size(); index > location; index--) 
			list[index] = list[index - 1];
		
		list[location] = element;
		numElements++;
	}
	
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, return false.
	@Override
	public boolean remove(T element)
	{
		find(element);
		if(found)
		{
			// Don't need to move last element since it will be nulled out
			for(int i = location; i <= numElements - 2; i++)
				list[i] = list[i+1];
			list[numElements - 1] = null;
			numElements--;
		}
		return found;
	}
	
	/*
	 * Searches list for an occurrence of an element e such that
	 * target.equals(e). If successful, sets instance variables 
	 * found to true and location to the array index of e. If
	 * not successful, sets found to false.
	 */
	@Override
	protected void find(T target)
	{
		int first = 0;
		int last = numElements - 1;
		int compareResult;
		Comparable targetElement = (Comparable) target;
		
		found = false;
		
		while(first <= last)
		{
			location = (first + last) / 2;
			compareResult = targetElement.compareTo(list[location]);
			
			if(compareResult == 0)
			{
				found = true;
				return;
			}
			// target element is less than element at location
			else if (compareResult < 0)
			{
				last = location - 1;
			}
			// target element is greater than element at location
			else
			{
				first = location + 1;
			}
		}
	}
	
	// Searches list between fromLocation and toLocation
	// for an occurrence of an element e such that
	// target.equals(e). If successful, sets instance variables
	// found to true and location to the array index of e. If 
	// not successful, sets found to false.
	protected void recFind(Comparable target, int beginning, int end)
	{
		if (beginning > end)
			found = false;
		else
		{
			int compareResult;
			location = (beginning + end) / 2;
			compareResult = target.compareTo(list[location]);
			
			if(compareResult == 0)
				found = true;
			else if (compareResult < 0)
				// target is less than element at location
				recFind(target, beginning, location - 1);
			else
				// target is greater than element at location
				recFind(target, location + 1, end);
		}
	}
	
	
	/*
	 * Searches list for an occurrence of an element e such that
	 * target.equals(e). If successful, sets instance variables
	 * found to true and location to the array index of e. If
	 * not successful, sets found to false.
	 */
	protected void findRecursive(T target)
	{
		Comparable targetElement = (Comparable) target;
		found = false;
		recFind(targetElement, 0, numElements - 1);
	}
}
