package sb223ce_assign4.Exercise3;

import java.util.ArrayList;
import java.lang.System;

public class TimeMeasuring {

	// Extra
	// private static ArrayList<Integer> time = new ArrayList<Integer>();
	// private static ArrayList<Integer> arrayLength = new ArrayList<Integer>();
	// private static ArrayList<Integer> concatenations = new
	// ArrayList<Integer>();

	public static void main(String[] args) {

		/* Described this all in report */

		for (int i = 0; i < 5; i++) {

			stringWithOneCharacter();
			// stringWith80Characters();
			// stringBuilderWithOneCharacter();
			// stringBuilderWith80Character();

		}

		/* Extra */
		// System.out.println("Average Time: " + getAverage(time) + " Average
		// Length: " + getAverage(arrayLength));

	}

	// To find the average
	public static int getAverage(ArrayList<Integer> a) {

		int average = 0;
		for (int i = 0; i < a.size(); i++) {
			average = average + a.get(i);
		}
		average = Math.round(average / a.size());
		return average;
	}

	public static void stringWithOneCharacter() {

		String string = "";
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			string = string + "a";
		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);
		System.out.println("Approximate time: " + runTime + " milliseconds." + " Total concatenations: "
				+ string.length() + ".  Total length: " + string.length() + "\n");

		/* Extra */
		// time.add(runTime);
		// arrayLength.add(string.length());
		// concatenations.add(string.length());

	}

	public static void stringWith80Characters() {

		String string = "";
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			string = string + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);
		System.out.println("Approximate time: " + runTime + " milliseconds." + "  Total concatenations: "
				+ (string.length() / 80) + ".  Total length: " + string.length() + "\n");

		/* Extra */
		// time.add(runTime);
		// arrayLength.add(string.length());
		// concatenations.add(string.length() / 80);
	}

	public static void stringBuilderWithOneCharacter() {

		StringBuilder str = new StringBuilder();
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str.append("a");
		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);

		long begin = System.currentTimeMillis();
		str.toString();
		long finish = System.currentTimeMillis();
		int toStringTime = (int) (finish - begin);

		StringBuilder newBuilder = new StringBuilder();
		long startPoint = System.currentTimeMillis();
		while (System.currentTimeMillis() - startPoint < 1000 - toStringTime) {
			newBuilder.append("a");
		}
		long endPoint = System.currentTimeMillis();
		int newRunTime = (int) (endPoint - startPoint);

		System.out.println("Before ToString:  Approximate time: " + runTime + " milliseconds."
				+ " Total concatenations: " + str.length() + ".  Total length: " + str.length());
		System.out.println("ToString time: " + toStringTime + " milliseconds.");
		System.out.println("After ToString:  Approximate time: " + (newRunTime + toStringTime)
				+ " milliseconds.  Total concatenations: " + newBuilder.length() + ".  Total Length: "
				+ newBuilder.length() + "\n");

		/* Extra */
		// time.add(newRunTime + toStringTime);
		// arrayLength.add(newBuilder.length());
		// concatenations.add(newBuilder.length());

	}

	public static void stringBuilderWith80Character() {

		StringBuilder str = new StringBuilder();
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);

		long begin = System.currentTimeMillis();
		str.toString();
		long finish = System.currentTimeMillis();
		int toStringTime = (int) (finish - begin);

		StringBuilder newBuilder = new StringBuilder();
		long startPoint = System.currentTimeMillis();
		while (System.currentTimeMillis() - startPoint < 1000 - toStringTime) {
			newBuilder.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		long endPoint = System.currentTimeMillis();
		int newRunTime = (int) (endPoint - startPoint);

		System.out.println("Before ToString:  Approximate time: " + runTime + " milliseconds."
				+ " Total concatenations: " + str.length() + ".  Total length: " + str.length());
		System.out.println("ToString time: " + toStringTime + " milliseconds.");
		System.out.println("After ToString:  Approximate time: " + (newRunTime + toStringTime)
				+ " milliseconds.  Total concatenation: " + (newBuilder.length() / 80) + ".  Total Length: "
				+ newBuilder.length() + "\n");

		/* Extra */
		// time.add(newRunTime + toStringTime);
		// arrayLength.add(newBuilder.length());
		// concatenations.add(newBuilder.length() / 80);

	}
}