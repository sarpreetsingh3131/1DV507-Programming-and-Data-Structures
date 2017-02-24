package sb223ce_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {

		Scanner scan1 = null;
		HashWordSet hash = new HashWordSet();
		TreeWordSet tree = new TreeWordSet();
		String read = "";
		String path = "/Users/SarpreetSingh/Documents/words.txt";

		try {
			File file = new File(path); // make file
			scan1 = new Scanner(file); // read file
			while (scan1.hasNext()) { // while scanner has next word
				read = scan1.next(); // save it in the string
				Word word = new Word(read); // create it an instance of word
											// class
				tree.add(word); // save it
				hash.add(word);
			}
			scan1.close();

			System.out.println("Tree size: " + tree.size());
			System.out.println("Hash size: " + hash.size() + "\n");

			System.out.println("Tree toString: " + tree.toString());
			System.out.println("Hash toString: " + hash.toString() + "\n");

			Word hashWord = new Word("adopted");
			Word treeWord = new Word("adopted");

			System.out.println("Hash set contains \"" + hashWord + "\"" + ": " + hash.contains(hashWord));
			System.out.println("Tree set contains \"" + treeWord + "\"" + ": " + tree.contains(treeWord) + "\n");

			System.out.println("Iterator: ");

			int count = 0;
			Iterator<Word> it = tree.iterator();
			// Iterator<Word> it = hash.iterator();

			while (it.hasNext())
				System.out.println(++count + "  " + it.next());

		}

		catch (FileNotFoundException e) { // catch error if file not found
			System.err.println(e.getMessage());
		}

	}
}