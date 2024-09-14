package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain1 {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();

        students.put("studentA", 90);
        students.put("studentB", 80);
        students.put("studentC", 80);
        students.put("studentD", 100);
        // 순서 보장 안됨
        System.out.println(students); // {studentB=80, studentA=90, studentD=100, studentC=80}

        // 특정 학생의 값 조회
        int result = students.get("studentD");
        System.out.println(result); // 100

        // keySet() -> Set<K> 반환
        for (String key : students.keySet()) {
            int value = students.get(key);
            System.out.printf("[%s, %d]\n", key, value);
        }

        // entrySet() -> Map.Entry<K, V> 반환
        // Entry는 Map 내에 있는 인터페이스
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("[%s, %d]\n", key, value);
        }

        // values() -> Collection<V> 반환
        // 값은 중복될 수 있고, 순서를 보장하지 않으므로 set도 list도 안됨
        for (Integer value : students.values()) {
            System.out.println(value);
        }

    }
}