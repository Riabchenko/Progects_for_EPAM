package com.intellect25.task1.stones;

import com.intellect25.task1.characteristicsOfStones.Clarity;
import com.intellect25.task1.characteristicsOfStones.Color;
import com.intellect25.task1.characteristicsOfStones.Cut;
import com.intellect25.task1.characteristicsOfStones.Forma;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This interface for Factories which creates stones. Implements it inner classes in the child classes of Stones.
*
*/
public interface Factory<Stones> {
	/**
	 * This method creates object of stones. 
	 * @param forma
	 * @param diametrOrLenght
	 * @param widht
	 * @param height
	 * @param color
	 * @param clarity
	 * @param cut
	 * @return
	 */
	Stones create(Forma forma,float diametrOrLenght, float widht,float height,Color color,Clarity clarity, Cut cut); 
}
