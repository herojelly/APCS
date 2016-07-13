import java.util.*;


public class Dijkstra {
	private HashMap<String, HashMap<String, Integer>> nodeDistances; // OG hash map
	private ArrayList<String> nodes = new ArrayList<String>(); // node names
	private ArrayList<Boolean> k = new ArrayList<Boolean>(); // selected set
	private ArrayList<Integer> d = new ArrayList<Integer>(); // distance to this node from start node
	private ArrayList<String> prev = new ArrayList<String>(); // previous node


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

		next(startIndex, start);
	}


	private void next(int startIndex, String startNode) {
		// This loop iterates through all the nodes in the hash map.
//		for (int currentNode = 0; currentNode < nodeDistances.size(); currentNode++) {

			// This loop iterates through all nodes that the CURRENT NODE is connected to.
			Iterator<String> nodeIterator = nodeDistances.get(startNode).keySet().iterator();
			Iterator<Integer> distanceIterator = nodeDistances.get(startNode).values().iterator();
			while (distanceIterator.hasNext()) {
				int nextDist = distanceIterator.next();
				String nextNode = nodeIterator.next();
				if (d.get(nodes.indexOf(nextNode)) == null || d.get(nodes.indexOf(nextNode)) < nextDist) {
					d.set(nodes.indexOf(nextNode), nextDist);
				}	
			}
			System.out.println(nodes);
			System.out.println(k);
			System.out.println(d);
			System.out.println(prev);
		}
//	}

//		private void play(){
//			ArrayList<String> myPath = new ArrayList<String>();
//			ArrayList<String> myPathfromnp = new ArrayList<String>();
//			String nodeInPath = "B";
//			myPath.add(nodeInPath);
//			
//			myPathfromnp.add(nodeInPath);
//			
//			while(!nodeInPath.equals("A")) {
//				nodeInPath = path.get(nodeInPath);
//				myPath.add(nodeInPath);
//			}
//			
//			while(!nodeInPath.equals("A")) {
//				int indexInNodes = nodes.indexOf(nodeInPath);
//				nodeInPath = prev.get(indexInNodes);
//				myPath.add(nodeInPath);
//			}
//		
//	}



}
