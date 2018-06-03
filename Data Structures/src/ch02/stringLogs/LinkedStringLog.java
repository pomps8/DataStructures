package ch02.stringLogs;

public class LinkedStringLog implements StringLogInterface{
	
	protected LLStringNode log; //reference to head node
	protected String name; 		//name of stringlog
	
	// instantiates and returns a reference to 
	// an empty Stringlog object with name "name."
	public LinkedStringLog(String name)
	{
		log = null;
		this.name = name;
	}
	
	// precondition: this stringlog is not full
	// postcondition: places element into this stringlog
	@Override
	public void insert(String element) 
	{
		LLStringNode newNode = new LLStringNode(element);
		newNode.setLink(log);
		log = newNode;
	}

	// precondition: none
	// postcondition: returns true if this stringlog is full,
	// false otherwise.
	@Override
	public boolean isFull() 
	{
		return false;
	}

	@Override
	public int size() 
	{
		int count = 0;			// size of list
		LLStringNode tempNode;	// tempNode to look into linkedlist
		tempNode = log; 		// point at the head
		
		while(tempNode != null)
		{
			count++;
			tempNode = tempNode.getLink();
		}
		
		return count;
	}

	@Override
	public boolean contains(String element) 
	{
		LLStringNode tempNode;
		tempNode = log;
		
		while(tempNode != null)
		{
			if(element.equalsIgnoreCase(tempNode.getInfo()))
			{
				return true;
			}
			
			tempNode = tempNode.getLink();
		}
		return false;
	}

	// precondition: none
	// postcondition: make the stringlog empty
	@Override
	public void clear() 
	{
		log = null;
	}

	// precondition: none
	// postcondition: returns the name of this stringlog
	@Override
	public String getName() 
	{
		return name;
	}
	
	// precondition: none
	// postcondition: returns a nicely formatted string representing this StringLog
	@Override
	public String toString()
	{
		StringBuilder logString = new StringBuilder();
		LLStringNode tempNode;
		tempNode = log;
		int count = 0;
		
		while(tempNode != null)
		{
			count++;
			logString.append((count) + ". " + tempNode.getInfo() + "\n");
			tempNode = tempNode.getLink();
		}
			
		logString.insert(0, "Log: " + name + "\n\n");
		return logString.toString();
	}

}
