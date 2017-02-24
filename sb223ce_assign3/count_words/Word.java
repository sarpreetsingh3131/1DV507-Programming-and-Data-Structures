package sb223ce_assign3.count_words;

public class Word implements Comparable<Word> {

	/* Field */
	private String word;

	/* Constructor */
	public Word() {
		word = "";
	}

	/* Constructor */
	public Word(String str) {
		word = str.toLowerCase(); // to make all words equal
	}

	/* Method */
	public String toString() {
		return word;
	}

	/* Method */
	public int hashCode() {
		int h = word.hashCode(); // get hash code using string class method
		if (h < 0) // if less than 0
			h = -h; // make it positive
		return h;
	}

	@Override
	public boolean equals(Object other) {
		/* Check if this object is instance of word class */
		if (other instanceof Word) {
			Word w = (Word) other;
			return this.hashCode() == w.hashCode();
		}
		return false;

	}

	@Override
	public int compareTo(Word o) {
		/* Use compareTo string class method */
		return word.compareTo(o.word);
	}
}
