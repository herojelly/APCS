/** Gregory Jerian
 *  Period 4 APCS
 *  12/7/15 */

import java.util.ArrayList;
import java.util.Scanner;

public class Randp {
	// These two array lists keep track of the numbers used and the numbers remaining.
	private ArrayList<Integer> numsUsed = new ArrayList<Integer>();
	private ArrayList<Integer> numsLeft = new ArrayList<Integer>();

	/** Constructor.
	 *  @param limit: The limit to generate random numbers to. */
	public Randp(int limit) {
		for (int i = 0; i < limit; i++)
			numsLeft.add(i + 1);
	}

	/** The nextInt method. Call this to generate another random number. */
	public int nextInt() {
		
		// If there are still numbers left to be used, this chooses random ones from that list.
		if (numsLeft.size() > 0) {
			int index = (int)(Math.random() * numsLeft.size());
			int num = numsLeft.get(index);
			numsUsed.add(num);
			numsLeft.remove(index);
			return num;
		}
		
		// Returns 0 if no numbers left.
		else
			return 0;
	}

	/** Main method. Allows the user to choose a limit and how many numbers they want. */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a limit to test to: ");
		int limit = input.nextInt();
		System.out.print("Enter how many numbers you would like to randomly generate: ");
		int howMany = input.nextInt();
		
		Randp rand = new Randp(limit);
		for (int i = 0; i < howMany; i++)
			System.out.print(rand.nextInt() + " ");
	}

}
