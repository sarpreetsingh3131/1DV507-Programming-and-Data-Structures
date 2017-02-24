package sb223ce_assign4.ArrayQueue;

import java.util.Iterator;

import sb223ce_assign4.ArrayQueue.ArrayQueue;

public class ArrayQueueMain {

	public static void main(String[] args) {
		ArrayQueue<Integer> a = new ArrayQueue<Integer>();

		for (int i = 0; i < 15; i++) {
			a.enqueue(i);
		}
		System.out.println("********Integer Array Queue*******");
		System.out.println("Enqueue");
		System.out.println("First Element: " + a.first());
		System.out.println("Last Element: " + a.last());
		System.out.println("String: " + a.toString());
		System.out.println("Size: " + a.size());
		System.out.println();

		System.out.println("Dequeue");
		for (int i = 0; i < 10; i++) {
			a.dequeue();
		}
		System.out.println("First Element: " + a.first());
		System.out.println("Last Element: " + a.last());
		System.out.println("String: " + a.toString());
		System.out.println("Size: " + a.size());
		System.out.println();
		System.out.println("Iterator:");
		Iterator<Integer> s = a.iterator();
		while (s.hasNext()) {
			System.out.println(s.next());
		}

		ArrayQueue<String> q2 = new ArrayQueue<String>();

		for (int j = 0; j < 15; j++) {
			q2.enqueue("" + j);

		}
		System.out.println("\n********String Array Queue*******");
		System.out.println("Enqueue");
		System.out.println("First Element: " + q2.first());
		System.out.println("Last Element: " + q2.last());
		System.out.println("String: " + q2.toString());
		System.out.println("Size: " + q2.size());
		System.out.println();

		System.out.println("Dequeue");
		for (int i = 0; i < 10; i++) {
			q2.dequeue();
		}
		System.out.println("First Element: " + q2.first());
		System.out.println("Last Element: " + q2.last());
		System.out.println("String: " + q2.toString());
		System.out.println("Size: " + q2.size());
		System.out.println();
		System.out.println("Iterator:");
		Iterator<String> s1 = q2.iterator();
		while (s1.hasNext()) {
			System.out.println(s1.next());
		}

	}

}