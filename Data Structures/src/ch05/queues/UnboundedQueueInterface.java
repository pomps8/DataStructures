package ch05.queues;

// Interface for a class that implements a queueu of T with no bound
// on the size of the queue.  A queue is a "first in, first out" structure.

public interface UnboundedQueueInterface<T> extends QueueInterface<T> 
{
		// Adds element to the rear of this queue.
		void enqueue(T element);
		
}
