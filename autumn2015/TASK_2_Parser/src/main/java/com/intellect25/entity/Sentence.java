package com.intellect25.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Sentence is storing Words and Marks of input data
 * Use into pattern COMPOSITE as composition of Text
 *
 * @author Riabchenko Aliona
 */
public class Sentence extends Text {

	/**
	 * List of word and mark
	 */
	private List<Text> wordMark;

	/**
	 * Default constructor
	 */
	public Sentence() {
		this.wordMark = new LinkedList<Text>();
	}

	/**
	 * It adds data to the list
	 *
	 * @param data input data
	 * @param <T> Object of data
	 * @return the adding data
	 */
	@Override
	public<T> T add(T data) {
		wordMark.add((Text)data);
		return data;
	}

	/**
	 * Get list of word and mark
	 *
	 * @return list
	 */
	public List<Text> getWordMark() {
		return wordMark;
	}

	/**
	 * Get list of data that independent on the Type
	 *
	 * @param type type of data that needs return
	 * @return list of data
	 */
	public List<Text> get(Type type) {
		return makeListOf(type);

	}

	/**
	 * It helps to search type of input data
	 *
	 * @param data input data
	 * @param <T> input object
	 * @return Type of data
	 */
	private<T> Type searchType(T data){
		if (data instanceof Word) return Type.WORD;
		else if (data instanceof Mark) return Type.MARK;
		else return null;
	}

	/**
	 * It helps to make list of Words
	 *
	 * @param type type
	 * @return list of Text
	 */
	private List<Text> makeListOf(Type type){
		List<Text> list = new ArrayList<Text>();
		for (Text text:wordMark){
			if (searchType(text) == type) list.add(text);
		}
		return list;
	}

}
