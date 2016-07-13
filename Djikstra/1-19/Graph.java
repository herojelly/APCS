import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


// This is half baked code but it gives you some working code that works with Hashmaps
// like are required in the Dijkstra's algorithm assignment...

public class Graph {

	private HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	public static void main(String[] args) {
		// Creates a graph and a hashmap representing node distances
		Graph g = new Graph();
		g.nodeDistances = new HashMap<String, HashMap<String, Integer>>();
		
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
	    g.nodeDistances.put("A", nodeAdistances);
	    g.nodeDistances.put("B", nodeBdistances);
	    g.nodeDistances.put("C", nodeCdistances);
	    g.nodeDistances.put("D", nodeDdistances);
	    g.nodeDistances.put("E", nodeEdistances);
	    g.nodeDistances.put("F", nodeFdistances);
	    g.nodeDistances.put("G", nodeGdistances);
	    g.nodeDistances.put("H", nodeHdistances);
	    
//	    System.out.println(g.nodeDistances.get("A")); // this drops the hashmap to adjacent nodes for A on the floor
//	    Iterator<String> keysetiterator = g.nodeDistances.get("A").keySet().iterator();
//	    while (keysetiterator.hasNext()) {
//	    	System.out.print(keysetiterator.next() + " ");
//	    }
//	    System.out.println();
	    
		// getDistance returns -1 if there is no *direct* link from "A" to "B"
		
		Dijkstra myd = new Dijkstra(g.nodeDistances, "A");
//		HashMap<String,String> paths = myd.path;
		
		

	}

}
