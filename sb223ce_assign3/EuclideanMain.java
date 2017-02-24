package sb223ce_assign3;

import java.util.Scanner;

public class EuclideanMain {

	public static void main(String[] args) {

		int a = 0;
		int b = 0;
		String input = "";
		Scanner scan = new Scanner(System.in);

		/* User instructions */
		System.out.println("Enter two positive integers in order to get their GCD.");
		System.out.print("Integer 1: ");

		while (scan.hasNext()) {
			input = scan.nextLine();
			if (checkValue(input) == true && Integer.valueOf(input) >= 0) {
				a = Integer.valueOf(input);
				break;
			} else
				System.err.println("Please provide positive integer.");

		}
		System.out.print("Integer 2: ");
		while (scan.hasNext()) {
			input = scan.nextLine();
			if (checkValue(input) == true && Integer.valueOf(input) >= 0) {
				b = Integer.valueOf(input);
				break;
			} else
				System.err.println("Please provide positive integer.");

		}

		System.out.println("GCD of (" + a + "," + b + ") = " + gcd(a, b));

		scan.close();
	}

	public static int gcd(int a, int b) {

		/* Get minimum and maximum */
		int min = checkMin(a, b);
		int max = checkMax(a, b);

		/* If one of the integer is 0, then return other integer */
		if (a == 0 || b == 0)
			return max;

		/* If minimum divides maximum return minimum else do recursion */
		else if (max % min == 0)
			return min;
		else
			return gcd(min, max % min);

	}
	/* Check minimum and maximum in order to return correct GCD */

	public static int checkMin(int a, int b) {
		if (a >= b)
			return b;
		else
			return a;
	}

	public static int checkMax(int a, int b) {
		if (a >= b)
			return a;
		else
			return b;
	}

	/* For preventing unwanted inputs */
	private static boolean checkValue(String a) {
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;

	}
}
