package ch02.stringLogs;

public class ArrayStringLog implements StringLogInterface{

	//GLOBAL VARIABLES
	protected String[] log; 		//holds all strings inserted into the log
	protected int lastIndex = -1; // holds the last position to store the next object at
	protected String name; 		//this is the name of the stringlog itself
	static final int DEFAULT_SIZE = 100;
	
	// precondition: maxSize > 0
	// postcondition: instantiates and returns a reference to an empty ArrayStringLog
	// object with the name "name" and room for maxSize strings.
	public ArrayStringLog(String name, int maxSize)
	{
		this.name = name;
		log = new String[maxSize];
	}
	
	// postcondition: instantiates and returns a reference to an empty ArrayStringLog
	// object with the name "name" and room for 100 strings.
	public ArrayStringLog(String name)
	{
		this.name = name;
		log = new String[DEFAULT_SIZE];
	}
	
	// precondition: this stringlog is not full
	// postcondition: element is added to the stringlog
	@Override
	public void insert(String element) 
	{
		lastIndex++;
		log[lastIndex] = element;
	}

	// postcondition: returns true if the stringlog is full, false if otherwise
	@Override
	public boolean isFull() 
	{
		return (lastIndex == log.length - 1);
	}

	//postcondition: returns the number of strings in the stringlog
	@Override
	public int size() 
	{
		return (lastIndex + 1);
	}

	// postcondition: Returns true if element is in this stringlog
	// otherwise returns false
	//Ignores case difference when doing comparison
	@Override
	public boolean contains(String element) {
		for(int i = 0; i < lastIndex; i++)
		{
			if(element.equalsIgnoreCase(log[i]))
			{
				return true;
			}
		}
		return false;
	}

	// precondition: none
	// postcondition: make this stringlog empty
	@Override
	public void clear() 
	{
		for(int i = 0; i < log.length; i++)
		{
			log[i] = null;
		}
		
		lastIndex = -1;
	}

	// postcondition: return the name of the stringlog
	@Override
	public String getName() 
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		logString.append( "Log: " + name + "\n\n");
		
		for(int i = 0; i <= lastIndex; i++)
			logString.append(logString.toString() + (i+1) + ". " + log[i] + "\n");
			
		return logString.toString();
	}

}
