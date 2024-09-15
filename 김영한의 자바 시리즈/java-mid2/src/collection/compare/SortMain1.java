package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain1 {

    public static void main(String[] args) {
        // Comparator 사용을 위해 Wrapper 클래스로 사용
        Integer[] array = {3, 2, 1};

        // 오름차순(ascending) 정렬
        Arrays.sort(array, new AscComparator());
        System.out.println(Arrays.toString(array)); // [1, 2, 3]

        // 내림차순(descending) 정렬
        Arrays.sort(array, new DescComparator());
        System.out.println(Arrays.toString(array)); // [3, 2, 1]

        // Comparator.reversed() -> 원래 정렬 방식을 반대로
        Arrays.sort(array, new AscComparator().reversed());
        System.out.println(Arrays.toString(array)); // [3, 2, 1]
    }

    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2);
            return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1);
        }
    }

    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2);
            return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1) * -1;
        }
    }
}