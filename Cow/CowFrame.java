import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
	// Sets the aptly named cow color
	private final Color A_RICH_MAHOGANY = new Color(0x8B3E2F);
	
	public CowFrame () {
		init();
	}
	
	public void init() {
		setSize(700,600);
		setBackground(Color.WHITE);
		repaint();
	}
	
	public void paint(Graphics g) {
		/** draws the 1st horn behind the cow */
		g.setColor(Color.DARK_GRAY); // draws horn 1
		g.fillRect(480, 40, 10, 40);
		
		/** Creates the body of the cow*/
		g.setColor(A_RICH_MAHOGANY);
		g.fillRect(50, 100, 400, 200); // body of the cow
		g.fillOval(350, 50, 200, 100); // head of the cow
		g.fillOval(330, 70, 50, 30); // ear
		g.fillRect(60, 200, 50, 200); // leg 1
		g.fillRect(120, 200, 50, 200); // leg 2
		g.fillRect(330, 200, 50, 200); // leg 3
		g.fillRect(390, 200, 50, 200); // leg 4
		g.fillRect(40, 110, 20, 10); // tail part 1
		g.fillRect(30, 110, 10, 150); // tail part 2

		/** Creates the facial features of the cow*/
		g.setColor(Color.WHITE);
		g.fillOval(450, 90, 20, 20); // eye 1
		g.fillOval(480, 90, 20, 20); // eye 2
		g.setColor(Color.BLACK);
		g.fillOval(485, 95, 10, 10); // pupil 1
		g.fillOval(455, 95, 10, 10); // pupil 2
		g.fillOval(460, 115, 35, 25); // snout
		
		/** draws the 2nd horn in front of the cow */
		g.setColor(Color.DARK_GRAY);
		g.fillRect(400, 40, 10, 40); // draws horn 2



	}
}