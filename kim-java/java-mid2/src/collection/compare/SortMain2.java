package collection.compare;

import java.util.Arrays;

public class SortMain2 {

    public static void main(String[] args) {
        MyUser a = new MyUser("a", 30);
        MyUser b = new MyUser("b", 20);
        MyUser c = new MyUser("c", 10);

        MyUser[] array = {a, b, c};
        System.out.println(Arrays.toString(array)); // [a, b, c]

        // Arrays.sort(): Comparable 객체의 natural order
        Arrays.sort(array); 
        System.out.println(Arrays.toString(array)); // [c, b, a]

        // 인자로 정렬 기준(Comparator)을 넘겨줄 수도 있음
        Arrays.sort(array, new IdComparator());
        System.out.println(Arrays.toString(array)); // [a, b, c]

        Arrays.sort(array, new IdComparator().reversed());
        System.out.println(Arrays.toString(array)); // [c, b, a]
    }

}