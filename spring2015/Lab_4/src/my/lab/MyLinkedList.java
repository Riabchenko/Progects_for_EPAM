package my.lab;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.04.2015
*
*/

 class MyLinkedList {
	Element first;//first element
	Element last; //last element
	int size=0;//number of element
	private Element searchIndex;

/**	This method adds new element to the end of the list*/
	 void add(Integer e){
		if (size==0){
			addFirst(e);
		}else{
			addLast(e);
		}  
	}

/** This method adds new element to a certain place in the list*/
	 void add(int index,Integer element){
		if(index<size && index>=0){
		if (index == 0){
			addFirst(element);
		}
		else if (index == size){
			addLast(element);
		}
		else {
			search(index-1);
			Element one=searchIndex; //the element with is before necessary position
			search(index);
			Element two = searchIndex; //the element with is in necessary position
			Element current=new Element(element,two);
			one.next=current;			
			size++;
		}
		}else throw new IndexOutOfBoundsException("Error index!");
	}
	

/** This method adds first element in the list*/
	 void addFirst(Integer e){
		 Element current = new Element(e, first);
		 if(first==null){
			 last = current;}
		 first=current;
		 size++;
	}
	
/** This method adds last element in the list*/
	 void addLast(Integer e){
		Element current=new Element(e,null);
		last.next=current;			
		last=current;	
		size++;
	}
	
/** This method gets value of the element at certain position*/
	 Integer get(int index){
		if(index < 0 || index >size-1) throw new IndexOutOfBoundsException("Error index!");
		else{
			search(index);
			Element search=searchIndex;
			return search.getElement();		
		}					
	}
	
/** Get value of the first element*/
	 Integer getFirst(){
		return first.getElement();
	}
	
/** Get value of the last element*/
	 Integer getLast(){
		return last.getElement();
	}
	
/** Remove an element at a certain index*/	
	 Integer remove(int index){		 
		 if (index == 0) return removeFirst();
     if (index == size - 1) return removeLast();
     if(index<size && index>=0){	
						search(index);
						Element search=searchIndex;	
						size--;
						return 	search.remove(index);
			}else				
				throw new IndexOutOfBoundsException("Error index!");
							
		}
		

/** Remove the first element*/	
	 Integer removeFirst(){
		 Integer val = first.getElement();
		 first.remove(0);
		 size--;
		return val;
	}
	
/** Remove the last element*/	
	 Integer removeLast(){
		 Integer value=last.getElement();
		 last = search(size - 2);
     last.next = null;
     size--;
		return value;
	}

/** Set new value of element at certain position*/	
	 void set(int index,Integer element){
		if(index<size && index>=0){
		search(index);
		Element search=searchIndex;
		search.setElement(element);
		}else {
			throw new IndexOutOfBoundsException("Error index!");
			}
	}

/** Get size of the list*/
	 int size(){
		return size;
	}
	
/** Search the index of an element with certain value*/	
	  int indexOf(Integer o){
		 Element search = first;
		 int searchIndexInt = 0;
		 int no = 0;//не это значение
		 while(searchIndexInt<size && search!=null){
			 if(search.getElement()!=o){
				 search=search.next();
				 no++;
			 }	 
			 searchIndexInt++;		 
		 }
		 if(no==size) searchIndexInt=-1;
		 else searchIndexInt=no;
		 return searchIndexInt;
	 }
	
/** Search an element with certain index*/	
	 Element search(int index){
		if(index < 0 || index >size-1){
			System.out.println("Error index!");
			return null;
			}else{
				searchIndex = first;
				while ( searchIndex!=null && index!=0){
					searchIndex = searchIndex.next();
					index--;
					}
				return searchIndex;
				}
	}	
	
/** Print the list*/
	 String str(){
		String str = "List: ";
		Element search = first;	
		while (search!=null){
			str += search.getElement()+" => ";		
			search = search.next();		
		}	
		return str;
	}


	
}
