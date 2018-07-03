package ch05.queues;

// Exception if dequeue is called on an empty queue
public class QueueUnderflowException extends Exception 
{
	public QueueUnderflowException() 
	{
		super();
	}
	
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}
