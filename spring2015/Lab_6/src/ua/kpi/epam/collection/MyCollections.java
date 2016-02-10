package ua.kpi.epam.collection;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 16.04.2015
*
*/
import ua.kpi.epam.*;

public class MyCollections {
	
//**********************for MyLinkedList***************************//
/** Quick sort MyLinkedList
 * @param list Input MyLinked list 
 */	
	public static void sort(MyLinkedList list){
		quickSort(list,0,list.size()-1);
	}
//--------Below is methods for Quick sort MyLinkedList------------//
	/** Method for quick sort which uses recursion for sort 
	 * @param list Input MyLinked list 
	 * @param low Left less index of input list
	 * @param high Right lager index of input list
	 */
	private static void quickSort(MyLinkedList list,int low,int high){	
		if(high <= low)	return;		
			int p = partition(list,low,high);
			quickSort(list,low,p-1);
			quickSort(list,p+1,high);		
			isSorted(list, low, high);		
		}

	/** Method for quick sort which partition list
	 * @param list Input MyLinked list 
	 * @param low Left less index of input list
	 * @param high Right lager index of input list
	 */
	private static int partition(MyLinkedList list,int low,int high){
		int left = low;
		int right = high+1;
		Integer center = list.get(low);
		while(true){
			while(less(list.get(++left),center)) if (left == high) break; 
			while(less(center,list.get(--right))) if (right == low) break;				
			if (left >= right) break;
			swap(list,left,right);
		}
		swap(list,low,right);
		return right;
	}
	
	/** Method for quick sort which compare two value and return false or true.
	 * @param value First value of list
	 * @param center Second value of list 
	 */
	private static boolean less(Integer value,Integer center){		
		return value.compareTo(center) < 0;
	}
	
	/** Method for quick sort which checks is sorted
	 * @param list Input MyLinkedList list
	 * @param low Left less index of input list
	 * @param high Right lager index of input list
	 */
	private static boolean isSorted(MyLinkedList list, int low, int high) {
    for (int i = low + 1; i <= high; i++)
        if (less(list.get(i),list.get(i-1))) return false;
    return true;
}

	/** Swaps the elements at the specified positions in the specified list
	 * @param list Input MyLinkedList
	 * @param i First index 
	 * @param j Second index 
	 */
	public static void swap(MyLinkedList list, int i, int j){
    if (i > list.size() || i < 0)   throw new IndexOutOfBoundsException("Error index!");
    if (j > list.size() || j < 0)   throw new IndexOutOfBoundsException("Error index!");
		Integer elementTemp=list.get(i); //save first value to temporary variable 		
		list.set(i,list.get(j)); 
		list.set(j, elementTemp);//set first value wish was saved to temporary variable to position of last value
	}	
//----------------------------------------------------------------//
	/** Copies all of the elements from one list into another
	 * @param dest	Destination MyLinkedList
	 * @param src	Source MyLinkedList
	 */
	public static void copy(MyLinkedList dest, MyLinkedList src) {
		for(int l=0; l<src.size(); l++) {
			dest.add(src.get(l));
		}
	}
	
	/** Reverses the order of the elements in the specified list
	 * @param list Input MyLinkedList
	 */	
	public static void revers (MyLinkedList list){
    for (int i = 0; i < list.size() / 2; i++)  swap(list, i, list.size() - 1 - i);
	}
	
//**********************for MyArrayList***************************//
	/** Quick sort MyArrayList
	 * @param list Input MyArrayList array 
	 */	
		public static void sort(MyArrayList array){
			quickSort(array,0,array.size()-1);
		}
	//--------Below is methods for Quick sort MyLinkedList------------//
		/** Method for quick sort which uses recursion for sort 
		 * @param list Input MyLinked list 
		 * @param low Left less index of input list
		 * @param high Right lager index of input list
		 */
		private static void quickSort(MyArrayList array,int low,int high){	
			if(high <= low)	return;		
				int p = partition(array,low,high);
				quickSort(array,low,p-1);
				quickSort(array,p+1,high);		
				isSorted(array, low, high);		
			}

		/** Method for quick sort which partition list
		 * @param list Input MyLinked list 
		 * @param low Left less index of input list
		 * @param high Right lager index of input list
		 */
		private static int partition(MyArrayList array,int low,int high){
			int left = low;
			int right = high+1;
			Integer center = (Integer) array.get(low);
			while(true){
				while(lessArray((Integer) array.get(++left),center)) if (left == high) break; 
				while(lessArray(center,(Integer) array.get(--right))) if (right == low) break;				
				if (left >= right) break;
				swap(array,left,right);
			}
			swap(array,low,right);
			return right;
		}
		
		/** Method for quick sort which compare two value and return false or true.
		 * @param value First value of list
		 * @param center Second value of list 
		 */
		private static boolean lessArray(Integer value,Integer center){		
			return value.compareTo(center) < 0;
		}
		
		/** Method for quick sort which checks is sorted
		 * @param list Input MyLinkedList list
		 * @param low Left less index of input list
		 * @param high Right lager index of input list
		 */
		private static boolean isSorted(MyArrayList array, int low, int high) {
	    for (int i = low + 1; i <= high; i++)
	        if (less((Integer)array.get(i),(Integer)array.get(i-1))) return false;
	    return true;
	}

		/** Swaps the elements at the specified positions in the specified list
		 * @param list Input MyLinkedList
		 * @param i First index 
		 * @param j Second index 
		 */
		public static void swap(MyArrayList array, int i, int j){
			if (i > array.size() || i < 0)    throw new IndexOutOfBoundsException("Error index!");
			if (j > array.size() || j < 0)    throw new IndexOutOfBoundsException("Error index!");
			Integer elementTemp=(Integer)array.get(i); //save first value to temporary variable 		
			array.set(i,array.get(j)); 
			array.set(j, elementTemp);//set first value wish was saved to temporary variable to position of last value
		}	
	//----------------------------------------------------------------//
		/** Copies all of the elements from one list into another
		 * @param dest	Destination MyLinkedList
		 * @param src	Source MyLinkedList
		 */
		public static void copy(MyArrayList dest, MyLinkedList src) {
			for(int l=0; l<src.size(); l++) {
				dest.add(src.get(l));
			}
		}
		
		/** Reverses the order of the elements in the specified list
		 * @param list Input MyLinkedList
		 */	
		public static void revers (MyArrayList array){
	    for (int i = 0; i < array.size()/2; i++)  swap(array, i, array.size() - 1 - i);
		}
		
//**********************Binary search in the MyArrayList***************************//		
		
		/** Binary search on MyArrayList
		 * @param list	MyArrayList array to search 
		 * @param key		element to find
		 * @return			index of element or (-(insertion point) - 1) if element is not in the array
		 */
		public static int binarySearch(MyArrayList array, Integer key) {
			return bisectionSearch(array, key, 0, array.size());
		}

		private static int bisectionSearch(MyArrayList array, Integer key, int min, int max) {
			int midIndex = (min + max) / 2;
			
			if(min >= max) 	return (-(midIndex) - 1);
			if((Integer) array.get(midIndex) > key) 	return bisectionSearch(array, key, min, midIndex);
			else if((Integer) array.get(midIndex) < key) 	return bisectionSearch(array, key, midIndex+1, max);		
			else	return midIndex;
		}
}
