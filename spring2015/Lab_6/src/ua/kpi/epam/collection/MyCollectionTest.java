package ua.kpi.epam.collection;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 16.04.2015
*
*/
import ua.kpi.epam.MyArrayList;
import ua.kpi.epam.MyLinkedList;

public class MyCollectionTest {

	public static void main(String []args){
		
		/************* MyLinkedList**************/
//		MyLinkedList mlist=new MyLinkedList();
//		
//		/**	This method adds new element to the end of the list*/
//		for(Integer i=12;i>=0;i--)		mlist.add(i);
//		mlist.add(30);
//		mlist.add(59);
//		mlist.add(80);
//		mlist.add(2);
//		System.out.println(mlist.str()+"\n"); // Print the list
//				
//		MyCollections collection = new MyCollections();
//		/** Quick sort MyLinkedList*/
//		collection.sort(mlist);
//		/** Print the list to the console*/
//		System.out.println(mlist.str()+"\n"); // Print the list

		/************* MyArrayList***************/
		MyArrayList array = new MyArrayList();
		
		/**	This method adds new element to the array*/
		for(Integer i=12;i>=0;i--)	array.add(i);	
	
		MyCollections collection = new MyCollections();
		/** Quick sort MyArrayList*/
		collection.sort(array);
		
		/**	Binary search on MyArrayList*/
		System.out.println("Index => "+collection.binarySearch(array, 4));
	
		/** Print the arrayList to the console*/
		System.out.println("Array's size is "+array.size());	
		for(int i=0;i<array.size();i++)	System.out.println("["+i+"] = "+array.data[i]);		
	
	}
	
}
