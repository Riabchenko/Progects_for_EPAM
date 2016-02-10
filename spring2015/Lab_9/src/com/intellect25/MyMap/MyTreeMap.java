package com.intellect25.MyMap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * This class implements interface MyMap
 */
public class MyTreeMap implements MyMap{

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private int size;
    private SimpleEntry head;
    private final Comparator comparator;

    /**
     * 
     * @author Riabchenko Aliona
     *
     */
    public static class SimpleEntry implements MyMap.Entry {

        private Object key;
        private Object value;
        private boolean color = BLACK;// color of parent link
        private SimpleEntry right; //links to the right subtree
        private SimpleEntry left;//links to the left  subtree
        private SimpleEntry parent;

        /**
         * It's constructor for SimpleEntry 
         * @param key Object key
         * @param value Associated data
         * @param parent SimpleEntry
         */
        public SimpleEntry(Object key, Object value, SimpleEntry parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        /*
         * (non-Javadoc)
         * @see com.intellect25.map.MyMap.Entry#getKey()
         */
        @Override
        public Object getKey() {
            return key;
        }

        /*
         * (non-Javadoc)
         * @see com.intellect25.map.MyMap.Entry#getValue()
         */
        @Override
        public Object getValue() {
            return value;
        }

        /*
         * (non-Javadoc)
         * @see com.intellect25.map.MyMap.Entry#setValue(java.lang.Object)
         */
        @Override
        public Object setValue(Object value) {
        	Object tempValue = this.value;
            this.value = value;
            return tempValue;
        }

    }

    /**
     *It's constructor for MyTreeMap 
     */
    public MyTreeMap() {
        size = 0;
        head = null;
        comparator = null;
    }

