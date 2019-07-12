package ivan.samoylov;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }

    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;


     @Override
    public boolean add(int element) {
        try {
            Entry newEntry = new Entry(element);
            if (size == 0) {
                first = newEntry;
                last = newEntry;
            } else {
                last.next = newEntry;
                newEntry.previous = last;
                last = newEntry;
            }
            size++;
            return true;
        }
        catch (Exception E){
            return false;
        }

     }

    @Override
    public int remove() {
        int temp = first.value;
        remove(0);
        return temp;
    }

    @Override
    public int element() {
         return first.value;
    }

    @Override
    public boolean add(int index, int element) {
        Entry current = last;

        for(int i = size() - 1; current.previous != null; i--){
            if(index == i){
                break;
            }
            current = current.previous;
            if (current == null){
                return false;
            }

        }
        Entry newLink = new Entry(element);
        if(current == last){
            newLink.next = null;
            last = newLink;
        }
        else{
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        size++;

        return true;
    }

    @Override
    public void clear() {
       this.first = null;
       this.last = null;
       size = 0;
    }

    @Override
    public int get(int index) {
        Entry tmp = last;
        int returnValue = 0;
        if (index == 0){
            returnValue = first.value;
        }
        else if (index == size()){
            returnValue = last.value;
        }
        else {
            int i = size() - 1;
            while (tmp.previous != null) {
                if (i == index) {
                    returnValue = tmp.value;
                    break;
                }
                tmp = tmp.previous;
                i--;
            }
        }
        return returnValue;
    }

    @Override
    public boolean isEmpty() {
         return size() == 0;
    }

    @Override
    public boolean remove(int index) {
        Entry current = first;
        for (int i = 0; current.next != null; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry current = first;
        while(current.value != value){
            current = current.next;
            if(current == null){
                return false;
            }
        }
        if(current == first){
            first = current.next;
        }
        else{
            current.previous.next = current.next;
        }
        if(current == last){
            last = current.previous;
        }
        else{
            current.next.previous = current.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index >=0 && index <= size() - 1) {
            Entry current = first;
            for (int i = 0; current != null; i++) {
                if (i == index) {
                    break;
                }
                current = current.next;
            }
            current.value = element;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
         return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
         IntLinkedList returnList = new IntLinkedList();
         for (int i = fromIndex; i <= toIndex; i++){
             returnList.add(this.get(i));
         }
         return returnList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public boolean push(int value) {
        return add(value);
    }

    @Override
    public int pop() {
        return remove();
    }

    @Override
    public int peek() {
       return last.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}