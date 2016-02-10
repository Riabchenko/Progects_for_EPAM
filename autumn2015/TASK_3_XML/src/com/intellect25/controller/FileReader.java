package com.intellect25.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class reads file
 *
 * @author Riabchenko Aliona
 */
public final class FileReader {

    /**
     * Default private constructor
     */
    private FileReader() {
    }

    /**
     * Reads file
     *
     * @param fileName path to file
     * @return String
     */
    public static String readFile(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        String symbol = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(
                                                new FileInputStream(fileName), "UTF-8"));

            while ((symbol = bufferedReader.readLine()) != null)
                stringBuilder.append(symbol+"\n");
            bufferedReader.close();

            if (stringBuilder.charAt(0) == '\uFEFF')
                stringBuilder.deleteCharAt(0);

        } catch (IOException e) {
            e.getStackTrace();
        }
        return stringBuilder.toString();
    }

}
