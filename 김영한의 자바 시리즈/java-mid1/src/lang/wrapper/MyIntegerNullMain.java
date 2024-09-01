package lang.wrapper;

public class MyIntegerNullMain {

    public static void main(String[] args) {
        int[] intArr = {-1, 0, 1, 2, 3};
        System.out.println(findValue(intArr, -1)); // -1 -> 찾았다는 의미
        System.out.println(findValue(intArr, 0)); // 0
        System.out.println(findValue(intArr, 1)); // 1
        System.out.println(findValue(intArr, 100)); // -1 -> 못찾았다는 의미

        // wrapper 클래스 사용
        MyInteger[] newintArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};
        System.out.println(findValue(newintArr, -1)); // -1
        System.out.println(findValue(newintArr, 0)); // 0
        System.out.println(findValue(newintArr, 1)); // 1
        System.out.println(findValue(newintArr, 100)); // null
    }

    private static int findValue(int[] intArr, int target) {
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }
        return -1; // 찾으려는 value == -1이면?
    }

    // 없다의 의미로 null 반환
    private static MyInteger findValue(MyInteger[] intArr, int target) {
        for (MyInteger myInteger : intArr) {
            if (myInteger.getValue() == target) {
                return myInteger;
            }
        }
        return null;
    }
}
