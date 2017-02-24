package sb223ce_assign2.LinkedQueue;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {

		LinkedQueue lq = new LinkedQueue();

		for (int i = 1; i <= 10; i++) {
			lq.enqueue(i);
		}

		System.out.println("Size: " + lq.size());
		System.out.println("String: " + lq.toString());
		System.out.println("Last object: " + lq.last());
		System.out.println("Remove and Return first element: " + lq.dequeue());
		System.out.println("Size: " + lq.size());
		System.out.println("First object: " + lq.first());
		System.out.println("Last object: " + lq.last());
		System.out.println("Remove and Return first element: " + lq.dequeue());
		System.out.println("String: " + lq.toString());
		Iterator i = lq.iterator();
		while (i.hasNext()) {

			System.out.println(i.next());

		}

	}
}
