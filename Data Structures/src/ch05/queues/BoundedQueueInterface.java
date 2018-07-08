package ch05.queues;

// Interface for a class that implements a queue of T with a bound
// on the size of the queue. A queue is a "first in, first out" structure.

public interface BoundedQueueInterface<T> extends QueueInterface<T> 
{	
	// Throws QueueOverflowException if this queue is full; 
	// otherwise, adds element to the rear of this queue.
	void enqueue(T element) throws QueueOverflowException;
	
	// Returns true if this queue is full; otherwise, returns false.
	boolean isFull();
}
