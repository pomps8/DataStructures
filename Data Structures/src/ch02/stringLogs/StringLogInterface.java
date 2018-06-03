package ch02.stringLogs;

public interface StringLogInterface {
	
	// Precondition: This stringlog isnt full
	//
	// Postcondition: places element into this stringlog
	void insert(String element);
	
	//returns true if this stringlog is full
	boolean isFull();
	
	//returns the number of stringlogs
	int size();
	
	//returns true if element is in this stringlog
	//otherwise returns false
	//Ignores case difference, ex: John and john are considered the same
	boolean contains(String element);
	
	//makes this stringlog empty
	void clear();
	
	//returns the name of this stringlog
	String getName();
	
	//retruns a nicly formatted stirng representing this stringlog
	String toString();
}
