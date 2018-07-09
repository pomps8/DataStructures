package ch05.queues;

// Implements UnboundedQueueInterface with an array to hold queue elements
//
// Two constructors are provided: one that creates a queue of a default
// original capacity and one that allows the calling program to specify
// the original capacity.
//
// If an enqueue is attempted when there is no room available in the array, a
// new array is created with capacity incremented by the original amount. 

public class ArrayUnboundQueue<T> implements UnboundedQueueInterface<T>
{

	private final int DEFAULT_CAPACITY = 100; // default capacity
	private T[] queue;						  // array that holds elements
	private int origCap;					  // original capacity
	private int numElements = 0;			  // Number of elements in the queue
	private int front = 0;					  // index of the front of the queue
	private int rear = -1;					  // index of the rear of the queue
	
	public ArrayUnboundQueue()
	{
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		rear = DEFAULT_CAPACITY - 1;
		origCap = DEFAULT_CAPACITY;
	}
	
	public ArrayUnboundQueue(int origCap)
	{
		queue = (T[]) new Object[origCap];
		rear = origCap - 1; 					// sets this to one before the max so when
		this.origCap = origCap;					// dequeue is called its adding at position 0.
	}
	
	// Increments the capacity of the queue by an amount
	// equal to the original capacity.
	private void enlarge()
	{
		// create the larger array
		T[] larger = (T[]) new Object[queue.length + origCap];
		
		// copy the contents from the smaller array into the larger one
		int currSmaller = front; // position in smaller array that can wrap around
		for(int currLarger =  0; currLarger < numElements; currLarger++)
		{
			larger[currLarger] = queue[currSmaller];
			currSmaller = (currSmaller + 1) % queue.length;
		}
		
		// update instance variables
		queue = larger;
		front = 0;
		rear = numElements - 1;
	}
	
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else
		{
			T toReturn = queue[front]; 			// gets the element
			queue[front] = null;				// null it out to all for garbage collection
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}

	// Returns true if this queue is empty; otherwise, returns false
	@Override
	public boolean isEmpty()
	{
		return (numElements == 0);
	}

	// Adds element to the rear of this queue
	@Override
	public void enqueue(T element)
	{
		if(numElements == queue.length)	
		{
			enlarge();
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = element;
		numElements = numElements + 1;
	}

}
