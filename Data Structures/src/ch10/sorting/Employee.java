/*
 * --------------------------------------------------------------------------------
 * Employee.java   									by Anthony Pompili
 * 
 * Example of a class for use with a hash table.
 * --------------------------------------------------------------------------------
*/


package ch10.sorting;

public class Employee implements Hashable
{
	protected String name;
	protected int idNum;
	protected int yearsOfService;
	
	protected final int MAX_ELEMENTS = 100;
	
	public Employee(String name, int id, int years)
	{
		this.name = name;
		idNum = id;
		yearsOfService = years;
	}
	// Returns an integer between 0 and MAX_ELEMENTS - 1.
	@Override
	public int hash()
	{
		return (idNum % MAX_ELEMENTS);
	}

}
