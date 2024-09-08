package collection.array;

public class MyArrayListV1Main {
    public static void main(String[] args) {
        MyArrayListV1 list = new MyArrayListV1();

        // 데이터 추가
        System.out.println(list); // []
        list.add("a");
        System.out.println(list); // [a]
        list.add("b");
        System.out.println(list); // [a, b]
        list.add("c");
        System.out.println(list); // [a, b, c]

        // 기능 사용
        System.out.println(list.size()); // 3
        System.out.println(list.get(1)); // b
        System.out.println(list.indexOf("c")); // 2
        System.out.println(list.set(2, "z")); // c
        System.out.println(list); // [a, b, z]


        // 범위 초과, 사이즈가 늘어나지 않으면 예외 발생
        list.add("d");
        System.out.println(list); // [a, b, z, d]
        list.add("e");
        System.out.println(list); // [a, b, z, d, e]
        /*
        list.add("f");
        System.out.println(list); // ArrayIndexOutOfBoundsException
        */
    }
}