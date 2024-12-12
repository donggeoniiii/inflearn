package oop1;

// 객체지향 프로그래밍
public class MusicPlayerMain4 {
    public static void main(String[] args) {
        /*
        1. 음악 플레이어 전원 켜고 끌 수 있어야 함
        2. 볼륨을 조절할 수 있어야 함
        3. 상태 확인(전원, 볼륨)이 가능해야 함
         */

        // 음악 플레이어 기능에 필요한 변수가 모은 클래스 사용, 관리가 쉬워짐
        MusicPlayer data = new MusicPlayer();

        // 음악 플레이어 켜기
        data.startMusicPlayer();

        // 볼륨 증가, 감소
        data.volumeUp();
        data.volumeUp();
        data.volumeDown();

        // 음악 플레이어 상태
        data.checkMusicPlayer();

        // 음악 플레이어 끄기
        data.endMusicPlayer();
    }
}
