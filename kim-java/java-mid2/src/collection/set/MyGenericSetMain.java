package collection.set;

public class MyGenericSetMain {

    public static void main(String[] args) {
        // 제네릭 타입: 타입 안전성 보장
        MyGenericSet<String> set = new MyGenericSet<>(10);
        
        // 추가
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set); // [[], [], [], [], [], [A], [B], [C], [], []]

        // 검색
        System.out.println(set.contains("A")); // true
    }
}