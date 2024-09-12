package collection.set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyObjectSet {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Object>[] elements;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    public MyObjectSet() {
        initBuckets();
    }

    public MyObjectSet(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        elements = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public boolean add(Object value) {
        int index = hashIndex(value);

        List<Object> bucket = elements[index];

        // 이미 넣은거면 추가 안함
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(Object value) {
        int index = hashIndex(value);
        List<Object> bucket = elements[index];
        return bucket.contains(value);
    }

    public boolean remove(Object searchValue) {
        int index = hashIndex(searchValue);

        List<Object> bucket = elements[index];

        if (!bucket.contains(searchValue)) {
            return false;
        }

        bucket.remove(searchValue);
        size--;
        return true;
    }

    public int size() { return size; }

    private int hashIndex(Object value) {
        return Math.abs(value.hashCode()) % capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}