/**Gregory Jerian
 * Period 4 APCS
 * Exercise 2 */

import java.io.*;

public class Cat {
	/** Some snazzy cat class or something */
	public static void cat(File file) {
		RandomAccessFile input = null;
		String line = null;

		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		}
		catch (FileNotFoundException shivum) {		// Exception handling saves the day.
			System.err.println("File: " + file + " not found.");
		}
		catch (IOException sid) {
			System.err.println(sid.toString());
		}
		finally {
			if (input != null) {
				try {
					input.close();
				} 
				catch (IOException sean) {			// Try-catch appears in the finally block as well.
					sean.printStackTrace();
				}
			}
		}
	}
}
