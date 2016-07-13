/* Gregory Jerian
 * 3/15/16
 * Period 4 APCS */

import java.util.ArrayList;

public class Hamiltonian {
	ArrayList<Point> points = new ArrayList<Point>(); // The list of points
	ArrayList<Point> HamiltonianPath = new ArrayList<Point>(); // A hamiltonian path between the points
	
	/**
	 * Creates a list of points and sets the HamiltonianPath ArrayList.
	 */
	public Hamiltonian() {
		// We create a list of points.
		Point p1 = new MyPoint(0,0);
		Point p2 = new MyPoint(1,0);
		Point p3 = new MyPoint(1,-1);
		Point p4 = new MyPoint(0,-1);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p1);
		
		// Uses Traveling Salesman Problem to calculate a Hamiltonian path between these points.
		TSP tsp = new TSP(points);
		
		// Sets the Hamiltonian path.
		System.out.println(tsp.getPath());
	}
	
	
	/**
	 * A main method that creates a Hamiltonian Path.
	 * @param args 
	 */
	public static void main(String[] args) {
		Hamiltonian h = new Hamiltonian();
		
	}
}
