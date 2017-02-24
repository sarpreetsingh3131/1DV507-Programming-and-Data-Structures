package sb223ce_assign1.LanguageTool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;

public class Error {

	/* Fields */
	private ArrayList<Integer> column = new ArrayList<Integer>();
	private ArrayList<String> suggestions = new ArrayList<String>();
	private List<RuleMatch> mistakes = new ArrayList<RuleMatch>();
	private ArrayList<Rule> rule = new ArrayList<Rule>();
	private ReadFile read = new ReadFile();
	private JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
	private String text = "";
	private StringBuilder str = new StringBuilder();
	private ArrayList<String> message = new ArrayList<String>();

	/* Constructor */
	public Error() {

	}

	/* Constructor */
	public Error(String path) {
		try {
			read.setPath(path); // method
			read.readFileText(); // method
			text = read.getFileText();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

	/* Check the file and save suggestion and columns in the array lists */
	public void check() {
		try {
			mistakes = langTool.check(text);
			getSuggestionsAndColumnAndRule(); // method
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	/* Helping method to for saving the suggestions,columns and rule */
	private void getSuggestionsAndColumnAndRule() {
		for (RuleMatch match : mistakes) {
			str.append(match.getSuggestedReplacements()); // can be more than 1
			suggestions.add(str.toString());
			column.add(match.getFromPos()); // for highlighting mistakes
			rule.add(match.getRule()); // add rule
			message.add(match.getShortMessage());
			str = new StringBuilder();
		}

	}

	/* Return string which highlights the error position */
	public String getCheckedText() {

		StringBuilder str = new StringBuilder();
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (count < column.size())
				if (i == column.get(count)) {
					count++;
					str.append(" [" + count + "]");
				}

			/* Sometimes, array contains duplicates */
			if (count + 1 < column.size() && column.get(count + 1) == i) {
				count += 2;
				str.append(" [" + count + "]");

			}
			str.append(text.charAt(i));
		}

		return str.toString();
	}

	/* Helper methods */
	public String getIssues() {
		StringBuilder str = new StringBuilder();
		str.append("Issues with mistakes:\n");
		for (int i = 0; i < rule.size(); i++) {
			str.append("[" + (i + 1) + "] " + rule.get(i).getLocQualityIssueType() + " issue.\n");
		}
		return str.toString();
	}

	public String getMessage() {
		StringBuilder str = new StringBuilder();
		str.append("Short messages related to the mistakes:\n");
		for (int i = 0; i < message.size(); i++) {
			if (message.get(i) != null)
				str.append("[" + (i + 1) + "] " + message.get(i) + "\n");
			else
				str.append("[" + (i + 1) + "] NO MESSAGE FOUND\n");
		}
		return str.toString();
	}

	public String getSuggestions() {
		StringBuilder str = new StringBuilder();
		str.append("Suggestions:\n");
		for (int i = 0; i < suggestions.size(); i++) {
			String s = suggestions.get(i).toString();
			if (s.equals("[]")) // if empty
				str.append("[" + (i + 1) + "] NO SUGGESTIONS FOUND\n");
			else
				str.append("[" + (i + 1) + "] " + s.substring(1, s.length() - 1) + "\n");
		}
		return str.toString();
	}

	public String getMistakes() {
		StringBuilder str = new StringBuilder();
		str.append("Total mistakes: " + getNumberOfMistakes() + "\n\n" + getIssues() + "\n\n" + getSuggestions()
				+ "\n\n" + getMessage());
		return str.toString();
	}

	public int getNumberOfMistakes() {
		return suggestions.size();
	}
}
