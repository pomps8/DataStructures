package ch04.recursion;

import java.util.*;

public class Towers {

	private static String indent = ""; //indentation for trace
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
				
				int n; // number of rings on starting peg
				System.out.print("Input the number of rings: ");
				
				if(in.hasNextInt())
					n = in.nextInt();
				else {
					System.out.println("Error: you must enter an integer");
					System.out.println("Terminating program.");
					return;
				}
				
				System.out.println("Towers of Hanoi with " + n + " rings \n");
				doTowers(n, 1, 2, 3);

	}

	public static void doTowers(
			int n,
			int startPeg,
			int auxPeg,
			int endPeg)
	{
		if (n > 0)
		{
			indent = indent + "  ";
			
			System.out.println(indent + "Get " + n + " rings moved from peg " + startPeg + " to peg " + endPeg);
			
			// Move n - 1 rings from starting peg to auxiliary peg.
			doTowers(n - 1, startPeg, endPeg, auxPeg);
			
			// Move nth ring from startin peg to ending peg.
			System.out.println(indent + "Get " + n + " rings moved from peg " + startPeg + " to peg " + endPeg);
			
			// Move n - 1 rings from auxiliary peg to ending peg.
			doTowers(n - 1, auxPeg, startPeg, endPeg);
			
			indent = indent.substring(2);
		}
	}
}
