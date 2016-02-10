package com.intellect25.task1.administration;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class creates necklaces,
*sort stones of necklace, 
*select on a specified range of clarity,
*sort in value,
*total weight of the necklace
*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.intellect25.task1.characteristicsOfStones.Clarity;
import com.intellect25.task1.characteristicsOfStones.Color;
import com.intellect25.task1.characteristicsOfStones.Cut;
import com.intellect25.task1.characteristicsOfStones.Forma;
import com.intellect25.task1.characteristicsOfStones.TypeStones;
import com.intellect25.task1.stones.Stones;

public class RegisteredFactories {
	private static double totalWeight;
	private static double totalPrice;

//=======================================================================//		
	public static void main(String [] args){		
		/**Create a necklace (Random)*/
		List <Stones> necklace = new ArrayList();
		creatNecklace(necklace , 8);
		
		/**Create a necklace2 (Random)*/
		List <Stones> necklace2= new ArrayList();
		creatNecklace(necklace2 , 8);
		
		/**Create a necklace3*/
		List <Stones> necklace3= new ArrayList();
		necklace3.add(Part.addStones(TypeStones.DIAMOND,Forma.ROUND,1f,1,1,Color.Z,Clarity.I3,Cut.POOR)); // TypeStones stones,Forma forma,float diametrOrLenght, float widht,float height,Color color,Clarity clarity, Cut cut
		necklace3.add(Part.addStones(TypeStones.DIAMOND,Forma.ROUND,1f,1,1,Color.D,Clarity.VVS1,Cut.EXCELLENT));
		necklace3.add(Part.addStones(TypeStones.DIAMOND,Forma.ROUND,6.4f,6.4f,4,Color.Z,Clarity.I3,Cut.POOR));
		necklace3.add(Part.addStones(TypeStones.DIAMOND,Forma.ROUND,6.4f,6.4f,4,Color.D,Clarity.VVS1,Cut.EXCELLENT));
		
		/**
		 * Create the comparator for compare stones
		 */
		Comparator comparatorForStones = new Comparator<Stones>(){
			public int compare(Stones o1, Stones o2) {
				return o1.getType().compareTo(o2.getType());
			}
		};		
			
		/** Sort in value*/ 
		necklace.sort(comparatorForStones);
		necklace2.sort(comparatorForStones);
		
		/** Total weight of the necklace*/
		totalWeight(necklace);
		totalWeight(necklace2);
		totalWeight(necklace3);
		
		/** Select on a specified range of clarity - the first value is minimum clarity, the second value is maximum clarity*/
		totalWeight(selectClarity(necklace,Clarity.VS2,Clarity.VVS2));
		
	}
//=======================================================================//	
	/**
	 *Select on a specified range of clarity - the first value is minimum clarity, the second value is maximum clarity
	 * @param necklace
	 * @param minClarity
	 * @param maxClarity
	 * @return List<Stones> 
	 */
	public static List<Stones> selectClarity(List<Stones> necklace,Clarity minClarity,Clarity maxClarity){
		int min = minClarity.ordinal();
		int max = maxClarity.ordinal();
		List<Stones> selected = new ArrayList();
		if(min<=max){
			for (Stones s : necklace){
				if(s.getClarity().ordinal() >= min && s.getClarity().ordinal() <= max)
					selected.add(s);	
			}
		}
		return selected;
	}
	
	/**
	 * Create a necklace
	 * @param necklace
	 * @param n
	 * @return
	 */
	public static List<Stones> creatNecklace(List<Stones> necklace, int n){
		for ( int i = 0; i < n; i++){
			necklace.add((Stones) Part.createRandom());
		}
		return necklace;
	}
	
	/** 
	 * Method for count of total weight of a necklace
	 * @param necklace
	 */
	public static void totalWeight(List <Stones> necklace){
		printTitle();
		 totalWeight = 0;
		 totalPrice = 0;
		for (Stones s : necklace){
			String stones = s.getClass().getSimpleName();
			Clarity clarity = s.getClarity();
			Color color = s.getColor();
			Cut cut = s.getCut();
			double weight = s.getWeight();
			double price = s.getPrice();			
		print(stones,clarity,color,cut, weight, price);		
		}
		printTotal();
		
	}
	/**
	 * Display the title
	 */
	public static void printTitle(){
		System.out.println("====================================================================");
		System.out.format("%-15s %5s %10s %10s %10s %10s\n","Stones","Clarity","Color","Cut","Weight"," Price");
		System.out.format("%-15s %5s %10s %10s %10s %10s\n","-------","-------","-------","-------","-------","-------");
	}
	/**
	 * Display the data
	 */
	public static void print(String stones,Clarity clarity, Color color, Cut cut, double weight,double price){
		System.out.format("%-15s %5s %10s %10s %10s %10s\n",stones,clarity,color, cut, weight,price);
		totalWeight += weight;
		totalPrice += price;
	}
	/**
	 * Display the total
	 */
	public static void printTotal(){
		System.out.format("%-15s %5s %10s %10s %10s %10s\n","-------","-------","-------","-------","-------","-------");
		System.out.format("%-15s %5s %10s %10s %10s %10s\n","Total","","","",Stones.round(totalWeight,2),Stones.round(totalPrice,2));
	}
}
