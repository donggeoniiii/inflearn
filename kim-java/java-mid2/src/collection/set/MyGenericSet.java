package collection.set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyGenericSet<E> implements MySet<E> {
    private LinkedList<E>[] elements;
    private int size = 0;
    private int capacity;

    public MyGenericSet(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        elements = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public boolean add(E value) {
        int index = hashIndex(value);

        List<E> bucket = elements[index];

        // 이미 넣은거면 추가 안함
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }
    public boolean contains(E value) {
        int index = hashIndex(value);
        List<E> bucket = elements[index];
        return bucket.contains(value);
    }

    public boolean remove(E searchValue) {
        int index = hashIndex(searchValue);

        List<E> bucket = elements[index];

        if (!bucket.contains(searchValue)) {
            return false;
        }

        bucket.remove(searchValue);
        size--;
        return true;
    }

    public int size() { return size; }

    private int hashIndex(E value) {
        return Math.abs(value.hashCode()) % capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}