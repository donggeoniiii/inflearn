package ref;

public class VarChange2 {
    public static void main(String[] args) {
        // 대원칙: Java의 변수는 값을 복사한다
        // 참조형 변수는 변수에 저장된 참조값을 가져온다
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB); // A와 동일
        System.out.println("dataA.value = " + dataA.value); // 10
        System.out.println("dataB.value = " + dataB.value); // 10

        // dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value); // 20
        System.out.println("dataB.value = " + dataB.value); // 20 (참조값이 같으므로)

        // dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value); // 30 (참조값이 같으므로)
        System.out.println("dataB.value = " + dataB.value); // 30
    }
}
