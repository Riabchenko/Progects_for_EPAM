package com.intellect25.task2.partsOfText;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class holds a text as a list of sentences, provides methods to read the
 * text and create a dictionary of the words met in the text.
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 12.15.2015
 */
public class SentenceParser {
	private Dictionary dictionary; // holds distinct words in lexicographical order
	private List<Sentence> text; // list of sentences
	
	public SentenceParser() {
		dictionary = new Dictionary();
		text = new ArrayList<Sentence>();
	}
	
	/**
	 * Reads the text sentence-by-sentence from scanner.
	 * @param scanner the source of input data
	 */
	public void parse(Scanner scanner) {
		Sentence temp = null;
		
		// read all sentences
		while (scanner.hasNext()) {
			temp = new Sentence();
			temp.read(scanner);
			text.add(temp);
		}
	}
	
	/**
	 * Generates dictionary from the given list of sentences.
	 * @return the dictionary created from the sentences
	 */
	public Dictionary createDictionary() {
		for (Sentence s : text) {
			
			// loop through all sentences
			for (SentenceObject token : s) {
				
				// loop through all tokens in the sentence
				if (token instanceof Word) {
					
					// add word to vocabulary
					dictionary.addWord((Word) token);
				}
			}
		}
		
		return dictionary;
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}

}
