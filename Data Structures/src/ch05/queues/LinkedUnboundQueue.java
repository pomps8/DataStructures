// Implements UnboundedQueueInterface using a linked list
package ch05.queues;

import support.*;

public class LinkedUnboundQueue<T> implements UnboundedQueueInterface<T>
{
	private LLNode<T> front; // reference to the front of this queue
	private LLNode<T> rear;  // reference to the rear of this queue
	
	public LinkedUnboundQueue()
	{
		front = null;
		rear = null;
	}
	
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue");
		else
		{
			T data;
			data = front.getInfo();
			front = front.getLink(); // move front up to the next element to "dequeue" node
			if(front == null) // if the front isn't pointing to anything, delete reference that the rear is hold aswell
				rear = null;
			return data;
		}
	}

	// Returns true if this queue is empty; otherwise, returns false.
	@Override
	public boolean isEmpty()
	{
		return front == null;
	}
	
	// Adds element to the rear of this queue
	@Override
	public void enqueue(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null)
		{
			front = newNode;
		}
		else
		{
			rear.setLink(newNode);
		}
		rear = newNode;
		
	}

}
