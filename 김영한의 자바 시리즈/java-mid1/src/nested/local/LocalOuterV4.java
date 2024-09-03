package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {

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

        /*
            만약 값을 변경한다면? -> compile error: effectively final(사실상 final 간주)
            캡쳐한 값과 스택 프레임에 올라와 있는 값 사이 동기화 문제가 발생하기 때문에 안됨
            연결되는 side effect 문제를 근본적으로 차단하는 것
            그냥 변경하면 안된다고 이해하고 넘어가자
         */
        // localVar = 10;
        // paramVar = 20;

        // printer.print()를 여기서 실행하지 않고 인스턴스만 반환
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        Printer printer = localOuter.process(2);
        // process()의 스택 프레임이 사라진 이후 실행됨, 즉 지역변수 자체는 없는게 정상
        // localVar, paramVar는...? -> 인스턴스가 생성될 때 필요한 지역 변수를 복사해서 같이 들고 있는다.
        printer.print(); // 전부 정상 실행

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 출력해보면 value를 제외한 나머지 변수는 앞에 final이 붙어있음
            System.out.println("field = " + field);
        }
    }
}
