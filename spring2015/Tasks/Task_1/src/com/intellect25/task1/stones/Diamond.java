package com.intellect25.task1.stones;

import com.intellect25.task1.characteristicsOfStones.Clarity;
import com.intellect25.task1.characteristicsOfStones.Color;
import com.intellect25.task1.characteristicsOfStones.Cut;
import com.intellect25.task1.characteristicsOfStones.Forma;
import com.intellect25.task1.characteristicsOfStones.TypeStones;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class is child of Stones.
*All information stored in stone.
*
*/
public class Diamond extends Stones{	
	TypeStones type = TypeStones.DIAMOND;
	Forma forma;
	Color color;
	Clarity clarity;
	Cut cut;
	double 
			weight,
			price,
			BASE_PRICE = 1;

	/**
	 * It's constructor for create Diamond
	 * @param forma
	 * @param diametrOrLenght
	 * @param widht
	 * @param height
	 * @param color
	 * @param clarity
	 * @param cut
	 */
	private Diamond (Forma forma,float diametrOrLenght, float widht,float height,Color color,Clarity clarity, Cut cut){
		this.forma = forma;
		this.color = color;
		this.clarity = clarity;
		this.cut = cut;
		setWeight(forma,diametrOrLenght,widht,height);
		setPrice(weight,color,clarity,cut); //price depends on weight,color,clarity,cut 
	}

	/**
	 * It's static class creates object of Diamond
	 * @author Aliona
	 *
	 */
	public static class Factory implements com.intellect25.task1.stones.Factory<Diamond> {
		/*
		 * (non-Javadoc)
		 * @see com.intellect25.tesk1.Factory#create(com.intellect25.tesk1.Forma, float, float, float, com.intellect25.tesk1.Color, com.intellect25.tesk1.Clarity, com.intellect25.tesk1.Cut)
		 */
		public Diamond create(Forma forma,float diametrOrLenght, float widht,float height,Color color,Clarity clarity, Cut cut){
			return new Diamond(forma,diametrOrLenght,widht,height,color,clarity,cut);
		}
	}
	
	/**
	 * Method sets weight of the Diamond which depends on many parameters  
	 * @param forma
	 * @param diametrOrLenght
	 * @param widht
	 * @param height
	 * @return double weight
	 */
	private double setWeight(Forma forma,float diametrOrLenght,float widht,float height){
		if(Forma.ROUND == forma) widht = diametrOrLenght;
		weight = getWeightForSet(forma, diametrOrLenght, widht, height);
		return weight;
	}
	
	/**
	 * This method is helper for method setWeight.
	 * @param forma
	 * @param diametrOrLenght
	 * @param widht
	 * @param height
	 * @return double Weight of the stone
	 */
	private double getWeightForSet(Forma forma,float diametrOrLenght,float widht,float height){
		return round((diametrOrLenght*widht*height*TypeStones.DIAMOND.getDensity()*forma.getProperty()),2);
	}
	
	/**
	 * Method sets price of the Diamond which depends on many parameters  
	 * @param weight
	 * @param color
	 * @param clarity
	 * @param cut
	 * @return double price
	 */
	private double setPrice(double weight,Color color,Clarity clarity, Cut cut){
		if(weight>=0.01){
			double priceNull = BASE_PRICE*Math.pow(weight,weight-0.01);
		double col = color.ordinal()*0.42*priceNull;
		double clar = clarity.ordinal()*0.15*priceNull/100;
		double c = cut.ordinal()*0.2*priceNull;
		price = round(priceNull+col+clar+c,2);
		}else price = 0;
		return price;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getPrice()
	 */
	public double getPrice(){
		return price;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getWeight()
	 */
	public double getWeight(){
		return weight;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getId()
	 */
	public int getId(){
		return id;
	}
	public Clarity getClarity(){
		return clarity;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getColor()
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getCut()
	 */
	public Cut getCut() {
		return cut;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.tesk1.Stones#getType()
	 */
	public TypeStones getType() {
		return type;
	}

	
}
