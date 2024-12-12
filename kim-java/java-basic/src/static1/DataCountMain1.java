package static1;

public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("A count = " + data1.count); // 1

        Data1 data2 = new Data1("B");
        System.out.println("B count = " + data2.count); // 1

        Data1 data3 = new Data1("C");
        System.out.println("C count = " + data3.count); // 1

        // 인스턴스 내에서 카운터를 각자 사용하므로 서로가 영향x
    }
}
