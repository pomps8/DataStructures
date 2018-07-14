package ch05.threads;

public class Increase2 implements Runnable
{
	private SyncCounter sc;
	private int amount;
	
	public Increase2(SyncCounter sc, int amount) 
	{
		this.sc = sc;
		this.amount = amount;
	}
	
	// Overridden method from Runnable 
	@Override
	public void run()
	{
		for(int i = 1; i <= amount; i++)
			sc.increment();
	}
}
