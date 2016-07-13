/*  
 * Gregory Jerian
 * 1/3/16
 * Period 4 APCS
 */

import java.util.*;

public class GenericMax {
	
	/**
	 * Finds the maximum value of a collection.
	 * @param data The collection
	 * @return The maximum value of the collection
	 */
	public static <T extends Comparable<T>> T max(Collection<T> data) {
		// Creates an iterator to iterate through the collection.
		Iterator<T> iterator = data.iterator();
		
		// Sets the max as the first item in the collection
		T max = iterator.next();
		
		// While there are still items in the collection, compares values to the max.
		// If they are greater, make them the max.
		while (iterator.hasNext()) {
			T value = iterator.next();
			if (value.compareTo(max) > 0)
				max = value;	
		}
		
		// Returns the max of the collection
		return max;
		
	}
	
	
	/**
	 * Main method. Runs test cases.
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(2);
		arr.add(6);
		arr.add(4);
		System.out.println(max(arr));
		
		Stack<String> stack = new Stack<String>();
		stack.add("Hi");
		stack.add("no");
		stack.add("flubber");
		stack.add("k");
		stack.add("zzzzzz");
		System.out.println(max(stack));

		TreeSet<Boolean> tree = new TreeSet<Boolean>();
		tree.add(true);
		tree.add(true);
		tree.add(false);
		System.out.println(max(tree));
		
		LinkedList<Character> linked = new LinkedList<Character>();
		linked.add('5');
		linked.add('d');
		linked.add('e');
		linked.add('&');
		System.out.println(max(linked));

	}

}
