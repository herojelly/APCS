import java.util.HashMap;

public class Graph {

	HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	public Graph() {
		// Creates a graph and a hashmap representing node distances
		nodeDistances = new HashMap<String, HashMap<String, Integer>>();
		
		// Fills the graph.
		HashMap<String, Integer> nodeAdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeBdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeCdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeDdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeEdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeFdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeGdistances = new HashMap<String,Integer>();
		HashMap<String, Integer> nodeHdistances = new HashMap<String,Integer>();
		nodeAdistances.put("F", 10);
		nodeAdistances.put("B", 8);
		nodeBdistances.put("E", 10);
		nodeBdistances.put("C", 4);
		nodeCdistances.put("D", 3);
		nodeDdistances.put("F", 18);
		nodeDdistances.put("E", 25);
		nodeEdistances.put("D", 9);
		nodeEdistances.put("G", 7);
		nodeFdistances.put("C", 3);
		nodeFdistances.put("E", 2);
		nodeFdistances.put("B", 7);
		nodeFdistances.put("A", 5);
		nodeGdistances.put("H", 3);
		nodeGdistances.put("D", 2);
		nodeHdistances.put("A", 4);
		nodeHdistances.put("B", 9);
	    nodeDistances.put("A", nodeAdistances);
	    nodeDistances.put("B", nodeBdistances);
	    nodeDistances.put("C", nodeCdistances);
	    nodeDistances.put("D", nodeDdistances);
	    nodeDistances.put("E", nodeEdistances);
	    nodeDistances.put("F", nodeFdistances);
	    nodeDistances.put("G", nodeGdistances);
	    nodeDistances.put("H", nodeHdistances);

	}

}
