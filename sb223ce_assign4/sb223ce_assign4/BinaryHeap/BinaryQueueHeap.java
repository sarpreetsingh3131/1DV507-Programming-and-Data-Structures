package sb223ce_assign4.BinaryHeap;

import java.util.Iterator;

public class BinaryQueueHeap implements PriorityQueue {

	// Fields
	private Task[] task;
	private int size;

	// Constructor
	public BinaryQueueHeap() {
		task = new Task[10];
		size = 1;

	}

	/*
	 * The idea behind this is same as I mentioned in BinaryIntHeap exercise. I
	 * am comparing the task with their priority number.
	 */
	@Override
	public void insert(Task t) {
		if (size == 1) {
			task[size] = t;
			size++;
		} else if (size > 1) {
			if (size == task.length)
				resize();
			task[size++] = t;
		}
		int index = size - 1;
		check(index);
	}

	private void check(int a) {
		if (a == 1) {
			return;
		} else if (task[a].getTaskPriority() <= task[a / 2].getTaskPriority())
			return;
		else {
			int pos = a;
			Task temp = task[a / 2];
			int index = a / 2;
			task[index] = task[a];
			task[pos] = temp;
			check(index);
		}
	}

	private void resize() {
		Task[] temp = new Task[task.length * 2];
		for (int i = 1; i < size; i++) {
			temp[i] = task[i];
		}
		task = temp;
	}

	@Override
	public Task pullHighest() {
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		Task highest = task[1];
		task[1] = task[size - 1];

		/* Use one of this, either remove() or size-- */
		remove();
		// size--;
		int index = 1;
		swap(index);
		return highest;
	}

	private void remove() {
		Task[] temp = new Task[task.length];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = task[i];
		}
		task = temp;
		size--;
	}

	private void swap(int a) {
		if (a == size - 1 || a * 2 > size - 1 || a * 2 + 1 > size - 1) {
			return;
		}
		Task left = task[a * 2];
		Task right = task[a * 2 + 1];
		if (task[a].getTaskPriority() >= left.getTaskPriority()
				&& task[a].getTaskPriority() >= right.getTaskPriority()) {
			return;
		} else {
			if (left.getTaskPriority() >= right.getTaskPriority()) {
				Task temp = task[a];
				task[a] = left;
				task[a * 2] = temp;
				swap(a * 2);
			} else {
				Task temp = task[a];
				task[a] = right;
				task[a * 2 + 1] = temp;
				swap(a * 2 + 1);
			}
		}
	}

	/* Check if task a is present in the array */
	@Override
	public boolean contains(Task a) {
		for (int i = 1; i < size; i++) {
			if (task[i] == a) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size - 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 1;
	}

	// return at position 1
	@Override
	public Task peekHighest() {
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		return task[1];
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < size; i++) {
			if (i == size - 1) {
				str.append(task[i]);
			} else
				str.append(task[i] + ", ");
		}
		return "[" + str.toString() + "]";
	}

	/* Clear every thing */
	@Override
	public void clear() {
		size = 1;
		task = new Task[10];
	}

	// Simply save and return the current tasks in to string array
	@Override
	public String[] toArray() {
		String[] str = new String[size - 1];
		for (int i = 0; i < str.length; i++) {
			str[i] = task[i + 1].toString();
		}
		return str;
	}

	/*
	 * First check if parameter task is present in the task array. If yes, first
	 * find the index of that task and then make a new array of length size -
	 * task index, in other words the number of task after the parameter task
	 * because we are going to delete the task. So I am saving all the tasks
	 * which comes after the deleted task. Then I am decreasing the size for
	 * over writing the array. Means in my insert method I am adding the element
	 * at position size, so when I will decrease the size, then I will over
	 * write the array at those indexes. I will then insert the task which I
	 * saved in a array in order to make the Binary heap correct.
	 */

	@Override
	public void remove(Task t) {
		if (contains(t) == true) {
			Task[] temp;
			int index = getIndex(t);
			temp = new Task[size() - index];
			int count = 0;
			for (int i = index; i < size(); i++) {
				temp[count++] = task[i + 1];
			}
			size = size() - temp.length;
			for (int i = 0; i < temp.length; i++) {
				insert(temp[i]);
			}
		} else // throw error if not present
			throw new IllegalArgumentException("Cannot remove the task: " + t.toString() + "  because it is not present in the queue.");
	}

	// Get index of the task
	private int getIndex(Task t) {
		int index = 0;
		for (int i = 1; i < size; i++) {
			if (task[i] == t) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Iterator
	@Override
	public Iterator<Task> iterator() {
		return new TaskIterator();
	}

	/* Iterator class */
	private class TaskIterator implements Iterator<Task> {

		private int count = 1; // because index 0 is empty

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public Task next() {
			if (!hasNext()) {
				throw new IllegalArgumentException("Queue is empty");
			}
			return task[count++];
		}

	}
}