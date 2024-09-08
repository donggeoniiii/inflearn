package collection.array;

import java.util.Arrays;

/**
 * 배열의 특징
 */
public class ArrayMain2 {

    // 배열의 첫번째 위치에 추가 - O(n)
    private static void addFirst(int[] arr, int newValue) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
    }

    // 배열의 마지막 위치에 추가 - O(1)
    private static void addLast(int[] arr, int newValue) {
        arr[arr.length - 1] = newValue;
    }

    // 배열의 index 위치에 추가 - O(n)
    private static void addAtIndex(int[] arr, int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

        int newValue = 3;
        addFirst(arr, newValue);
        System.out.println(Arrays.toString(arr));

        int index = 2;
        int value = 4;
        addAtIndex(arr, index, value);
        System.out.println(Arrays.toString(arr));

        newValue = 5;
        addLast(arr, newValue);
        System.out.println(Arrays.toString(arr));

        // 문제1: 배열의 크기 이상으로 데이터가 들어가게 되면?
        // 문제2: 항상 우리가 배열의 값을 수동으로 미는 코드를 넣어야 하나?
    }
}