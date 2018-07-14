// Used to test counter class with threads. 
// Issue arises since "Count is: .." doesnt print out correct value (10000 in this case).
package ch05.threads;

public class Demo02
{
	public static void main(String [] args) throws InterruptedException
	{
		Counter c = new Counter();
		Runnable r = new Increase(c, 10000);
		Thread t = new Thread(r);
		
		t.start(); // creates a new thread from this main thread to run another line on execution
		
		System.out.println(c);
	}
}
