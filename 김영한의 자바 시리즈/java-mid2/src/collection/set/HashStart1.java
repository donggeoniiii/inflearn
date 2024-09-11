package collection.set;

import java.util.Arrays;

public class HashStart1 {

    public static void main(String[] args) {
        Integer[] inputArray = new Integer[4];
        inputArray[0] = 1;
        inputArray[1] = 2;
        inputArray[2] = 5;
        inputArray[3] = 8;
        System.out.println(Arrays.toString(inputArray)); // [0, 1, 2, 3]

        // 배열에서 검색: O(n) (별로임)
        int searchValue = 8;
        for (int inputValue : inputArray) {
            if (inputValue == searchValue) {
                System.out.println(inputValue);
            }
        }
    }
}