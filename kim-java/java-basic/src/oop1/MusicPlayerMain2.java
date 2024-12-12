package oop1;

// 클래스로 데이터 묶기
public class MusicPlayerMain2 {
    public static void main(String[] args) {
        /*
        1. 음악 플레이어 전원 켜고 끌 수 있어야 함
        2. 볼륨을 조절할 수 있어야 함
        3. 상태 확인(전원, 볼륨)이 가능해야 함
         */

        // 음악 플레이어 기능에 필요한 변수가 모은 클래스 사용, 관리가 쉬워짐
        MusicPlayerData data = new MusicPlayerData();

        // 음악 플레이어 켜기
        System.out.println("음악 플레이어를 시작합니다.");
        data.isOn = true;

        // 볼륨 증가, 감소
        data.volume++;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
        data.volume++;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
        data.volume--;
        System.out.println("음악 플레이어 볼륨: " + data.volume);

        // 음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨: " + data.volume);
        }
        else {
            System.out.println("음악 플레이어 OFF, 볼륨: " + data.volume);
        }

        // 음악 플레이어 끄기
        System.out.println("음악 플레이어를 종료합니다.");
        data.isOn = false;
        data.volume = 0;
    }
}
