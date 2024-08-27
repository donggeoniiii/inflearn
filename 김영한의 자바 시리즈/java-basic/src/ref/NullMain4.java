package ref;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data(); // 이제 참조값 생김
        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // 참조값

        System.out.println("bigData.data.value = " + bigData.data.value); // 0
    }
}
