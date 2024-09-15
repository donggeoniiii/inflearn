package collection.iterable;

import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {
    private int[] targetArray;
    private int currentIndex = -1;

    public MyArrayIterator(int[] targetArray) {
        this.targetArray = targetArray;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < targetArray.length - 1;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) return null;

        return targetArray[++currentIndex];
    }
}