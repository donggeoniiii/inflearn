package final1;

public class ConstantMain2 {
	public static void main(String[] args) {
		System.out.println("프로그램 최대 참여자 수 " + Constant.MAX_USERS);
		int currentUserCount = 999;
		process(currentUserCount++);
		process(currentUserCount++);
		process(currentUserCount++);
	}

	// 상수 사용: 상수값 하나만 바꾸면 해당 상수가 사용될 모든 코드가 수정됨
	private static void process(int currentUserCount) {
		System.out.println("참여자 수:" + currentUserCount);
		if (currentUserCount > Constant.MAX_USERS) {
			System.out.println("대기자로 등록합니다.");
		} else {
			System.out.println("게임에 참여합니다.");
		}
	}
}
