package lang.wrapper;

public class WrapperVsPrimitive {
    public static void main(String[] args) {
        int iterations = 1_000_000_000; // 10억
        long startTime, endTime;

        // 기본형 사용 시 반복 시간
        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Primitive: " + (endTime - startTime) + "ms"); // 2ms

        // 래퍼 클래스 사용 시 반복 시간
        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; // 오토 박싱 발생 -> 시간 더 잡아먹음
        }
        endTime = System.currentTimeMillis();
        System.out.println("Wrapper: " + (endTime - startTime) + "ms"); // 3447ms

        /*
            래퍼 클래스가 메모리도 더먹음(클래스 메타데이터 등을 위한 공간)
            그렇지만 엄청난 차이가 아니기 때문에(저건 10억 번 돌렸을 때 얘기) 
            어떤 방법이든 일단 코드를 보기 좋은(유지보수 이점) 방향으로 만들고
            후에 최적화를 고민하는 편이 낫다
         */
    }
}
