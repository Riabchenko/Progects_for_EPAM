package my.lab;

import java.util.Random;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
class ListTest {

	public static void main(String[]args){
		MyLinkedList mlist=new MyLinkedList();
		
/**	This method adds new element to the end of the list*/
    for(Integer i=12;i>=0;i--)	{	
    	int j = new Random().nextInt(20);
    	mlist.add(j);
    }
		System.out.println(mlist.str()+"\n"); // Print the list
		
/** This method adds first element in the list*/
//		System.out.println("Add fist elements:");
//		mlist.addFirst(10);
//		mlist.addFirst(30);
		
/** This method adds last element in the list*/		
//		System.out.println("Add last element");
//		mlist.addLast(45);
	
/** Get value of the first element*/
		System.out.println("First element "+mlist.getFirst());
		
/** Get value of the last element*/
		System.out.println("Last element "+mlist.getLast());
		
/** Remove the first element*/
		System.out.println("Remove the first element: "+mlist.removeFirst());
		
/** Remove the last element*/
		System.out.println("Remove the last element: "+mlist.removeLast());
		
/** Remove an element at a certain index*/		
		try{
			mlist.remove(1);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			}
//		
/** This method gets value of the element at certain position*/
		try{
		System.out.println("Value by index ["+2+"] => "+mlist.get(2));
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());}
		
/** This method adds new element to a certain place in the list*/
//		try{
//			mlist.add(6,100);
//		}catch (IndexOutOfBoundsException e){
//			System.out.println(e.getMessage());
//		}
		
/** Set new value of element at certain position*/
//		try{
//		mlist.set(4, 200);
//		System.out.println(mlist.str()+"\n"); // Print the list
//		}catch (IndexOutOfBoundsException e){
//			System.out.println(e.getMessage());
//			}
//		catch (NullPointerException e){
//			System.out.println("Empty the index!");
//		}
		
/** Get size of the list*/
		System.out.println("Size of the list: "+mlist.size());
		
/** Search the index of an element with certain value*/	
//		System.out.println("Index of an element by value (3) => "+mlist.indexOf(3));
		
		System.out.println(mlist.str()+"\n"); // Print the list
		
	}
	

}


