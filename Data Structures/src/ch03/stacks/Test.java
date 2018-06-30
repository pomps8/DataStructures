//By Anthony Pompili
package ch03.stacks;

public class Test
{
	public static void main(String [] args)
	{
		Balanced balanced = new Balanced("({[", ")}]");
		System.out.println(balanced.test("((()))"));
		
		LinkedStack <String> stack = new LinkedStack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.printReversed();
	}
}
