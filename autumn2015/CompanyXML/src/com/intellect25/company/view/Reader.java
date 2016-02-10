package com.intellect25.company.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {

	/**
	 *  reader of input stream
	 */
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * read an integer from the range
	 * @param lo	lowest integer
	 * @param hi	highest integer
	 * @return		input number
	 */
	public int readInt(int lo, int hi){
        int resultInt = 0;
        try {
            do {
                Scanner sc = new Scanner(System.in);
                resultInt = sc.nextInt();
            }while (!((resultInt >= lo) && (resultInt <= hi)));
        }catch (InputMismatchException e){
            readInt( lo,  hi);
        }
		return resultInt;
	}

	public int readInt(){
        int i = 0;
        try {
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
        }catch (InputMismatchException e){
            readInt();
        }
        return i;
	}


	/**
	 * read text
	 * @return		input String
	 */
	public String readString(){

		String result = null;
		try {
			do {
				result = reader.readLine();
				result = result.trim();
			}while (result.compareTo("") == 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
