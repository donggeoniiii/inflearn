package collection.set.member;

import collection.set.MyObjectSet;

public class HashAndEqualsMain2 {

    public static void main(String[] args) {
        // hashCode()는 재정의했지만 equals()는 안한 경우
        MyObjectSet set = new MyObjectSet(10);
        MemberOnlyHash m1 = new MemberOnlyHash("A");
        MemberOnlyHash m2 = new MemberOnlyHash("A");
        System.out.println(m1.hashCode()); // 96
        System.out.println(m2.hashCode()); // 96
        System.out.println(m1.equals(m2)); // false: 인스턴스 기준으로 체크

        // 두 값이 같은 줄 모름 -> 중복 등록이 허용됨!
        // 해시값은 같으니까 심지어 같은 바구니에 중복됨
        set.add(m1);
        set.add(m2);
        System.out.println(set); // [[], [], [], [], [], [], [A, A], [], [], []]

        // 비교할 줄을 모르니까 검색도 실패
        MemberOnlyHash searchValue = new MemberOnlyHash("A");
        System.out.println(searchValue.hashCode()); // 96
        System.out.println(set.contains(searchValue)); // false
    }
}