package collection.link;

public class MyLinkedListV1Main {

    public static void main(String[] args) {
        MyLinkedListV1 list = new MyLinkedListV1();
        System.out.println(list); // [], size = 0
        list.add("a");
        System.out.println(list); // [a], size = 1
        list.add("b");
        System.out.println(list); // [a, b], size = 2
        list.add("c");
        System.out.println(list); // [a, b, c], size = 3

        System.out.println(list.size()); // 3
        System.out.println(list.get(1)); // b
        System.out.println(list.indexOf("c")); // 2
        System.out.println(list.set(2, "z")); // c
        System.out.println(list); // [a, b, z], size = 3

        list.add("d");
        System.out.println(list); // [a, b, z, d], size = 4
        list.add("e");
        System.out.println(list); // [a, b, z, d, e], size = 5
        list.add("f");
        System.out.println(list); // [a, b, z, d, e, f], size = 6
    }
}