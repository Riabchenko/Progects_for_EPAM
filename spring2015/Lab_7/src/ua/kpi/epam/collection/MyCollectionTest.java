package ua.kpi.epam.collection;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 16.04.2015
*
*/
import java.util.Comparator;
import java.util.Random;
import ua.kpi.epam.MyArrayList;
import ua.kpi.epam.MyLinkedList;
import ua.kpi.epam.interfaces.MyList;

public class MyCollectionTest {

	public static void main(String []args){
	
		/** Create new MyArrayList*/
    MyList myList = new MyArrayList();
    
    /**	This method adds new element to the list*/
    for(Integer i=12;i>=0;i--)	{	
    	int j = new Random().nextInt(20);
    	myList.add(j);
    }
    
    /** Create new MyLinkedList*/
    MyList myList2 = new MyLinkedList();
    
    /** Copy values from myList to myList2"*/
    MyCollections.copy(myList2, myList); 
    
    System.out.println(myList.str());
    System.out.println(myList2.str());
    
  	/** Sort*/
    MyCollections.sort(myList);
    MyCollections.sort(myList2);
    
    System.out.println("Sort: "+myList.str());
    System.out.println("Sort: "+myList2.str());
    
    /** Sort (Comparator)*/
    MyCollections.sort(myList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Integer) o1).compareTo((Integer) o2);
			}
		});
    
    MyCollections.sort(myList2, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Integer) o1).compareTo((Integer) o2);
			}
		});

    System.out.println("Sort (Comparator): "+myList.str());
    System.out.println("Sort (Comparator): "+myList2.str());

    
    /** Reveres*/
    MyCollections.reverse(myList);
    MyCollections.reverse(myList2);
    
    System.out.println("Reveres: "+myList.str());
    System.out.println("Reveres: "+myList2.str());
 
    /** Swap*/
    MyCollections.swap(myList, 0, 1);
    MyCollections.swap(myList2, 0, 1);
    
    System.out.println("Swap: "+myList.str());
    System.out.println("Swap: "+myList2.str());
    

	}
}
