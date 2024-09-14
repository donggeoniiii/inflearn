package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> dictionary = new HashMap<>();

        // 단어 입력
        System.out.println("==단어 입력 단계==");
        while (true){
            System.out.print("영어 단어를 입력하세요 (종료는 'q'): ");
            String eng = input.nextLine();

            if (eng.equals("q")) {
                break;
            }

            System.out.print("한글 뜻을 입력하세요: ");
            String kor = input.nextLine();

            dictionary.put(eng, kor);
        }

        // 단어 검색
        System.out.println("== 단어 검색 단계==");
        while (true) {
            System.out.print("찾을 영어 단어를 입력하세요 (종료는 'q'): ");
            String search = input.nextLine();

            if (search.equals("q")) {
                break;
            }

            if (!dictionary.containsKey(search)) {
                System.out.println(search + "은(는) 사전에 없는 단어입니다.");
                continue;
            }

            System.out.println(search + "의 뜻: " + dictionary.get(search));
        }
    }
}