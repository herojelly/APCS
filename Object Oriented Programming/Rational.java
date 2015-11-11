/* Code by Gregory Jerian
 * Think AP Java Problem 15.4
 * Period 4 APCS */

public class Rational {

	/** The main method. Runs a variety of tests for the Rational class.*/
	public static void main(String[] args) {
		// #1: Uses the zero-arg constructor and has its numerator and denominator set afterward.
		Rational num1 = new Rational();
		num1.setNumerator(1);
		num1.setDenominator(100);
		num1.printRational();

		// #2: Uses the second constructor to set numerator and denominator, then negates and reduces the fraction.
		Rational num2 = new Rational(6, 4);
		num2.negate();
		num2.reduce();
		num2.printRational();

		// #3: Invokes the zero-arg constructor and does not modify values.
		Rational num3 = new Rational();
		num3.printRational();

		// #4: Invokes the second constructor to set numerator and denominator, then inverts the fraction and turns it into a double.
		Rational num4 = new Rational(25, 144);
		num4.invert();
		System.out.println(num4.toDouble());

		// #5: Invokes the second constructor to set numerator and denominator, then reduces the fraction.
		Rational num5 = new Rational(400, 1600);
		num5.reduce();
		num5.printRational();

		// #6: Adds together #2 and #5.
		Rational num6 = num2.add(num5);
		num6.printRational();
	}

	private int numerator, denominator; // data fields

	/** Zero-arg constructor. Sets numerator to 0 and denominator to -1 by default. */
	public Rational() {
		numerator = 0;
		denominator = 1;
	}

	/** Second constructor. Takes values for numerator and denominator. */
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/** Returns numerator */
	public int getNumerator() {
		return numerator;
	}

	/** Sets numerator to a value */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	/** Returns denominator */
	public int getDenominator() {
		return denominator;
	}

	/** Sets denominator to a value */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	/** Prints the rational */
	public void printRational() {
		System.out.println("" + numerator + "/" + denominator);
	}

	/** Negates the rational (changes the sign)*/
	public void negate() {
		numerator *= -1;
	}

	/** Inverts the rational */
	public void invert() {
		int temp = numerator;
		numerator = denominator;
		denominator = temp;
	}

	/** Turns the fraction into a decimal */
	public double toDouble() {
		return 1.0 * numerator / denominator;
	}

	/** Reduces the fraction by dividing both the numerator and denominator by the GCD */
	public void reduce() {
		int a = numerator;
		int b = denominator;
		while (b != 0) { 		// This while loop finds the GCD of the numerator and denominator
			int temp = a;
			a = b;
			b = temp % b;
		}
		numerator /= a;
		denominator /= a;
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
	}

	/** Adds 2 fractions together by making the denominators the same and adding the numerators */
	public Rational add(Rational that) {
		int numerator = this.numerator * that.denominator + that.numerator * this.denominator;
		int denominator = this.denominator * that.denominator;

		Rational sum = new Rational(numerator, denominator);
		sum.reduce();
		return sum;
	}


}
