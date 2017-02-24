package sb223ce_assign4.LinkedQueue;

import java.util.Iterator;

import sb223ce_assign4.LinkedQueue.LinkedQueue;

public class QueueMain {

	public static void main(String[] args) {

		LinkedQueue<Integer> lq = new LinkedQueue<Integer>();

		for (int i = 1; i <= 10; i++) {
			lq.enqueue(i);
		}
		System.out.println("*******Integer Queue********");
		System.out.println("Size: " + lq.size());
		System.out.println("String: " + lq.toString());
		System.out.println("Last element: " + lq.last());
		System.out.println("Remove and Return first element: " + lq.dequeue());
		System.out.println("Size: " + lq.size());
		System.out.println("First element: " + lq.first());
		System.out.println("Last element: " + lq.last());
		System.out.println("Remove and Return first element: " + lq.dequeue());
		System.out.println("String: " + lq.toString());
		Iterator<Integer> ite = lq.iterator();
		while (ite.hasNext()) {

			System.out.println(ite.next());

		}

		LinkedQueue<String> lq1 = new LinkedQueue<String>();

		for (int i = 1; i <= 10; i++) {
			lq1.enqueue("" + i);
		}
		System.out.println("\n*******String Queue********");
		System.out.println("Size: " + lq1.size());
		System.out.println("String: " + lq1.toString());
		System.out.println("Last element: " + lq1.last());
		System.out.println("Remove and Return first element: " + lq1.dequeue());
		System.out.println("Size: " + lq1.size());
		System.out.println("First element: " + lq1.first());
		System.out.println("Last element: " + lq1.last());
		System.out.println("Remove and Return first element: " + lq1.dequeue());
		System.out.println("String: " + lq1.toString());
		Iterator<String> it = lq1.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());

		}

	}
}
