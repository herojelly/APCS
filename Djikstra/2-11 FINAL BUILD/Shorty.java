/* 
 * Gregory Jerian
 * 2/10/16
 * Period 4 APCS
 */

import java.util.*;

public interface Shorty {
	/**
	 * Returns the shortest path from the starting node of a Dijkstra object to the end
	 * node specified in the string.
	 * @param endNode The end node.
	 * @param d The Dijkstra object, including the starting node.
	 * @return The shortest path between the two nodes.
	 */
	public static ArrayList<String> next(String endNode, Dijkstra d) {
		// Creates two iterators to iterate through the keys and values of the
		// HashMap "path". The keys are the nodes array, the values are the prev array
		Iterator<String> nodeIterator = d.path.keySet().iterator();
		Iterator<String> prevIterator = d.path.values().iterator();
		
		// Next, two ArrayLists are created to hold the values. This makes it easier
		// to look at the data, as it is no longer stored in a confusing HashMap.
		ArrayList<String> nodes = new ArrayList<String>();
		ArrayList<String> prev = new ArrayList<String>();
		
		// The ArrayLists are filled with the values from the HashMap.
		while (nodeIterator.hasNext())
			nodes.add(nodeIterator.next());
		while (prevIterator.hasNext())
			prev.add(prevIterator.next());
		
		// Initializes an ArrayList to return the shortest path.
		ArrayList<String> retval = new ArrayList<String>();
		
		// Adds the second-to-last node to retval.
		retval.add(prev.get(nodes.indexOf(endNode)));
		
		// Iterates through the prev ArrayList, adding the previous nodes to
		// retval. This eventually creates the entire path, although backwards.
		while (prev.get(nodes.indexOf(retval.get(retval.size() - 1))) != null)
			retval.add(prev.get(nodes.indexOf(retval.get(retval.size() - 1))));
		
		// Reverses the path so it is now forwards.
		Collections.reverse(retval);
		
		// Adds the end node to the end.
		retval.add(endNode);
		
		// Returns retval.
		return retval;
	}

}
