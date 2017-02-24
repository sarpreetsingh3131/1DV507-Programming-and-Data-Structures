package sb223ce_assign2.ArrayQueue;

import java.util.Iterator;

public class ArrayQueueMain {

	public static void main(String[] args) {
		ArrayQueue a = new ArrayQueue();

		for (int i = 0; i < 15; i++) {

			a.enqueue(i);

			System.out.println("First Element: " + a.first());
			System.out.println("Last Element: " + a.last());

			System.out.println("String: " + a.toString());

			System.out.println("Size: " + a.size());
			System.out.println();

		}

		System.out.println("Dequeue");
		for (int i = 0; i < 14; i++) {
			a.dequeue();
			System.out.println("First Element: " + a.first());
			System.out.println("Last Element: " + a.last());

			System.out.println("String: " + a.toString());

			System.out.println("Size: " + a.size());
			System.out.println();

		}
		System.out.println("Enqueue");
		for (int i = 0; i < 2; i++) {
			a.enqueue(i);

			System.out.println("First Element: " + a.first());
			System.out.println("Last Element: " + a.last());

			System.out.println("String: " + a.toString());

			System.out.println("Size: " + a.size());
			System.out.println();

		}

		Iterator s = a.iterator();

		while (s.hasNext()) {
			System.out.println(s.next());
		}

	}
}