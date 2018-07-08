package ch05.queues;

public class QueueTest 
{
	public static void main(String []args)
	{
		BoundedQueueInterface<String> myQueue = new ArrayBoundQueue<String>();
		try {
			myQueue.enqueue("Anthony");
			myQueue.enqueue("Anthony");
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(myQueue.toString());
	}
}
