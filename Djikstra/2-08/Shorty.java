import java.util.ArrayList;
import java.util.Collections;

public interface Shorty {
	/**
	 * Returns the shortest path from the starting node of a Dijkstra object to the end
	 * node specified in the string.
	 * @param endNode The end node.
	 * @param d The Dijkstra object, including the starting node.
	 * @return The shortest path between the two nodes.
	 */
	public static ArrayList<String> next(String endNode, Dijkstra d) {
		// Initializes an ArrayList to return the shortest path.
		ArrayList<String> retval = new ArrayList<String>();
		
		// Adds the second-to-last node to retval.
		retval.add(d.prev.get(d.nodes.indexOf(endNode)));
		
		// Iterates through the prev ArrayList, adding the previous nodes to
		// retval. This eventually creates the entire path, although backwards.
		while (d.prev.get(d.nodes.indexOf(retval.get(retval.size() - 1))) != null)
			retval.add(d.prev.get(d.nodes.indexOf(retval.get(retval.size() - 1))));
		
		// Reverses the path so it is now forwards.
		Collections.reverse(retval);
		
		// Adds the end node to the end.
		retval.add(endNode);
		
		// Returns retval.
		return retval;
	}

}
