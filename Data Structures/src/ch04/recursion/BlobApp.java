package ch04.recursion;

import java.util.*;

public class BlobApp {

	public static void main(String[] args) 
	{
		Scanner conIn = new Scanner(System.in);
		
		final int GRIDR = 10; // number of grid rows
		final int GRIDC = 40; // number of grid cols
		
		// Get percentage probability of blob characters
		int percentage;
		System.out.println("Input percentage probability (0 to 100): ");
		if(conIn.hasNextInt())
			percentage = conIn.nextInt();
		else
		{
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program");
			return;
		}
		System.out.println();
		
		// create grid
		Grid grid = new Grid(GRIDR, GRIDC, percentage);
		
		// display grid and blob count
		System.out.println(grid);
		System.out.println("\nThere are " + grid.blobCount() + " blobs.\n");
	}

}
