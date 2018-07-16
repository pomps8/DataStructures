/*
 * --------------------------------------------------------------------------------
 * IndexedListInterface.java   										by Anthony Pompili
 * 
 * Extends the ListInterface with methods specified to indexed lists.
 * --------------------------------------------------------------------------------
*/
package ch06.lists;

public interface IndexedListInterface<T> extends ListInterface<T>
{
	
	int ELEMENT_NOT_FOUND = -1;
	
	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < - or index > size().
	 * Otherwise, adds elements to list at position index; all current 
	 * elements art that position or higher have 1 added to their index.
	 */
	void add(int index, T element);
	
	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, replaces element on this list at position index and 
	 * returns the replaced element.
	 */
	T set(int index, T element);
	
	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, returns the element on this list at position index.
	 */
	T get(int index);
	
	/*
	 * If this list contains an element e such that e.equals(element),
	 * then returns the index of the first such element.
	 * Otherwise, returns -1.
	 */
	int indexOf(T element);
	
	/*
	 * Throws IndexOutOfBoundsException if passed an index argument
	 * such that index < 0 or index >= size().
	 * Otherwise, removes element on this list at position index and 
	 * returns the removed element; all current elements at positions
	 * higher than that position have 1 subtracted from their index. 
	 * 
	 */
	T remove(int index);
}
