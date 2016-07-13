/** Gregory Jerian
 *  Period 4
 *  3/10/16 */
import java.awt.*;
import javax.swing.JFrame;

public class ClockFrame extends JFrame{
	int x, y, size, numClocks, time;
	double theta;

	public ClockFrame(int x, int y, int size, int numClocks) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.numClocks = numClocks;
		setSize(1000,700);
		setBackground(Color.WHITE);
		repaint();
	}

	public void paint(Graphics g) {
		System.out.println("Nice clock, Ahmed!");
		g.setColor(Color.BLACK);
		g.drawOval(x, y, size, size);

		int xCenter = x + size/2;
		int yCenter = y + size/2;
		while (true) {
			for (int i = -15; i < 45; i++) {
				try {
					Thread.sleep(1000);
					g.clearRect(x-size, y-size, size*2, size*2);
					g.drawOval(x, y, size, size);

				}
				catch (InterruptedException e) {
					System.err.println("lol");
				}
				double theta = (i * 2 * Math.PI)/60;
				g.drawLine(xCenter, yCenter, (int)((size/2) * Math.cos(theta)) + xCenter, (int)((size/2) * Math.sin(theta)) + yCenter);
			}
		}

	}
}
