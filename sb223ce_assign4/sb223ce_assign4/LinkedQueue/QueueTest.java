package sb223ce_assign4.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.*;
import sb223ce_assign4.LinkedQueue.LinkedQueue;
import sb223ce_assign4.LinkedQueue.Queue;
import sb223ce_assign4.ArrayQueue.ArrayQueue;

public class QueueTest {
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
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		assertEquals(0, queueInteger.size());
		assertEquals(0, queueString.size());
		assertEquals(0, arrayInteger.size());
		assertEquals(0, arrayString.size());

		/* Not Empty */
		for (int i = 0; i < 1000; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);
		}

		assertEquals(1000, queueInteger.size());
		assertEquals(1000, queueString.size());
		assertEquals(1000, arrayInteger.size());
		assertEquals(1000, arrayString.size());
	}

	/* Check isEmpty */
	@Test
	public void testIsEmpty() {
		/* Empty */
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		assertEquals(true, queueInteger.isEmpty());
		assertEquals(true, queueString.isEmpty());
		assertEquals(true, arrayInteger.isEmpty());
		assertEquals(true, arrayString.isEmpty());

		/* Not Empty */
		queueInteger.enqueue(100);
		queueString.enqueue("" + 100);
		arrayInteger.enqueue(100);
		arrayString.enqueue("" + 100);

		assertEquals(false, queueInteger.isEmpty());
		assertEquals(false, queueString.isEmpty());
		assertEquals(false, arrayInteger.isEmpty());
		assertEquals(false, arrayString.isEmpty());
	}

	/* Check Enqueue */
	@Test
	public void testEnqueue() {
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		/* Add element At Last Position */
		for (int i = 0; i < 100; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);

			/* Cast to int from integer for checking */
			assertEquals(i, (int) queueInteger.last()); /* Check */
			assertEquals("" + i, queueString.last());
			assertEquals(i, (int) arrayInteger.last());
			assertEquals("" + i, arrayString.last());
		}

		/* Check First Element */
		assertEquals(0, (int) queueInteger.first());
		assertEquals("" + 0, queueString.first());
		assertEquals(0, (int) arrayInteger.first());
		assertEquals("" + 0, arrayString.first());
	}

	/* Check Dequeue */
	@Test
	public void testDequeue() {
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		/* First add 100 elements */
		for (int i = 0; i < 100; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);
		}

		/* Now, remove the elements One By One */
		for (int i = 0; i < 100; i++) {
			assertEquals(i, (int) queueInteger.dequeue()); /* Check */
			assertEquals("" + i, queueString.dequeue());
			assertEquals(i, (int) arrayInteger.dequeue());
			assertEquals("" + i, arrayString.dequeue());
		}

		/* New Queue For Testing If empty Queue throw error */
		Queue<Integer> queueInteger1 = new LinkedQueue<Integer>();
		Queue<String> queueString1 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger1 = new ArrayQueue<Integer>();
		Queue<String> arrayString1 = new ArrayQueue<String>();

		boolean q1 = false;
		boolean q2 = false;
		boolean a1 = false;
		boolean a2 = false;

		try {
			queueInteger1.dequeue();
		} catch (NoSuchElementException e) {
			q1 = true;
		}
		assertTrue(q1);

		try {
			queueString1.dequeue();
		} catch (NoSuchElementException e) {
			q2 = true;
		}
		assertTrue(q2);

		try {
			arrayInteger1.dequeue();
		} catch (NoSuchElementException e) {
			a1 = true;
		}
		assertTrue(a1);

		try {
			arrayString1.dequeue();
		} catch (NoSuchElementException e) {
			a2 = true;
		}
		assertTrue(a2);

	}

	/* Check First */
	@Test
	public void testFirst() {
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		/* Add 50 elements */
		for (int i = 0; i < 50; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);
		}

		assertEquals(0, (int) queueInteger.first()); /* Check */
		assertEquals("" + 0, queueString.first());
		assertEquals(0, (int) arrayInteger.first());
		assertEquals("" + 0, arrayString.first());

		/* New Queue With Only 1 Element */
		Queue<Integer> queueInteger1 = new LinkedQueue<Integer>();
		Queue<String> queueString1 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger1 = new ArrayQueue<Integer>();
		Queue<String> arrayString1 = new ArrayQueue<String>();

		queueInteger1.enqueue(100);
		queueString1.enqueue("" + 100);
		arrayInteger1.enqueue(100);
		arrayString1.enqueue("" + 100);

		assertEquals(100, (int) queueInteger1.first()); /* Check */
		assertEquals("" + 100, queueString1.first());
		assertEquals(100, (int) arrayInteger1.first()); /* Check */
		assertEquals("" + 100, arrayString1.first());

		/* New Queue For Testing If empty queue through error */
		Queue<Integer> queueInteger2 = new LinkedQueue<Integer>();
		Queue<String> queueString2 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger2 = new ArrayQueue<Integer>();
		Queue<String> arrayString2 = new ArrayQueue<String>();

		boolean q1 = false;
		boolean q2 = false;
		boolean a1 = false;
		boolean a2 = false;

		try {
			queueInteger2.first();
		} catch (NoSuchElementException e) {
			q1 = true;
		}
		assertTrue(q1);

		try {
			queueString2.first();
		} catch (NoSuchElementException e) {
			q2 = true;
		}
		assertTrue(q2);

		try {
			arrayInteger2.first();
		} catch (NoSuchElementException e) {
			a1 = true;
		}
		assertTrue(a1);

		try {
			arrayString2.first();
		} catch (NoSuchElementException e) {
			a2 = true;
		}
		assertTrue(a2);

	}

	/* Check Last */
	@Test
	public void testLast() {
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		/* Add 50 elements */
		for (int i = 0; i < 50; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);

			assertEquals(i, (int) queueInteger.last()); /* Check */
			assertEquals("" + i, queueString.last());
			assertEquals(i, (int) arrayInteger.last());
			assertEquals("" + i, arrayString.last());
		}

		/* New Queue With Only 1 Element */
		Queue<Integer> queueInteger1 = new LinkedQueue<Integer>();
		Queue<String> queueString1 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger1 = new ArrayQueue<Integer>();
		Queue<String> arrayString1 = new ArrayQueue<String>();

		queueInteger1.enqueue(100);
		queueString1.enqueue("" + 100);
		arrayInteger1.enqueue(100);
		arrayString1.enqueue("" + 100);

		assertEquals(100, (int) queueInteger1.last()); /* Check */
		assertEquals("" + 100, queueString1.last());
		assertEquals(100, (int) arrayInteger1.last());
		assertEquals("" + 100, arrayString1.last());

		/* New Queue For Testing If empty queue through error */
		Queue<Integer> queueInteger2 = new LinkedQueue<Integer>();
		Queue<String> queueString2 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger2 = new ArrayQueue<Integer>();
		Queue<String> arrayString2 = new ArrayQueue<String>();

		boolean q1 = false;
		boolean q2 = false;
		boolean a1 = false;
		boolean a2 = false;

		try {
			queueInteger2.last();
		} catch (NoSuchElementException e) {
			q1 = true;
		}
		assertTrue(q1);

		try {
			queueString2.last();
		} catch (NoSuchElementException e) {
			q2 = true;
		}
		assertTrue(q2);

		try {
			arrayInteger2.last();
		} catch (NoSuchElementException e) {
			a1 = true;
		}
		assertTrue(a1);

		try {
			arrayString2.last();
		} catch (NoSuchElementException e) {
			a2 = true;
		}
		assertTrue(a2);

	}

	/* Check String */
	@Test
	public void testString() {
		/* Empty Queue */
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		String str = "[ ]";
		assertEquals(str, queueInteger.toString());
		assertEquals(str, queueString.toString());
		assertEquals(str, arrayInteger.toString());
		assertEquals(str, arrayString.toString());

		/* Filled Queue */
		Queue<Integer> queueInteger1 = new LinkedQueue<Integer>();
		Queue<String> queueString1 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger1 = new ArrayQueue<Integer>();
		Queue<String> arrayString1 = new ArrayQueue<String>();

		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < 50; i++) {
			queueInteger1.enqueue(i);
			queueString1.enqueue("" + i);
			arrayInteger1.enqueue(i);
			arrayString1.enqueue("" + i);

			s.append(" " + i); // because toString method use space to
								// differentiate elements
		}
		s.append(" ]");
		assertEquals(s.toString(), queueInteger1.toString());
		assertEquals(s.toString(), queueString1.toString());
		assertEquals(s.toString(), arrayInteger1.toString());
		assertEquals(s.toString(), arrayString1.toString());

		/* Remove Element From Queue and leave last 5 elements */
		for (int i = 0; i < 45; i++) {
			queueInteger1.dequeue();
			queueString1.dequeue();
			arrayInteger1.dequeue();
			arrayString1.dequeue();
		}
		String ss = "[ 45 46 47 48 49 ]";
		assertEquals(ss, queueInteger1.toString());
		assertEquals(ss, queueString1.toString());
		assertEquals(ss, arrayInteger1.toString());
		assertEquals(ss, arrayString1.toString());

		/* Now, Remove the last 5 elements */
		for (int i = 0; i < 5; i++) {
			queueInteger1.dequeue();
			queueString1.dequeue();
			arrayInteger1.dequeue();
			arrayString1.dequeue();
		}
		String sss = "[ ]";
		assertEquals(sss, queueInteger1.toString());
		assertEquals(sss, queueString1.toString());
		assertEquals(sss, arrayInteger1.toString());
		assertEquals(sss, arrayString1.toString());
	}

	/* Check Iterator */
	@Test
	public void testIterator() {
		/* Filled Queue */
		Queue<Integer> queueInteger = new LinkedQueue<Integer>();
		Queue<String> queueString = new LinkedQueue<String>();
		Queue<Integer> arrayInteger = new ArrayQueue<Integer>();
		Queue<String> arrayString = new ArrayQueue<String>();

		for (int i = 0; i < 100; i++) {
			queueInteger.enqueue(i);
			queueString.enqueue("" + i);
			arrayInteger.enqueue(i);
			arrayString.enqueue("" + i);
		}

		Iterator<Integer> qInteger = queueInteger.iterator();
		Iterator<String> qString = queueString.iterator();
		Iterator<Integer> arrInteger = arrayInteger.iterator();
		Iterator<String> arrString = arrayString.iterator();

		/*
		 * Check if iterator provide the same element which we inserted above
		 */

		int j = 0;
		while (qInteger.hasNext()) {
			assertEquals(j, (int) qInteger.next());
			j++;
		}

		int k = 0;
		while (qString.hasNext()) {
			assertEquals("" + k, qString.next());
			k++;
		}

		int l = 0;
		while (arrInteger.hasNext()) {
			assertEquals(l, (int) arrInteger.next());
			l++;
		}

		int m = 0;
		while (arrString.hasNext()) {
			assertEquals("" + m, arrString.next());
			m++;
		}

		/* Empty Queue */
		Queue<Integer> queueInteger1 = new LinkedQueue<Integer>();
		Queue<String> queueString1 = new LinkedQueue<String>();
		Queue<Integer> arrayInteger1 = new ArrayQueue<Integer>();
		Queue<String> arrayString1 = new ArrayQueue<String>();

		Iterator<Integer> integerQueue = queueInteger1.iterator();
		Iterator<String> stringQueue = queueString1.iterator();
		Iterator<Integer> integerArray = arrayInteger1.iterator();
		Iterator<String> stringArray = arrayString1.iterator();

		assertEquals(false, integerQueue.hasNext());
		assertEquals(false, stringQueue.hasNext());
		assertEquals(false, integerArray.hasNext());
		assertEquals(false, stringArray.hasNext());

		boolean q1 = false;
		boolean q2 = false;
		boolean a1 = false;
		boolean a2 = false;

		/* Check if iterator through error */

		try {
			integerQueue.next();
		} catch (NoSuchElementException e) {
			q1 = true;
		}
		assertTrue(q1);

		try {
			stringQueue.next();
		} catch (NoSuchElementException e) {
			q2 = true;
		}
		assertTrue(q2);

		try {
			integerArray.next();
		} catch (NoSuchElementException e) {
			a1 = true;
		}
		assertTrue(a1);

		try {
			stringArray.next();
		} catch (NoSuchElementException e) {
			a2 = true;
		}
		assertTrue(a2);

	}
}