package final1;

public class ConstantMain1 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 1000);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    // 리터럴 그대로 사용: 기준치가 바뀌면 해당 리터럴이 사용되는 모든 필드에 가서 수정해야 함
    // 거기에 유지보수에도 문제가 있음(리터럴만 보고서는 얘가 가진 의미를 모름)
    private static void process(int currentUserCount) {
        System.out.println("참여자 수:" + currentUserCount);
        if (currentUserCount > 1000) {
            System.out.println("대기자로 등록합니다.");
        } else {
            System.out.println("게임에 참여합니다.");
        }
    }
}
