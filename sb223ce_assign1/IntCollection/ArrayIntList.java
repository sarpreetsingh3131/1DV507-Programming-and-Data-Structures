package sb223ce_assign1.IntCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	/* Simply add the element and resize if needed */
	@Override
	public void add(int n) {
		if (size == values.length)
			resize();
		values[size++] = n;
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (size == values.length)
			resize();
		/* I add 1 in size in order to add element at index 0 when array is
		 * empty as well as for adding element after the last element. Without
		 * this, I could not add element at index 0 when array is empty*/
		if (checkIndex(index, size + 1) == true) {
			for (int i = size - 1; i >= index; i--) {
				values[i + 1] = values[i]; // shift the element to next position
			}
			values[index] = n;
			size++;
		} else
			throw new IndexOutOfBoundsException();
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index, size) == true) {
			for (int i = index; i < size - 1; i++) {
				values[i] = values[i + 1]; // replace the index element with
											// next element without saving it
			}
			size--;
		} else
			throw new IndexOutOfBoundsException();
	}

	/* return element if index is with in the bounds */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index, size) == true)
			return values[index];
		else
			throw new IndexOutOfBoundsException();
	}

	/* If element is present return index i, else -1 */
	@Override
	public int indexOf(int n) {
		for (int i = 0; i < size; i++) {
			if (values[i] == n)
				return i;
		}
		return -1;
	}

}
