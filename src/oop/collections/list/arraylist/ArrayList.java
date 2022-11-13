package oop.collections.list.arraylist;
import oop.collections.list.List;

public class ArrayList implements List{
    private int size;
    private String[] data;
    public ArrayList() {
        data = new String[2];
    }

    public void addAtFront(String data) {
        if(size == this.data.length) {
            increase();
        }

        for(int i=size; i>0; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[0] = data;
        this.size++;
    }

    public void addAtTail(String data) {
        if(size == this.data.length) {
            increase();
        }
        this.data[size] = data;
        size++;
    }

    private void increase() {
        String []newArray = new String[this.data.length * 2];

        for(int i=0; i<data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public int getSize() {
        return size;
    }

    public ArrayListIterator getIterator() {
        return new ArrayListIterator(this);
    }

    public boolean removeIndex(int indexToRemove) {
        if(indexToRemove<0 || indexToRemove >= size) {
            return false;
        }
        for(int i=indexToRemove; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        return true;
    }

    public void removeAll() {
        for(int i = 0; i < size; i++) {
            data[i] = null;
        }
        size=0;
    }

    public boolean setAt(int indexToSearch, String data) {
        if(indexToSearch < 0 || indexToSearch >= size) {
            return false;
        }
        this.data[indexToSearch] = data;
        return true;
    }

    public String getAt(int indexToSearch) {
        if(indexToSearch < 0 || indexToSearch >= size) {
            return null;
        }
        return this.data[indexToSearch];
    }

    public boolean removeAllWithValue(String value) {
        int count = 0;
        String []newArray = new String[data.length];
        for(int i = 0; i < size; i++) {
            if(!data[i].equals(value)) {
                newArray[count] = data[i];
                count++;
            }
        }
        this.data = newArray;
        size = count;
        return true;
    }

    /*public static class ArrayListIterator implements Iterator {
        private ArrayList arrayList;
        private int currentIndex = 0;

        public ArrayListIterator(ArrayList arrayList) {
            this.arrayList = arrayList;
        }

        public boolean hasNext() {
            return currentIndex < arrayList.getSize();
        }

        public String next() {
            return arrayList.getAt(currentIndex++);
        }
    }*/
}
