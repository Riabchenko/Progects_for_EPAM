package com.intellect25.test;

import java.util.ArrayList;
import java.util.List;
import com.intellect25.administration.CollectionForFruit;
import com.intellect25.fruit.Apple;
import com.intellect25.fruit.Fruit;
import com.intellect25.fruit.Melon;
import com.intellect25.fruit.Orange;
import com.intellect25.fruit.RedApple;

public class Test {
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
    
    CollectionForFruit.fromArrayToCollection(a, app);
//    CollectionForFruit.fromArrayToCollection(a, mell);//error
    
    CollectionForFruit.copyAll(or, fr); 
    CollectionForFruit.copyAll(rapp, fr); 
    CollectionForFruit.copyAll(rapp, app); 
    CollectionForFruit.copyAll(rapp, rapp); 
//    CollectionForFruit.copyAll(fr, or);//error
   
    System.out.println(CollectionForFruit.collectionWithFilter(app,2));

	}
}
