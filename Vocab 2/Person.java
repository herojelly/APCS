/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

public interface Person {
	// This is the public interface for Mr. Kuszmaul.
	// (potentially for other people as well), and has
	// has many getters to allow the user to access
	// information quickly and easily.
	
	/**
	 * Gets the height of the person
	 * @return The height of the person
	 */
	public double getHeight();
	
	/**
	 * Gets the weight of the person
	 * @return The weight of the person
	 */
	public double getWeight();
	
	/**
	 * Gets the name of the person
	 * @return The name of the person
	 */
	public String getName();
	
	/**
	 * Gets the gender of the person
	 * @return The gender of the person
	 */
	public char getGender();
}
