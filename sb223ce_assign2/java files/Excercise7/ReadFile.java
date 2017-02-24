package sb223ce_assign2.Excercise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {

	/* Fields */
	private String filePath = "";
	private int[] num = new int[10];
	private int other = 0;
	private int from1To100 = 0;
	private String read = "";

	/* Constructor */
	public ReadFile() {

	}

	/* Another constructor with parameter */
	public ReadFile(String path) {
		filePath = path;
	}

	/* Getter and setters */
	public void setPath(String path) {
		filePath = path;
	}

	public String getFilePath() {
		return filePath;
	}

	/* Check if file exists */
	public boolean checkIfFileExists() {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	/* Read file */
	public void readFileText() throws FileNotFoundException {
		if (checkIfFileExists() == true) { // first check if it exists

			File file = new File(filePath);

			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()) {

				String number = scan.nextLine();

				int digit = Integer.valueOf(number); // Convert string to
														// integer for getting
														// numeric value.

				if (digit <= 100 && digit >= 1) { // compare the value if it is
													// in given limits.

					from1To100++;

					if (digit <= 10 && digit > 0) {
						num[0] = num[0] + 1;
					} else if (digit > 10 && digit <= 20) {
						num[1] = num[1] + 1;
					} else if (digit > 20 && digit <= 30) {
						num[2] = num[2] + 1;
					} else if (digit > 30 && digit <= 40) {
						num[3] = num[3] + 1;
					} else if (digit > 40 && digit <= 50) {
						num[4] = num[4] + 1;
					} else if (digit > 50 && digit <= 60) {
						num[5] = num[5] + 1;
					} else if (digit > 60 && digit <= 70) {
						num[6] = num[6] + 1;
					} else if (digit > 70 && digit <= 80) {
						num[7] = num[7] + 1;
					} else if (digit > 80 && digit <= 90) {
						num[8] = num[8] + 1;
					} else {
						num[9] = num[9] + 1;
					}
				}

				/*
				 * If no condition is true, then it will come in variable other
				 */
				else {

					other++;
				}

			}
			scan.close();
		}

		else
			throw new FileNotFoundException("No file found"); // throw error if
																// file does not
																// exists

	}

	/*Check if file is correct for bar chart*/
	public boolean check() throws FileNotFoundException {
		File file = new File(filePath);

		Scanner scan = new Scanner(file);

		while (scan.hasNext()) {
			read = read + scan.nextLine();
		}
		scan.close();
		for (int i = 0; i < read.length(); i++) {
			char c = read.charAt(i);
			if (!Character.isDigit(c)) {
				return true;
			}
		}
		return false;

	}

	
	/* Getters */
	public int getOtherNumber() {
		return other;
	}

	public int getFrom1To100() {
		return from1To100;
	}

	public int getFrom1To10() {
		return num[0];
	}

	public int getFrom11To20() {
		return num[1];
	}

	public int getFrom21To30() {
		return num[2];
	}

	public int getFrom31To40() {
		return num[3];
	}

	public int getFrom41To50() {
		return num[4];
	}

	public int getFrom51To60() {
		return num[5];
	}

	public int getFrom61To70() {
		return num[6];
	}

	public int getFrom71To80() {
		return num[7];
	}

	public int getFrom81To90() {
		return num[8];
	}

	public int getFrom91To100() {
		return num[9];
	}
}