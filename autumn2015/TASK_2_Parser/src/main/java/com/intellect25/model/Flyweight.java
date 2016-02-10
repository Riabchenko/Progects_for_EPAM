package com.intellect25.model;

import com.intellect25.entity.Mark;
import com.intellect25.entity.Text;
import com.intellect25.entity.Type;
import com.intellect25.entity.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is using pattern FLYWEIGHT for the creating words
 *
 * @author Riabchenko Aliona
 */
public class Flyweight {

	/**
	 * List of unique words
	 */
//	private List<Word> cashWord;
	private Map<String,Text> hashWord;

	/**
	 * Default constructor
	 */
	public Flyweight() {
		this.hashWord = new HashMap<String,Text>();
	}

	/**
	 * It creates or return from list of cash object of Word
	 * or Mark
	 *
	 * @param input input string
	 * @param type type of Text
	 * @return Text
	 */
	public Text create(Type type,String input) {
		if(hashWord.containsKey(input)){
			return hashWord.get(input);
		}else {
			switch (type) {
				case WORD:
					return createWord(input);
				case MARK:
					return createMark(input);
				default:
					throw new NullPointerException("Error");
			}
		}
	}

	private Word createWord(String input){
		Word word = new Word();
		word.add(input);
		hashWord.put(input,word);
		return word;
	}

	private Mark createMark(String input){
		Mark mark = new Mark();
		mark.add(input);
		hashWord.put(input,mark);
		return mark;
	}

	/**
	 * It gets list of unique words
	 *
	 * @return list of Words
	 */
	public List<String> getHashWord() {
		List<String> wordList = new ArrayList<String>();
		for (Map.Entry<String,Text> map: hashWord.entrySet()) {
			if (map.getValue() instanceof Word)
				wordList.add(map.getKey());
		}
		return wordList;
	}
}
