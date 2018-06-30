package ch04.recursion;

import java.util.*;

public class Grid 
{
	protected int rows; // number of grid rows
	protected int cols; // number of grid columns
	
	protected boolean [][] grid; // the grid containing the blobs
	boolean [][] visited; 		 // used by blobCount
	
	// Preconditions: rows and cols > 0
	// 0 <= percentage <= 100
	// PostCondition: Instantiates a grid of size rows by cols, where locations are set to
	// indicate blob characters based on the percentage probability.
	public Grid(int rows, int cols, int percentage)
	{
		this.rows = rows;
		this.cols = cols;
		grid = new boolean [rows][cols];
		
		// Used to generate random numbers
		int randInt;
		Random rand = new Random();
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
			{
				randInt = rand.nextInt(100);
				if(randInt < percentage)
					grid[i][j] = true;
				else
					grid[i][j] = false;
			}
		
	}
	
	// Postcondition: Prints a nicely formatted version of the grid.
	@Override
	public String toString()
	{
		String gridString = "";
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(grid[i][j])
					gridString = gridString + "X";
				else
					gridString = gridString + "-";
			}
			gridString = gridString + "\n";
		}
		return gridString;
	}
	
	// Postcondition: Returns the number of blobs in this grid
	public int blobCount()
	{
		int count = 0;
		visited = new boolean[rows][cols]; // true if location is visited
		
		// initialize visited
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				visited[i][j] = false;
		
		// count the blobs
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				if(grid[i][j] && !visited[i][j])
				{
					count++;
					markBlob(i, j);
				}
		
		
		return count;
	}
	
	// Mark position row, column as having been visited.
	// Check and if appropriate mark locations above, below, left and
	// right of that position.
	private void markBlob(int row, int col)
	{
		visited[row][col] = true;
		
		// check above
		if((row - 1) >= 0)					// if it's on the grid
			if(grid[row - 1][col])			// and has a blob character
				if(!visited[row-1][col])	// and has not been visited
					markBlob(row-1, col);	// then mark it
		
		// check below
				if((row + 1) < rows)
					if(grid[row + 1][col])
						if(!visited[row + 1][col])
							markBlob(row + 1, col);
				
		// check left
		if ((col - 1) >= 0)
			if (grid[row][col - 1])
				if (!visited[row][col - 1])
					markBlob(row, col - 1);

		// check right
		if ((col + 1) < cols)
			if (grid[row][col + 1])
				if (!visited[row][col + 1])
					markBlob(row, col + 1);
	}
}
