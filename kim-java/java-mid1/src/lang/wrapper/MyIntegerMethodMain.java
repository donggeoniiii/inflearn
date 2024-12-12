package lang.wrapper;

public class MyIntegerMethodMain {

    public static void main(String[] args) {
        int value = 10;
        int i1 = compareTo(value, 5);
        int i2 = compareTo(value, 10);
        int i3 = compareTo(value, 20);
        System.out.println("i1 = " + i1); // -1
        System.out.println("i2 = " + i2); // 0
        System.out.println("i3 = " + i3); // 1
        
        // 비교, 데이터 자체의 접근까지 본인 메서드로 제공 -> 보다 객체지향적
        MyInteger myInteger = new MyInteger(10);
        i1 = myInteger.compareTo(5);
        i2 = myInteger.compareTo(10);
        i3 = myInteger.compareTo(20);
        System.out.println("i1 = " + i1); // -1
        System.out.println("i2 = " + i2); // 0
        System.out.println("i3 = " + i3); // 1
    }

    /*
        value라는 int 변수 입장에서 자기 값을 가지고 비교하는데 외부 메서드 필요
        본인 스스로의 메서드를 제공하는게 보다 객체지향적인 설계일 것
     */
    public static int compareTo(int value, int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }
}
