package ua.kpi.epam;

import ua.kpi.epam.interfaces.MyList;
import ua.kpi.epam.interfaces.Queue;
import ua.kpi.epam.interfaces.Stack;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.04.2015
*
*/

 public class MyLinkedList implements MyList,Queue,Stack {
	Element first;//first element
	Element last; //last element
	int size=0;//number of element
	private Element searchIndex;

/**	This method adds new object to the end of the list*/
	 public void add(Object e){
		if (size==0)	addFirst(e);
		else addLast(e); 
	}

/**	This method adds new object from array to the end of the list*/	 
	 public void addAll(Object[] c) {
		 if(c.length>0){
			 for(int i=0;i<c.length;i++){
					if (size==0)	addFirst(c[i]);
					else addLast(c[i]);
			 }
		 }			
		}

	 
/** This method adds new element to a certain place in the list*/
	 public void add(int index,Object element){
		if(index<size && index>=0){
			if (index == 0)		addFirst(element);
			else if (index == size) 	addLast(element);
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

/** This method adds new object from array to a certain place in the list*/	 
	 public void addAll(int index, Object[] c) {
		 if(c.length>0){
				if(index<size && index>=0){
					for(int i=0;i<c.length;i++){
						if (index == 0)		addFirst(c[i]);
						else if (index == size) 	addLast(c[i]);
						else {
							search(index-1);
							Element one=searchIndex; //the element with is before necessary position
							search(index);
							Element two = searchIndex; //the element with is in necessary position
							Element current=new Element(c[i],two);
							one.next=current;			
							size++;
						}
					}
				} else throw new IndexOutOfBoundsException("Error index!");
		 }			
		}
	 
/** This method adds first element in the list*/
	 void addFirst(Object e){
		 Element current = new Element(e, first);
		 if(first==null) last = current;
		 first=current;
		 size++;
	}
	
/** This method adds last element in the list*/
	 void addLast(Object e){
		Element current=new Element(e,null);
		last.next=current;			
		last=current;	
		size++;
	}
	
/** This method gets value of the element at certain position*/
	 public Object get(int index){
		if(index < 0 || index >size-1) throw new IndexOutOfBoundsException("Error index!");
		else{
			search(index);
			Element search=searchIndex;
			return search.getElement();		
		}					
	}
	
/** Get value of the first element*/
	 public Object getFirst(){
		return first.getElement();
	}
	
/** Get value of the last element*/
	 public Object getLast(){
		return last.getElement();
	}
	
/** Remove an element at a certain index*/	
	 public Object remove(int index){		 
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
	 Object removeFirst(){
		 Object val = first.getElement();
		 first.remove(0);
		 size--;
		return val;
	}
	
/** Remove the last element*/	
	 Object removeLast(){
		 Object value=last.getElement();
		 last = search(size - 2);
     last.next = null;
     size--;
		return value;
	}

/** Set new value of element at certain position*/	
	 public void set(int index,Object element){
		if(index<size && index>=0){
		search(index);
		Element search=searchIndex;
		search.setElement(element);
		}else	throw new IndexOutOfBoundsException("Error index!");
	}

/** Get size of the list*/
	 public int size(){
		return size;
	}
	
/** Search the index of an object with certain value*/	
	  public int indexOf(Object o){
		 Element search = first;
		 int searchIndexInt = 0;
		 int no = 0;//not this value
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
	 public Element search(int index){
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

/** Convert MyLinkedList to an array of Objects
 * @return array of Objects
 */
public Object[] toArray() {
	Object [] arrayFromList = new Object [this.size()];
	for (int l=0; l<this.size();l++)
		arrayFromList [l] = this.get(l);		
	return arrayFromList;
}

/** Print the list*/
	 public String str(){
		String str = "List: ";
		Element search = first;	
		while (search!=null){
			str += search.getElement()+" => ";		
			search = search.next();		
		}	
		return str;
	}
	 
//******************Queue************************//
	 /** New element adds to the end of the queue*/	
	 public void offer(Object e){
			 this.addLast(((Element) e).getElement());		
	}
	
	/** Get the first element of the queue*/
	 public Object peek(){
		 Object del=this.getFirst();
		 return del;
	}
	
	/** Get the first element of the queue and remove it*/
	 public Object poll() {
		 if(this.size<0) throw new IndexOutOfBoundsException("Queue is empty!");
		 else {		 
			Object del=this.getFirst();
			 this.first=this.first.next();
			 this.size--;
			 if (this.size == 0) this.last = null;
			 return del;
		 }
	}
//*****************Stack*************************//
	 /** Push a new object on top of the stack*/
	 public void push(Object e){ 
			 this.addFirst(((Element) e).getElement());		
	}
	
	/** Take the object from the top of the stack*/	
	 public Object pop() {
		 if(this.size<0)  throw new IndexOutOfBoundsException("Stack is empty!");
		 else {		 
			Object del=this.getFirst();
			 this.first=this.first.next();
			 this.size--;
			 if (this.size == 0) this.last = null;
			 return del;
		 }
	} 
	 
}
