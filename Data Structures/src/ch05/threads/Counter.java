// Tracks the current value of a counter

package ch05.threads;

public class Counter
{
	private int count;
	
	public Counter()
	{
		count = 0;
	}
	
	public void increment()
	{
		count++;
	}
	
	@Override
	public String toString()
	{
		return ("Count is: \t" + count);
	}
}
