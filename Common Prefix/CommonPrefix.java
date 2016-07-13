/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

public class CommonPrefix {

	/**
	 * Finds the common prefix of two strings.
	 * @param a The first string
	 * @param b The second string
	 * @return The prefix of a and b
	 */
	public static String common(String a, String b) {
		/*
		 * Checks if a is shorter or if b is shorter.
		 * Then, the loops iterate through the number of indices of 
		 * the shorter string to avoid String index out of bounds
		 * exceptions.
		 */
		boolean aShorterThanB;
		if (a.length() < b.length())
			aShorterThanB = true;
		else
			aShorterThanB = false;
		
		// A temporary string to store the output.
		String temp = "";
		
		// If a is shorter than b, it loops through the length of a only.
		if (aShorterThanB) {
			for (int i = 0; i < a.length(); i++) {
				// At each index, if the characters are the same it is added to temp
				if (a.charAt(i) == b.charAt(i))
					temp += a.charAt(i);
				// If the characters are different the loop breaks.
				else
					break;
			}
		}
		// Same as above but if b is shorter than a.
		else {
			for (int i = 0; i < b.length(); i++) {
				if (a.charAt(i) == b.charAt(i)) {
					temp += a.charAt(i);
				}
				else {
					break;
				}
			}
		}
		
		// Temp is returned at the end
		return temp;
	}
	
	/** 
	 * A main method that runs several tests of the common method.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("common(\"Hello\", \"Hehaw\") = " 
				+ common("Hello", "Hehaw"));
		System.out.println("common(\"Deer\", \"Dill Pickle\") = "
				+ common("Deer", "Dill Pickle"));
		System.out.println("common(\"Rafi\", \"Raffi\") = "
				+ common("Rafi", "Raffi"));
	}

}
