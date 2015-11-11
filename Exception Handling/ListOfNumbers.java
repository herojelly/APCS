/**Gregory Jerian
 * Period 4 APCS
 * Exercise 1 */

/* A lot of this was inspired from the answers, but I used an ArrayList
 * instead of the "Vector" stuff the answer key used. */

import java.io.*;
import java.util.ArrayList;

public class ListOfNumbers {
	private ArrayList<Integer> list;

	/** Constructor. Creates a new blank array list for the integers. */
	public ListOfNumbers () {
		list = new ArrayList<Integer>();
	}

	/** Writes contents from the list into the outfile */
	public void writeList() {
		PrintWriter out = null;
		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt")); // opens up outfile.txt 

			// writes from list to text file
			for (int i = 0; i < list.size(); i++)
				out.println("Value at: " + i + " = " + list.get(i));
		} 
		// Exception handling!
		catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " +
					e.getMessage());
		} 
		catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} 
		// Finally block. This always runs at the end.
		finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} 
			else {
				System.out.println("PrintWriter not open");
			}
		}
	}

	/** Reads contents from the infile and places them into a list */
	public void readList() {
        String line = null;
		try {
			RandomAccessFile file = new RandomAccessFile("InFile.txt", "r");
			while ((line = file.readLine()) != null) {
				Integer i = new Integer(Integer.parseInt(line));
				System.out.println(i);
				list.add(i);
			}
		} 
		// Exception handling!
		catch(FileNotFoundException fnf) {
			System.err.println("File: " + "InFile.txt" + " not found.");
		} 
		catch (IOException io) {
			System.err.println(io.toString());
		}
		// Gives user a friendlier (although still red) message if the infile has strings or other non-ints in it.
		catch (Exception e) {
			System.err.println("Not an int!");
		}
	}

	/** Main method. Creates a new list and runs the readList and writeList methods. */
	public static void main(String[] args) {
		ListOfNumbers list = new ListOfNumbers();
		list.readList();
		list.writeList();
	}
}