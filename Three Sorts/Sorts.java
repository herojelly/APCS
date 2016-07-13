/* Gregory Jerian
 * Three Sorts
 * Period 4 APCS*/

public class Sorts {

	/** Main method. */
	public static void main(String[] args) {
		// Initializes three identical arrays
		int[] array = {5, 8, 2, 79, 14, 18, 1};
		int[] array2 = {5, 8, 2, 79, 14, 18, 1};
		int[] array3 = {5, 8, 2, 79, 14, 18, 1};
		
		// Prints the original array
		System.out.print("Original array: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		// Prints the selection sorted array
		selectionSort(array);
		System.out.print("Selection sorted: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();

		// Prints the insertion sorted array
		insertionSort(array2);
		System.out.print("Insertion sorted: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();

		// Prints the bubble sorted array
		bubbleSort(array3);
		System.out.print("Bubble sorted: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	/** Swaps the values in two indices of an array. */
	public static void swap(int[] array, int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}

	/** Sorts the array using a selection sort. */
	public static void selectionSort(int[] array) {
		// Cycles through all the indices of the array
		for (int j = 0; j < array.length; j++) {
			int minimum = array[j];	// Sets the minimum as the first item in the array
			// Cycles through all the indices AFTER the current minimum
			for (int i = j; i < array.length; i++) {
				// Swaps the "next" minimum with the index after the previous minimum
				if (array[i] < minimum) {
					minimum = array[i];
					swap(array, j, i);
				}
			}
		}
	}

	/** Sorts the array using an insertion sort. */
	public static void insertionSort(int[] array) {
		// Cycles through all the indices of the array
		for (int j = 1; j < array.length; j++) {
			// Cycles through all the indices under the current one
			for (int i = j - 1; i >= 0; i--) {
				// If the number at index j is less than number at index i, swaps them and goes down an index
				if (array[j] < array[i]) {
					swap(array, j, j-1);
					j--;
				}
			}
		}
	}

	/** Sorts the array using a bubble sort. */
	public static void bubbleSort(int[] array) {
		// Cycles through all the indices of the array, repeating moving the maximum to the end.
		for (int j = 0; j < array.length; j++) {
			// Cycles through all the indices of the array, moving the maximum to the end.
			for (int i = 1; i < array.length; i++) {
				// Moves the maximum one over
				if (array[i] < array[i-1]) {
					swap(array, i, i-1);
				}
			}
		}
	}




}
