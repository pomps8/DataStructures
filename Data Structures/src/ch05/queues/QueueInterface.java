package ch05.queues;

// Interface for a class that implements a queue of T.
// A queue is a "first in, first out" structure.

public interface QueueInterface<T>
{
	// Throws QueueUnderflowException if this queue is empty;
	// Otherwise, removes the front element from this queue and returns it.
	T dequeue() throws QueueUnderflowException;
	
	// Returns true if this queue is empty; otherwise, return false.
	T enqueue() throws  QueueOverflowException;
}
