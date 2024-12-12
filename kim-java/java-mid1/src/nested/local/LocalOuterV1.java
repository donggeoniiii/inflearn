package nested.local;

public class LocalOuterV1 {

    private int outInstanceVar = 3;

    public void process(int paramVar) {

        int localVar = 1;

        // 지역 클래스: 지역 변수와 똑같음(접근제어자 사용 안됨, 위치)
        class LocalPrinter {
            int value = 0;

            public void printData() {
                System.out.println("value=" + value); // 0

                // 본인이 속한 스코프 내의 지역변수 접근 가능(매개변수도 지역변수임)
                System.out.println("localVar=" + localVar); // 1
                System.out.println("paramVar=" + paramVar); // 2

                // 접근 가능(지역 클래스도 내부 클래스)
                System.out.println("outInstanceVar=" + outInstanceVar); // 3
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.printData();
    }

    public static void main(String[] args) {
        LocalOuterV1 localOuter = new LocalOuterV1();
        localOuter.process(2);
    }
}
