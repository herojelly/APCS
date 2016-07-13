/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

// This class extends the Jacket class, showing inheritance.
public class KevlarJacket extends Jacket {
	// Shows the bulletproofiness of the kevlar jacket. Regular jackets do not
	// need to have any bulletproofiness, so this is exclusive to
	// the KevlarJacket class.
	private double bulletproofiness = 0.0;
	
	/**
	 * No-arg constructor.
	 */
	public KevlarJacket() {
	}
	
	/**
	 * Constructor. Takes a boolean for if the jacket is zipped, a
	 * string for the color of the jacket, and a double for the level
	 * of bulletproofiness.
	 * @param isZipped true if the jacket is zipped, false if it is not
	 * @param color The color of the jacket
	 * @param bulletproofiness The bulletproofiness of the jacket
	 */
	public KevlarJacket(boolean isZipped, String color, double bulletproofiness) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets the bulletproofiness of the jacket.
	 * @param bulletproofiness The bulletproofiness of the jacket
	 */
	public void setBulletproofiness(double bulletproofiness) {
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Gets the bulletproofiness of the jacket.
	 * @return The bulletproofiness of the jacket
	 */
	public double getBulletproofiness() {
		return bulletproofiness;
	}
	
	/** 
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish.
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 * @param color The color of the jacket
	 * @param bulletproofiness The bulletproofiness of the jacket
	 */
	public void setVars(boolean isZipped, String color, double bulletproofiness) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish.
	 * @param color The color of the jacket
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 * @param bulletproofiness The bulletproofiness of the jacket
	 */
	public void setVars(String color, boolean isZipped, double bulletproofiness) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish.
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 * @param bulletproofiness The bulletproofiness of the jacket
	 * @param color The color of the jacket
	 */
	public void setVars(boolean isZipped, double bulletproofiness, String color) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish.
	 * @param color The color of the jacket
	 * @param bulletproofiness The bulletproofiness of the jacket
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 */
	public void setVars(String color, double bulletproofiness, boolean isZipped) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish. 
	 * @param bulletproofiness The bulletproofiness of the jacket
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 * @param color The color of the jacket
	 */
	public void setVars(double bulletproofiness, boolean isZipped, String color) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
	/**
	 * Sets all the variables. This is an example of overloading as the method
	 * is repeated 6 times, with 6 different method headers. This allows for
	 * the user to enter if the jacket is zipped, the color of the jacket,
	 * and the bulletproofiness of the jacket in whatever order they wish.
	 * @param bulletproofiness The bulletproofiness of the jacket
	 * @param color The color of the jacket
	 * @param isZipped true if the jacket is zipped, false if it isn't
	 */
	public void setVars(double bulletproofiness, String color, boolean isZipped) {
		if (isZipped) 
			zipJacket();
		else 
			unzipJacket();
		setColor(color);
		this.bulletproofiness = bulletproofiness;
	}
	
}
