package collection.set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyIntegerSet {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Integer>[] elements;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    public MyIntegerSet() {
        initBuckets();
    }

    public MyIntegerSet(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        elements = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public boolean add(int value) {
        int index = hashIndex(value);

        List<Integer> bucket = elements[index];

        // 이미 넣은거면 추가 안함
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    private int hashIndex(int value) {
        return value % capacity;
    }

    public boolean contains(int value) {
        int index = hashIndex(value);
        List<Integer> bucket = elements[index];
        return bucket.contains(value);
    }

    public boolean remove(int searchValue) {
        int index = hashIndex(searchValue);

        List<Integer> bucket = elements[index];

        if (!bucket.contains(searchValue)) {
            return false;
        }

        elements[index].remove(Integer.valueOf(searchValue));
        size--;
        return true;
    }

    public int size() { return size; }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}