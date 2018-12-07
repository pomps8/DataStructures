package ch10.sorting;

public class MergeSorts
{

	public static void mergesort(int[] array)
	{
		mergesort(array, new int[array.length], 0, array.length - 1);
	}
	
	public static void mergesort(int [] array, int [] temp, int leftStart, int rightEnd)
	{
		if (leftStart >= rightEnd)	// checks if there is 1 element left in the sub array, i
			return;					// if yes, then it is sorted and no need to sort any more
			
		
		int middle = (leftStart + rightEnd) / 2;
		mergesort(array, temp, leftStart, middle);		
		mergesort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd); // merge the two sub arrays we just created
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd)
	{
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) // while both indexes in sub arrays is in bounds (elements to compare)
		{
			if(array[left] <= array[right])
			{
				temp[index] = array[left];
				left++;
			} 
			else 
			{
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		// out of lines 49 and 50, only one will have elements left depending on which side runs out of elements firt
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
	
	public static void main(String[] args)
	{

	}

}
