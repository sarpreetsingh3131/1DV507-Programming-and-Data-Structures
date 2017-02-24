package sb223ce_assign4.BinaryHeap;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		PriorityQueue a = new BinaryQueueHeap();

		String[] tasks = new String[] { "Wake up", "Brush your teeth", "Take shower", "Pray", "Eat breakfast",
				"Get ready for college", "Find the class", "Attend the class", "Eat lunch", "Speak with family",
				"Do assignments" };

		for (int i = 1; i < 10; i++) {
			Task t = new WorkTask(i, tasks[i - 1]);
			a.insert(t);
		}
		Task tt = new WorkTask(1, "sleep 1");
		a.insert(tt);

		System.out.println("Size: " + a.size());
		System.out.println("Empty: " + a.isEmpty());
		System.out.println("Peek : " + a.peekHighest());
		System.out.println("String: " + a.toString() + "\n");
		System.out.println("Pull: " + a.pullHighest());
		System.out.println("Peek : " + a.peekHighest());
		System.out.println("Size: " + a.size() + "\n");
		// a.clear();
		String[] arr = a.toArray();
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Contains: " + a.contains(tt));
		System.out.println("Contains: " + a.contains(tt));
		System.out.println("String: " + a.toString() + "\n");
		//a.remove(tt);

		Task tt1 = new WorkTask(1, "Number 1");

		System.out.println(tt.equals(tt1));
		System.out.println("\nIterator");
		Iterator<Task> it = a.iterator();
		while (it.hasNext())
			System.out.println(it.next());

	}

}
