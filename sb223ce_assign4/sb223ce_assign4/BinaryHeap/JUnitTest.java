package sb223ce_assign4.BinaryHeap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

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

	/* Check priority number is positive and greater than 0 */
	@Test
	public void testPriorityNumber() {
		BinaryQueueHeap queue = new BinaryQueueHeap();

		boolean a = false;

		try {
			queue.insert(new WorkTask(-2, "Go"));
		} catch (IllegalArgumentException e) {
			a = true;
		}

		assertTrue(a);

		boolean b = false;

		try {
			queue.insert(new WorkTask(0, "Go"));
		} catch (IllegalArgumentException e) {
			b = true;
		}

		assertTrue(b);

		boolean c = false;

		try {
			queue.insert(new WorkTask(1, "Go"));
		} catch (IllegalArgumentException e) {
			c = true;
		}

		assertFalse(c);

	}

	/* Check size */
	@Test
	public void testSize() {
		/* Empty */
		BinaryQueueHeap queue = new BinaryQueueHeap();
		assertEquals(0, queue.size());

		/* ADD */
		/* I started loop from 1 because task priority must be greater than 0 */
		for (int i = 1; i <= 5; i++) {
			queue.insert(getTask(i));
		}
		assertEquals(5, queue.size());

	}

	/* Check isEmpty */
	@Test
	public void testIsEmpty() {
		/* Empty */
		BinaryQueueHeap queue = new BinaryQueueHeap();
		assertEquals(true, queue.isEmpty());

		/* Add task */
		queue.insert(getTask(1));
		assertEquals(false, queue.isEmpty());
	}

	/* Check Insert */
	@Test
	public void testInsert() {
		PriorityQueue queue = new BinaryQueueHeap();

		ArrayList<Integer> task = new ArrayList<Integer>();
		task.add(null); // we will not use first position

		/*
		 * Add 1000 tasks, I started loop from 1 because task priority must be
		 * greater than 0
		 */
		for (int i = 1; i < 10; i++) {
			queue.insert(getTask(i));
		}

		String str = queue.toString(); // save all the elements in string
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
			} else if (c == ',' || c == ']') {
				String number = s.toString();
				if (number.length() > 0) {
					task.add(Integer.valueOf(number));
					s = new StringBuilder();
				}
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

		for (int i = 1; i < task.size(); i++) {
			if (i * 2 < task.size() && i * 2 + 1 < task.size()) {
				int left = task.get(task.indexOf(task.get(i)) * 2);
				int right = task.get(task.indexOf(task.get(i)) * 2 + 1);
				assertEquals(true, task.get(i) >= left);
				assertEquals(true, task.get(i) >= right);
			} else if (i * 2 < task.size()) {
				int left = task.get(task.indexOf(task.get(i)) * 2);

				assertEquals(true, task.get(i) >= left);
			} else if (i * 2 + 1 < task.size()) {
				int right = task.get(task.indexOf(task.get(i)) * 2 + 1);

				assertEquals(true, task.get(i) >= right);
			}
		}
	}

	/* Check pullHigehst */
	@Test
	public void testPullHighest() {
		BinaryQueueHeap heap = new BinaryQueueHeap();

		/*
		 * Add 1000 elements, I started loop from 1 because task priority must
		 * be greater than 0
		 */
		for (int i = 1; i < 1000; i++) {
			heap.insert(getTask(i));
		}
		/*
		 * Take out all the elements and check if it is highest then rest of the
		 * element
		 */
		for (int i = 999; i >= 1; i--) {
			Task t = heap.pullHighest();
			assertEquals(i, t.getTaskPriority());
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

	/* Test Contain(Task t) */
	@Test
	public void testContain() {
		BinaryQueueHeap heap = new BinaryQueueHeap();
		Task t = new WorkTask(100, "In");
		Task tt = new WorkTask(100, "Out");
		heap.insert(t); // insert
		assertEquals(true, heap.contains(t));
		assertEquals(false, heap.contains(tt));

	}

	/* Test PeekHighest */
	@Test
	public void testPeekHighest() {
		BinaryQueueHeap heap = new BinaryQueueHeap();

		for (int i = 1; i <= 1000; i++) {
			heap.insert(getTask(i));
		}
		assertEquals(1000, heap.peekHighest().getTaskPriority());
		heap.pullHighest();
		assertEquals(999, heap.peekHighest().getTaskPriority());

		/* Check if method throw error */

		// Remove all the elements
		for (int i = 999; i >= 1; i--) {
			heap.pullHighest();
		}

		boolean a = false;
		try {
			heap.peekHighest();
		} catch (IllegalArgumentException e) {
			a = true;
		}
		assertTrue(a);

	}

	/* Check clear */
	@Test
	public void testClear() {
		BinaryQueueHeap heap = new BinaryQueueHeap();

		for (int i = 1; i < 1000; i++) {
			heap.insert(getTask(i));
		}
		Task t = new WorkTask(1, "Java");
		heap.insert(t);

		heap.clear();
		assertEquals(true, heap.isEmpty());
		assertEquals(0, heap.size());
		assertEquals(false, heap.contains(t));

		/* Check if methods throw errors */
		boolean a = false;
		boolean b = false;

		try {
			heap.peekHighest();
		} catch (IllegalArgumentException e) {
			a = true;
		}
		assertTrue(a);

		try {
			heap.pullHighest();
		} catch (IllegalArgumentException e) {
			b = true;
		}
		assertTrue(b);

	}

	/* Check remove(task t) */
	@Test
	public void testRemove() {
		BinaryQueueHeap heap = new BinaryQueueHeap();
		Task t = new WorkTask(1, "Yes");
		Task tt = new WorkTask(1, "No");
		heap.insert(tt);
		heap.insert(t);

		heap.remove(t);
		assertEquals(1, heap.size());
		assertEquals(false, heap.contains(t));
		assertEquals(tt, heap.peekHighest());

		/*
		 * Check if queue throw error when queue is Empty or if task is not
		 * inserted in queue
		 */
		heap.remove(tt);
		Task t1 = new WorkTask(1, "Hi");

		boolean a = false;
		boolean b = false;

		try {
			heap.remove(tt);
		} catch (IllegalArgumentException e) {
			a = true;
		}
		assertTrue(a);

		try {
			heap.remove(t1);
		} catch (IllegalArgumentException e) {
			b = true;
		}
		assertTrue(b);

	}

	/* Iterator */
	@Test
	public void testIterator() {
		BinaryQueueHeap heap = new BinaryQueueHeap();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			heap.insert(getTask(i));
		}
		String str = heap.toString(); // save all the elements in string
		StringBuilder s = new StringBuilder();

		// save in array for comparing
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				s.append(c);
			} else if (c == ',' || c == ']') {
				String number = s.toString();
				if (number.length() > 0) {
					arr.add(Integer.valueOf(number));
					s = new StringBuilder();
				}
			}
		}

		Iterator<Task> it = heap.iterator();
		int count = 0;
		while (it.hasNext()) {

			assertEquals((Object) arr.get(count), (Object) it.next().getTaskPriority());
			count++;
		}
		assertEquals(false, it.hasNext());

		/* Check if iterator throw error */
		boolean a = false;

		try {
			it.next();
		} catch (IllegalArgumentException e) {
			a = true;
		}
		assertTrue(a);

	}

	private Task getTask(int num) {
		Task task;
		Random ran = new Random();
		String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
				"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		int length = letter.length - 1;
		int randomLetter = num;

		if (randomLetter >= length) {
			randomLetter = length;
		}

		String detail = letter[ran.nextInt(randomLetter)] + letter[ran.nextInt(randomLetter)];
		task = new WorkTask(num, detail);
		return task;

	}
}