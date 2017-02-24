package sb223ce_assign1;

import java.util.Arrays;

public class PascalMain {

	public static void main(String[] args) {

		int[] a = pascalRow(4);
		System.out.println(Arrays.toString(a));

	}

	/*
	 * As we already know that the nth row size is always greater than the
	 * number n by 1, So we will create an array whose size is n + 1. We also
	 * know that the first and last number is 1 in Pascal triangle so we will
	 * assign the values in the beginning. For adding the previous numbers
	 * together, I am running loop from 1 because we already assigned the O
	 * position. I want to know if I could add the previous elements without
	 * using loop. First, I thought that I can make a separate method for adding
	 * the numbers, then I thought that Jonus told us that make the recursion
	 * method short.
	 */

	public static int[] pascalRow(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Row must be positive");
		int[] num = new int[n + 1];
		int[] row = new int[num.length];

		num[0] = 1;
		num[n] = 1;

		if (n == 0)
			return num;

		row = pascalRow(n - 1);

		for (int i = 1; i < row.length; i++) {

			num[i] = row[i - 1] + row[i];
		}

		return num;
	}

	// This method can also be used to print array
	public static void toString(int[] a) {

		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + " ");
		}
	}

}
