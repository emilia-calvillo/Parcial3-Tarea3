package oop.collections.list.linkedlist;
import oop.collections.list.Iterator;

public class LinkedListIterator implements Iterator {
    private Node current;
    
    public LinkedListIterator(Node head){
        this.current=head;
    }
    public boolean hasNext() {
        return current!=null;
    }
    
    public String next() {
        String data = current.getData();
        current=current.getNext();
        return data;
    }
}
