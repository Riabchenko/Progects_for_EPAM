package com.intellect25.task1.administration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.intellect25.task1.characteristicsOfStones.Clarity;
import com.intellect25.task1.characteristicsOfStones.Color;
import com.intellect25.task1.characteristicsOfStones.Cut;
import com.intellect25.task1.characteristicsOfStones.Forma;
import com.intellect25.task1.characteristicsOfStones.TypeStones;
import com.intellect25.task1.stones.Alexandrite;
import com.intellect25.task1.stones.Diamond;
import com.intellect25.task1.stones.Factory;
import com.intellect25.task1.stones.Ruby;
import com.intellect25.task1.stones.Sapphire;
import com.intellect25.task1.stones.Stones;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class creates stones. It has two methods for creating  different.
*
*/
public class Part {
	//It's a list for all factories
	static List<Factory<? extends Stones>> partFactories = 
			new ArrayList<Factory<? extends Stones>>();
	static {
		partFactories.add(new Diamond.Factory());
		partFactories.add(new Sapphire.Factory());
		partFactories.add(new Ruby.Factory());
		partFactories.add(new Alexandrite.Factory());
		
	}

	private static Random rand = new Random();
	/**
	 * This method creates random stones.
	 * @return 
	 */
	public static Stones createRandom(){
		int n = rand.nextInt(partFactories.size());
		Forma forma = null;
		int rForma = rand.nextInt(7);
		int i=0;		
		for(Forma f : Forma.values()){
			if(i==rForma) forma = f;
			i++;
		}
		Color color = null;
		int rColor = rand.nextInt(23);
		i = 0;
		for(Color c : Color.values()){
			if(i==rColor) color = c;
			i++;
		}
		Clarity clarity = null;
		int rClarity = rand.nextInt(9);
		i = 0;
		for(Clarity c : Clarity.values()){
			if(i==rClarity) clarity = c;
			i++;
		}
		Cut cut = null;
		int rCut = rand.nextInt(5);
		i = 0;
		for(Cut c : Cut.values()){
			if(i==rCut) cut = c;
			i++;
		}
		float 
				diametrOrLenght = 0,
				height = 0,
				widht = 0;
		while(diametrOrLenght<=1) diametrOrLenght = rand.nextFloat()*rand.nextInt(13);
		while(height<=1) height = rand.nextFloat()*rand.nextInt(13);
		while(widht<=1) widht = rand.nextFloat()*rand.nextInt(13);

		return partFactories.get(n).create( forma,diametrOrLenght,widht,height,color,clarity,cut);
	}
	/**
	 * This method creates specified stones.
	 * @param type
	 * @param forma
	 * @param diametrOrLenght
	 * @param widht
	 * @param height
	 * @param color
	 * @param clarity
	 * @param cut
	 * @return
	 */
	public static Stones addStones(TypeStones type,Forma forma,float diametrOrLenght, float widht,float height,Color color,Clarity clarity, Cut cut){
		Stones s = null;
		switch (type){
			case DIAMOND:  
				s = new Diamond.Factory().create(forma,diametrOrLenght,widht,height,color,clarity,cut);
				return s;
			case RUBY:  
				s = new Ruby.Factory().create(forma,diametrOrLenght,widht,height,color,clarity,cut);
				return s;
			case SAPPHIRE:  
				s = new Sapphire.Factory().create(forma,diametrOrLenght,widht,height,color,clarity,cut);
				return s;
			case ALEXANDRITE:  
				s =	new Alexandrite.Factory().create(forma,diametrOrLenght,widht,height,color,clarity,cut);
				return s;
		}		
		return s;
	}

}
