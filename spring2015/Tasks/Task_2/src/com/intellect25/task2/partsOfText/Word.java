package com.intellect25.task2.partsOfText;

/**
 * This class represents a word, provides method to compare 2 words by their
 * lexicographical order.
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 12.15.2015
 */
public class Word implements Comparable<Word>, SentenceObject {
	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}

	@Override
	public int compareTo(Word anotherWord) {
		return word.compareToIgnoreCase(anotherWord.getWord());
	}
}