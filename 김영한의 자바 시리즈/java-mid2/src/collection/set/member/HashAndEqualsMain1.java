package collection.set.member;

import collection.set.MyObjectSet;

public class HashAndEqualsMain1 {

    public static void main(String[] args) {
        // hashCode(), equals() 둘 다 오버라이드 안한 경우
        MyObjectSet set = new MyObjectSet(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");
        System.out.println(m1.hashCode()); // 1922154895
        System.out.println(m2.hashCode()); // 883049899
        System.out.println(m1.equals(m2)); // false: 인스턴스 기준으로 체크

        // 두 값이 같은 줄 모름 -> 중복 등록이 허용됨!
        set.add(m1);
        set.add(m2);
        System.out.println(set); // [[], [], [], [], [], [A], [], [], [], [A]]

        // 비교할 줄 모르니까 검색도 실패
        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
        System.out.println(searchValue.hashCode()); // 317574433
        System.out.println(set.contains(searchValue)); // false
    }
}