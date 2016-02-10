package com.intellect25.model;

import com.intellect25.entity.*;

/**
 * This class is using pattern FACTORY
 * and helps create instance of objects
 *
 * @author Riabchenko Aliona
 */
public class Factory {

	/**
	 * Output error
	 */
	private static final String ERROR = "Type isn't correct";

	/**
	 * It gets an instance of object
	 *
	 * @param type Type of object
	 * @return Data
	 */
	public static Data getInstance(Type type) {
		switch (type){
			case BOOK:
				return new Book();
			case CODE:
				return new Code();
			case SENTENCE:
				return new Sentence();
			case WORD:
				return new Word();
			case MARK:
				return new Mark();
			default:
				throw new NullPointerException(ERROR);
		}
	}

}
