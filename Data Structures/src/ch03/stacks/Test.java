package ch03.stacks;

public class Test
{
	public static void main(String [] args)
	{
		Balanced balanced = new Balanced("({[", ")}]");
		System.out.println(balanced.test("((()))"));
	}
}
