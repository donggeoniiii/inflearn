package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        // Object의 기본 hashCode는 객체의 참조값을 기반으로 생성
        // 인스턴스가 다르면 해시코드도 다르다
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.hashCode()); // 189568618
        System.out.println(obj2.hashCode()); // 793589513

        // 각 클래스마다 hashCode()가 오버라이딩 되어 있음
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";
        System.out.println(i.hashCode()); // 10 = 10
        System.out.println(strA.hashCode()); // A = 65
        System.out.println(strAB.hashCode()); // AB = 2081

        // 해시코드로 마이너스 값이 들어올 수 있음
        System.out.println(Integer.valueOf(-1).hashCode()); // -1 = -1

        // hashCode()를 오버라이드하면 equals()를 통한 비교도 가능해짐
        // 현재 hashCode()를 오버라이드해서 id값을 참조하게 함
        // 참고: ==(물리적 비교, 자바 머신 기준) / equals()(논리적 비교, 해시코드 기준)
        Member member1 = new Member("idA");
        Member member2 = new Member("idA");
        System.out.println((member1 == member2)); // false(서로 다른 두 인스턴스)
        System.out.println(member1.equals(member2)); // true(id가 같으므로 논리적으로 같음)
        System.out.println(member1.hashCode()); // 104101
        System.out.println(member2.hashCode()); // 104101
    }
}