/* Gregory Jerian
 * 3/10/16
 * Period 4 APCS */

public class MyPoint implements Point {
	private int x;
	private int y;
	
	/**
	 * No-arg constructor. Sets x and y to 0
	 */
	public MyPoint() {
		x = 0;
		y = 0;
	}
	
	/**
	 * Constructor. Sets x and y
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets x-coordinate
	 * @return x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets x-coordinate
	 * @param x-coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets y-coordinate
	 * @return y-coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets y-coordinate
	 * @param y-coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
