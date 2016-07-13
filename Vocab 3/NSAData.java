import java.util.*;

public class NSAData {
	// An ArrayList is an example of a collection.
	private Collection<String> terroristNames = new ArrayList<String>();
	
	// You can also use a String to collect many elements.
	private String statesTheNSAIsSpyingOn = "";
	
	// Here is an example of a graph. Nodes are connected to other nodes by edges.
	// These edges have certain distances.
	Graph g = new Graph();
	
	public static void main(String[] args) {
		NSAData d = new NSAData();
		
		// An example of an ArrayList, a type of collection.
		d.terroristNames.add("Joe");
		d.terroristNames.add("Bob");
		d.terroristNames.add("Fred");
		System.out.println("Terrorists: " + d.terroristNames);
		
		// An example of using a String as a collection.
		d.statesTheNSAIsSpyingOn += "CA";
		d.statesTheNSAIsSpyingOn += "FL";
		d.statesTheNSAIsSpyingOn += "NY";
		d.statesTheNSAIsSpyingOn += "MO";
		System.out.print("States being spied on: ");
		for (int i = 0; i < d.statesTheNSAIsSpyingOn.length(); i+= 2) {
			System.out.print("" + d.statesTheNSAIsSpyingOn.charAt(i) +
					d.statesTheNSAIsSpyingOn.charAt(i+1) + " ");
		}
		
		// An example of using a graph connecting several cities (represented by letters).
		System.out.println("\nGraph of cities and distances: " + d.g.nodeDistances);
		
	}
}
