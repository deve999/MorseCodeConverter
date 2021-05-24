package Project5;

import java.io.*;
import java.util.Scanner;
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	
	public static String printTree() {
		return tree.toString();
	}
	
	public static String convertToEnglish(String code) {
		String sentence = "";
		String word = "";
		int flag = 0;
		code = code.trim().replaceAll(" +", " ");
		
		for(int i = 0; i < code.length(); i++){
			
		    if(code.charAt(i) != ' ' && code.charAt(i) != '/' 
		    		&& code.charAt(i) != '-' && code.charAt(i) != '.') {
		    	System.out.println("Invalid Character");
		    	System.exit(0);
		    }
		    
			if(word.equals("/")) {
		    	word = "";
		    	sentence += " ";
		    }
		    else if(code.charAt(i) == ' ') {	
		    	sentence += tree.fetch(word);
		    	word = "";
		    }
		    
		    word += String.valueOf(code.charAt(i)).trim();
		}
		sentence += tree.fetch(word);
		return sentence;
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner processor = new Scanner(codeFile);
		String sentence = "";
		String conversion = "";
		String word = "";
		
		while(processor.hasNext()) {
			 sentence += processor.nextLine();
		}
		processor.close();
		
		sentence = sentence.trim();
		
		for(int i = 0; i < sentence.length(); i++) {
			
			if(sentence.charAt(i) != ' ' && sentence.charAt(i) != '/'
					&& sentence.charAt(i) != '-' && sentence.charAt(i) != '.') {
		    	System.out.println("Invalid Character");
		    	System.exit(0);
		    }
			
			if(word.equals("/")) {
		    	word = "";
		    	conversion += " ";
		    }
		    else if(sentence.charAt(i) == ' ') {	
		    	conversion += tree.fetch(word);
		    	word = "";
		    }
		    
		    word += String.valueOf(sentence.charAt(i)).trim();
		}
		conversion += tree.fetch(word);
		
		
		return conversion;
	}
}
