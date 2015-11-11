/* Gregory Jerian
 * Problem 1.12: Pascal's Triangle
 * Period 4 APCS*/
public class Pascal {

	public static void main(String[] args) {
		// runs several test cases for computePascal
		System.out.println(computePascal(20, 15));
		System.out.println(computePascal(40,1));
		System.out.println(computePascal(35,7));
		System.out.println(computePascal(3,2));
	}

	/** Finds the value in Pascal's triangle for a row and column */
	public static int computePascal(int row, int column) {
		if (column > row) 		// returns a placeholder value of 0 for undefined.
			return 0;
		else if (column < 0) 	// returns a placeholder value of 0 for undefined.
			return 0;
		else if (column == 0) 	// returns 1 as a final value if the column is 0.
			return 1;
		else 					// completes tail-recursion until a bunch of 1s are added to each other
			return computePascal(row-1, column-1) + computePascal(row-1, column);
	}
}
