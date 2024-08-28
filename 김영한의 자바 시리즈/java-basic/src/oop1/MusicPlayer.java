package oop1;

// 객체가 속성과 기능을 모두 포함하고 있음, 인스턴스만 생성해도 온전히 이용 가능
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    void startMusicPlayer() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }

    void endMusicPlayer() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
    }

    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨: " + volume);
    }

    void checkMusicPlayer() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨: " + volume);
        } else {
            System.out.println("음악 플레이어 OFF, 볼륨: " + volume);
        }
    }

}
