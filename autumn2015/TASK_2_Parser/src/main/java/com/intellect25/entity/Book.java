package com.intellect25.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Book is storing blokes of input data
 * Use into pattern COMPOSITE as composition of Data
 *
 * @author Riabchenko Aliona
 */
public class Book extends Data {

	/**
	 * List of code and sentence
	 */
	private List<Data> codeSentence;

	/**
	 * Default constructor
	 */
	public Book() {
		this.codeSentence = new ArrayList<Data>();
	}

	/**
	 * It adds data to the list of data
	 *
	 * @param data input data
	 * @param <T> Object of data
	 * @return the adding data
	 */
	@Override
	public<T> T add(T data) {
		codeSentence.add((Data)data);
		return data;
	}

	/**
	 * Get book
	 *
	 * @return list
	 */
	public List<Data> getCodeSentence() {
		return codeSentence;
	}

	/**
	 * Get list of data that independent on the Type
	 *
	 * @param type type of data that needs return
	 * @return list of data
	 */
	public List<Data> get(Type type) {
		return makeListOf(type);
	}

	/**
	 * It helps to make list of type
	 *
	 * @param type type
	 * @return list of Data
	 */
	private List<Data> makeListOf(Type type) {
		List<Data> list = new ArrayList<Data>();
		for (Data text : codeSentence) {
			if (searchType(text) == type)
			 list.add(text);
		}
		return list;
	}

	/**
	 * It helps to search type of input data
	 *
	 * @param data input data
	 * @param <T> input object
	 * @return Type of data
	 */
	private<T> Type searchType(T data){
		if (data instanceof Sentence) return Type.SENTENCE;
		else if (data instanceof Code) return Type.CODE;
		else return null;
	}


}
