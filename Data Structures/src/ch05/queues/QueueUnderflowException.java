package ch05.queues;

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
