package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    private Object[] elements;
    private int size = 0; // 현재 사이즈

    public MyArrayListV2(int capacity) {
        elements = new Object[capacity];
    }

    // 추가
    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
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

    public Object get(int index) {
        return elements[index];
    }

    public Object set(int index, Object o) {
        Object old = get(index);

        elements[index] = o;

        return old;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size))+ ", capacity=" + elements.length;
    }
}