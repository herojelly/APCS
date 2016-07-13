/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

public class MrKuszmaul implements Person {
	// Several data fields. Note that the name and gender are
	// invariants, and thus cannot be changed. Also, several data
	// fields are private and can only be accessed through getters and
	// setters, showing encapsulation.
	private double height = 6, weight = 150;
	final private String name = "Mr. Kuszmaul";
	final private char gender = 'M';
	
	/**
	 * No-arg constructor.
	 */
	public MrKuszmaul() {
	}
	
	/**
	 * Gets Mr. Kuszmaul's height.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Gets Mr. Kuszmaul's weight.
	 */
	@Override
	public double getWeight() {
		return weight;
	}

	/**
	 * Gets Mr. Kuszmaul's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets Mr. Kuszmaul's gender.
	 */
	@Override
	public char getGender() {
		return gender;
	}
	
	/**
	 * Mr. Kuszmaul eats a cheeseburger, increasing
	 * his weight by 5.
	 */
	public void eatCheeseburger() {
		weight += 5;
	}
	
	/**
	 * Mr. Kuszmaul hits the gym, decreasing
	 * his weight by 5.
	 */
	public void hitTheGym() {
		weight -= 5;
	}
	
	/**
	 * Mr. Kuszmaul takes growth hormones, increasing
	 * his height.
	 */
	public void takeGrowthHormone() {
		height++;
	}
	
	/**
	 * Mr. Kuszmaul cuts his legs off, decreasing
	 * his height.
	 */
	public void cutLegsOff() {
		height--;
	}

}
