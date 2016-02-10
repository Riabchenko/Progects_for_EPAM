package com.intellect25.model;

import com.intellect25.entity.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is managing of parsing of text and search words from
 * first sentence in remain text, and display words that absent into
 * first sentence.
 *
 * @author Riabchenko Aliona
 */
public class Parser implements Regex{

	/**
	 * Instance of Facade
	 */
	private Facade facade;

	/**
	 * Default constructor
	 */
	public Parser(){
		facade = new Facade();
	}

	/**
	 * It removes all multi spaces and tags
	 *
	 * @param allData input data
	 * @return array of String blocks
	 * @throws FileNotFoundException error
	 */
	public String[] removeAllMultiSpaceTag(String allData) throws FileNotFoundException {
		String[] blocksOfInputData = allData.split(REGEX_LINE);
		for (int i = 0; i < blocksOfInputData.length; i++){
			blocksOfInputData[i] = blocksOfInputData[i].replaceAll(REGEX_SPACE_TAG, " ");
		}
		return blocksOfInputData;
	}

	/**
	 * It creates object of Book (all text)
	 *
	 * @param blocksOfInputData blocks of input data
	 * @return object of Book
	 */
	public Book createBook(String[] blocksOfInputData){
		boolean isText = false;
		int bracket = 0;
		Type type = null;
		Book book = (Book) Factory.getInstance(Type.BOOK);

		for (int indexOfBlock = 0; indexOfBlock < blocksOfInputData.length; indexOfBlock++) {

			isText = false;

			/*
        	*  If this block starts from high letter, it may be text
        	*  (java code almost always starts from low letter)
        	*/
			Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
			Matcher matcher = pattern.matcher(blocksOfInputData[indexOfBlock]);
			while (matcher.find()) {
				isText = true;
			}

            /*
            * Only if this block is text than it can create a class of Text,
            * anyway will create a class Code
            */
			if (isText) type = Type.TEXT;
			else type = Type.CODE;

			/*
			* If brackets are 0 than this block is text
			*/
			bracket = isText(blocksOfInputData[indexOfBlock],bracket);
			if(bracket != 0) type = Type.CODE;

			/** Add Code or Text to book*/
				List<Data> listData = addNewData(type, blocksOfInputData[indexOfBlock]);
				for (Data data : listData) {
					book.add(data);
				}

			/** Add new line*/
			Sentence sentence = new Sentence();
			Mark mark = new Mark();
			mark.add("\n");
			sentence.add(mark);
			book.add(sentence);
		}
		return book;

	}

	/**
	 * It searches search words from first sentence in remain text
	 *
	 * @param book object of Book
	 * @return list of result
	 */
	public List<String> searchWordFromFirstSentenceIntoOther(Book book){
		List<String> differentWord = new ArrayList<String>();

		List<String> wordList = facade.getSentence(book, 0);
		Collections.sort(wordList);
		List<String> wordFromHash = facade.getHashList();
		Collections.sort(wordFromHash);

		int i = 0;
		for (String word:wordFromHash) {
			int is = Collections.binarySearch(wordList, wordFromHash.get(i));
			if (is < 0) {
				differentWord.add(wordFromHash.get(i));
			}
			i++;
		}
		return differentWord;
	}

	/**
	 * Get whole book as list
	 *
	 * @param book book
	 * @return list
	 */
	public List<String> getBook(Book book){
		return facade.getBook(book);
	}

	/**
	 * It creates sentence
	 *
	 * @param string input string
	 * @return list of Sentence
	 */
	private List<Sentence> addSentences(String string){
		List<Sentence> list = new LinkedList<Sentence>();
		Type type = null;
		List<String> listSentence = searchSentence(string); //divide to one sentence
		for (String sentenceOfList : listSentence) {
			list.add(facade.addSentence(facade.addWordAndMark(sentenceOfList)));
		}
		return list;
	}

	/**
	 * It helps to definite is input data Text or Code
	 *
	 * @param inputData input data
	 * @param bracket count of brackets
	 * @return count of brackets
	 */
	private int isText(String inputData, int bracket){
		Pattern pattern_bracket = Pattern.compile(REGEX_BRACKET_OPEN);
		Pattern pattern_bracket_close = Pattern.compile(REGEX_BRACKET_CLOSE);

        /*
        * If this paragraph isn't text than increase close brackets
        */
		Matcher matcher_bracket = pattern_bracket.matcher(inputData);
		while (matcher_bracket.find()) {
			bracket++;
		}

        /*
        * If this paragraph isn't text than decrease close brackets
        */
		Matcher matcher_bracket_close = pattern_bracket_close.matcher(inputData);
		while (matcher_bracket_close.find()) {
			bracket--;
		}

		return bracket;
	}

	/**
	 * It adds new Data to the object of Book
	 *
	 * @param type Type of data
	 * @param string string
	 * @return list of data
	 */
	private List<Data> addNewData(Type type,String string){ //Text or Code
		List<Data> list = new LinkedList<Data>();

		/** Create an instance of Code or Text*/
		switch (type) {
			case CODE:
				list.add(facade.addCode(string));
				break;
			case TEXT:
				list.addAll(addSentences(string));
				break;
		}
		return list;
	}

	/**
	 * It divides input string to list of sentence
	 *
	 * @param data input string
	 * @return list of sentence
	 */
	private List<String> searchSentence(String data){
		List<String> listSentence = new LinkedList<String>();
		boolean sentenceWithPoint = false;
		Pattern pattern = Pattern.compile(REGEX_SENTENCE);
		Matcher matcher = pattern.matcher(data);

		int lastMatcher = 0;
		while (matcher.find()) {
			String sentence = data.substring(lastMatcher, matcher.end());
			listSentence.add(sentence);
			lastMatcher = matcher.end();
			sentenceWithPoint = true;
		}
		if (!sentenceWithPoint) {
			listSentence.add(data);
		}

		return listSentence;
	}

}
