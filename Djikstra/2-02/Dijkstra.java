import java.util.*;


public class Dijkstra implements Shorty {
	protected HashMap<String, HashMap<String, Integer>> nodeDistances; // OG hash map
	protected ArrayList<String> nodes = new ArrayList<String>(); // node names
	protected ArrayList<Boolean> k = new ArrayList<Boolean>(); // selected set
	protected ArrayList<Integer> d = new ArrayList<Integer>(); // distance to this node from start node
	protected ArrayList<String> prev = new ArrayList<String>(); // previous node


	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {
		// Sets the OG hash map
		this.nodeDistances = nodeDistances;

		// Initializes node names
		int numNodes = 0;
		int startIndex = -1;
		Iterator<String> iterator = nodeDistances.keySet().iterator();
		while (iterator.hasNext()) {
			nodes.add(iterator.next());
			if (nodes.get(numNodes).equals(start)) {
				startIndex = numNodes;
			}
			numNodes++;
		}

		// Initializes selected set
		for (int i = 0; i < numNodes; i++) {
			k.add(false);
		}
		k.set(startIndex, true);

		// Initializes distances with null values
		for (int i = 0; i < numNodes; i++) {
			d.add(null);
		}
		d.set(startIndex, 0);

		// Initializes previous node arraylist with null values
		for (int i = 0; i < numNodes; i++) {
			prev.add(null);
		}

		// Prints out all arrays (testing). TODO get rid of this
		System.out.println(nodes);
		System.out.println(k);
		System.out.println(d);
		System.out.println(prev);
		System.out.println();

		doStuff(start);
	}


	private void doStuff(String startNode) {
		// This loop iterates through all the nodes in the hash map.
		String currentNode = startNode;
		while (k.contains(false)) {
			ArrayList<Boolean> somethingChanged = new ArrayList<Boolean>();
			for (int i = 0; i < nodes.size(); i++) {
				somethingChanged.add(false);
			}
			
			// This loop iterates through all nodes that the CURRENT NODE is connected to.
			// Updates d (distance)
			Iterator<String> nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
			Iterator<Integer> distanceIterator = nodeDistances.get(currentNode).values().iterator();
			while (distanceIterator.hasNext()) {
				int nextDist = distanceIterator.next();
				String nextNode = nodeIterator.next();
				if (d.get(nodes.indexOf(nextNode)) == null || 
						d.get(nodes.indexOf(nextNode)) > nextDist+ d.get(nodes.indexOf(currentNode))) {
					d.set(nodes.indexOf(nextNode), nextDist + d.get(nodes.indexOf(currentNode)));
					somethingChanged.set(nodes.indexOf(nextNode), true);
				}	
			}
			
			// Updates prev (previous node)
			nodeIterator = nodeDistances.get(currentNode).keySet().iterator();
			while (nodeIterator.hasNext()) {
				String nextNode = nodeIterator.next();
				if (somethingChanged.get(nodes.indexOf(nextNode)) == true) {
					prev.set(nodes.indexOf(nextNode), currentNode);
				}
			}
			
			/*
			 * Moves onto next node. Also updates k (selected set).
			 */
			// Finds the smallest distance in the array thus far
			int smallestDistance = Integer.MAX_VALUE;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i) != null && d.get(i) < smallestDistance && k.get(i) == false)
					smallestDistance = d.get(i);
			}
			k.set(d.indexOf(smallestDistance), true);
			currentNode = nodes.get(d.indexOf(smallestDistance));
			
			// Prints out all arrays (testing). TODO get rid of this god damn block
			System.out.println(nodes);
			System.out.println(k);
			System.out.println(d);
			System.out.println(prev);
			System.out.println();
			
		}
		
		

	}
	
	
	public ArrayList<String> next(String s1, String s2, Dijkstra d) {
		return nodes;
	}

}
