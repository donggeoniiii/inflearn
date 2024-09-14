package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain2 {

    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        String studentName = "studentA";
        studentMap.put(studentName, 90);
        System.out.println(studentMap.get(studentName)); // 90

        // 같은 키에 저장시 기존 값 교체
        studentMap.put(studentName, 100);
        System.out.println(studentMap.get(studentName)); // 100

        System.out.println(studentMap.containsKey("studentA")); // true

        // 중복 저장되는 것이 아님
        studentMap.remove(studentName);
        System.out.println(studentMap.isEmpty()); // true

        // 학생이 없는 경우에만 추가하기
        if (!studentMap.containsKey(studentName)) {
            studentMap.put(studentName, 100);
        }
        System.out.println(studentMap); // {studentA=100}

        // putIfAbsent() == containsKey() = false 확인 후 입력
        String studentName2 = "studentB";
        studentMap.putIfAbsent(studentName, 80); // 안 들어감
        studentMap.putIfAbsent(studentName2, 100);
        System.out.println(studentMap); // {studentB=100, studentA=100}
    }
}