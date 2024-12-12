package static2;

public class DecoData {

    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
        // 인스턴스 변수/메서드는 static 메서드 생성시 아직 없음, 참조값이 없으므로 접근 안됨
        // instanceValue++; // compile error
        // instanceMethod(); // compile error

        staticValue++; // 같은 static이라 가능
        staticMethod(); // 같은 static이라 가능
    }

    public void instanceCall() {
        instanceValue++; // 인스턴스 변수 접근(당연히 가능)
        instanceMethod(); // 인스턴스 메서드 접근(당연히 가능)

        staticValue++; // 정적 변수 접근(당연히 가능)
        staticMethod(); // 정적 메서드 접근(당연히 가능)
    }


    private void instanceMethod() {
        System.out.println("instance: " + instanceValue);
    }

    private static void staticMethod() {
        System.out.println("static: " + staticValue);
    }
}
