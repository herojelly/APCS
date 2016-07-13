/** Gregory Jerian
 *  Period 4 APCS
 *  12/8/15 */

import java.util.ArrayList;
import java.util.Scanner;

public class MathSet {
	// This array list holds the values of the math set.
	private ArrayList<Integer> list = new ArrayList<Integer>();

	/** Default no-arg constructor. */
	public MathSet() {
		removeDuplicates();
	}

	/** Constructor for inputting numbers into the math set. 
	 *  @param nums: an array of numbers */
	public MathSet(int[] nums) {
		for (int i: nums)
			list.add(i);
		removeDuplicates();
	}

	/** Removes duplicate values from the array to make it more like a set. */
	public void removeDuplicates() {
		// Creates a temporary list.
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		// Adds elements to the temporary list that do not already exist in it.
		for (int i = 0; i < list.size(); i++) {
			if (newList.contains(list.get(i)) == false)
				newList.add(list.get(i));
		}
		
		// Assigns the original list to the temporary list.
		list = newList;
	}

	/** Finds the intersection of two math sets.
	 *  @param set2: The set you are comparing with. */
	public MathSet intersection(MathSet set2) {
		// Creates a temporary set.
		MathSet math = new MathSet();
		
		// Moves all elements in both sets to the temporary set.
		for (int i = 0; i < list.size(); i++) {
			if (set2.getList().contains(list.get(i)))
				math.getList().add(list.get(i));
		}
		
		// Returns the temporary set.
		return math;
	}
	
	/** Finds the union of two math sets. 
	 *  @param set2: The set you are comparing with. */
	public MathSet union(MathSet set2) {
		// Creates a temporary set.
		MathSet math = new MathSet();
		
		// Moves all elements from the first set to the temp set.
		for (int i = 0; i < list.size(); i++)
			math.getList().add(list.get(i));
		
		// Moves all elements from the second set to the temp set.
		for (int i = 0; i < set2.getList().size(); i++)
			math.getList().add(set2.getList().get(i));
		
		// Removes duplicate elements.
		math.removeDuplicates();
		
		// Returns the temporary set.
		return math;
	}

	/** Returns the list. Woo-hoo encapsulation! */
	public ArrayList<Integer> getList() {
		return list;
	}

	/** Main method. Asks for user input instead of just
	 *  running test cases. Wow I tried too hard. */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of elements in set 1: ");
		int[] numVals1 = new int[input.nextInt()];
		System.out.print("Enter the elements (separated by spaces): ");
		for (int i = 0; i < numVals1.length; i++)
			numVals1[i] = input.nextInt();
		
		System.out.print("Enter the number of elements in set 2: ");
		int[] numVals2 = new int[input.nextInt()];
		System.out.print("Enter the elements (separated by spaces): ");
		for (int i = 0; i < numVals2.length; i++)
			numVals2[i] = input.nextInt();
		
		MathSet set1 = new MathSet(numVals1);
		MathSet set2 = new MathSet(numVals2);
		System.out.println("\nSet 1 is: " + set1.getList());
		System.out.println("Set 2 is: " + set2.getList());
		System.out.println("The intersection is: " + set1.intersection(set2).getList());
		System.out.println("The union is: " + set1.union(set2).getList());

	}

}
