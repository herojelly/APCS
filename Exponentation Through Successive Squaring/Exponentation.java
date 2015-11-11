// Gregory Jerian
// 9/25/15
// Period 4
// Even and odd exponent formulas taken from Wikipedia. I helped Sean with his code.

public class Exponentation {
	
	/** This main method simply runs the exponent method with some values. */
	public static void main(String[] args) {
		final double NUMBER = 2; //change this value to change the output
		final double EXPONENT = 6; //change this value as well
		System.out.println(exponent(NUMBER, EXPONENT));
	}
	
	/** This method takes a number and its exponent and checks several things about it,
	 * simplifying it using recursion and several formulas until it is to the 1st power,
	 * where it is returned and printed. */
	public static double exponent(double number, double exponent) {
		/* A number raised to a negative power is always 1 over that same number raised to the
		 * positive version of that power. This conditional turns the number and exponent
		 * into that "alternate form" and runs it back through the exponent method. */
		if (exponent < 0)
			return exponent(1 / number, -1 * exponent);
		
		/* A number to the 0th power is always 1. As such, this conditional returns 1. */
		else if (exponent == 0)
			return 1;
		
		/* A number raised to the 1st power is always that number. As such, this conditional
		 * returns that number. */
		else if (exponent == 1)
			return number;
		
		/* A number with an even exponent can be simplified from x^n to (x^2)^(n/2). This
		 * turns it into that form and sends it back through the exponent method. */
		else if (exponent % 2 == 0)
			return exponent(number*number, exponent/2);
		
		/* A number with an odd exponent can be simplified from x^n to (x)(x^2)^([n-1]/2). This
		 * turns it into that form and sends it back through the exponent method. */
		else
			return number * exponent(number*number, (exponent-1)/2);
	}

}
