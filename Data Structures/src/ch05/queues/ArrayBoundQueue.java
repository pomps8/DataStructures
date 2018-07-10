package ch05.queues;

public class ArrayBoundQueue <T> implements BoundedQueueInterface<T> 
{

	private final int DEFAULT_CAPACITY = 100; // default capacity
	private T[] queue;						  // array that holds elements
	private int numElements = 0;			  // Number of elements in the queue
	private int front = 0;					  // index of the front of the queue
	private int rear;						  // index of the rear of the queue
	
	// Constructor for default size
	public ArrayBoundQueue()
	{
		// Must cast. Cannot create an array of generic type
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		rear = DEFAULT_CAPACITY - 1;
	}
	
	// Constructor for set size, set by the user
	public ArrayBoundQueue(int maxSize)
	{
		// Must cast. Cannot create an array of generic type
		queue = (T[]) new Object[maxSize];
		rear = maxSize - 1;
	}
	
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	@Override
	public T dequeue() throws QueueUnderflowException 
	{
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on a full queue.");
		else
		{
			T element = queue[front];
			queue[rear] = null;
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return element;
		}
	}

	
	// Returns true if this queue is empty;
	// otherwise, false.
	@Override
	public boolean isEmpty() 
	{
		return (numElements == 0);
	}

	// Throws QueueOverflowException if this queue is full;
	// otherwise, adds element to the rear of this queue.
	@Override
	public void enqueue(T element) throws QueueOverflowException 
	{
		if(isFull())
			throw new QueueOverflowException("Enqueue attempted on a full queue.");
		else
		{
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}
		
	}

	// Returns true if this queue is full;
	// otherwise, returns false.
	@Override
	public boolean isFull() 
	{
		return (numElements == queue.length);
	}
	
	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		logString.append( "Queue: ");
		int position = front;
		
		// Go through all elements and add them to the string to return.
		// Position must not be past the end and there must be at least 1 element.
		while((position != rear + 1) && numElements != 0)
		{
			logString.append(queue[position] + " ");
			position = (position + 1) % queue.length;
		}
			
		return logString.toString();
	}

}
