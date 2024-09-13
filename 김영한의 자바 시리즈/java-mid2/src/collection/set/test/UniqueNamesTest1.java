package collection.set.test;

import java.util.HashSet;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        int[] inputArr = {30, 20, 20, 10, 10};
        HashSet<Integer> set = new HashSet<>();
        for (int i : inputArr) {
            set.add(i);
        }

        System.out.println(set); // [20, 10, 30]
    }
}
