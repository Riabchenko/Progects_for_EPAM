package com.intellect25.task2.partsOfText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * 
 * This class holds distinct words in lexicographical order, provides methods to
 * add new words and print the content to a given html file.
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 12.15.2015
 */
public class Dictionary {
	private TreeSet<Word> words;
	
	public Dictionary() {
		words = new TreeSet<Word>();
	}
	
	/**
	 * Adds new word to the dictionary in case it is unique.
	 * @param word the word to be added to the vocabulary
	 * @return true if the word was successfully added, false - otherwise
	 */
	public boolean addWord(Word word) {
		return words.add(word);
	}
	
	/**
	 * Prints the content of the dictionary in lexicographical order to the
	 * html file. For each first letter in the word highlights the first word
	 * in the list with red color.
	 * @param filename the name of the html file to be created (including extension)
	 */
	public void printToHTML(String filename) {
		BufferedWriter out = null;
		char currentLetter = ' ';
		boolean newLetter = false;
		String currentWord = null;
		
		try {
			out = new BufferedWriter(new FileWriter(filename));
			
			out.write("<html>");
			out.newLine();
			out.write("<body>");
			out.newLine();
			
			for (Word w : words) {
				
				// write each word to the file
				currentWord = w.getWord();
				
				if (Character.toLowerCase(currentWord.charAt(0)) != currentLetter) {
					
					/* we met new letter so the first word should be highlighted
					 * with red color.
					*/
					newLetter = true;
					currentLetter = Character.toLowerCase(currentWord.charAt(0));
					out.write("<font color=\"red\">");
				}
				
				out.write(currentWord);
				out.write("<br/>");
				
				if (newLetter) {
					newLetter = false;
					out.write("</font>");
				}
				
				out.newLine();
			}
			
			out.write("</body>");
			out.newLine();
			out.write("</html>");
			out.newLine();
			
			out.close();
		} catch (IOException e) {
			System.out.println("Can't write to the file " + filename);
		}
	}
}