package sb223ce_assign1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PrintJava {

	public static void main(String[] args) throws IOException {

		printJavaFiles("/Users/SarpreetSingh/Documents/");
	}

	/* If file exist, visit sub directories */
	public static void printJavaFiles(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			System.out.println("Reading java files from directory: " + file);
			readSubDirectory(file);
		} else
			System.err.println("Can't find directory: " + file);
	}

	private static int folders = 1; // count folders

	/* Simply print directory and find java files in them and print them */
	private static void readSubDirectory(File file) throws IOException {
		if (file.isDirectory()) {
			printDirectory(file);
			folders++;
			File[] subs = file.listFiles();
			for (File f : subs) {
				if (checkIfJavaFile(f) == true) {
					printJavaFile(f);
				}
				readSubDirectory(f);
			}
			folders--;
		}
	}

	private static int count = 0;

	private static void printDirectory(File file) {
		StringBuffer directory = new StringBuffer();
		for (int i = 0; i < folders; i++)
			directory.append("  ");
		System.out.println((++count) + directory.toString() + file.getName());
	}

	/* Check if file is .java file */
	private static boolean checkIfJavaFile(File f) {
		String name = f.getName();
		char ch = '.';
		int dot = name.lastIndexOf(ch);
		if (dot != -1 && dot != 0) {
			String java = name.substring(dot);
			return java.equals(".java");
		}
		return false;
	}

	/* Count the lines */
	private static int countLines(File f) throws IOException {
		int line = 0;
		FileReader reader = new FileReader(f);
		LineNumberReader lineCounter = new LineNumberReader(reader);
		while (lineCounter.readLine() != null) {
			line++;
		}
		lineCounter.close();
		return line;
	}

	/* Print java files */
	private static void printJavaFile(File f) throws IOException {
		StringBuffer java = new StringBuffer();
		for (int i = 0; i < folders; i++)
			java.append("  ");
		System.out.println((++count) + java.toString() + f.getName() + " {Size: " + countLines(f) + "}");
	}
}