package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {

    private int outInstanceVar = 3;

    public Printer process(int paramVar) {
        // 지역 변수: 해당 스택 프레임이 종료되는 순간 함께 제거
        int localVar = 1;

        class LocalPrinter implements Printer {
            int value = 0;

            @Override
            public void print() {
                System.out.println("value=" + value); // 0

                System.out.println("localVar=" + localVar); // 1
                System.out.println("paramVar=" + paramVar); // 2
                System.out.println("outInstanceVar=" + outInstanceVar); // 3
            }
        }

        // 인스턴스: 참조되지 않을 때까지 생존. 지역 변수보다 더 오래 살아남음
        LocalPrinter printer = new LocalPrinter();

        // printer.print()를 여기서 실행하지 않고 인스턴스만 반환
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuter = new LocalOuterV3();
        Printer printer = localOuter.process(2);
        // process()의 스택 프레임이 사라진 이후 실행됨, 즉 지역변수 자체는 없는게 정상
        // localVar, paramVar는...? -> 인스턴스가 생성된 시점에 필요한 지역 변수를 복사해서 같이 들고 있는다.
        printer.print(); // 전부 정상 실행

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field); // LocalPrinter.paramVar, LocalPrinter.localVar 존재
            // 바깥 클래스를 참조하기 위한 변수도 같이 확인 가능
        }
    }
}
