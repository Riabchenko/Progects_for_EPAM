package ua.kpi.epam;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
 public class Element {
	int value;
	Element next; 
	
	Element(Integer value,Element next){
		this.value=value;
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
  Integer remove(Integer index) {
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
  Integer getElement() {
    return value;
    }
  
/** Set new value in the element*/  
  void setElement(Integer value) {
    this.value = value;
   }
	
}
