/*
 * --------------------------------------------------------------------------------
 * ArrayIndexedList.java   									by Anthony Pompili
 * 
 * Implements the IndexedList interface using an array.
 * 
 * Null Elements are not permitted on a list.
 * 
 * Two constructors are provided: one that creates a list of a default 
 * original capacity, and one that allows the calling program to specify 
 * the original capacity.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

public class ArrayIndexedList<T> extends ArrayUnsortedList<T> implements IndexedListInterface<T>
{

	public ArrayIndexedList()
	{
		super();
	}
	
	public ArrayIndexedList(int origCap)
	{
		super(origCap);
	}

	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index > size().
	 * Otherwise, adds elements to this list at position index; all current
	 * elements at that index or higher have 1 added to their index.
	 */
	@Override
	public void add(int index, T element)
	{
		if((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + 
					" passed to ArrayIndexedList add method.\n");
		
		if(numElements == list.length)
			enlarge();
		
		for(int i = numElements; i > index; i++)
			list[i] = list[i - 1];
		
		list[index] = element;
		numElements++;
	}

	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, replaces element on this list at position index and 
	 * returns the replaced element.
	 */
	@Override
	public T set(int index, T element)
	{
		if((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + 
					" passed to ArrayIndexedList add method.\n");
		
		T hold = list[index];
		list[index] = element;
		return hold;
	}

	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, returns the element on this list at position index.
	 */
	@Override
	public T get(int index)
	{
		if((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + 
					" passed to ArrayIndexedList get method.\n");
		return list[index];
	}

	@Override
	public int indexOf(T element)
	{
		find(element);
		
		if(found)
			return location;
		
		return ELEMENT_NOT_FOUND;
	}

	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, removes element on this list at position index and
	 * returns the removed element; all current elements at positions 
	 * higher than that index have 1 subtracted from their index.
	 */
	@Override
	public T remove(int index)
	{
		if((index < 0) || (index > size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + 
					" passed to ArrayIndexedList remove method.\n");
		
		T hold = list[index];
		
		for(int i = index; i < (numElements - 1); i++)
			list[i] = list[i + 1];
		
		list[numElements - 1] = null;
		numElements--;
		
		return hold;
	}

	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		logString.append("List:\n");
		
		for(int i = 0; i <= numElements; i++)
			logString.append(i + " " + list[i] + " ");
			
		return logString.toString();
	}
}
