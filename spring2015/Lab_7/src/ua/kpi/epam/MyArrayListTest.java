package ua.kpi.epam;

import java.util.Random;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 class MyArrayListTest {

	public static void main (String [] args){
		
		
		/**Using this constructor creates holder for data with given 
		 * initial capacity
		 */	
//		MyArrayList arrayDefalt = new MyArrayList(10);
		
		/**Using no-argument constructor creates holder for data with
		 *  initial capacity of 10
		 */		
		MyArrayList array = new MyArrayList();
		
		/** Add new element to the end of the arrayList*/
    for(Integer i=12;i>=0;i--)	{	
    	int j = new Random().nextInt(20);
    	array.add(j);
    }
		
		/** Add new element to specified index of the arrayList and shift all elements */	
		try{
			array.add(2,100);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		/** Appends all of the elements to the end of this list*/	
		Object [] c = new Object []{1,2,3,4,5};
		array.addAll(c);
		
		/** Inserts all of the elements into this list, starting at the specified position*/
		try{
			Object [] e = new Object []{1,2,3,4,5};
			array.addAll(13,e);		
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		/** Get element of the arrayList by index*/	
		try{
			array.get(13);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		/** Remove the element at given index, shift 
		 * all elements to the left and adjust the size of 
		 * the container 
		 */	 
		try{
			array.remove(10);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		/** Set new element to position with certain index*/	
		try{
			array.set(1, 300);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		/** Get size of the arrayList*/	 
		System.out.println("List size = "+array.size());
		
		/** Print the arrayList to the console*/
		System.out.println("Array size's "+array.size());		
		for(int i=0;i<array.size();i++){
			System.out.println("["+i+"] = "+array.data[i]);
		}		
	}

}
