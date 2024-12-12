package collection.set;

public class MyStringSetMain {

    public static void main(String[] args) {
        MyObjectSet set = new MyObjectSet(10);
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("AB");
        set.add("SET"); // AB와 index 동일, 해시 충돌
        System.out.println(set); // [[], [AB], [], [], [], [A], [B, SET], [C], [D], []]

        System.out.println("A".hashCode()); // 65
        System.out.println("B".hashCode()); // 66
        System.out.println("AB".hashCode()); // 2081
        System.out.println("SET".hashCode()); // 81986

        // 검색
        System.out.println(set.contains("SET")); // true
    }
}