// Used to test counter class with threads. 
// Issue arises since "Count is: .." doesnt print out correct value (10000 in this case).
// Need to add "t.join();" to solve issue.
package ch05.threads;

public class Demo02
{
	public static void main(String [] args) throws InterruptedException
	{
		Counter c = new Counter();
		Runnable r = new Increase(c, 10000);
		Thread t = new Thread(r);
		
		// creates a new thread from this main thread 
		// to run another line on execution
		t.start(); 
		
		// this will cause the main thread to wait for 
		// the "t" thread to wait till its execution is complete
		t.join(); 
		
		System.out.println(c);
	}
}
