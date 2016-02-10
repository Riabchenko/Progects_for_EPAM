package com.intellect25.model;

/**
 * Interface is storing data of regex to parser
 *
 * @author Riabchenko Aliona
 */
public interface Regex {
    String REGEX_SPACE_TAG = "\\s+";
    String REGEX_LINE = "\\n";
    String REGEX_BRACKET_OPEN = "[{]";
    String REGEX_BRACKET_CLOSE = "[}]";
    String REGEX_PARAGRAPH = "^\\s??[A-ZА-Я_0-9]+";
    String REGEX_SENTENCE = "\\.";
    String REGEX_SEPARATOR_WORD_AND_SYMBOL= "(^[0-9a-zA-Zа-яА-Я]+)";
    String REGEX_BORDER_OF_WORD= "\\s+\\b";
}
