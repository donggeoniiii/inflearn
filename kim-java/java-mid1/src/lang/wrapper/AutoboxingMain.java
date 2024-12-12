package lang.wrapper;

public class AutoboxingMain {

    public static void main(String[] args) {
        // Primitive -> Wrapper => Boxing
        int value = 7;
        Integer boxedValue = Integer.valueOf(value);

        // Wrapper -> Primitive => Unboxing
        int unboxedValue = boxedValue.intValue();

        System.out.println("boxedValue = " + boxedValue); // 7
        System.out.println("unboxedValue = " + unboxedValue); // 7

        // 근데 저 두 과정이 너무 많이 일어나서 이렇게 해도 java가 똑같이 처리해준다(컴파일 단계에서 위처럼 바뀜)
        boxedValue = value; // Auto-boxing
        unboxedValue = boxedValue; // Auto-Unboxing

        System.out.println("boxedValue = " + boxedValue); // 7
        System.out.println("unboxedValue = " + unboxedValue); // 7
    }
}
