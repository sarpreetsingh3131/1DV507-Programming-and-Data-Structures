package sb223ce_assign3;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
	public static void main(String[] args) {

		int[] insertionArr = insertionSort(fillArray(10, 20));
		System.out.println("Insertion sort: " + Arrays.toString(insertionArr) + "\n");

		int[] mergeArr = mergeSort(fillArray(10, 200));
		System.out.println("Merge sort: " + Arrays.toString(mergeArr) + "\n");

		String[] insertion = insertionSort(randomStringArray(10, 10));
		System.out.println("Insertion sort: " + Arrays.toString(insertion) + "\n");

		String[] merge = mergeSort(randomStringArray(10, 10));
		System.out.println("Merge sort: " + Arrays.toString(merge) + "{n");

		/*
		 * Both algorithms ideas, I read it from book by Horstmann and implement
		 * it
		 */
	}

	public static int[] insertionSort(int[] in) {

		/*
		 * Create a new array of same size as parameter array and copy all the
		 * integers from parameter array
		 */

		int[] arr = new int[in.length];
		System.arraycopy(in, 0, arr, 0, in.length);

		/* Initialize the variables */

		int temp = 0;
		int count = 0;

		/*
		 * According to theory, we must assume that first element of the array
		 * is sorted. So we will start the loop from 1.
		 */

		for (int i = 1; i < arr.length; i++) {

			/*
			 * Save the index i element in the temp and start count from same
			 * number as i
			 */
			temp = arr[i];
			count = i;

			/*
			 * Until count is greater than 0 and temp is smaller than previous
			 * elements swap the positions.
			 */
			while (count > 0 && temp <= arr[count - 1]) {
				arr[count] = arr[count - 1];
				count--;
				/*
				 * decrease count by 1 because we must set the array in
				 * ascending order
				 */
			}
			arr[count] = temp; // save the smaller integer
		}

		return arr;
	}

	public static int[] mergeSort(int[] in) {

		/*
		 * Create a new array of same size as parameter array and initialize the
		 * variables
		 */
		int[] arr = new int[in.length];
		int[] left;
		int[] right;
		int count = 0;
		int first = 0;
		int second = 0;

		System.arraycopy(in, 0, arr, 0, in.length); // copy the elements

		/* No need to sort, if length is 1 */
		if (in.length == 1)
			return arr;
		else {

			/*
			 * Divide the elements in two parts and and save them in the arrays
			 */
			left = new int[in.length / 2];
			right = new int[in.length - left.length];

			System.arraycopy(in, 0, left, 0, left.length);
			System.arraycopy(in, left.length, right, 0, right.length);
		}

		/* Do recursion until we do not get the base case */
		left = mergeSort(left);
		right = mergeSort(right);

		/*
		 * Compare the base case. We will set count for saving the element in
		 * array arr. Variable first and second will give new elements in left
		 * and right array. They will also protect the errors, if one of the
		 * array is smaller than other in size
		 */

		while (first < left.length && second < right.length) {
			if (left[first] <= right[second]) {
				arr[count] = left[first];
				first++;
			} else {
				arr[count] = right[second];
				second++;
			}
			count++;
		}

		/*
		 * Sometimes left or right array contains more element than each other
		 * and we cannot compare them with the help of above loop because it
		 * will through array out of index error. so for that reason we declare
		 * two separate while loops in order to get all the elements. only one
		 * of the loop will run.
		 */

		while (first < left.length) {
			arr[count] = left[first];
			first++;
			count++;
		}

		while (second < right.length) {
			arr[count] = right[second];
			second++;
			count++;
		}
		return arr;

	}

	public static String[] insertionSort(String[] in) {

		/*
		 * The idea behind this string method is same as integer method. The
		 * only difference is rather than using < or > operator (mathematics
		 * operators), I am using compareTo methods because the input variable
		 * is string
		 */

		String[] arr = new String[in.length];
		System.arraycopy(in, 0, arr, 0, in.length);

		String temp;
		int count = 0;

		for (int i = 1; i < arr.length; i++) {

			temp = arr[i];
			count = i;

			while (count > 0 && temp.compareTo(arr[count - 1]) <= 0) {
				arr[count] = arr[count - 1];
				count--;

			}
			arr[count] = temp;
		}

		return arr;
	}

	public static String[] mergeSort(String[] in) {

		/*
		 * The idea behind this string method is same as integer method. The
		 * only difference is rather than using < or > operator (mathematics
		 * operators), I am using compareTo methods because the input variable
		 * is string
		 */

		String[] arr = new String[in.length];
		System.arraycopy(in, 0, arr, 0, in.length);
		String[] left;
		String[] right;
		int count = 0;
		int first = 0;
		int second = 0;

		if (in.length == 1)
			return arr;
		else {
			left = new String[in.length / 2];
			right = new String[in.length - left.length];

			System.arraycopy(in, 0, left, 0, left.length);
			System.arraycopy(in, left.length, right, 0, right.length);
		}
		left = mergeSort(left);
		right = mergeSort(right);

		while (first < left.length && second < right.length) {
			if (left[first].compareTo(right[second]) <= 0) {
				arr[count] = left[first];
				first++;
			} else {
				arr[count] = right[second];
				second++;
			}
			count++;
		}

		while (first < left.length) {
			arr[count] = left[first];
			first++;
			count++;
		}

		while (second < right.length) {
			arr[count] = right[second];
			second++;
			count++;
		}
		return arr;

	}

	/* for filling the array with random numbers */
	private static int[] fillArray(int length, int n) {
		Random ran = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(n);
		}
		return arr;
	}

	/* Fill the array with random letters */
	private static String[] randomStringArray(int length, int n) {
		Random ran = new Random();
		String[] arr = new String[length];
		String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		if (n >= letter.length || n <= 0)
			n = letter.length - 1;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = letter[ran.nextInt(n)] + letter[ran.nextInt(n)]; // +
																		// letter[ran.nextInt(n)]
																		// ;
		}
		return arr;
	}
}