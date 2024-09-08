package collection.array;

import java.util.Arrays;

public class ArrayMain1 {
    public static void main(String[] args) {
        // 배열: 자료 크기가 고정이므로 index랑 참조값만 알면 자료 접근이 쉬움
        int[] arr = new int[5];
        // index 입력: O(1)
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 0, 0]

        // index 변경: O(1)
        arr[2] = 10;
        System.out.println(Arrays.toString(arr)); // [1, 2, 10, 0, 0]

        // index 조회: O(1)
        System.out.println(arr[2]); // 10

        // 검색: O(n)
        System.out.println(Arrays.toString(arr)); // [1, 2, 10, 0, 0]
        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]:" + arr[i]);
            if (arr[i] == value) {
                System.out.println(value + " 찾음");
                break;
            }
        }
    }
}