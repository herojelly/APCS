/* 
 * Gregory Jerian
 * 2/10/16
 * Period 4 APCS
 */

import java.util.*;

public class Dijkstra implements Shorty {
	private HashMap<String, HashMap<String, Integer>> nodeDistances; // OG hash map
	private ArrayList<String> nodes = new ArrayList<String>(); // node names
	private ArrayList<Boolean> k = new ArrayList<Boolean>(); // selected set
	private ArrayList<Integer> d = new ArrayList<Integer>(); // distance to this node from start node
	private ArrayList<String> prev = new ArrayList<String>(); // previous node
	private int startIndex = -1; // Placeholder value for index of start node.
	private ArrayList<Boolean> somethingChanged = new ArrayList<Boolean>(); // keeps track of changes in distance
	public HashMap<String, String> path = new HashMap<String, String>(); // HashMap of the nodes to prev.

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

		// Fills the path HashMap.
		generatePath();
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
		// Sets every index to false.
		for (int i = 0; i < nodes.size(); i++)
			k.add(false);

		// Sets the starting node to true, as we have already looked at that.
		k.set(startIndex, true);
	}

	/**
	 * Initializes d, the distances array, with null values as placeholders.
	 */
	private void initializeD() {
		// Sets all distances to null as placeholders.
		for (int i = 0; i < nodes.size(); i++)
			d.add(null);

		// Sets the distance of the starting node to itself to zero.
		d.set(startIndex, 0);
	}

	/**
	 * Initializes the previous node array with null values as placeholders.
	 */
	private void initializePrev() {
		// Sets all previous nodes to null as placeholders.
		for (int i = 0; i < nodes.size(); i++)
			prev.add(null);
	}

	/**
	 * Performs Dijkstra's Algorithm, updating nodes like in the powerpoint on Schoology.
	 * @param startNode The starting node.
	 */
	private void updateNodes(String startNode) {
		String currentNode = startNode; // The first "current node" is the starting node.

		// This loop iterates through all the nodes in the hash map.
		while (k.contains(false)) {
			// Initializes the somethingChanged ArrayList. It is reset with every node.
			initializeSomethingChanged();

			// Updates d (distance) and prev (previous node)
			updateD(currentNode);
			updatePrev(currentNode);

			// Updates k (selected set) and finds the smallest distance in the array thus far
			int smallestDistance = updateKandGetSmallestDistance();
			
			// Sets the next "current" node to the one with the smallest distance to the starting node.
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
		// Creates two iterators for the current node, one that iterates through the 
		// nodes it is connected to and one that iterates through the distances.
		Iterator<String> nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
		Iterator<Integer> distanceIterator = nodeDistances.get(currentNode).values().iterator();

		// This loop iterates through all nodes that the CURRENT NODE is connected to.
		while (distanceIterator.hasNext()) {
			// The next connected node and its distance are selected.
			int nextDist = distanceIterator.next();
			String nextNode = nodeIterator.next();
			
			// Applies complicated logic to figure out if the new distance is, in fact, shorter than
			// the old distance. I still do not know how this works exactly, as I just kept shuffling
			// around values. If something is changed, it is marked in the somethingChanged ArrayList.
			if (d.get(nodes.indexOf(nextNode)) == null || 
					d.get(nodes.indexOf(nextNode)) > nextDist + d.get(nodes.indexOf(currentNode))) {
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
		// An iterator for all the nodes the current node is connected to.
		Iterator<String> nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
		
		while (nodeIterator.hasNext()) {
			// Picks the next connected node.
			String nextNode = nodeIterator.next();
			
			// If the previous node has changed (marked in the somethingChanged ArrayList),
			// then it is changed in the prev ArrayList.
			if (somethingChanged.get(nodes.indexOf(nextNode)) == true)
				prev.set(nodes.indexOf(nextNode), currentNode);
		}
	}

	/**
	 * Updates the selected set ArrayList (k) and returns the smallest distance so far.
	 * @return The smallest distance so far.
	 */
	private int updateKandGetSmallestDistance() {
		// Integer.MAX_VALUE is a placeholder. Hopefully there is not actually an edge with 
		// Integer.MAX_VALUE length, or else this code might actually not work!
		int smallestDistance = Integer.MAX_VALUE;
		
		// If the node is not part of the selected set and it is the smallest distance so far,
		// the smallestDistance variable is updated.
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i) != null && d.get(i) < smallestDistance && k.get(i) == false)
				smallestDistance = d.get(i);
		}
		// The smallest distance is updated in the d ArrayList.
		k.set(d.indexOf(smallestDistance), true);
		
		// The smallest distance is returned so it can be used to choose the next node.
		return smallestDistance;
	}

	/**
	 * Fills the path HashMap with the contents of nodes and prev.
	 */
	private void generatePath() {
		// Fills the path HashMap with the contents of the nodes and prev ArrayLists.
		for (int i = 0; i < nodes.size(); i++)
			path.put(nodes.get(i), prev.get(i));
	}

}
