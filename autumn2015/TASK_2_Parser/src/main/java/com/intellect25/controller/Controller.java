package com.intellect25.controller;

import com.intellect25.entity.Book;
import com.intellect25.model.Parser;
import com.intellect25.view.Writer;

import java.io.IOException;
import java.util.List;

/**
 * Controller for the Parser
 *
 * @author Riabchenko Aliona
 */
public class Controller {

    /**
     * It is major method
     *
     * @throws IOException error
     */
    public void execute() throws IOException {

        /** Read file*/
        Reader reader = new Reader();
        String allData = reader.readFile();

        /** Create instance of Parser */
        Parser parser = new Parser();

        /** Delete all multi spaces and tags */
        String[] blocksOfInputData = parser.removeAllMultiSpaceTag(allData);

		/* Create book (all text) from input data */
        Book book = parser.createBook(blocksOfInputData);

		/* List of words absent into first sentence*/
        List<String> resultList = parser.searchWordFromFirstSentenceIntoOther(book);

		/* Output result into file */
        Writer writer = new Writer();
        writer.writeFile(resultList);

        /* Display text from book */
        List<String> bookAsLis = parser.getBook(book);
        writer.display(bookAsLis);

    }
}
