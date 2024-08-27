package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value); // 10
        System.out.println("dataA=" + dataA);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value); // 20
    }

    static void changeReference(Data dataX) {
        System.out.println("dataX=" + dataX); // dataA의 참조값과 동일
        dataX.value = 20; // dataA가 가리키는 주소에 있는 값을 변경했음 -> 변경됨
    }
}
