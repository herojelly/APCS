import java.util.*;


public class Dijkstra {
	public HashMap<String, String> path;
	
	String startNode;
	private ArrayList<Boolean> k; // selected set
	private ArrayList<String> nodes; // node names
	private ArrayList<String> prev; // previous node is the shortest path
	private ArrayList<Integer> d; // distance to this node from start node
	
	
	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start) {
		// I want to fill those three data structures in the slides
		// I know I am supposed to use a priority queue, but I will not at first
		// well, I will use the abstraction! I just think of priority queues
		// as also incoluding performance.
	}
		
		// nodes and prev are equivalent to path as follows:
		private void play(){
			ArrayList<String> myPath = new ArrayList<String>();
			ArrayList<String> myPathfromnp = new ArrayList<String>();
			String nodeInPath = "B";
			myPath.add(nodeInPath);
			
			myPathfromnp.add(nodeInPath);
			
			while(!nodeInPath.equals("A")) {
				nodeInPath = path.get(nodeInPath);
				myPath.add(nodeInPath);
			}
			
			while(!nodeInPath.equals("A")) {
				int indexInNodes = nodes.indexOf(nodeInPath);
				nodeInPath = prev.get(indexInNodes);
				myPath.add(nodeInPath);
			}
		
	}
	
	

}
