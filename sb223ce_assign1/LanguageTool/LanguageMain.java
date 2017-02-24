package sb223ce_assign1.LanguageTool;

import java.io.IOException;

public class LanguageMain {

	public static void main(String[] args) throws IOException {

		Error b = new Error("/Users/SarpreetSingh/Documents/p.txt");
		b.check();
		System.out.println(b.getCheckedText());
		System.out.println("\n" +b.getMistakes());
	
	}
	
	

}
