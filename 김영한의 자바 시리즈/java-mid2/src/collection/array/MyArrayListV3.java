package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size = 0; // 현재 사이즈

    public MyArrayListV3() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(Object o) {
        // 배열이 꽉 차면 길이 증가
        if (size == elements.length) {
            grow();
        }

        elements[size++] = o;
    }

    public void add(int index, Object o) {
        // 배열이 꽉 차면 길이 증가
        if (size == elements.length) {
            grow();
        }

        shiftRightFrom(index);

        elements[index] = o;

        size++;
    }

    public Object get(int index) {
        return elements[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public Object remove(int index) {
        Object old = elements[index];

        elements[index] = null;

        size--;


        shiftLeftFrom(index);

        return old;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }
}