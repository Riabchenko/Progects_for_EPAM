package com.intellect25.administration;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.intellect25.fruit.Apple;
import com.intellect25.fruit.Fruit;
import com.intellect25.fruit.Melon;
import com.intellect25.fruit.Orange;
import com.intellect25.fruit.RedApple;

public class CollectionForFruit {
	
	/**
	 * This method converts array to list
	 * @param <T> some class
	 * @param <T> some class
	 * @param a array 
	 * @param c Collection<T>
	 */
		public static <T> void fromArrayToCollection(T [] a, Collection<T> c){
		 List list = Arrays.asList(a);
		 c.addAll(list);
	  }
	/**
	 * This method for copy all elements to the certain list
	 * @param collection 
	 * @param out
	 */
		public static <T extends E, E> void copyAll(Collection  <T> collection, Collection <E> out){
			 for(T element : collection) {
         out.add(element);
       }
	  }
		/**
		 * 
		 * @param source
		 * @param criteria
		 * @return
		 */
		public static <T extends Fruit> Collection collectionWithFilter(Collection<T> source, int parameterOfCount) {
      Collection<T> result = new ArrayList<>();
      for(T element : source) {
          if(element.getAmount() - parameterOfCount > 0) {
              result.add(element);
          }
      }
      return result;
     }
	
	public static void main (String[] args){	
		
		Apple [] a =new Apple[]{new Apple(5),new Apple(), new Apple(), new Apple()};
		
    List<Fruit> fr = null;
    List<Apple> app = null;
    List<Orange> or = null;
    List<RedApple> rapp = null;
    List<Melon> mel = null;

    fr = new ArrayList<>();
    app = new ArrayList<>();
    or = new ArrayList<>();
    rapp = new ArrayList<>();
    mel = new ArrayList<>();
    
    mel.add(new Melon(5));
    
    fromArrayToCollection(a, app);
//    fromArrayToCollection(a, mell);//error
    
    copyAll(or, fr); 
    copyAll(rapp, fr); 
    copyAll(rapp, app); 
    copyAll(rapp, rapp); 
//    copyAll(fr, or);//error
   
    System.out.println(collectionWithFilter(app,2));

	}
	
}
