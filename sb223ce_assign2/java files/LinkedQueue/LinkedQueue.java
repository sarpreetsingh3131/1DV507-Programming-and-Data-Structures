package sb223ce_assign2.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements the queue interface and represent a linked queue.
 * 
 * @author SarpreetSingh
 */

public class LinkedQueue implements Queue {

	// Fields
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	/**
	 * This constructs an empty linked queue.
	 */

	public LinkedQueue() {

	}

	/*
	 * This is a inner Node class which helps to reference the element in the
	 * queue.
	 */

	private class Node {

		// Fields
		private Object data;
		private Node next;

	}

	/**
	 * Return the size of queue
	 */

	@Override
	public int size() {
		return size;
	}

	/**
	 * Return true if queue is empty,Otherwise false.
	 */

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Insert Object at last position of the queue.
	 * 
	 * @param element  Object to be added
	 * 
	 *            
	 */

	@Override
	public void enqueue(Object element) {

		/*
		 * If queue is empty, insert the element at the beginning. That element
		 * will be the first and last element of the queue. If not, put the
		 * element next to the tail node and change the tail node position which
		 * represent this new element. Increase the size in both cases.
		 */

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

	/**
	 * This method returns and removes the Object at position first in the
	 * queue.
	 * 
	 * If the queue is empty, this methods throws NoSuchElementException.
	 */

	@Override
	public Object dequeue() {

		/*
		 * If empty, throw exception. Otherwise, remove and return the first
		 * element and change the head node next to this element. Decrease the
		 * size.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		Object element = head.data;
		head = head.next;
		size--;
		return element;
	}

	/**
	 * This method returns the Object at position first in the queue.
	 * 
	 * If the queue is empty, this methods throws NoSuchElementException.
	 */

	/*
	 * I tried to write the throws like
	 * 
	 * @throws NoSuchElementException, but the console gives error. Then I
	 * searched online http://www.javapractices.com/topic/TopicAction.do?Id=171
	 * and I read that I must avoid throws in java doc because it generates it
	 * automatically. Please suggest me if this is not true.
	 */

	@Override
	public Object first() {

		/*
		 * If empty, throw exception. Otherwise, return the first element.
		 */

		if (head == null) {
			throw new NoSuchElementException();
		} else
			return head.data;
	}

	/**
	 * This method returns the Object at position last in the queue.
	 * 
	 * If the queue is empty, this methods throws NoSuchElementException.
	 */

	@Override
	public Object last() {

		/*
		 * If empty, throw exception. Otherwise, return the last element.
		 */

		if (tail == null) {
			throw new NoSuchElementException();
		} else
			return tail.data;
	}

	/**
	 * Represent all the elements in the queue.
	 * 
	 * @return String 
	 * 
	 */

	@Override
	public String toString() {

		/*
		 * Add all the element from head to tail in the string builder. If
		 * empty, return empty queue.
		 * 
		 */

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

	/**
	 * Runs over all the element present in the queue.
	 * 
	 * @return Iterator
	 */

	@Override
	public Iterator iterator() {
		return new LinkedQueueIterator();
	}

	// Inner iterator class
	private class LinkedQueueIterator implements Iterator {

		// field
		private Node position;

		// constructor
		public LinkedQueueIterator() {
			position = null;

		}

		/**
		 * Return true until the iterator does reached up to last Object of the
		 * queue.
		 * 
		 * @return boolean
		 */

		@Override
		public boolean hasNext() {

			/*
			 * In the beginning, position is null, so this method will return
			 * true only if queue is not empty, otherwise false. In other case,
			 * position is increasing by 1, this method will return true until
			 * position is not reached up to the tail.
			 */

			if (position == null) {
				return head != null;
			} else
				return position.next != null;

		}

		/**
		 * This method return Object until the hasnNext() method is true.
		 * 
		 * @return Object
		 */

		@Override
		public Object next() {

			/*
			 * Throw error if iterator already runs over all the elements in the
			 * queue. In the first case, this method will only run if above
			 * method is true. In the last case, it will return elements until
			 * the position will not reached up to the tail.
			 */

			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (position == null) { //
				position = head;
			} else {
				position = position.next;
			}
			return position.data;

		}

	}

}
