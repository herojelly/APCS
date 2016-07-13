/** Gregory Jerian
 *  12/3/15
 *  Period 4 APCS
 *  Credits go to Rafi Long for helping explain to me how this works. 
 *  The readme has a more detailed writeup. */

import java.util.ArrayList;

public class MedianFinder {
	
	/** This method finds the median.*/
	public static int findMedian(int[] array, int numsLower, int numsHigher) {
		// These three ArrayLists break up the array based on 
		// the value when compared to the pivot.
		ArrayList<Integer> higherThanPivot = new ArrayList<Integer>();
		ArrayList<Integer> sameAsPivot = new ArrayList<Integer>();
		ArrayList<Integer> lowerThanPivot = new ArrayList<Integer>();
		
		// The pivot is initialized as the first element in the array.
		int pivot = array[0]; 
		
		// The elements in the array are distributed among the 3 ArrayLists.
		for (int i = 0; i < array.length; i++) {
			if (array[i] < pivot)
				lowerThanPivot.add(array[i]);
			else if (array[i] == pivot)
				sameAsPivot.add(array[i]);
			else
				higherThanPivot.add(array[i]);
		}	
		
		// Now the recursive calls! This one returns the pivot if it is the median.
		if (sameAsPivot.size() >= Math.abs((lowerThanPivot.size() + numsLower) -
				(higherThanPivot.size() + numsHigher))) {
			return pivot;
		}
		
		// This one changes the array being searched to the "lower than pivot" 
		// array if that array has more elements, because the array with more 
		// elements contains the median.
		else if (lowerThanPivot.size() > higherThanPivot.size()) {
			int[] temp = new int[lowerThanPivot.size()];
			for (int i = 0; i < lowerThanPivot.size(); i++)
				temp[i] = lowerThanPivot.get(i);
			return findMedian(temp, numsLower, numsHigher + 
					higherThanPivot.size() + sameAsPivot.size());
		}
		
		// Same concept as above. This one changes the array being searched to the
		// "higher than pivot" array if that one contains more elements.
		else {
			int[] temp = new int[higherThanPivot.size()];
			for (int i = 0; i < higherThanPivot.size(); i++)
				temp[i] = higherThanPivot.get(i);
			return findMedian(temp, numsLower + lowerThanPivot.size() + 
					sameAsPivot.size(), numsHigher);
		}
		
	}
	

	/** Main method. Runs several test cases. */
	public static void main(String a[]){
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		System.out.println(findMedian(input, 0, 0));
		
		int[] input2 = {3,1,4,1,5,9,2,6,5};
		System.out.println(findMedian(input2, 0, 0));

		int[] input3 = {3,1,4,1,5,9,2,6,5};
		System.out.println(findMedian(input3, 0, 0));
		
		int[] input4 = {1, 8, 5, 2, 9, 12, 15, 37, 3};
		System.out.println(findMedian(input4, 0, 0));
		
		int[] input5 = {20, 10, 14, 15, 18, 2, 5, 7};
		System.out.println(findMedian(input5, 0, 0));
		
		int[] input6 = {22, 18, 24, 31, 9, 20, 2, 71};
		System.out.println(findMedian(input6, 0, 0));
	}
}