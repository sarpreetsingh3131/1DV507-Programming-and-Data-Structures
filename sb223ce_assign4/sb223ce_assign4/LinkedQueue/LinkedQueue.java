package sb223ce_assign4.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

	// Fields
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	// Constructor
	public LinkedQueue() {

	}

	// Inner class
	private class Node {

		// Fields
		private T data;
		private Node next;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void enqueue(T element) {
		if (isEmpty() == true) {
			Node newNode = new Node();
			newNode.data = element;
			head = newNode;
			tail = head;

		} else {
			Node newNode = new Node();
			newNode.data = element;
			tail.next = newNode;
			tail = tail.next;
		}
		size++;

	}

	@Override
	public T dequeue() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		T element = head.data;
		head = head.next;
		size--;
		return element;
	}

	@Override
	public T first() {
		if (head == null) {
			throw new NoSuchElementException();
		} else
			return head.data;
	}

	@Override
	public T last() {
		if (tail == null) {
			throw new NoSuchElementException();
		} else
			return tail.data;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Node newNode = new Node();
		newNode = head;
		str.append("[");
		while (newNode != null) {
			str.append(" " + newNode.data);
			newNode = newNode.next;
		}
		str.append(" ]");
		return str.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedQueueIterator<T>();
	}

	// Inner class
	private class LinkedQueueIterator<X> implements Iterator<X> {

		// Field
		private Node position = null;

		@Override
		public boolean hasNext() {

			/*
			 * In the beginning, position is null, so this method will return
			 * true only if queue is not empty, otherwise false. In other case,
			 * position is increasing by 1, this method will return true until
			 * position is reached up to the tail.
			 */

			if (position == null) {
				return head != null;
			} else
				return position.next != null;

		}

		@SuppressWarnings("unchecked")
		@Override
		public X next() {

			/*
			 * Throw error if iterator already runs over all the elements in the
			 * queue. In the first case, this method will only run if above
			 * method is true. In other cases, it will return elements until the
			 * position will not reached up to the tail.
			 */

			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (position == null) {
				position = head;
			} else {
				position = position.next;
			}
			return (X) position.data;

		}

	}
}
