package sb223ce_assign4.BinaryHeap;

import java.util.Iterator;

public interface PriorityQueue{

	void insert(Task t); // add task

	Task pullHighest(); // return and remove highest priority task

	boolean contains(Task a); // return true if queue contains the task

	int size(); // return current number of tasks in queue

	boolean isEmpty(); // return true, if queue is empty

	Task peekHighest(); // return highest priority task

	String toString(); // to string

	void clear(); // remove all the tasks the queue

	String[] toArray(); // return array containing all the current tasks in
						// queue

	Iterator<Task> iterator(); // return iterator

	void remove(Task t); // remove the task if present in the queue

}
