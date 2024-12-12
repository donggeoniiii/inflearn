package collection.list;

public class MyListPerformanceTest {
    public static void main(String[] args) {
        // 추가
        int size = 50_000;
        // ArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        addFirst(arrayList, size); // 1505ms (O(n))
        arrayList = new MyArrayList<>(); // 빠른 출력을 위한 초기화
        addMid(arrayList, size); // 762ms (O(n))
        arrayList = new MyArrayList<>();
        addLast(arrayList, size); // 2ms (O(1))
        // LinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        addFirst(linkedList, size); // 3ms(O(1))
        linkedList = new MyLinkedList<>();
        addMid(linkedList, size); // 804ms (O(n))
        linkedList = new MyLinkedList<>();
        addLast(linkedList, size); // 1438ms (O(n))

        // 조회
        int loop = 10000;
        // ArrayList
        getIndex(arrayList, loop, 0); // 0ms (O(1))
        getIndex(arrayList, loop, size / 2); // 0ms (O(1))
        getIndex(arrayList, loop, size - 1); // 1ms (O(1))
        // LinkedList
        getIndex(linkedList, loop, 0); // 0ms (0(1))
        getIndex(linkedList, loop, size / 2); // 287ms (O(n))
        getIndex(linkedList, loop, size - 1); // 577ms (O(n))

        // 검색
        // ArrayList
        search(arrayList, loop, 0); // 1ms (O(1))
        search(arrayList, loop, size / 2); // 102ms (O(n))
        search(arrayList, loop, size - 1); // 206ms (O(n))
        // LinkedList
        search(linkedList, loop, 0); // 1ms (O(1))
        search(linkedList, loop, size / 2); // 336ms (O(n))
        search(linkedList, loop, size - 1); // 654ms (O(n))
    }

    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void search(MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}