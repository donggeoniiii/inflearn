package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5;
    
    private Object[] elements;
    private int size = 0; // 현재 사이즈

    public MyArrayListV1() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(Object o) {
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
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}
