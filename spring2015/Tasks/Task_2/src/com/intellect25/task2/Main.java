package com.intellect25.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.intellect25.task2.partsOfText.SentenceParser;

/**
 * Creates parser which reads a text from the file to the list of sentences,
 * creates dictionary and prints its content to html file.
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 12.15.2015
 *
 */
public class Main {
	/**
	 * Creates parser which reads a text from the file to the list of sentences,
	 * creates dictionary and prints its content to html file.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SentenceParser parser = new SentenceParser();
		
		try {
			parser.parse(new Scanner(new File("input.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("Can't open the file input.txt");
		}
		
		parser.createDictionary().printToHTML("output.htm");
		System.out.println("Result in the output.htm");
	}
}
