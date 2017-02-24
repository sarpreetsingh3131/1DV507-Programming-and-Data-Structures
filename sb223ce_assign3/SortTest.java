package sb223ce_assign3;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;
import sb223ce_assign3.SortingAlgorithms;
import java.util.Random;

public class SortTest {

	private static int test_count = 0;

	/* Is executed before every test method (not test case). */
	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test " + test_count);
	}

	/* Is executed after every test method (not test case). */
	@After
	public void tearDown() {
	}

	/* Check integer insertion sort */
	@Test
	public void testIntInsertionSort() {

		/* Get an array */
		int[] arr = SortingAlgorithms.insertionSort(randomIntArray(20, 300));

		System.out.println("Insertion: " + Arrays.toString(arr) + "\n"); // print
																			// out

		int size = arr.length; // get the size of array

		boolean a = false; // initialize the boolean variable

		/*
		 * run the loop and check if the first variable is smaller than the next
		 * variable
		 */
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				a = true; // if yes, change the boolean
			}
			assertEquals(true, a); // check

			a = false; // again change the variable for next text

		}
	}

	/* Check integer merge sort */
	@Test
	public void testIntMergeSort() {

		/* Get an array */
		int[] arr = SortingAlgorithms.mergeSort(randomIntArray(20, 300));

		System.out.println("Merge: " + Arrays.toString(arr) + "\n"); // print
																		// out

		int size = arr.length;

		boolean a = false;// initialize the boolean variable
		/*
		 * run the loop and check if the first variable is smaller than the next
		 * variable
		 */
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				a = true;
			}
			assertEquals(true, a); // check

			a = false; // again change the variable for next text
		}

	}

	@Test
	public void testStringInsertionSort() {

		/*
		 * The idea behind this is same as integer insertionSort. The only
		 * difference is use compareTo method rather than mathematical operator
		 * because we are going to compare two strings
		 */
		String[] array = SortingAlgorithms.insertionSort(randomStringArray(20, 300));
		System.out.println("Insertion: " + Arrays.toString(array) + "\n");
		int size = array.length;
		boolean a = false;
		for (int i = 0; i < size - 1; i++) {
			if (array[i].compareTo(array[i + 1]) <= 0) {
				a = true;
			}
			assertEquals(true, a);
			a = false;
		}

	}

	@Test
	public void testStringMergeSort() {

		/*
		 * The idea behind this is same as integer insertionSort. The only
		 * difference is use compareTo method rather than mathematical operator
		 * because we are going to compare two strings
		 */
		String[] array = SortingAlgorithms.mergeSort(randomStringArray(20, 300));
		System.out.println("Merge: " + Arrays.toString(array) + "\n");
		int size = array.length;
		boolean a = false;
		for (int i = 0; i < size - 1; i++) {
			if (array[i].compareTo(array[i + 1]) <= 0) {
				a = true;
			}
			assertEquals(true, a);
			a = false;
		}

	}

	/* Fill the array with random letters */
	private String[] randomStringArray(int length, int n) {
		Random ran = new Random();
		String[] arr = new String[length];
		String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		if (n >= letter.length || n <= 0)
			n = letter.length - 1;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = letter[ran.nextInt(n)] + letter[ran.nextInt(n)];
		}
		return arr;
	}

	/* Fill the array with random numbers */
	private int[] randomIntArray(int length, int n) {
		Random ran = new Random();
		int[] arr = new int[length];
		if (n <= 0)
			n = arr.length;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(n);
		}
		return arr;
	}

}
