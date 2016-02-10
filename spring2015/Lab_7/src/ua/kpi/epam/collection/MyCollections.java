package ua.kpi.epam.collection;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 17.04.2015
*
*/
import java.util.Comparator;
import java.util.RandomAccess;
import ua.kpi.epam.MyArrayList;
import ua.kpi.epam.interfaces.MyList;

public class MyCollections {

//***********************************Sort*********************************//	
/** sort MyList
 * @param list Input list 
 */	
	public static void sort(MyList list){
		if (list.size() > 0 && list.get(0) instanceof Comparable) {
      if (list instanceof RandomAccess)
          quickSort(list, 0, list.size() - 1);
      else bubleSort(list);
    }
  }
	
//-----------------------bubbleSort-----------------------------------------//
	 private static void bubleSort(MyList list) {
		 for (int i = list.size() - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (((Comparable) list.get(j)).compareTo(list.get(j + 1)) > 0) {
						Object temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			}
	 } 


//---------------------------- quickSort ------------------------------------//
	/** Method for quick sort which uses recursion for sort 
	 * @param list Input MyLinked list 
	 * @param low Left less index of input list
	 * @param high Right lager index of input list
	 */
	private static void quickSort(MyList list,int low,int high){	
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
	private static int partition(MyList list,int low,int high){
		int left = low;
		int right = high+1;
		Object center = list.get(low);
		while(true){
			while(((Comparable) list.get(++left)).compareTo(center) < 0) if (left == high) break; 
			while(((Comparable) center).compareTo(list.get(--right)) < 0) if (right == low) break;				
			if (left >= right) break;
			swap(list,left,right);
		}
		swap(list,low,right);
		return right;
	}

	
	/** Method for quick sort which checks is sorted
	 * @param list Input MyLinkedList list
	 * @param low Left less index of input list
	 * @param high Right lager index of input list
	 */
	private static boolean isSorted(MyList list, int low, int high) {
    for (int i = low + 1; i <= high; i++)
        if (((Comparable) list.get(i)).compareTo(list.get(i-1)) < 0) return false;
    return true;
}

	/** Swaps the elements at the specified positions in the specified list
	 * @param list Input MyLinkedList
	 * @param i First index 
	 * @param j Second index 
	 */
	public static void swap(MyList list, int i, int j){
    if (i > list.size() || i < 0)   throw new IndexOutOfBoundsException("Error index!");
    if (j > list.size() || j < 0)   throw new IndexOutOfBoundsException("Error index!");
		Object elementTemp=list.get(i); //save first value to temporary variable 		
		list.set(i,list.get(j)); 
		list.set(j, elementTemp);//set first value wish was saved to temporary variable to position of last value
	}		  
	
//-----------------------Sort (Comparable)-----------------------------------------//	
	/** Quick sort MyList
	 * @param list Input list 
	 * @param c Comparator
	 */	
	public static void sort(MyList list,Comparator c){
		if (list.size() > 0 && list.get(0) instanceof Comparable) {
      if (list instanceof RandomAccess)
      	quickSort(list, 0, list.size() - 1,c);
      else bubbleSort(list,c);
    }
  }

//-----------------------bubbleSort (Comparable)-----------------------------------------//	
	 private static void bubbleSort(MyList list,Comparator c) {
		 for (int i = list.size() - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (c.compare(list.get(j), list.get(++j)) > 0) {
						Object temp = list.get(j);
						list.set(j, list.get(++j));
						list.set(++j, temp);
					}
				}
			}
	 }

//--------------------Below is methods for quickSort (Comparator)------------------------------//
	 	/** Method for quick sort which uses recursion for sort 
	 	 * @param list Input MyLinked list 
	 	 * @param low Left less index of input list
	 	 * @param high Right lager index of input list
	 	 */
	 	private static void quickSort(MyList list,int low,int high,Comparator c){	
	 		if(high <= low)	return;		
	 			int p = partition(list,low,high,c);
	 			quickSort(list,low,p-1,c);
	 			quickSort(list,p+1,high,c);		
	 			isSorted(list, low, high,c);		
	 		}

	 	/** Method for quick sort which partition list
	 	 * @param list Input MyLinked list 
	 	 * @param low Left less index of input list
	 	 * @param high Right lager index of input list
	 	 */
	 	private static int partition(MyList list,int low,int high,Comparator c){
	 		int left = low;
	 		int right = high+1;
	 		Object center = list.get(low);
	 		while(true){
	 			while(c.compare(list.get(++left), center) < 0) if (left == high) break; 
	 			while(c.compare(center, list.get(--right)) < 0) if (right == low) break;				
	 			if (left >= right) break;
	 			swap(list,left,right);
	 		}
	 		swap(list,low,right);
	 		return right;
	 	}
	 	
	 	/** Method for quick sort which checks is sorted
	 	 * @param list Input MyLinkedList list
	 	 * @param low Left less index of input list
	 	 * @param high Right lager index of input list
	 	 */
	 	private static boolean isSorted(MyList list, int low, int high,Comparator c) {
	     for (int i = low + 1; i <= high; i++)
	         if (c.compare(list.get(i), list.get(i-1)) < 0) return false;
	     return true;
	 }
	 	
//***************************Copy**********************************//	
	/** Copies all of the elements from one list into another
	 * @param dest	Destination MyLinkedList
	 * @param src	Source MyLinkedList
	 */
	public static void copy(MyList dest, MyList src) {
		for(int l=0; l<src.size(); l++) {
			dest.add(src.get(l));
		}
	}
	
//***************************Reverse**********************************//	
	/** Reverses the order of the elements in the specified list
	 * @param list Input MyLinkedList
	 */	
	public static void reverse(MyList list){
    for (int i = 0; i < list.size() / 2; i++)  
    	swap(list, i, list.size() - 1 - i);
	}
//**********************Binary search in the MyArrayList***************************//		
	
		/** Binary search on MyArrayList
		 * @param list	MyArrayList array to search 
		 * @param key		element to find
		 * @return			index of element or (-(insertion point) - 1) if element is not in the array
		 */
		public static int binarySearch(MyList myList2, Integer key) {
			return bisectionSearch(myList2, key, 0, myList2.size());
		}

		private static int bisectionSearch(MyList myList2, Integer key, int min, int max) {
			int midIndex = (min + max) / 2;
			
			if(min >= max) 	return (-(midIndex) - 1);
			if((Integer) myList2.get(midIndex) > key) 	return bisectionSearch(myList2, key, min, midIndex);
			else if((Integer) myList2.get(midIndex) < key) 	return bisectionSearch(myList2, key, midIndex+1, max);		
			else	return midIndex;
		}
	
}
