package com.intellect25.task1.stones;

import com.intellect25.task1.characteristicsOfStones.Clarity;
import com.intellect25.task1.characteristicsOfStones.Color;
import com.intellect25.task1.characteristicsOfStones.Cut;
import com.intellect25.task1.characteristicsOfStones.TypeStones;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class is parent for different kind of stones.
*All information stored in stones.
*
*/
abstract public class Stones {
 public static int count;
 protected int id = count++;

 /**
  * The method gets a Id of a stone
  * @return int id
  */
 abstract public int getId();
 
 /**
  * The method gets a type of a stone
  * @return TypeStones type
  */
 abstract public TypeStones getType();
 
 /**
  * The method gets the price of the stone
  * @return double price
  */
 abstract public double getPrice();
 
 /**
  * The method gets the weight of the stone
  * @return double weight
  */
 abstract public double getWeight();
 
 /**
  * The method gets the clarity of the stone
  * @return Clarity clarity
  */
 abstract public Clarity getClarity();
 
 /**
  * The method gets the color of the stone
  * @return Color color
  */
 abstract public Color getColor();
 
 /**
  * The method gets the cut of the stone
  * @return Cut cut
  */
 abstract public Cut getCut();
 
 /**
  * Displays 2 number after the point in 'double'
  * @param value 
  * @param scale
  * @return double with 2 number after the point
  */
 public static double round(double value, int scale) {
   return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
	}
}
