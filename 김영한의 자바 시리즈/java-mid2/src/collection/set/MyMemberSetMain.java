package collection.set;

import collection.set.member.Member;

public class MyMemberSetMain {

    public static void main(String[] args) {
        MyObjectSet set = new MyObjectSet(10);
        
        // 객체를 넣어도 정상 작동할까?
        Member hi = new Member("hi");
        Member jpa = new Member("JPA");
        Member java = new Member("java");
        Member spring = new Member("spring");
        
        System.out.println(hi.hashCode()); // 3360
        System.out.println(jpa.hashCode()); // 73690
        System.out.println(java.hashCode()); // 3254849
        System.out.println(spring.hashCode()); // -895679956

        // 추가
        set.add(hi);
        set.add(jpa);
        set.add(java);
        set.add(spring);
        System.out.println(set); // [[hi, JPA], [], [], [], [], [], [spring], [], [], [java]]

        // 검색
        // 해시코드 생성시 id를 참조하기로 했으므로 같은 id의 다른 인스턴스를 넣어도 비교 가능
        System.out.println(set.contains(new Member("JPA"))); // true
    }
}