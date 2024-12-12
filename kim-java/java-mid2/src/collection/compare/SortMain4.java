package collection.compare;

import java.util.TreeSet;

public class SortMain4 {

    public static void main(String[] args) {
        MyUser a = new MyUser("a", 30);
        MyUser b = new MyUser("b", 20);
        MyUser c = new MyUser("c", 10);

        // 트리 구조를 이용하는 자료 구조는 비교 기준이 있어야 함 -> Comparable 객체만 사용 가능
        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(a); // Comparable 하지 않으면 ClassCastException 발생
        treeSet1.add(b);
        treeSet1.add(c);
        System.out.println(treeSet1); // [c, b, a]

        // 생성 단계에서 비교 기준을 넣어줄 수도 있음
        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
        treeSet2.add(a);
        treeSet2.add(b);
        treeSet2.add(c);
        System.out.println(treeSet2); // [a, b, c]
    }

}