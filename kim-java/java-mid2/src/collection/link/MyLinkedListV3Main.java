package collection.link;

public class MyLinkedListV3Main {
    public static void main(String[] args) {
        MyLinkedListV3<String> stringList = new MyLinkedListV3<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        String string = stringList.get(0);
        System.out.println(string); // a

        MyLinkedListV3<Integer> intList = new MyLinkedListV3<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println(integer); // 1
        
        // 기능 테스트
        MyLinkedListV3<String> list = new MyLinkedListV3<>();

        // 마지막에 추가
        list.add("a"); // O(n)
        list.add("b"); // O(n)
        list.add("c"); // O(n)
        System.out.println(list); // [a, b, c], size = 3

        // 첫 번째 항목 추가, 삭제
        list.add(0,"d"); // O(1)
        System.out.println(list); // [d, a, b, c], size = 4

        list.remove(0); // O(1)(첫 노드의 참조값은 갖고 있음)
        System.out.println(list); // [a, b, c], size = 3

        // 중간 항목 추가, 삭제
        list.add(1, "e"); // O(1)
        System.out.println(list); // [a, e, b, c], size = 4

        list.remove(1); // 특정 노드를 바꾸는 건 O(n)(참조값 찾아가야 함)
        System.out.println(list); // [a, b, c], size = 3
    }

}