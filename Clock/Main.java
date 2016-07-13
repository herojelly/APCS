/** Gregory Jerian
 *  Period 4
 *  3/10/16 */
public class Main {
	public static void main(String[] args) {
		int x = 50;
		int y = 100;
		int size = 500;
		int numClocks = 1;
		
		ClockFrame c = new ClockFrame(x, y, size, numClocks);
		c.setDefaultCloseOperation(c.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
}
