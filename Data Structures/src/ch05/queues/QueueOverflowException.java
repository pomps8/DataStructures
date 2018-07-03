package ch05.queues;

// Exception if enqueue is called on a full queue (Array implementation)
public class QueueOverflowException extends Exception 
{
	public QueueOverflowException() 
	{
		super();
	}
	
	public QueueOverflowException(String message)
	{
		super(message);
	}
}
