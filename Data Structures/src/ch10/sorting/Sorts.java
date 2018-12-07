/*
 * --------------------------------------------------------------------------------
 * Sorts.java   									by Anthony Pompili
 * 
 * Test harness used to run sorting algorithms.
 * --------------------------------------------------------------------------------
*/

package ch10.sorting;

import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class Sorts
{
	static final int SIZE = 50;				// Size of array to be sorted
	static int[] values = new int[SIZE];	// Values to be sorted
	
	// Initializes the values array with random integers from 0 to 99.
	public static void initValues()
	{
		Random rand = new Random();
		for(int index = 0; index < SIZE; index++)
			values[index] = Math.abs(rand.nextInt()) % 100;
	}
	
	// Returns true if the array values are sorted, and false otherwise.
	public static boolean isSorted()
	{
		boolean sorted = true;
		for(int index = 0; index< (SIZE - 1); index++)
			if(values[index] > values[index + 1])
			{
				sorted = false;
				break;
			}
				
		return sorted;
	}
	
	// Precondition: index1 and index2 are >= and < SIZE
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	public static void swap(int index1, int index2)
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
	
	// Prints all the values integers
	public static void printValues()
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("The values array is:");
		for (int index = 0; index < SIZE; index++)
		{
			value = values[index];
			if(((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) throws IOException
	{
		initValues();
		printValues();
		System.out.println("values is sorted: " + isSorted());
		System.out.println();
		swap(0,1);
		printValues();
		System.out.println("values is sorted: " + isSorted());
		System.out.println();
	}
}
