package ch10.sorting;

public class QuickSorts
{

	static int[] values;
	
	public static int split(int first, int last)
	{
		int splitVal = values[first];
		int saveF = first;
		boolean onCorrectSide;
		
		first++;
		
		do
		{
			onCorrectSide = true;
			while (onCorrectSide)
				if (values[first] > splitVal)
					onCorrectSide = false;
				else
				{
					first++;
					onCorrectSide = (first <= last);	
				}
					
			onCorrectSide = (first <= last);
			while (onCorrectSide)
				if (values[last] <= splitVal)
					onCorrectSide = false;
				else
				{
					
					last--;
					onCorrectSide = (first <= last);
				}
			
			if(first < last)
			{
				swap(first, last);
				first++;
				last--;
			
		}
		
		
		} while(first <= last);
		
		swap(saveF, last);
		return last;
	}
	
	public static void swap(int num1, int num2)
	{
		
	}
	
	public static void main(String[] args)
	{
		values = new int [10];
	}

}
