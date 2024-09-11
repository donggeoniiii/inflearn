package collection.set;

import java.util.Arrays;

public class HashStart2 {

    public static void main(String[] args) {
        // 입력: 1, 2, 5, 8
        Integer[] containArray = new Integer[10];
        containArray[1] = 1;
        containArray[2] = 2;
        containArray[5] = 5;
        containArray[8] = 8;
        System.out.println(Arrays.toString(containArray)); // [null, 1, 2, null, null, 5, null, null, 8, null]

        // index를 이용한 검색: O(1)
        int searchValue = 8;
        Integer result = containArray[searchValue]; 
        System.out.println(result);

        // 근데 range가 더 넓어지면...?
        Integer[] bigContainArray = new Integer[100];
        bigContainArray[1] = 1;
        bigContainArray[2] = 2;
        bigContainArray[5] = 5;
        bigContainArray[8] = 8;
        bigContainArray[14] = 14;
        bigContainArray[99] = 99;
        System.out.println(Arrays.toString(bigContainArray)); // [null, 1, 2, null, null, 5, null, null, 8, .., 14 ....., 99]

        // index를 이용한 검색: O(1)
        searchValue = 99;
        result = bigContainArray[searchValue];
        System.out.println(result);
        
        // 메모리 낭비가 너무 심함!!
    }
}