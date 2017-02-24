package sb223ce_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

	public static void main(String[] args) {

		Scanner scan1 = null;
		HashSet<Word> hash = new HashSet<Word>();
		TreeSet<Word> tree = new TreeSet<Word>();
		String read = "";
		String path = "/Users/SarpreetSingh/Documents/words.txt";

		try {
			File file = new File(path); // make file
			scan1 = new Scanner(file); // read file
			while (scan1.hasNext()) { // while scanner has next word
				read = scan1.next(); // save it in read string
				Word word = new Word(read); // create it an instance of word
											// class
				tree.add(word); // save it
				hash.add(word);
			}
			scan1.close();

			// size
			System.out.println("Tree size: " + tree.size());
			System.out.println("Hash size: " + hash.size() + "\n");

			int count = 0;
			System.out.println("Tree Iterator: \n");
			// iterator
			Iterator<Word> it = tree.iterator();
			while (it.hasNext())
				System.out.println(++count + " " + it.next());

		} catch (FileNotFoundException e) { // catch error if file not found
			System.err.println(e.getMessage());
		}

	}

}
