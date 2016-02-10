package com.intellect25.model;

import com.intellect25.entity.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is using pattern FACADE for the Parser.
 * It gives capacities simple access to the complexity
 * structure of the Entities
 *
 * @author Riabchenko Aliona
 */
public class Facade implements Regex{

	/**
	 * Instance of Flyweight which is using
	 * pattern FLYWEIGHT
	 */
	private Flyweight flyweight;

	/**
	 * Default constructor
	 */
	public Facade() {
		flyweight = new Flyweight();
	}

	/**
	 * Get whole book as list
	 *
	 * @param book book
	 * @return list
	 */
	public List<String> getBook(Book book){
		List<String> list = new ArrayList<String>();
		for (Data text : book.getCodeSentence()) {
			if (text instanceof Sentence)
				list.addAll(getWordMark(text));
			else list.add(((Code) text).getCode());
		}
		return list;
	}

	/**
	 * It gets sentence from a book(all text) by index
	 *
	 * @param book all input text
	 * @param index index of sentence
	 * @return list of sentence
	 */
	public List<String> getSentence(Book book,int index) {
		List<String> wordList = new ArrayList<String>();
		List<Data> sentenceList = book.get(Type.SENTENCE);

		for (Data sentence : sentenceList) {
			for (Text word : ((Sentence)sentence).get(Type.WORD))
				wordList.add(((Word) word).getWord());
		}
		return wordList;
	}

	/**
	 * Get list of Text
	 *
	 * @param sentence input sentence
	 * @return list
	 */
	public List<String> getWordMark(Data sentence) {
		List<String> list = new ArrayList<String>();
		for (Text text : ((Sentence)sentence).getWordMark()){
			if (searchType(text) == Type.WORD)
				list.add(" " + ((Word) text).getWord()); //space between words
			else list.add(((Mark)text).getMark());
		}
		return list;
	}

	/**
	 * It gets list of cash (all unique words into input text)
	 *
	 * @return list of words
	 */
	public List<String> getHashList(){
		return flyweight.getHashWord();
	}

	/**
	 * It creates object of a class Code
	 *
	 * @param input input string
	 * @return created object of a class Code
	 */
	public Code addCode(String input) {
		Code code= (Code) Factory.getInstance(Type.CODE);
		code.add(input);
		return code;
	}

	/**
	 * It creates sentence
	 *
	 * @param listWordAndMark list of word and mark
	 * @return sentence
	 */
	public Sentence addSentence(List<Text> listWordAndMark ){
		Type type = null;
		Sentence newSentence = (Sentence) Factory.getInstance(Type.SENTENCE);

		for (Text result : listWordAndMark) {

			if (result instanceof Word) type = Type.WORD;
			else type = Type.MARK;

			switch (type) {
				case WORD:
					addWordIntoSentence(result, newSentence);
					break;
				case MARK:
					addMarkIntoSentence(result, newSentence);
			}
		}
		return newSentence;
	}

	/**
	 * It creates objects of word and marks
	 *
	 * @param sentence input string of sentence
	 * @return list of Data
	 */
	public List<Text> addWordAndMark(String sentence){
		List<Text> listWordMark = new LinkedList<Text>();
		String[] words = sentence.split(REGEX_BORDER_OF_WORD);

		int i = 0;
		for (String wordFromArray:words) {
			Pattern pattern = Pattern.compile(REGEX_SEPARATOR_WORD_AND_SYMBOL);
			Matcher matcher = pattern.matcher(words[i]);
			while (matcher.find()) {
				String newMark = words[i].substring(matcher.end(),words[i].length());
				String newWord = matcher.group();
				if (!isSpace(newWord)) {
					Text word = flyweight.create(Type.WORD,newWord);
					listWordMark.add(word);
				}

				Mark mark = (Mark) Factory.getInstance(Type.MARK);
				mark.add(newMark);
				listWordMark.add(mark);

			}
			i++;
		}
		return listWordMark;
	}

	/**
	 * It sets objects of a class Word into Sentence
	 *
	 * @param result input object of word
	 * @param sentence into this object of sentence need to put word
	 */
	private void addWordIntoSentence(Text result,Sentence sentence){
		Word word = (Word) result;
		if (!isSpace(word.getWord())){
			sentence.add(word);
		}
	}

	/**
	 * It sets objects of a class Mark into Sentence
	 *
	 * @param result  input object of Mark
	 * @param sentence into this object of sentence need to put mark
	 */
	private void addMarkIntoSentence(Text result,Sentence sentence){
		Mark marks = (Mark) result;
		sentence.add(marks);
	}

	/**
	 * Search type of data
	 *
	 * @param data input data
	 * @param <T> object
	 * @return type
	 */
	private<T> Type searchType(T data){
		if (data instanceof Word) return Type.WORD;
		else if (data instanceof Mark) return Type.MARK;
		else return null;
	}

	/**
	 * It helps to definite is string a space
	 *
	 * @param input input string
	 * @return false or true
	 */
	private boolean isSpace(String input){
		return input.compareTo("REGEX_SPACE_TAG") == 0;
	}

}
