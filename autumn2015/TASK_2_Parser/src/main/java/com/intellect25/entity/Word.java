package com.intellect25.entity;

/**
 * Word is storing value of word
 * Use into pattern COMPOSITE as leaf of Text
 *
 * @author Riabchenko Aliona
 */
public class Word extends Text {

	/**
	 * Value of word
	 */
	private String word;

	/**
	 * Get word
	 *
	 * @return word
	 */
	public String getWord(){
		return word;
	}

	/**
	 * It adds data to the map of data
	 *
	 * @param data input data
	 * @param <T> Object of data
	 * @return the adding data
	 */
	@Override
	public<T> T add(T data) {
		word = (String) data;
		return data;
	}

}
