import java.util.*;

public class Dijkstra implements Shorty {
	protected HashMap<String, HashMap<String, Integer>> nodeDistances; // OG hash map
	protected ArrayList<String> nodes = new ArrayList<String>(); // node names
	protected ArrayList<Boolean> k = new ArrayList<Boolean>(); // selected set
	protected ArrayList<Integer> d = new ArrayList<Integer>(); // distance to this node from start node
	protected ArrayList<String> prev = new ArrayList<String>(); // previous node
	private int startIndex = -1; // Placeholder value for index of start node.
	private ArrayList<Boolean> somethingChanged = new ArrayList<Boolean>(); // keeps track of changes in distance

	/** 
	 * Constructor for the Dijkstra class. Initializes all the data structures.
	 * @param nodeDistances Adjacency list representation of a graph.
	 * @param start The starting node.
	 */
	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {
		// Sets the OG hash map
		this.nodeDistances = nodeDistances;

		// Initializes the data structures.
		initializeNodes(start);
		initializeK();
		initializeD();
		initializePrev();

		// Applies Dijkstra's algorithm.
		updateNodes(start);
	}

	/**
	 * Initializes node names. Also figures out the index of the starting node.
	 * @param start The starting node.
	 */
	private void initializeNodes(String start) {
		int numNodes = 0; // Keeps track of the current number of nodes traversed.
		Iterator<String> iterator = nodeDistances.keySet().iterator(); // Iterator for the nodes.
		while (iterator.hasNext()) {
			// Adds the current node to the nodes array.
			nodes.add(iterator.next());

			// Checks if the node is the start node, setting the start index if it is.
			if (nodes.get(numNodes).equals(start))
				this.startIndex = numNodes;

			// Adds one to the number of nodes traversed.
			numNodes++;
		}
	}

	/**
	 * Initializes k, the selected set array, with a whole lot of falses.
	 */
	private void initializeK() {
		for (int i = 0; i < nodes.size(); i++)
			k.add(false);

		// Sets the starting node to true, as we have already looked at that.
		k.set(startIndex, true);
	}

	/**
	 * Initializes d, the distances array, with null values as placeholders.
	 */
	private void initializeD() {
		for (int i = 0; i < nodes.size(); i++)
			d.add(null);

		// Sets the distance of the starting node to itself to zero.
		d.set(startIndex, 0);
	}

	/**
	 * Initializes the previous node array with null values as placeholders.
	 */
	private void initializePrev() {
		for (int i = 0; i < nodes.size(); i++)
			prev.add(null);
	}

	/**
	 * Performs Dijkstra's Algorithm, updating nodes like in the powerpoint on Schoology.
	 * @param startNode The starting node.
	 */
	private void updateNodes(String startNode) {
		String currentNode = startNode; // The current node is the start node at first.

		// This loop iterates through all the nodes in the hash map.
		while (k.contains(false)) {
			// Initializes the somethingChanged ArrayList
			initializeSomethingChanged();

			// Updates d (distance) and prev (previous node)
			updateD(currentNode);
			updatePrev(currentNode);

			// Moves onto next node. Also updates k (selected set) and finds the
			// smallest distance in the array thus far
			int smallestDistance = updateKandGetSmallestDistance();
			currentNode = nodes.get(d.indexOf(smallestDistance));
		}

	}

	/**
	 * Initializes the somethingChanged ArrayList.
	 */
	private void initializeSomethingChanged() {
		// This ArrayList keeps track of changes in the current shortest distance between two nodes.
		ArrayList<Boolean> somethingChanged = new ArrayList<Boolean>();
		// Right now there are no changes, so the entire thing is set to false.
		for (int i = 0; i < nodes.size(); i++)
			somethingChanged.add(false);
		// Sets the global variable's reference to the local somethingChanged ArrayList.
		this.somethingChanged = somethingChanged;
	}

	/**
	 * Updates the distances ArrayList (d).
	 * @param currentNode The current node being examined.
	 */
	private void updateD(String currentNode) {
		Iterator<String> nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
		Iterator<Integer> distanceIterator = nodeDistances.get(currentNode).values().iterator();

		// This loop iterates through all nodes that the CURRENT NODE is connected to.
		while (distanceIterator.hasNext()) {
			int nextDist = distanceIterator.next();
			String nextNode = nodeIterator.next();
			if (d.get(nodes.indexOf(nextNode)) == null || 
					d.get(nodes.indexOf(nextNode)) > nextDist+ d.get(nodes.indexOf(currentNode))) {
				d.set(nodes.indexOf(nextNode), nextDist + d.get(nodes.indexOf(currentNode)));
				somethingChanged.set(nodes.indexOf(nextNode), true);
			}	
		}
	}

	/**
	 * Updates the previous node ArrayList (prev).
	 * @param currentNode The current node being examined.
	 */
	private void updatePrev(String currentNode) {
		// Updates prev (previous node)
		Iterator<String> nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
		while (nodeIterator.hasNext()) {
			String nextNode = nodeIterator.next();
			if (somethingChanged.get(nodes.indexOf(nextNode)) == true)
				prev.set(nodes.indexOf(nextNode), currentNode);
		}
	}

	/**
	 * Updates the selected set ArrayList (k) and returns the smallest distance so far.
	 * @return The smallest distance so far.
	 */
	private int updateKandGetSmallestDistance() {
		int smallestDistance = Integer.MAX_VALUE;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i) != null && d.get(i) < smallestDistance && k.get(i) == false)
				smallestDistance = d.get(i);
		}
		k.set(d.indexOf(smallestDistance), true);
		return smallestDistance;
	}
}
