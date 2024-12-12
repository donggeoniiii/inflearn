package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // null

        // bigData.data가 null이므로 그 아래 멤버변수는 접근이 불가능함
        System.out.println("bigData.data.value = " + bigData.data.value); // NullPointerException
    }
}
