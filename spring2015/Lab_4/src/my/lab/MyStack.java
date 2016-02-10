package my.lab;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 class MyStack {
	Element del;
	MyLinkedList myList;

	MyStack(){
		myList = new MyLinkedList();
	}
	
	/** Push a new Element on top of the stack*/
	 void push(Element e){ 
			 myList.addFirst(e.getElement());		
	}
	
	/** Take the element from the top of the stack*/	
	 Element pop() {
		 if(myList.size<0) {
			 System.out.println("Empty stack!");
			 return null;
		 }
		 else {		 
			 del=myList.first;
			 myList.first=myList.first.next;
			 myList.size--;
			 if (myList.size == 0) myList.last = null;
			 return del;
		 }
	}
}
