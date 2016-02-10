package ua.kpi.epam;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 public class Element {
	Object value;
	Element next; 
	
	Element(Object element,Element next){
		this.value=element;
		this.next=next;
	}

/** Do list has next element? */
  boolean hasNext() {
      return next != null;
  }
  
/**Return the next element̆*/
  Element next() {
    return next;
  }
  
/**Remove the element with certain index*/	
  Object remove(Integer index) {
  	if (next != null) {
      if (index > 1) {
          return next.remove(--index);
      } else {
          value = next.getElement();
          next = next.next();
          return value;
      }
  	}
    return null;
  }
  
/**Get element*/	
  Object getElement() {
    return value;
    }
  
/** Set new value in the element*/  
  void setElement(Object element) {
    this.value = element;
   }
	
}
