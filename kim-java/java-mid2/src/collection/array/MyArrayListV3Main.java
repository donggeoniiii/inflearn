package collection.array;

public class MyArrayListV3Main {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();
        // 마지막에 추가
        list.add("a"); // O(1)
        list.add("b"); // O(1)
        list.add("c"); // O(1)
        System.out.println(list); // [a, b ,c]

        // 원하는 위치에 추가
        list.add(3, "addLast"); // O(1), size-1로 index 접근해 바로 입력
        System.out.println(list); // [a, b, c, addLast]

        list.add(0, "addFirst"); // O(n), 뒤에 있는 애들 다 밀어야 됨
        System.out.println(list); // [addFirst, a, b, c, addLast]

        // 삭제
        Object removed1 = list.remove(4); // O(1), size-1로 index 접근해 바로 삭제
        System.out.println(removed1); // addLast
        System.out.println(list); // [addFirst, a, b, c]

        Object removed2 = list.remove(0); // O(n), 뒤에 있는 애들 다 밀어야 됨
        System.out.println(removed2); // addFirst
        System.out.println(list); // [a, b, c]
    }
}