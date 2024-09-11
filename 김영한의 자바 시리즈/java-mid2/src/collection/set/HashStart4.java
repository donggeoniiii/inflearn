package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart4 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 충돌 방지를 위해 index 별로 해당하는 숫자 list 생성
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); 
        System.out.println(Arrays.toString(buckets)); // [[], [1], [2], [], [14], [5], [], [], [8], [99, 9]]

        // index를 이용한 검색: O(1)
        int searchValue = 9;
        System.out.println(contains(buckets, searchValue)); // true


        /* 만약 한 index에만 값이 몰린다면...? 어쩔 수 없이 O(n)의 성능
         그러나 이전에 비하면 이런 경우는 정말 드문 일이라고 할 수 있음
         capacity를 적절히 조절하면 충돌과 메모리 낭비를 어느 정도 커버할 수 있음
         통계적으로 입력한 데이터 수 = 배열 크기의 75%가 적절함
        */
    }

    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        // 해당 index의 list 가져오기
        LinkedList<Integer> bucket = buckets[hashIndex];

        // 부분적으로 list를 사용하지만 전체 자료구조는 set이므로 중복 방지는 필요함
        if (!bucket.contains(value)) { // O(n)
            bucket.add(value); 
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);

        // 전체 검색 -> 같은 index list 내 검색
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        return bucket.contains(searchValue); // O(n)
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}