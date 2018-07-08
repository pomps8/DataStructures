package Miscellaneous;

import java.util.*;

// Since collects use the iterator class, this is 
// used as a little practice to better understand how
// this iterator class work.
public class IteratorTesting 
{

	public static void main(String[] args) 
	{
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("Anthony");
		myList.add("Lifeguard");
		myList.add("Programmer");
		
		// the iterator must match the type of the list its traversing over
		// hence "Iterator <String>" and "ArrayList <String>"
		Iterator<String> it = myList.iterator(); 
		
		// Iterator<String> newIt = new Iterator<String>(); // can't instantiate the iterator class
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}
