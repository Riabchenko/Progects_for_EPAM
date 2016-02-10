package my.lab;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 class MyQueue {
	Element del;
	MyLinkedList myList;
		
	MyQueue(){
		myList = new MyLinkedList();
	}

	/** New element adds to the end of the queue*/	
	 void offer(Element e){
			 myList.addLast(e.getElement());		
	}
	
	/** Get the first element of the queue*/
	 Element peek(){
		 del=myList.first;
		 return del;
	}
	
	/** Get the first element of the queue and remove it*/
	 Element poll() {
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
