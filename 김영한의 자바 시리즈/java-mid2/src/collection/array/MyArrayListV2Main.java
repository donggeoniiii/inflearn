package collection.array;

public class MyArrayListV2Main {

    public static void main(String[] args) {
        MyArrayListV2 list = new MyArrayListV2(2);
        System.out.println(list); // []

        list.add("a");
        System.out.println(list); // [a], capacity = 2
        list.add("b");
        System.out.println(list); // [a, b], capacity = 2
        list.add("c");
        System.out.println(list); // [a, b, c], capacity = 4
        list.add("d");
        System.out.println(list); // [a, b, c, d], capacity = 4
        list.add("e");
        System.out.println(list); // [a, b, c, d, e], capacity = 8
        list.add("f");
        System.out.println(list); // [a, b, c, d, e, f], capacity = 8
    }
}