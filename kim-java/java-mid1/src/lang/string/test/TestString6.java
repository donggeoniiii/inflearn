package lang.string.test;

public class TestString6 {

    public static void main(String[] args) {
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";

        int count = 0;
        int idx = str.indexOf(key); // 못찾으면 끝
        // 찾아지면 다음으로
        while (idx >= 0) {
            count++; // 일단 하나 찾은거
            idx = str.indexOf(key, idx+1); // 다음으로 이동
        }

        System.out.println("count = " + count);
    }
}
