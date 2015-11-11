/* Gregory Jerian
 * Problem 1.11
 * Period 4 APCS*/
public class f {
	
	public static void main(String[] args) {
		// runs several test cases for recursive and iterative
		System.out.println("Recursive: " + recursive(0) + ", " + recursive(1) + ", " + 
				recursive(2) + ", " + recursive(3) + ", " +
				recursive(4) + ", " + recursive(5) + ", " + 
				recursive(6) + ", " + recursive(7) + ", " + 
				recursive(8) + ", " + recursive(9));
		System.out.println("Iterative: " + iterative(0) + ", " + iterative(1) + ", " + 
				iterative(2) + ", " + iterative(3) + ", " +
				iterative(4) + ", " + iterative(5) + ", " + 
				iterative(6) + ", " + iterative(7) + ", " + 
				iterative(8) + ", " + iterative(9));
	}
	
	/** Finds the nth value of the f function using recursion */
	public static int recursive(int n) {
		// returns n if it is less than 3
		if (n < 3)		
			return n;
		// otherwise it runs n through the formula until it is broken up into parts less than 3
		else			
			return recursive(n-1) + 2*recursive(n-2) + 3*recursive(n-3);
	}
	
	/** Finds the nth value of the f function using iteration */
	public static int iterative(int n) {
		// returns n if it is less than 3	
		if (n < 3)	
			return n;
		// otherwise it goes through a for loop, using the formula each step of the way
		else {
			int fOfNMinusOne = 2;	 // assuming n = 3, f(n-1) = 2
			int fOfNMinusTwo = 1;	 // assuming n = 3, f(n-2) = 1
			int fOfNMinusThree = 0;	 // assuming n = 3, f(n-3) = 0
			int fOfN = 0;		 // for now, f(n) is set to temp. value of 0
			
			for (int i = 3; i <= n; i++) {
				fOfN = fOfNMinusOne + 2*fOfNMinusTwo + 3*fOfNMinusThree; // The formula part
				fOfNMinusThree = fOfNMinusTwo; 	// Because n is incremented by one, f(n-3) is now f(n-2)
				fOfNMinusTwo = fOfNMinusOne; 	// Because n is incremented by one, f(n-2) is now f(n-1)
				fOfNMinusOne = fOfN; 		// Because n is incremented by one, f(n-1) is now f(n)
			}
			return fOfNMinusOne;
		}
	}
}
