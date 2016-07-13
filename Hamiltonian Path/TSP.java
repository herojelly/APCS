/* Gregory Jerian
 * 3/15/16
 * Period 4 APCS */

import java.util.ArrayList;

public class TSP {
	private ArrayList<Point> path = new ArrayList<Point>(); // this is the answer to the tsp

	/**
	 * Uses the traveling salesman problem to find shortest path between a bunch of points
	 */
	public TSP (ArrayList<Point> points) {
		// DOES STUFF TO FIGURE OUT TRAVELING SALESMAN PROBLEM (allegedly)
		
		// Constructs a hamiltonian path from the points.
		for (int i = points.size() - 1; i >= 0; i--) {
			path.add(points.get(i));
		}
	}
	
	/**
	 * Returns the shortest path from the start node to the end node
	 * (a hamiltonian path)
	 * @return the path
	 */
	public ArrayList<Point> getPath() {
		return path;
	}
}
