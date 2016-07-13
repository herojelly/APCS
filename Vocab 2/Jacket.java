/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

public class Jacket {
	// These data fields are used in jackets and kevlar jackets.
	private boolean isZipped = false;
	private String color = "white";
	
	/**
	 * No-arg constructor.
	 */
	public Jacket() {
	}
	
	/**
	 * Constructor. Takes a boolean for if the jacket is zipped and a
	 * string for the color of the jacket.
	 * @param isZipped true if the jacket is zipped, false if it is not
	 * @param color The color of the jacket
	 */
	public Jacket(boolean isZipped, String color) {
		this.isZipped = isZipped;
		this.color = color;
	}
	
	/**
	 * Zips the jacket.
	 */
	public void zipJacket() {
		isZipped = true;
	}
	
	/**
	 * Unzips the jacket.
	 */
	public void unzipJacket() {
		isZipped = false;
	}
	
	/**
	 * Sets the color of the jacket.
	 * @param color The color of the jacket
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Gets the color of the jacket.
	 * @return The color of the jacket
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Sees if the jacket is zipped.
	 * @return If the jacket is zipped
	 */
	public boolean isZipped() {
		return isZipped;
	}
}
