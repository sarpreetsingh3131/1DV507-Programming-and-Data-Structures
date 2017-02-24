package sb223ce_assign4.BinaryIntHeap;

public class BinaryIntHeap {

	/* I implement this with the help of lecture notes. */

	// Fields
	private int[] queue;
	private int size;

	// Constructor
	public BinaryIntHeap() {
		queue = new int[10];
		size = 1; // 1st position must be empty
	}

	/*
	 * According to theory, I must save the first element at position 1 in the
	 * array. For that reason I initialize the size variable from 1. Every time
	 * When I return the size of array, I am reducing 1 from size variable in
	 * order to give correct size.
	 */

	public boolean isEmpty() {
		return size == 1;
	}

	public int size() {
		return size - 1;
	}

	/*
	 * In this method, I am saving the element at position 1 during first time
	 * and increasing the size. During other times, I am simply adding the
	 * elements at position size and increasing the size by 1. In both cases I
	 * am using check() method. I explain this method separately.
	 */
	public void insert(int n) {
		if (size == 1) {
			queue[size] = n;
			size++;
		} else if (size > 1) {
			if (size == queue.length) // resize
				resize();
			queue[size++] = n;
		}
		int index = size - 1;
		check(index);
	}

	/*
	 * In this method, I am getting the index of recently added element as a
	 * parameter. If the index is 1 (first position) then return. This condition
	 * will work in two ways. First, when we will add the first element, this
	 * method will return immediately. Second, when we will do the recursion and
	 * we reached at index 1 where we know that there is no parent of this
	 * element, then we will return. The other condition will return if the
	 * element at parameter index is smaller than its parent element. If both
	 * conditions will be false, then I am doing recursion for reaching up to
	 * the base cases. In recursion, I am first saving the parameter index and
	 * parent of parameter index element. Then I am also saving the index of
	 * parent. At last I am just swapping the elements and performing recursion.
	 */

	private void check(int a) {
		if (a == 1) {
			return;
		} else if (queue[a] <= queue[a / 2])
			return;
		else {
			int pos = a;
			int temp = queue[a / 2];
			int index = a / 2;
			queue[index] = queue[a];
			queue[pos] = temp;
			check(index);
		}
	}

	/*
	 * In this method, I am throwing error if array is empty. Otherwise,I am
	 * picking the first element and saving it in a variable. Then according to
	 * theory, I am swapping the element at position last with position 1. After
	 * this, I must decrease the size by 1 as removed the element at position 1
	 * and save last element at this position. At last, I am doing the recursion
	 * for correcting the tree as the element at position 1 is smaller than its
	 * children. I am giving index 1 for the recursion because we know that its
	 * 1 as we moved it from last to first position.
	 * 
	 * I have one question in this method, After swapping the positions I must
	 * have to delete the decrease the size as I pulled one element. For that, I
	 * have two ways, for one I made method remove() in which I am simply for
	 * loop up to size -1 and saving the all elements other array and then back
	 * to queue array.I think the more better way to do this is just simply
	 * reduce the size by 1. By this when user will add new elements I will just
	 * overwrite the last element. I want your advice too ?
	 */
	public int pullHighest() {
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		int highest = queue[1];
		queue[1] = queue[size - 1];
		/* Use one of this, either remove() or size-- */
		remove();
		// size--;
		int index = 1;
		swap(index);
		return highest;
	}

	private void remove() {
		int[] temp = new int[queue.length];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
		size--;
	}

	/*
	 * In this method, Again I am taking element index number as a parameter. I
	 * made two base cases in this. One where I am checking if the parameter
	 * index is last index of array or if element at parameter index have no
	 * child then return. In second case, I am simply checking If element at
	 * parameter index is greater or equal to both of its children. If yes,
	 * return. Otherwise, I am checking which child is bigger, and then just
	 * swap the element with that child.
	 */

	private void swap(int a) {
		if (a == size - 1 || a * 2 > size - 1 || a * 2 + 1 > size - 1) {
			return;
		}
		int left = queue[a * 2];
		int right = queue[a * 2 + 1];
		if (queue[a] >= left && queue[a] >= right) {
			return;
		} else {
			if (left >= right) {
				int temp = queue[a];
				queue[a] = left;
				queue[a * 2] = temp;
				swap(a * 2);
			} else {
				int temp = queue[a];
				queue[a] = right;
				queue[a * 2 + 1] = temp;
				swap(a * 2 + 1);
			}
		}
	}

	/* Simply adding all the elements from array to string builder */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < size; i++) {
			if (i == size - 1) {
				str.append(queue[i]);
			} else
				str.append(queue[i] + ", ");
		}
		return "[" + str.toString() + "]";
	}

	/*
	 * Creating a new array double the size of queue array and saving all the
	 * elements in it from queue array.
	 */
	private void resize() {
		int[] temp = new int[queue.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}
}