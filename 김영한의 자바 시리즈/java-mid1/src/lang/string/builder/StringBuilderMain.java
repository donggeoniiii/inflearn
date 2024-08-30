package lang.string.builder;

public class StringBuilderMain {
    public static void main(String[] args) {
        // 가변 스트링: 객체가 계속 생성되지 않음, 성능 UP
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb); // ABCD

        sb.insert(4, "Java");
        System.out.println("insert = " + sb); // ABCDJava

        sb.delete(4, 8);
        System.out.println("delete = " + sb); // ABCD

        sb.reverse();
        System.out.println("reverse = " + sb); // DCBA

        //StringBuilder -> String
        String str1 = sb.toString();
        System.out.println("string = " + str1); // DCBA


        // 이렇게 체이닝해서 사용도 가능(메서드들이 자기 자신을 반환함)
        String str2 = sb.append("A").append("B").append("C").append("D")
            .insert(4, "Java")
            .delete(4, 8)
            .reverse()
            .toString();

        System.out.println("string = " + str2); // DCBAABCD
    }
}
