package oop.collections.list;

import oop.collections.list.arraylist.ArrayListIterator;

public interface List {
    void addAtTail (String data);
    void addAtFront(String data);
    boolean removeIndex(int index);
    void removeAll();
    boolean setAt(int index,String data);
    String getAt(int index);
    boolean removeAllWithValue(String data);
    int getSize();
    Iterator getIterator();
}
