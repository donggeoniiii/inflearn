package static2;

import static static2.DecoData.staticCall;

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall(); // static: 1

        System.out.println("2. 인스턴스 호출 1");
        DecoData data1 = new DecoData();
        data1.instanceCall(); // instance: 1, static: 2

        System.out.println("3. 인스턴스 호출 2");
        DecoData data2 = new DecoData();
        data2.instanceCall(); // instance: 1, static: 3

        // static 컨텍스트는 클래스를 통한 접근 추천
        DecoData.staticCall(); // static: 4

        // static 컨텍스트는 import 문을 통해 클래스명 생략도 가능
        staticCall(); // static: 5
    }
}
