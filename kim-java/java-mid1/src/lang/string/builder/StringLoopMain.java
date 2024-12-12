package lang.string.builder;

public class StringLoopMain {
    public static void main(String[] args) {
        System.out.println("======= String =======");
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
        }
        long endTime = System.currentTimeMillis();

        System.out.println("time = " + (endTime - startTime) + "ms"); // 8~9초

        System.out.println("======= StringBuilder =======");
        startTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello Java ");
        }
        endTime = System.currentTimeMillis();

        result = sb.toString();
        System.out.println("time = " + (endTime - startTime) + "ms"); // 거의 즉시
    }
}
