package collection.set.member;

import collection.set.MyObjectSet;

public class HashAndEqualsMain3 {

    public static void main(String[] args) {
        // hashCode(), equals() 둘 다 오버라이드 한 경우
        MyObjectSet set = new MyObjectSet(10);
        Member m1 = new Member("A");
        Member m2 = new Member("A");
        System.out.println(m1.hashCode()); // 96
        System.out.println(m2.hashCode()); // 96
        System.out.println(m1.equals(m2)); // true (논리적 비교: id 같음)

        // 같은 거 비교가 됨 -> 중복 차단 성공!
        set.add(m1);
        set.add(m2);
        System.out.println(set); // [[], [], [], [], [], [], [A], [], [], []]

        // 검색 성공
        Member searchValue = new Member("A");
        System.out.println(searchValue.hashCode()); // 96
        System.out.println(set.contains(searchValue)); // true

        // 결론: 해시 자료구조를 사용하고 싶다? -> hashCode(), equals() 반드시 재정의하자!
    }
}