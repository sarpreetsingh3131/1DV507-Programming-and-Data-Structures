package sb223ce_assign2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.*;
import sb223ce_assign2.LinkedQueue.Queue;
import sb223ce_assign2.ArrayQueue.*;
import sb223ce_assign2.LinkedQueue.*;

public class QueueJUnitTest {
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
	public void testInitSize() {
		/* Empty */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		assertEquals(0, queue.size(), array.size());

		/* Filled */
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
			array.enqueue(i);
		}

		assertEquals(1000, queue.size(), array.size());

	}

	/* Check isEmpty */
	@Test
	public void testIsEmpty() {
		/* Empty */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		assertEquals(true, queue.isEmpty());
		assertEquals(true, array.isEmpty());

		/* Not Empty */
		queue.enqueue(100);
		array.enqueue(100);

		assertEquals(false, queue.isEmpty());
		assertEquals(false, array.isEmpty());
	}

	/* Check Enqueue */
	@Test
	public void testEnqueue() {
		/* Add Object At Last Position */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			array.enqueue(i);
			assertEquals(i, queue.last()); /* Check */
			assertEquals(i, array.last());
		}

		/* Check First Element */
		assertEquals(0, queue.first());
		assertEquals(0, array.first());

	}

	/* Check Dequeue */
	@Test
	public void testDequeue() {
		/* Add 10 Objects */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			array.enqueue(i);
		}

		/* Remove The Object One By One */
		for (int i = 0; i < 10; i++) {
			assertEquals(i, queue.dequeue()); /* Check */
			assertEquals(i, array.dequeue());
		}

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue1 = new LinkedQueue();
		Queue array1 = new ArrayQueue();

		boolean res1 = false;
		try {
			queue1.dequeue();
			array1.dequeue();
		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check First Object */
	@Test
	public void testObjectFirst() {
		/* Add 5 Objects */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
			array.enqueue(i);
		}

		assertEquals(0, queue.first()); /* Check */
		assertEquals(0, array.first());

		/* New Queue With Only 1 Element */
		Queue queue1 = new LinkedQueue();
		Queue array1 = new ArrayQueue();

		queue1.enqueue(100);
		array1.enqueue(100);

		assertEquals(100, queue1.first()); /* Check */
		assertEquals(100, array1.first());

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue2 = new LinkedQueue();
		Queue array2 = new ArrayQueue();

		boolean res1 = false;
		try {
			queue2.first();
			array2.first();
		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check First Object */
	@Test
	public void testObjectLast() {
		/* Add 5 Objects */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
			array.enqueue(i);
			assertEquals(i, queue.last()); /* Check */
			assertEquals(i, array.last());
		}

		/* New Queue With Only 1 Element */
		Queue queue1 = new LinkedQueue();
		Queue array1 = new ArrayQueue();

		queue1.enqueue(100);
		array1.enqueue(100);

		assertEquals(100, queue1.last()); /* Check */
		assertEquals(100, array1.last());

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue2 = new LinkedQueue();
		Queue array2 = new ArrayQueue();

		boolean res1 = false;
		try {
			queue2.last();
			array2.last();
		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check String */
	@Test
	public void testString() {
		/* Empty Queue */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		String str = "[ ]";
		assertEquals(str, queue.toString(), array.toString());

		/* Filled Queue */
		Queue queue1 = new LinkedQueue();
		Queue array1 = new ArrayQueue();

		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < 5; i++) {
			queue1.enqueue(i);
			array1.enqueue(i);
			s.append(" " + i);
		}
		s.append(" ]");
		assertEquals(s.toString(), queue1.toString(), array1.toString());

		/* Remove Element From Queue */
		for (int i = 0; i < 4; i++) {
			queue1.dequeue();
			array1.dequeue();
		}
		String ss = "[ 4 ]";
		assertEquals(ss, queue1.toString(), array1.toString());
	}

	/* Check Iterator */
	@Test
	public void testIterator() {
		/* Filled Queue */
		Queue queue = new LinkedQueue();
		Queue array = new ArrayQueue();

		Iterator que = queue.iterator();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);

			while (que.hasNext()) {
				assertEquals(i, que.next());
			}
		}

		Iterator arr = array.iterator();
		for (int i = 0; i < 10; i++) {
			array.enqueue(i);
			while (arr.hasNext()) {
				assertEquals(i, arr.next());
			}
		}

		/* Empty Queue */
		Queue queue1 = new LinkedQueue();
		Queue array1 = new ArrayQueue();

		Iterator que1 = queue1.iterator();
		Iterator arr1 = array1.iterator();

		assertEquals(false, que1.hasNext());
		assertEquals(false, arr1.hasNext());

		boolean res1 = false;
		try {
			que1.next();
			arr1.next();
		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

}
