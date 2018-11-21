/*
 * --------------------------------------------------------------------------------
 * PriQueueInterface.java   									by Anthony Pompili
 * 
 * Interface for a class that implements a priorty queue.
 * --------------------------------------------------------------------------------
*/
package ch09.priorityQueues;

public interface PriQueueInterface<T extends Comparable<T>>
{
	// Returns true if this priority queue is empty; otherwise, returns false.
	boolean isEmpty();
	
	// Returns true if this priority queue is full; otherwise, returns false.
	boolean isFull();
	
	// Throws PriQOverflowException if this priority queue is full;
	// otherwise, adds element to this priority queue.
	void enqueue(T element);
	
	// Throws PriQUnderflowException if this priority queue is empty;
	// otherwise, removes element with highest prioty from this
	// priority queue and reutrns it.
	T dequeue();
}