    /**
     *It's constructor for MyTreeMap with a parameter of comparator
     * @param comparator
     */
    public MyTreeMap(Comparator<Object> comparator) {
        size = 0;
        head = null;
        this.comparator = comparator;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#clear()
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * This method determinate the color
     * @param p SimpleEntry
     * @return 
     */
    private static boolean colorOf(SimpleEntry  p) {
        return (p == null) ? BLACK : p.color;
    }

    /**
     * This method determinate the parent of SimpleEntry
     * @param p SimpleEntry
     * @return
     */
    private static SimpleEntry parentOf(SimpleEntry  p) {
        return (p == null) ? null : p.parent;
    }

    /**
     * This method sets the color to SimpleEntry
     * @param p SimpleEntry
     * @param c true or false
     */
    private static   void setColor(SimpleEntry  p, boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    /**
     * This method determinate the left reference to SimpleEntry
     * @param p SimpleEntry
     * @return SimpleEntry
     */
    private static SimpleEntry  leftOf(SimpleEntry  p) {
        return (p == null) ? null : p.left;
    }

    /**
     * This method determinate the right reference to SimpleEntry
     * @param p SimpleEntry
     * @return SimpleEntry
     */
    private static SimpleEntry  rightOf(SimpleEntry  p) {
        return (p == null) ? null : p.right;
    }

    /**
     *This method gets Entry using comparator
     * @param key Object
     * @return SimpleEntry
     */
    private SimpleEntry  getEntryUsingComparator(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        SimpleEntry  p = head;
        while (p != null) {
            int cmp = comparator.compare(key, p.getKey());
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * This method gets Entry
     * @param key Object
     * @return SimpleEntry
     */
    private SimpleEntry  getEntry(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        SimpleEntry  node = head;
        while (node != null) {
            int cmp = ((Comparable) key).compareTo(node.getKey());
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object key) {
        SimpleEntry  node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        return node != null || get(key) != null;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#containsValue(java.lang.Object)
     */
    @Override
    public boolean containsValue(Object value) {
        Iterator<? extends Entry > i = entryIterator();
        if (value == null) {
            while (i.hasNext()) {
                Entry  e = i.next();
                if (e.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                Entry  e = i.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#get(java.lang.Object)
     */
    @Override
    public Object get(Object key) {
        SimpleEntry  node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        return node == null ? null : node.getValue();
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        SimpleEntry  t = head;

        if (t == null) {

            head = new SimpleEntry(key, value, null);
            size = 1;
            return null;
        }
        int cmp;
        SimpleEntry  parent;
        Comparator<? super Object> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        } else {
            if (key == null) {
                throw new NullPointerException();
            }
            Comparable<? super Object> k = (Comparable<? super Object>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        }
        SimpleEntry  e = new SimpleEntry(key, value, parent);
        if (cmp < 0) {
            parent.left = e;
        } else {
            parent.right = e;
        }
        fixAfterInsertion(e);
        size++;
        return null;
    }

    /**
     * This method rotates on the left
     * @param p SimpleEntry
     */
    private void rotateLeft(SimpleEntry  p) {
        if (p != null) {
            SimpleEntry  r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                head = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    /**
     *This method rotates on the right
     * @param p SimpleEntry
     */
    private void rotateRight(SimpleEntry  p) {
        if (p != null) {
            SimpleEntry  l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                head = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    /**
     *This method fixes tree after inserting
     * @param forFix
     */
    private void fixAfterInsertion(SimpleEntry  forFix) {
        SimpleEntry  x = forFix;
        x.color = RED;

        while (x != null && x != head && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                SimpleEntry  y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                SimpleEntry  y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        head.color = BLACK;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#remove(java.lang.Object)
     */
    @Override
    public Object remove(Object key) {
        SimpleEntry  node = null;
        if (comparator != null) {
            node = getEntryUsingComparator(key);
        } else {
            node = getEntry(key);
        }
        if (node == null) {
            return null;
        }

        Object oldValue = node.value;
        deleteEntry(node);
        return oldValue;
    }

    /**
     *This method searches the successor
     * @param t SimpleEntry
     * @return
     */
    private SimpleEntry  successor(SimpleEntry  element) {
        if (element == null) {
            return null;
        } else if (element.right != null) {
            SimpleEntry  p = element.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            SimpleEntry  p = element.parent;
            SimpleEntry  ch = element;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    /**
     *This method delete Entry
     * @param p1 SimpleEntry to remove
     */
    private void deleteEntry(SimpleEntry  p1) {
        SimpleEntry  p = p1;
        size--;

        if (p.left != null && p.right != null) {
            SimpleEntry  s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }

        SimpleEntry  replacement = (p.left != null) ? p.left : p.right;

        if (replacement != null) {
        	
            replacement.parent = p.parent;
            if (p.parent == null) head = replacement;
            else if (p == p.parent.left) p.parent.left = replacement;
            else  p.parent.right = replacement;
           
            p.left = p.right = p.parent = null;

            if (p.color == BLACK)  fixAfterDeletion(replacement);
        } else if (p.parent == null) head = null;
          else { 
            if (p.color == BLACK)  fixAfterDeletion(p);
           
            if (p.parent != null) {
                if (p == p.parent.left) p.parent.left = null;
                else if (p == p.parent.right)  p.parent.right = null;
                p.parent = null;
            }
        }
    }

    /**
     *This method fixes tree after deletion
     * @param x1 SimpleEntry
     */
    private void fixAfterDeletion(SimpleEntry  forFix) {
        SimpleEntry  x = forFix;
        while (x != head && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                SimpleEntry  sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK
                        && colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = head;
                }
            } else {
            	
                SimpleEntry  sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK
                        && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = head;
                }
            }
        }

        setColor(x, BLACK);
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#size()
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * (non-Javadoc)
     * @see com.intellect25.map.MyMap#entryIterator()
     */
    @Override
    public Iterator<Entry> entryIterator() {
        return new entryIterator();
    }

    /**
     * This method gets the first element
     * @return SimpleEntry
     */
    private SimpleEntry  getFirstEntry() {
        SimpleEntry  node = head;
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    /**
     *This class implements Iterator for entryIterator
     */
    private class entryIterator implements Iterator<Entry> {

        private SimpleEntry  nextForIterator;
        private SimpleEntry  lastReturnedForIterator;
        private SimpleEntry  tempNodeForIterator;

        /**
         *It's constructor
         */
        public entryIterator() {
            lastReturnedForIterator = null;
            nextForIterator = getFirstEntry();
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return nextForIterator != null;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public Entry  next() {
            tempNodeForIterator = nextForIterator;
            if (tempNodeForIterator == null) {
                throw new NoSuchElementException();
            }

            nextForIterator = successor(tempNodeForIterator);
            lastReturnedForIterator = tempNodeForIterator;
            return tempNodeForIterator;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {

            if (lastReturnedForIterator == null) 
                throw new NoSuchElementException();

            if (lastReturnedForIterator.left != null && lastReturnedForIterator.right != null) 
                nextForIterator = lastReturnedForIterator;
            
            deleteEntry(lastReturnedForIterator);
            lastReturnedForIterator = null;
        }
    }
    
  //--------------------------display----------------------------//	
  	public void display() {
  		showAllElements(head);
  	}
  	
  	private void showAllElements(SimpleEntry element) {
  		if (element == null)
  			return;
  		showAllElements(element.left);
  		Object leftSon = (element.left == null)?null:element.left.getValue();
  		Object rightSon = (element.right == null)?null:element.right.getValue();
  		System.out.println("-----------------------------------");
  		System.out.println("Color="+element.color+"  Node="+ element.getValue());
  		System.out.println("[left son="+leftSon+"]  [right son="+rightSon+"]");		
  		showAllElements(element.right);		
  	}	


}
