package sb223ce_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentifyWordsMain {

	// Fields
	private static String read = "";
	private static String str;
	private static String readFilePath;
	private static File file;

	public static void main(String[] args) {

		/* type the file path to read the file */
		readFilePath = "/Users/SarpreetSingh/Documents/p.txt";

		readFile(readFilePath); // method call

	}

	public static void readFile(String path) {

		try {
			/* create a new file by using method parameter argument */
			file = new File(path);

			Scanner scan = new Scanner(file); // read the file

			while (scan.hasNextLine()) { // Read the file until it has next line

				/*
				 * save the file in string, I used line break in order to make
				 * the file look exactly the same as it is in the original file
				 */
				str = scan.nextLine() + "\n";

				/* Now read the string character by character */
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);

					/*
					 * If character is letter or whitespace, add it in the
					 * string
					 */
					if (Character.isLetter(c) || Character.isWhitespace(c)) {
						read = read + c;
					}
					/*
					 * In order to get 350 words, as it is mentioned in the
					 * assignment, I replace the dash '-' with space, otherwise
					 * i get 349 words
					 */
					else if (c == '-')
						read = read + " ";
				}
			}

			writeFile(); // method call
			System.out.println("Your file has been succesfully read and created. You can find your new file at: "
					+ file.getParentFile() + "/words.txt");
			scan.close();
		}
		/* for catching error while finding/reading the file. */
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/* Write the file */
	private static void writeFile() throws IOException {
		File file1 = new File(file.getParentFile() + "/words.txt");// (createFilePath);
		file1.createNewFile();
		PrintWriter printer = new PrintWriter(file1);
		printer.print(read);
		printer.close();
	}

}