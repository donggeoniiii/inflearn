package enumeration.ex3;

import static enumeration.ex3.Grade.*; // import 해서 간단하게 사용 가능

public class EnumRefMain {
    public static void main(String[] args) {
        System.out.println("class BASIC = " + BASIC.getClass());
        System.out.println("class GOLD = " + GOLD.getClass());
        System.out.println("class DIAMOND = " + DIAMOND.getClass());

        System.out.println("ref BASIC = " + refValue(BASIC));
        System.out.println("ref GOLD = " + refValue(GOLD));
        System.out.println("ref DIAMOND = " + refValue(DIAMOND));
    }

    private static String refValue(Object grade) {
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
