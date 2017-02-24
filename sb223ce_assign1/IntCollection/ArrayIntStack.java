package sb223ce_assign1.IntCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	/* Simply add the element and resize if needed */
	@Override
	public void push(int n) {
		if (size == values.length)
			resize();
		values[size++] = n;

	}

	/*
	 * Throw error if empty, else return top element. I just did size-- for
	 * removing, because next time when user will add element it will over write
	 * the element at position size - 1. I made one alternative method too.
	 */
	@Override
	public int pop() throws IndexOutOfBoundsException {
		if (isEmpty() == true)
			throw new IndexOutOfBoundsException("Stack is empty");

		/* Remove these two lines if want to use remove() */
		 int temp = values[size - 1];  
		 size--;

		//int temp = remove();
		return temp;
	}

	/* Simply return the last element and throw error if stack is empty */
	@Override
	public int peek() throws IndexOutOfBoundsException {
		if (isEmpty() == true)
			throw new IndexOutOfBoundsException("Stack is empty");
		return values[size - 1];
	}

	/* This is alternative method for returning and removing last element */
	private int remove() {
		int[] temp = new int[values.length];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = values[i];
		}
		int element = values[size - 1];
		values = temp;
		size--;
		return element;
	}

}
