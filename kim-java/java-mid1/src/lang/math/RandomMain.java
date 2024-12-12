package lang.math;

import java.util.Random; // 사실 얘는 lang 패키지 소속은 아님

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random(); // 시드값과 System.nanoTime() 결과를 이용
        // Random random = new Random(1); // 시드 넘버(int)가 정해져 있으면 실행시마다 결과가 같음

        int randomInt = random.nextInt();
        System.out.println("randomInt: " + randomInt); // 전체 범위에서 랜덤 int 반환

        double randomDouble = random.nextDouble(); 
        System.out.println("randomDouble: " + randomDouble); // 0.0d ~ 1.0d

        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean: " + randomBoolean); // true / false 둘 중 하나

        // 범위 조회
        int randomRange1 = random.nextInt(10);
        System.out.println("0 ~ 9: " + randomRange1); // [0 ~ 9) 중에서 출력

        int randomRange2 = random.nextInt(10) + 1;
        System.out.println("1 ~ 10: " + randomRange2); // [1 ~ 10) + 1 중에서 출력
    }
}
