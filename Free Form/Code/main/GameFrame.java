package main;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JPanel;

public class GameFrame extends Applet {
	// Sets the aptly named cow color
	private final Color A_CARIBBEAN_CYAN = new Color(80, 221, 213);
	JPanel gameBoardPanel;

	public void init() {
		setSize(500,500);
		setBackground(A_CARIBBEAN_CYAN);
		repaint();
		try {
			Desktop.getDesktop().open(new File("test.mp4"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void paint(Graphics g) {

	}
}
