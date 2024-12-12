package collection.set;

import java.util.Arrays;

public class HashStart3 {

    static final int CAPACITY = 10;

    // 나머지 연산으로 index 압축
    static int hashIndex(int value) {
        return value % CAPACITY;
    }

    public static void main(String[] args) {
        System.out.println(hashIndex(1)); // 1
        System.out.println(hashIndex(2)); // 2
        System.out.println(hashIndex(5)); // 5
        System.out.println(hashIndex(8)); // 8
        System.out.println(hashIndex(14)); // 14 % 10 = 4
        System.out.println(hashIndex(99)); // 99 % 10 = 9

        Integer[] containArray = new Integer[CAPACITY];
        add(containArray, 1);
        add(containArray, 2);
        add(containArray, 5);
        add(containArray, 8);
        add(containArray, 14);
        add(containArray, 99);
        System.out.println(Arrays.toString(containArray)); // [1, 2, 5, 8, 14, 99]

        // index를 이용한 검색: O(1)
        int searchValue = 14;
        int hashIndex = hashIndex(searchValue);
        System.out.println(hashIndex); // 4
        Integer result = containArray[hashIndex];
        System.out.println(result); // 14

        // 근데 index가 중복되는 값이 들어오면...?
        add(containArray, 4);
        result = containArray[hashIndex];
        System.out.println(result); // 14 -> 4
    }

    private static void add(Integer[] inputArray, int value) {
        int hashIndex = hashIndex(value);
        inputArray[hashIndex] = value;
    }
}