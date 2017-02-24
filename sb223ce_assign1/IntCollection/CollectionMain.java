package sb223ce_assign1.IntCollection;

import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {

		ArrayIntList array = new ArrayIntList();

		for (int i = 0; i < 10; i++) {
			array.addAt(i, 0);
		}
		System.out.println("****************INT LIST******************");
		System.out.println("Empty: " + array.isEmpty());
		System.out.println("String: " + array.toString());
		System.out.println("Size: " + array.size());
		System.out.println("Get element:  " + array.get(5));
		System.out.println("Index of element: " + array.indexOf(5));

		for (int i = 9; i >= 4; i--) {
			array.remove(i);
		}
		array.add(0);
		System.out.println("String: " + array.toString());
		System.out.println("Size: " + array.size());

		Iterator<Integer> i = array.iterator();
		System.out.print("Iterator:  ");
		while (i.hasNext()) {
			System.out.print(+ i.next() + "  ");
		}
		System.out.println("\n========================================================================");

		ArrayIntStack stack = new ArrayIntStack();

		for (int j = 0; j < 10; j++) {
			stack.push(j);
		}

		System.out.println("**************STACK******************");

		System.out.println("String: " + stack.toString());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Size: " + stack.size());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Size: " + stack.size());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Size: " + stack.size());
		System.out.println("Empty: " + stack.isEmpty());

		Iterator<Integer> it = stack.iterator();
		System.out.print("Iterator:  ");
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
	}
}