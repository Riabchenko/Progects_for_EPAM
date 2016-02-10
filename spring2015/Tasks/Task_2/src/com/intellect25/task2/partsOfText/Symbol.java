package com.intellect25.task2.partsOfText;

/**
 * This is the abstract class to store and manipulate symbols.
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 12.15.2015
 *
 */
public abstract class Symbol {
	private char symbol;
	
	/**
	 * Creates new Symbol by the given character.
	 * @param symbol the character to be stored
	 */
	protected Symbol(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Returns the stored character.
	 * @return the character representation of the Symbol
	 */
	public char getSymbol() {
		return symbol;
	}
}