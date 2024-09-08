package collection.array;

import java.util.Arrays;

// 타입 안전성을 보장하기 위해 제네릭 타입으로 선언
public class MyArrayListV4<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size = 0; // 현재 사이즈

    // Q. 배열은 왜 그대로 Object 배열인가요?
    // A. 타입 이레이저 기능 때문에 배열 초기화시 타입 매개변수 사용이 안됩니다.
    public MyArrayListV4() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(E o) {
        // 배열이 꽉 차면 길이 증가
        if (size == elements.length) {
            grow();
        }

        elements[size++] = o;
    }

    public void add(int index, E o) {
        // 배열이 꽉 차면 길이 증가
        if (size == elements.length) {
            grow();
        }

        shiftRightFrom(index);

        elements[index] = o;

        size++;
    }

    @SuppressWarnings("unchecked") // 어차피 한 타입만 받으니까 무조건 E로 다운 캐스팅해도 됨
	public E get(int index) {
        return (E) elements[index];
    }

    public int indexOf(E o) {
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