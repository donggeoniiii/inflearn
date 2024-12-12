package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});

        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
        }

        // for-each: 내부에서 iterator() 사용, 즉 iterable한 객체만 사용 가능
        for (int value : myArray) {
            System.out.println(value);
        }
    }

}