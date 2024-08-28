package oop1;

// 메서드 추출하기
public class MusicPlayerMain3 {
    public static void main(String[] args) {
        /*
        1. 음악 플레이어 전원 켜고 끌 수 있어야 함
        2. 볼륨을 조절할 수 있어야 함
        3. 상태 확인(전원, 볼륨)이 가능해야 함
         */

        // 음악 플레이어 기능에 필요한 변수가 모은 클래스 사용, 관리가 쉬워짐
        MusicPlayerData data = new MusicPlayerData();

        // 음악 플레이어 켜기
        startMusicPlayer(data);

        // 볼륨 증가, 감소
        volumeUp(data);
        volumeUp(data);
        volumeDown(data);

        // 음악 플레이어 상태
        checkMusicPlayer(data);

        // 음악 플레이어 끄기
        endMusicPlayer(data);
    }

    private static void startMusicPlayer(MusicPlayerData data) {
        System.out.println("음악 플레이어를 시작합니다.");
        data.isOn = true;
    }

    private static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
    }

    private static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
    }

    private static void checkMusicPlayer(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨: " + data.volume);
        }
        else {
            System.out.println("음악 플레이어 OFF, 볼륨: " + data.volume);
        }
    }

    private static void endMusicPlayer(MusicPlayerData data) {
        System.out.println("음악 플레이어를 종료합니다.");
        data.isOn = false;
        data.volume = 0;
    }

}
