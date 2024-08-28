package oop1;

// 절차지향 프로그래밍
public class MusicPlayerMain1 {
    public static void main(String[] args) {
        /*
        1. 음악 플레이어 전원 켜고 끌 수 있어야 함
        2. 볼륨을 조절할 수 있어야 함
        3. 상태 확인(전원, 볼륨)이 가능해야 함
         */

        // 음악 플레이어 기능에 필요한 변수: 전원, 볼륨
        int volume;
        boolean isOn;

        // 음악 플레이어 켜기
        System.out.println("음악 플레이어를 시작합니다.");
        isOn = true;
        volume = 0;

        // 볼륨 증가, 감소
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
        volume--;
        System.out.println("음악 플레이어 볼륨: " + volume);

        // 음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨: " + volume);
        }
        else {
            System.out.println("음악 플레이어 OFF, 볼륨: " + volume);
        }

        // 음악 플레이어 끄기
        System.out.println("음악 플레이어를 종료합니다.");
        isOn = false;
        volume = 0;
    }
}
