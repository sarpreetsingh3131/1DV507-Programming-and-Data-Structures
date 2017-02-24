package sb223ce_assign2.ArrayQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue implements sb223ce_assign2.LinkedQueue.Queue {

	/* Fields */
	private int size = 0;
	private Object[] values = new Object[5];
	private int first = 0;
	private int last = 0;

	/* Constructor */
	public ArrayQueue() {

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(Object element) {

		/*
		 * Resize if size is equal to array length. During first time add
		 * element at position 0, this will be the first and last element of the
		 * queue. Increase the size. Otherwise, add the element at position size
		 * and increase the size.
		 * 
		 */

		if (size == values.length) {
			resize();
		}

		if (isEmpty() == true) { // during first element
			values[size] = element;
			first = size;
			last = first;
		} else {
			values[size] = element;
			last = size;
		}
		size++;
	}

	@Override
	public Object dequeue() {

		/*
		 * Throw error if array is empty. Otherwise use the private method and
		 * remove and return the object at position first.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		Object obj = remove();
		// shrink(); //will shrink the array and no empty spaces left
		return obj;
	}

	@Override
	public Object first() {
		/*
		 * Throw error if array is empty. Otherwise return the object at
		 * position first.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		return values[first];
	}

	@Override
	public Object last() {

		/*
		 * Throw error if array is empty. Otherwise return the object at
		 * position last.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		return values[last];
	}

	@Override
	public Iterator iterator() {
		return new ArrayQueueIterator();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 0; i < size; i++) {
			str.append(values[i] + " ");
		}
		str.append("]");
		return str.toString();
	}

	// double the array
	private void resize() {
		Object[] temp = new Object[values.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	/*
	 * First take the first element and save it in a variable, then put rest of
	 * the element in new array
	 */
	private Object remove() {
		Object[] temp = new Object[values.length];
		Object a = values[first];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = values[i + 1];
		}
		values = temp;
		last = last - 1;
		/*
		 * change the last position, as we shift the second element to position
		 * first, so we automatically changed the first position.
		 */
		size--;
		return a;

	}

	/* Iterator */
	private class ArrayQueueIterator implements Iterator {

		private int total = 0;

		@Override
		public boolean hasNext() {
			return total < size;
		}

		@Override
		public Object next() {
			return values[total++];
		}

	}

	/*
	 * For removing the unused spaces, not sure if needed. Because I was in
	 * doubt about "The problem with this approach is that after (say) 100
	 * dequeue we will have that first = 100 and 100 non-used elements
	 * (positions 1 to 99) that never will be used again. That is, a waste of
	 * memory." this line.
	 */
	private void shrink() {
		Object[] temp = new Object[size];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];

		}
		values = temp;

	}

}