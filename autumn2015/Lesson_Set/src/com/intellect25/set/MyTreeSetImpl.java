package com.intellect25.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyTreeSetImpl<T extends Comparable<T>> implements MyTreeSet<T> {

    /**
     * root of tree set
     */
    private Node root;

    /**
     * count item in set
     */
    private int size;

    /**
     * default constructor
     */
    public MyTreeSetImpl() {
    }

    /**
     * inner class Node for save one element and communication with other
     */
    private class Node {
        /**
         * value of element in this node
         */
        private T item;

        /**
         * pointer on left node
         */
        private Node leftNode;

        /**
         * pointer on right node
         */
        private Node rightNode;

        /**
         * pointer on parent of this node
         */
        private Node parent;

        /**
         * default constructor
         */
        public Node() {
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    @Override
    public void add(T item) {
        checkNull(item);
        if(root == null) {
            root = new Node();
            root.setItem(item);
            size++;
            return;
        }
        if (contains(item)){ return; }
        add(root, item);
    }

    /**
     * adding to set new node
     * @param node	begin node
     * @param item	item
     */
    private void add(Node node, T item){

        Node parent = node;

        while (node != null) {
            if (0 > item.compareTo(node.getItem())) {
                parent = node;
                node = node.getLeftNode();
            } else {
                parent = node;
                node = node.getRightNode();
            }
        }

        Node newNode = new Node();
        newNode.setItem(item);
        newNode.setParent(parent);

        if(0 > item.compareTo(parent.getItem())) {
            parent.setLeftNode(newNode);
        }else {
            parent.setRightNode(newNode);
        }
        size++;
    }

    @Override
    public boolean remove(T item) {

        checkNull(item);

        if (!contains(item)){
            return false;
        }
        Node current = findNode(item);
        if (current == null) return false;

        Node parent;
        if ((current.getLeftNode() == null) && (current.getRightNode() == null)) {
            if (current == root) {
                root = null;
            } else {
                parent = current.getParent();
                if (parent.getRightNode() == current)
                    parent.setRightNode(null);
                else parent.setLeftNode(null);
            }
        } else {
            if (current.getRightNode() == null) {
                if(current == root){
                    root = current.getLeftNode();
                } else {
                    parent = current.getParent();
                    if(parent.getLeftNode() == current){
                        parent.setLeftNode(current.getLeftNode());
                        parent.getLeftNode().setParent(parent);
                    }else{
                        parent.setRightNode(current.getLeftNode());
                        parent.getRightNode().setParent(parent);
                    }
                }
            } else {
                if (current.getLeftNode() == null) {
                    if(current == root){
                        root = current.getRightNode();
                    } else {
                        parent = current.getParent();
                        if(parent.getLeftNode() == current){
                            parent.setLeftNode(current.getRightNode());
                            parent.getLeftNode().setParent(parent);
                        }else{
                            parent.setRightNode(current.getRightNode());
                            parent.getRightNode().setParent(parent);
                        }
                    }
                } else {
                    Node successor = minimum(current.getRightNode());
                    parent = successor.getParent();

                    if (parent.getRightNode() == successor){
                        current.setItem(successor.getItem());
                        if (successor.getRightNode() != null) {
                            successor.getRightNode().setParent(current);
                            current.setRightNode(successor.getRightNode());
                        } else { parent.setLeftNode(null); }
                    } else {
                        current.setItem(successor.getItem());
                        if (successor.getRightNode() != null){
                            successor.getRightNode().setParent(parent);
                            parent.setLeftNode(successor.getRightNode());
                        } else { parent.setLeftNode(null); }
                    }
                }
            }
        }
        size--;
        return true;
    }

    /**
     * findNode minimum in tree from node
     * @param node	node which begin to findNode
     * @return		minimum node
     */
    private Node minimum(Node node){
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }

    /**
     * find Node with item in set
     * @param item	item
     * @return	node with value of item or NULL when absent
     */
    private Node findNode(T item){

        Node current = root;
        while (current != null) {
            int cmp = item.compareTo(current.getItem());
            if (cmp < 0)
                current = current.getLeftNode();
            else if (cmp > 0)
                current = current.getRightNode();
            else
                return current;
        }
        return null;
    }

    /**
     * count of item in set
     * @return count of item in set
     */
    public int size(){
        return size;
    }

    @Override
    public boolean contains(T item) {
        if (root == null) return false;
        return contains(root, item);
    }

    /**
     * check present item in set
     * @param node	begin node
     * @param item	item
     * @return		true when contains in set
     */
    private boolean contains(Node node, T item){
        if (node == null) return false;

        if ( contains(node.getLeftNode(), item) )
            return true;
        if ( node.getItem().equals(item))
            return true;
        return contains(node.getRightNode(), item);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int currentIndex = -1;

            List<Node> allNodes = createListOfElements(root);


            @Override
            public boolean hasNext() {
                return currentIndex < size()-1;
            }

            @Override
            public Object next() {
                if (hasNext()){
                    currentIndex++;
                    return allNodes.get(currentIndex).getItem();
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * create list of branch tree
     * @param node	begin of branch tree
     * @return		list of nodes
     */
    private List<Node> createListOfElements(Node node) {
        List<Node> list = new ArrayList<Node>();
        addToList(list, node);
        return list;
    }

    /**
     * adding to list
     * @param list		list of nodes
     * @param begin		node begin of branch tree
     */
    private void addToList (List<Node> list, Node begin){
        if (begin == null) return;
        addToList(list, begin.getLeftNode());
        list.add(begin);
        addToList(list, begin.getRightNode());
    }

    /**
     * check item for null
     * @param item	item
     */
    private void checkNull(T item) {
        if (item == null) { throw new IllegalArgumentException("input NULL");}
    }
}
