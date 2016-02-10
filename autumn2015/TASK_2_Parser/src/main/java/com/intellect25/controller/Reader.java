package com.intellect25.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader is reading data from file
 *
 * @author Riabchenko Aliona
 */
public class Reader implements Path {

	/**
	 * Read file
	 *
	 * @return entered data
	 * @throws IOException error
	 */
	public String readFile() throws IOException {
		StringBuilder allData = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_INPUT));
		String string;
		while((string = bufferedReader.readLine()) != null) {
			allData.append(string);
			allData.append("\n");
		}
		bufferedReader.close();
		return allData.toString();
	}

}
