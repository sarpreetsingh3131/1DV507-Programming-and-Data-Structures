package sb223ce_assign4.ArrayQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements sb223ce_assign4.LinkedQueue.Queue<T> {

	/* Fields */
	private int size = 0;
	@SuppressWarnings("unchecked")
	private T[] values = (T[]) new Object[10];
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
	public void enqueue(T element) {
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
	public T dequeue() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		T obj = remove();
		shrink(); // will shrink the array and no empty spaces left
		return obj;
	}

	@Override
	public T first() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		return values[first];
	}

	@Override
	public T last() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		return values[last];
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

	@Override
	public Iterator<T> iterator() {

		return new ArrayQueueIterator<T>(values);
	}

	private void resize() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[values.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	private T remove() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[values.length];
		T a = values[first];
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

	private class ArrayQueueIterator<X> implements Iterator<X> {

		private int total = 0;
		private X[] elements;

		public ArrayQueueIterator(X[] xElements) {
			elements = xElements;
		}

		@Override
		public boolean hasNext() {
			return total < size;
		}

		@Override
		public X next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return elements[total++];
		}

	}

	/* For removing the unused spaces, not sure if needed */
	private void shrink() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}
}