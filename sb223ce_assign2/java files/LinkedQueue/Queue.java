package sb223ce_assign2.LinkedQueue;

import java.util.Iterator;

/**
 * An interface representing a simple Queue. It provides support for accessing
 * element at first and last position without removing. There is one method
 * which return and remove the element at position first. This interface also
 * contains one method which helps to add the element at the end of the queue.
 * There are some other methods which give the size of the queue, nice looking
 * String with all the elements in the queue, boolean method to check if queue
 * is empty and Iterator which runs over all the elements in the queue.
 * 
 * @author SarpreetSingh
 *
 */

public interface Queue {

	/**
	 * Number of current element in the queue.
	 * 
	 * @return Integer
	 */
	public int size();

	/**
	 * Check if the queue is Empty.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * Add object at the end of the queue.
	 * 
	 * @param element
	 *            Object to be added
	 */
	public void enqueue(Object element);

	/**
	 * Return and remove first object in the queue.
	 * 
	 * @return Object
	 */
	public Object dequeue();

	/**
	 * Get object at position first without removing.
	 * 
	 * @return Object
	 */
	public Object first();

	/**
	 * Get object at position last without removing.
	 * 
	 * @return Object
	 */
	public Object last();

	/**
	 * A string representing all the element in the queue.
	 * 
	 * @return String
	 */
	public String toString();

	/**
	 * Iterate over all the element in the queue.
	 * 
	 * @return Iterator
	 */
	public Iterator iterator();

}
