/* 
 * Gregory Jerian
 * 2/10/16
 * Period 4 APCS
 */

import java.util.*;

public class Graph {

	private HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	/**
	 * A main method, used for testing. Right now, it utilizes the graph from the powerpoint.
	 * Working with this graph made it easier to figure out what was wrong with the program
	 * as I could reference the powerpoint step by step for what the output should have been.
	 */
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
	
	    // Creates a Dijkstra object with starting node "G".
		Dijkstra myd = new Dijkstra(g.nodeDistances, "G");
		
		// Prints the path HashMap from the Dijkstra object.
		System.out.println("Path HashMap: " + myd.path);
		
		// Prints the shortest path to E using Shorty.next
		ArrayList<String> path = Shorty.next("E", myd);
		System.out.println("Shortest path to E: " + path);
		
//		Graph g2 = new Graph();
//		g2.play();
	}
	
	/**
	 * Mr. Kuszmaul's test class from Schoology. It works!
	 */
	private void play(){
		HashMap<String, HashMap<String, Integer>> distanceGraph = new HashMap<String, HashMap<String, Integer>>();
		String startNode = "G";
		HashMap<String, Integer> Gconnections = new HashMap<String, Integer>();
		HashMap<String, Integer> Hconnections = new HashMap<String, Integer>();
		HashMap<String, Integer> Dconnections = new HashMap<String, Integer>();
		Gconnections.put("H", 3);
		Gconnections.put("D", 2);
		distanceGraph.put("G", Gconnections);
		distanceGraph.put("H", Hconnections);
		distanceGraph.put("D", Dconnections);
		Dijkstra myD = new Dijkstra(distanceGraph, startNode);

		ArrayList<String> path = Shorty.next("H", myD);
		System.out.println("path: " + path);
}

}
