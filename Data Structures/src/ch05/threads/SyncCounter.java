package ch05.threads;

public class SyncCounter
{
	private int count;
	
	public SyncCounter()
	{
		count = 0;
	}
	
	public synchronized void increment()
	{
		count++;
	}
	
	@Override
	public String toString()
	{
		return ("Count is: \t" + count);
	}
}
