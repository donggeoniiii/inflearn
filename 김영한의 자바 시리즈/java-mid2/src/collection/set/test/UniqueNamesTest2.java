package collection.set.test;

import java.util.LinkedHashSet;

public class UniqueNamesTest2 {

    public static void main(String[] args) {
        int[] inputArr = {30, 20, 20, 10, 10};
        // 입력순서 유지를 위해 LinkedHashSet 사용
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : inputArr) {
            set.add(num);
        }
        System.out.println(set); // [30, 20, 10]
    }
}
