package com.intellect25.entity;

/**
 * This class use into pattern COMPOSITE as Component.
 * It's parent of all parts of text
 *
 * @author Riabchenko Aliona
 */
public abstract class Data {

	/**
	 * It adds data to the map of data
	 *
	 * @param data input data
	 * @param <T> Object of data
	 * @return the adding data
	 */
	public abstract<T> T add(T data);

}
