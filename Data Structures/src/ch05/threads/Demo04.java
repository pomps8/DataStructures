// Used to test SyncCounter class with mulitple threads. 
// Issue arises since "Count is: .." doesn't print out correct value (10000 in this case).
// Proves us there as an over writing issue with a type of "interference". Need to
// Synchronization the method so that only one caller can access it at a time, no matter
// the amount of threads. Issue solved here.
package ch05.threads;

public class Demo04
{
	public static void main (String [] args) throws InterruptedException
	{
		SyncCounter sc = new SyncCounter();
		Runnable r1 = new Increase2(sc, 5000);
		Runnable r2 = new Increase2(sc, 5000);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		// creates a new thread from this main thread 
		// to run another line on execution
		t1.start();
		t2.start();
		
		// this will cause the main thread to wait for 
		// the "t" thread to wait till its execution is complete
		t1.join(); 
		t2.join();
		
		System.out.println(sc);
	}
}
