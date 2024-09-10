package collection.list;

import java.util.Arrays;

// 컴파일 타임 의존 관계: 자바 컴파일러가 보는 의존관계, 소스 코드에서 정적으로 확인 가능
// 자식은 부모에 의존한다(코드 상에 extends, implements 키워드로 드러남)
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size = 0; // 현재 사이즈

    // Q. 배열은 왜 그대로 Object 배열인가요?
    // A. 타입 이레이저 기능 때문에 배열 초기화시 타입 매개변수 사용이 안됩니다.
    public MyArrayList() {
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

    @Override
    public E set(int index, E element) {
        E old = get(index);

        elements[index] = element;

        return old;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
	public E remove(int index) {
        Object old = elements[index];

        elements[index] = null;

        size--;


        shiftLeftFrom(index);

        return (E) old;
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