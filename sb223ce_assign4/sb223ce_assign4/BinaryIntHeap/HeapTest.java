package sb223ce_assign4.BinaryIntHeap;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sb223ce_assign4.BinaryHeap.*;

public class HeapTest {
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

	/* Check size */
	@Test
	public void testSize() {
		/* Empty */
		BinaryIntHeap heap = new BinaryIntHeap();
		assertEquals(0, heap.size());
		/* Not empty */
		for (int i = 0; i < 1000; i++) {
			assertEquals(i, heap.size());
			heap.insert(i);
		}
		assertEquals(1000, heap.size());
	}

	/* Check isEmpty */
	@Test
	public void testIsEmpty() {
		/* Empty */
		BinaryIntHeap heap = new BinaryIntHeap();
		assertEquals(true, heap.isEmpty());

		/* Add 1 element */
		heap.insert(1);
		assertEquals(false, heap.isEmpty());

		/* Add 1000 elements more */
		for (int i = 0; i < 1000; i++) {
			heap.insert(i);
		}

		/*
		 * Now take out all the elements. As I added 1 element separately, thats
		 * why I am running loop equal to 1000
		 */
		for (int i = 0; i <= 1000; i++) {
			heap.pullHighest();
		}
		assertEquals(true, heap.isEmpty());
	}

	/* Check pullHigehst */
	@Test
	public void testPullHighest() {
		BinaryIntHeap heap = new BinaryIntHeap();

		/* Add 1000 elements */
		for (int i = 0; i < 1000; i++) {
			heap.insert(i);
		}
		/*
		 * Take out all the elements and check if it is highest then rest of the
		 * element
		 */
		for (int i = 999; i >= 0; i--) {
			assertEquals(i, heap.pullHighest());
		}

		/* Check if throw error when queue is empty */
		boolean a = false;
		try {
			heap.pullHighest();
		} catch (IllegalArgumentException e) {
			a = true;
		}
		assertTrue(a);

	}

	/* Check Insert and toString */
	@Test
	public void testInsert() {
		BinaryIntHeap heap = new BinaryIntHeap();
		Random ran = new Random();

		/* For comparing, I am using array list */
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(null); // we will not use first position

		/* Add 1000 random element */
		for (int i = 1; i < 10000; i++) {

			// positive elements
			if (i % 2 == 0) {
				heap.insert(ran.nextInt((i + 1) * 2));
			}
			// negative elements
			else {
				int s = ran.nextInt((i + 1) * 2);
				heap.insert(-s);
			}
		}
		String str = heap.toString(); // save all the elements in string
		StringBuilder s = new StringBuilder();

		/*
		 * Run for loop on string and save all the elements in array list. I am
		 * taking each character at a time and checking if it is a digit. If
		 * yes, I am saving it in a string builder. I know that I separate the
		 * integers by comma in toString method. So when comma will come I am
		 * just converting string builder to string and saving it in array.
		 */
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				s.append(c);

			} else if (c == '-') { // for negative integers
				s.append(c);
			} else if (c == ',') {
				arr.add(Integer.valueOf(s.toString()));
				s = new StringBuilder(); // renew the string builder
			} else if (c == ']') { // for getting last element
				arr.add(Integer.valueOf(s.toString()));
				s = new StringBuilder(); // renew the string builder
			}

		}
		/*
		 * Here I am checking if the parent is bigger than its both children. I
		 * am running for loop from 1(0 index we are not using) up to less than
		 * array size. Then check if element at index i have both children. If
		 * yes, check element at index i is bigger or equal to its both
		 * children. Sometimes elements have only one child and for that I have
		 * two separate statements. If my first statement will be false then one
		 * of this statement will run. These statements also check if parent is
		 * bigger than children
		 */

		for (int i = 1; i < arr.size(); i++) {
			if (i * 2 < arr.size() && i * 2 + 1 < arr.size()) {
				int left = arr.get(arr.indexOf(arr.get(i)) * 2);
				int right = arr.get(arr.indexOf(arr.get(i)) * 2 + 1);
				assertEquals(true, arr.get(i) >= left);
				assertEquals(true, arr.get(i) >= right);
			} else if (i * 2 < arr.size()) {
				int left = arr.get(arr.indexOf(arr.get(i)) * 2);

				assertEquals(true, arr.get(i) >= left);
			} else if (i * 2 + 1 < arr.size()) {
				int right = arr.get(arr.indexOf(arr.get(i)) * 2 + 1);

				assertEquals(true, arr.get(i) >= right);
			}
		}
	}
}