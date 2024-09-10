package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPerformanceTest {
    public static void main(String[] args) {
        // 추가
        int size = 50_000;

        // ArrayList: 추가 시 System.arrayCopy()로 배열 고속 복사
        ArrayList<Integer> arrayList = new ArrayList<>();
        addFirst(arrayList, size); // 98ms (O(n))
        arrayList = new ArrayList<>(); // 빠른 출력을 위한 초기화
        addMid(arrayList, size); // 50ms (O(n))
        arrayList = new ArrayList<>();
        addLast(arrayList, size); // 4ms (O(1))

        // LinkedList: java의 LinkedList는 마지막 index도 저장함
        LinkedList<Integer> linkedList = new LinkedList<>();
        addFirst(linkedList, size); // 4ms (O(1))
        linkedList = new LinkedList<>();
        addMid(linkedList, size); // 827ms (O(n))
        linkedList = new LinkedList<>();
        addLast(linkedList, size); // 3ms (O(1))


        // 조회
        int loop = 10000;

        // ArrayList
        getIndex(arrayList, loop, 0); // 0ms (O(1))
        getIndex(arrayList, loop, size / 2); // 0ms (O(1))
        getIndex(arrayList, loop, size - 1); // 0ms (O(1))

        // LinkedList
        getIndex(linkedList, loop, 0); // 0ms (0(1))
        getIndex(linkedList, loop, size / 2); // 287ms (O(n))
        getIndex(linkedList, loop, size - 1); // 1ms (O(1))


        // 검색
        // ArrayList
        search(arrayList, loop, 0); // 0ms (O(1))
        search(arrayList, loop, size / 2); // 108ms (O(n))
        search(arrayList, loop, size - 1); // 203ms (O(n))

        // LinkedList
        search(linkedList, loop, 0); // 0ms (O(1))
        search(linkedList, loop, size / 2); // 328ms (O(n))
        search(linkedList, loop, size - 1); // 652ms (O(n))

        /*
            배열은 node보다 다음 참조값을 찾기가 더 쉽다(연속적으로 위치, 캐시 효율도 좋음)
            평균적으로 성능을 따지면 ArrayList를 쓰는게 더 좋음
            다만 head에서 삽입/삭제가 많이 발생하는 경우엔 LinkedList가 유리함
            (O(1), java에서 Queue 구현을 LinkedList로 하는 이유)
         */
    }

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void search(List<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}