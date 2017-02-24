package sb223ce_assign4.Exercise4;

import java.util.ArrayList;
import java.util.Random;

public class Experiment {

	/* Extra */
	// private static ArrayList<Integer> time = new ArrayList<Integer>();
	// private static ArrayList<Integer> arrayLength = new ArrayList<Integer>();

	public static void main(String[] args) {

		/* Described this all in report */

		// doIntInsertionSort();
		// doStringInsertionSort();
		// doIntMergeSort();
		// doStringMergeSort();

		/* Extra */
		// System.out.println("Average Time: " + getAverage(time) + " Average
		// Length: " + getAverage(arrayLength));
	}

	public static void doIntInsertionSort() {
		int length = 1000;
		int number = length * 2;
		int[] insertionArr = fillArray(length, number);
		int runTime = 0;
		while (runTime < 1000) {
			long start = System.currentTimeMillis();
			insertionSort(insertionArr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			System.out.println("Approximate time: " + runTime + " milliseconds.  Total length: " + insertionArr.length);

			/* To get accurate result */
			if (runTime == 999 || runTime == 1000 || runTime == 1001) {
				break;
			} else if (runTime > 1001 && runTime <= 1050) {
				insertionArr = fillArray(insertionArr.length - 1, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime > 1050) {
				insertionArr = fillArray(insertionArr.length - 500, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime <= 950) {
				insertionArr = fillArray(insertionArr.length + 1000, insertionArr.length * 2);
				runTime = 0;
			} else {
				/* Extra */
				// time.add(runTime);
				// arrayLength.add(insertionArr.length);
				insertionArr = fillArray(insertionArr.length + 1, insertionArr.length * 2);
			}
		}
	}

	public static void doStringInsertionSort() {
		int length = 1000;
		int number = length * 2;

		String[] insertionArr = randomStringArray(length, number);
		int runTime = 0;
		while (runTime < 1000) {
			long start = System.currentTimeMillis();
			insertionSort(insertionArr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			System.out.println("Approximate time: " + runTime + " milliseconds.  Total length: " + insertionArr.length);

			/* To get accurate result */
			if (runTime == 999 || runTime == 1000 || runTime == 1001) {
				break;
			} else if (runTime > 1001 && runTime <= 1050) {
				insertionArr = randomStringArray(insertionArr.length - 1, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime > 1050) {
				insertionArr = randomStringArray(insertionArr.length - 250, insertionArr.length * 2);
				runTime = 0;
			}

			else if (runTime <= 950) {
				insertionArr = randomStringArray(insertionArr.length + 500, insertionArr.length * 2);
			} else {
				/* Extra */
				// time.add(runTime);
				// arrayLength.add(insertionArr.length);
				insertionArr = randomStringArray(insertionArr.length + 1, insertionArr.length * 2);
			}
		}
	}

	public static void doIntMergeSort() {
		int length = 1000;
		int number = length * 2;

		int[] insertionArr = fillArray(length, number);
		int runTime = 0;
		while (runTime < 1000) {
			long start = System.currentTimeMillis();
			mergeSort(insertionArr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			System.out.println("Approximate time: " + runTime + " milliseconds.  Total length: " + insertionArr.length);

			/* To get accurate result */
			if (runTime == 999 || runTime == 1000 || runTime == 1001) {
				break;
			} else if (runTime > 1001 && runTime <= 1050) {
				insertionArr = fillArray(insertionArr.length - 1, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime <= 950) {
				insertionArr = fillArray(insertionArr.length + 1000, insertionArr.length * 2);
			} else if (runTime > 1050) {
				insertionArr = fillArray(insertionArr.length - 1000, insertionArr.length * 2);
			} else {
				/* Extra */
				// time.add(runTime);
				// arrayLength.add(insertionArr.length);
				insertionArr = fillArray(insertionArr.length + 1, insertionArr.length * 2);
			}
		}
	}

	public static void doStringMergeSort() {
		int length = 1000;
		int number = length * 2;
		String[] insertionArr = randomStringArray(length, number);

		int runTime = 0;
		while (runTime < 1000) {
			long start = System.currentTimeMillis();
			mergeSort(insertionArr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			System.out.println(
					"Approximate time: " + runTime + " milliseconds.  " + "Total  length: " + insertionArr.length);

			/* To get accurate result */
			if (runTime == 999 || runTime == 1000 || runTime == 1001) {
				break;
			} else if (runTime > 1001 && runTime <= 1050) {
				insertionArr = randomStringArray(insertionArr.length - 1, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime > 1050) {
				insertionArr = randomStringArray(insertionArr.length - 1000, insertionArr.length * 2);
				runTime = 0;
			} else if (runTime <= 950) {
				insertionArr = randomStringArray(insertionArr.length + 10000, insertionArr.length * 2);
			} else {
				/* Extra */
				// time.add(runTime);
				// arrayLength.add(insertionArr.length);
				insertionArr = randomStringArray(insertionArr.length + 1, insertionArr.length * 2);
			}
		}

	}

	/* Fill the array with random letters */
	private static String[] randomStringArray(int length, int n) {
		Random ran = new Random();
		String[] arr = new String[length];
		String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
				"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		if (n >= letter.length || n <= 0)
			n = letter.length;
		StringBuilder s;
		for (int i = 0; i < arr.length; i++) {
			s = new StringBuilder();
			int count = 0;
			while (count != 10) {
				s.append(letter[ran.nextInt(n)]);
				count++;
			}
			arr[i] = s.toString();

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

	/* Extra: To find average */
	private static int getAverage(ArrayList<Integer> a) {
		int average = 0;
		for (int i = 0; i < a.size(); i++) {
			average = average + a.get(i);
		}
		average = Math.round(average / a.size());
		return average;
	}

	/* ALGORITHMS */

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

			while (count > 0 && temp.compareToIgnoreCase(arr[count - 1]) <= 0) {
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
			if (left[first].compareToIgnoreCase(right[second]) <= 0) {
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
}