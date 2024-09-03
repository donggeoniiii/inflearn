package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {

    private int outInstanceVar = 3;

    public void process(int paramVar) {

        int localVar = 1;

        // 익명클래스: 선언부와 생성부가 함께 있음
        // 상속받는 부모 클래스나 인터페이스가 있는 경우에 사용
        Printer printer = new Printer() {
            int value = 0;

            @Override
            public void print() {
                System.out.println("value=" + value); // 0
                System.out.println("localVar=" + localVar); // 1
                System.out.println("paramVar=" + paramVar); // 2
                System.out.println("outInstanceVar=" + outInstanceVar); // 3
            }
        };

        printer.print();
        System.out.println("printer.class = " + printer.getClass()); // AnonymousOuter$1(이름이 없어서, 숫자는 익명클래스의 개수)
    }

    public static void main(String[] args) {
        AnonymousOuter main = new AnonymousOuter();
        main.process(2);
    }
}
