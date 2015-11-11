import java.awt.*;
import javax.swing.JFrame;

public class FlagFrame extends JFrame {
	/** initialize constants */
	// Creates colors for the flag - blue, red, and white
	private final Color OLD_GLORY_RED = new Color(224,22,43);
	private final Color SWAG_WHITE = new Color(255,255,255);
	private final Color OLD_GLORY_BLUE = new Color(0,82,165);	
	
	// Creates scaling variable
	private int SCALE = 300;
	
	/** constructor class for a FlagFrame object. Runs the init method. */
	public FlagFrame () {
		init();
	}
	
	/** creates a background */
	public void init() {
		setSize(1250, 800);
		setBackground(Color.WHITE);
		repaint();
	}
	
	// Flag measurements are scaled by the amount specified in the SCALE variable.
	public void paint(Graphics g) {
		super.paint(g);
		/** Scales the flag - I modified code from Blake Novak*/
		if (getHeight() / 1 <= getWidth() / 1.9)	// Scales based on height if the height of window is very small
			SCALE = (int)(getHeight() / 1 - 200); 
		else										// Scales based on width in other situations
			SCALE = (int)(getWidth()/1.9 - 100);
		
		/** draws the body of the flag */
		// Paints the background of the flag (red)
		g.setColor(OLD_GLORY_RED);
		g.fillRect(100, 100, (int)(1.9 * SCALE), (int)(1.0 * SCALE));
		
		// Paints the white stripes of the flag
		g.setColor(SWAG_WHITE);
		g.fillRect(100, (int)(100 + 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));
		g.fillRect(100, (int)(100 + 3 * 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));
		g.fillRect(100, (int)(100 + 5 * 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));
		g.fillRect(100, (int)(100 + 7 * 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));
		g.fillRect(100, (int)(100 + 9 * 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));
		g.fillRect(100, (int)(100 + 11 * 0.0769 * SCALE), (int)(1.9 * SCALE), (int)(0.0769 * SCALE));

		// Paints the Union
		g.setColor(OLD_GLORY_BLUE);
		g.fillRect(100, 100, (int)(0.76 * SCALE), (int)(0.5385 * SCALE));
		
		// Draws outline of flag
		g.setColor(Color.BLACK);
		g.drawRect(100, 100, (int)(1.9 * SCALE), (int)(1.0 * SCALE));
		
		/** Draws the stars */
		final double pi = Math.PI; // constant for pi
		g.setColor(SWAG_WHITE);
		
		// This first block is for the first grid of stars (5 x 6)
		for (int j = 0; j < 5; j++) { // makes the 6 vertical columns of stars
			for (int i = 0; i < 6; i++) { // makes the 5 horizontal rows of stars
				// Creates an array of x values representing the vertices of a star
				int[] xArray = {(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(0 + pi / 2.0))) + 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2) * (Math.cos(.2 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(.4 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2) * (Math.cos(.6 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2),
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(.8 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(1.2 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1.4 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(1.6 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1.8 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2)};
				// Creates an array of y values representing the vertices of a star
				int[] yArray = {(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(0 + pi / 2.0))) + 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(.2 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(.4 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(.6 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054),
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(.8 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(1.2 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1.4 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(1.6 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1.8 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054)};
				g.fillPolygon(xArray, yArray, 10); // draws the star
			}
		}

		// This second block is for the second grid of stars (4 x 5)
		for (int j = 0; j < 4; j++) {// makes the 4 horizontal rows of stars
			for (int i = 0; i < 5; i++) { // makes the 5 vertical columns of stars
				// Creates an array of x values representing the vertices of a star
				int[] xArray = {(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(0 + pi / 2.0))) + 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2) * (Math.cos(.2 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(.4 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2) * (Math.cos(.6 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063),
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(.8 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(1.2 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1.4 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.cos(1.6 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063), 
						(int)((SCALE * 0.0616/2) * (Math.cos(1.8 * pi + pi / 2.0)))+ 100 + (int)(0.063 * SCALE) + (int)(SCALE * i * 0.063 * 2) + (int)(SCALE * 0.063)};
				// Creates an array of y values representing the vertices of a star
				int[] yArray = {(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(0 + pi / 2.0))) + 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(.2 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(.4 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(.6 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054),
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(.8 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054 + (int)(SCALE * 0.054)), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(1.2 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1.4 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2)/2.5 * (Math.sin(1.6 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054), 
						(int)((SCALE * 0.0616/2) * (Math.sin(1.8 * pi + pi / 2.0)))+ 100 + (int)(SCALE * 0.054) + (int)(SCALE * j * 2 * 0.054) + (int)(SCALE * 0.054)};
				g.fillPolygon(xArray, yArray, 10); // draws the star
			}
			
		}

	}

}
