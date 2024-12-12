package collection.iterable;

import java.util.Iterator;

// Iterable: 반복자(Iterator)를 가지고 반복 가능한(Iterable) 객체
public class MyArray implements Iterable<Integer> {

    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }

}