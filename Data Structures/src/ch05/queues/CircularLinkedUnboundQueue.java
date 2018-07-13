// Implements UnboundedQueueInterface using a linked list with only a rear element
package ch05.queues;

import support.LLNode;

public class CircularLinkedUnboundQueue<T> implements UnboundedQueueInterface<T>
{
	private LLNode<T> rear;  // reference to the rear of this queue
	
	public CircularLinkedUnboundQueue()
	{
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
			LLNode<T> front = rear.getLink();
			data = front.getInfo();			// grab data
			if(rear == front) 				// only one element, get rid of rear
			{
				rear = null;
			}
			else 							// more than one element, get rid of "front" element
			{
				rear.setLink(front.getLink());	// remove front"
			}
			return data;
		}
	}

	// Returns true if this queue is empty; otherwise, returns false.
	@Override
	public boolean isEmpty()
	{
		return rear == null;
	}

	// Adds element to the rear of this queue
	@Override
	public void enqueue(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null)
		{
			rear = newNode;
			rear.setLink(rear);
		}
		else 
		{
			newNode.setLink(rear.getLink());
			rear.setLink(newNode);
			rear = newNode;
		}
	}
	
	
}
