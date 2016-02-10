package my.array;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 class MyArrayList {
	private int initialCapacity;
	Object [] data;
	int size=0;

/**Using no-argument constructor creates holder for data with
 *  initial capacity of 10
 */	
	 MyArrayList() {
		initialCapacity=10;
	}
	 
/**Using this constructor creates holder for data with given 
 * initial capacity
 */	 
	 MyArrayList(int initialCapacity){
		this.initialCapacity=initialCapacity;
	}
	 
	 
/** Add new element to the end of the arrayList*/
	 void add(Object e){
		if(size==0){
			data = new Object [initialCapacity];
			data[size++]=e;
		}else{
			if (size==data.length) ensureCapacity(size+1);				
			data[size++]=e;		
		}
	}
	
	
/** Add new element to specified index of the arrayList and shift all elements */	
	  void add(int index, Object element){
			if(index>=size) throw new IndexOutOfBoundsException("Error index! Index can't be more "+(size-1)+"!");
			else if (index<0) throw new IndexOutOfBoundsException("Error index! Index can't be less 0!");
			else{
				System.arraycopy(data, index, data, index + 1, size - index);
				data[index] = element;
				size++;	
			}
	 }

/** Appends all of the elements to the end of this list*/	 
	  void addAll(Object[] c){
		 ensureCapacity(c.length+size);
		 for(int i=0;i<c.length;i++){
			 data[size]=c[i];
			 size++;
		 }
	 }
	 
/** Inserts all of the elements into this list, starting at the specified position*/	 
	  void addAll(int index, Object[] c){
		 if(index>=size) throw new IndexOutOfBoundsException("Error index! Index can't be more "+(size-1)+"!");
			else if (index<0) throw new IndexOutOfBoundsException("Error index! Index can't be less 0!");
			else{ 
				ensureCapacity(index+c.length);
				for(int i=0;i<c.length;i++){
					data[i+index+1]=c[i];	
					if(size<=i+index+1){
						size++;
					}
				}
			}
	 }
	 
/** Increases the capacity of this ArrayList instance,
 *  if necessary, to ensure that it can hold at least 
 *  the number of elements specified by 
 *  the minimum capacity argument.
 *  */
	  void ensureCapacity(int minCapacity){
		 while (minCapacity>data.length){
			 Object [] data_new = new Object [2*data.length]; //можно установить увеличение другое
			 for(int i=0; i<data.length;i++){
				data_new[i]=data[i];
			 }				
			 data = data_new;
			}
	 }
	 
/** Get element of the arrayList by index*/	 
	  Object get(int index){
	  	Object object=null;
		 if(index<=size){
			 object = data[index];
			 System.out.println("["+index+"] = "+object);
		 }else throw new IndexOutOfBoundsException("Error index! Index can't be more "+(size-1)+"!");
		 return object;
	 }
	 
/** Remove the element at given index, shift 
 * all elements to the left and adjust the size of 
 * the container 
 */	 
	  Object remove(int index){
	  	Object object=null;
		 if(index>=size) throw new IndexOutOfBoundsException("Error index! Index can't be more "+(size-1)+"!");
			else if (index<0) throw new IndexOutOfBoundsException("Error index! Index can't be less 0!");
			else{
				 System.arraycopy(data, index + 1, data, index, data.length - 2 - index);
				size--;	
			}
		 return object;
	 }

/** Set new element to position with certain index*/	 
	  void set(int index, Object element){
		 if(index>=size) throw new IndexOutOfBoundsException("Error index! Index can't be more "+(size-1)+"!");
			else if (index<0) throw new IndexOutOfBoundsException("Error index! Index can't be less 0!");
			else{
				data[index]=element;
			}
	 }
	 
/** Get size of the arrayList*/	  
	  int size(){
		 return size;
	 }
}
