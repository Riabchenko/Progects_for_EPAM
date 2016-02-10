package com.intellect25.Test;

import com.intellect25.MyMap.MyHashMap;
import com.intellect25.MyMap.MyMap;
import com.intellect25.MyMap.MyTreeMap;

/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * This class is test for MyTreeHash and MyTreeMap
 */

public class Test {

	public static void main (String [] args){
	
    	//================================MyHashMap===============================//
     		
     		MyMap ht = new MyHashMap(5,0.75f);
     		
     		for (int i=1; i<50; i++) {
     			Integer key = i;
     			Integer value = i+10;			
     			ht.put(key, value);
     			ht.put(16, 3);
     		}
     		
     		System.out.println( "contains key 1 => " + ht.containsKey(1) );
     		System.out.println( "contains value 20 => " + ht.containsValue(20) );
     		System.out.println( "contains key 99 => " + ht.containsKey(99) );
     		System.out.println( "contains value 22 => " + ht.containsValue(22) );
     		
     		System.out.println( "get 1 => "+ht.get(1));
     		System.out.println( "put 33 and 55 => "+ht.put(33,55));
     		System.out.println("remove 2 => "+ht.remove(2));
     		
     		System.out.println( "size => " + ht.size() );
     		((MyHashMap)ht).display();
     		
     		System.out.println( "clear all "); ht.clear();
     		System.out.println("isEmpty => "+ht.isEmpty());    		
    		
     		System.out.println("==============================================");
     		
     	//================================MyTreeMap===============================//
    		
     	 MyMap st = new MyTreeMap();
     	 
      		for (int i=1; i<10; i++) {
      			Integer key = i;
      			Integer value = i;			
      			st.put(key, value);
      		}
      		System.out.println( "contains key 1 => " + st.containsKey(1) );
      		System.out.println( "contains value 2 => " + st.containsValue(2) );
      		System.out.println( "contains key 99 => " + st.containsKey(99) );
      		System.out.println( "contains value 22 => " + st.containsValue(22) );
      		
      		System.out.println( "get 1 => "+st.get(1));
      		System.out.println( "put 33 and 55 => "+st.put(33,55));
      		System.out.println("remove 2 => "+st.remove(2));
      		
      		System.out.println( "size => " + st.size() );
      		((MyTreeMap)st).display();
      		
      		System.out.println( "clear all "); st.clear();
      		System.out.println("isEmpty => "+st.isEmpty());
      		
     		
   }

}
