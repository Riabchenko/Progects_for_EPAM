package com.intellect25.company.view;

import java.util.List;

public class Writer {
	/**
	 * print out text and stay on this line
 	 * @param string	text
	 */
	public void printStr(String string){
		System.out.print(string);
	}
	/**
	 * print out text and go to next line
	 * @param string	text
	 */
	public void printStrLN(String string){
		System.out.println(string);
	}

	public void printList(List list) {
		for (Object o:list)
			System.out.println(o);
	}
}
