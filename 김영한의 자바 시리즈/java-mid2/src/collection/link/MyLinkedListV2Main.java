package collection.link;

public class MyLinkedListV2Main {

    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();
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