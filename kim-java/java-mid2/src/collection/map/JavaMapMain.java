package collection.map;

import java.util.*;

public class JavaMapMain {

    public static void main(String[] args) {
        /* 
        Map == 옆에 value가 딸린 Set
        그냥 Entry 라는 형태로 값이 Set에 들어가있다고 생각하자
        key가 될 값은 중복 처리를 위해 hashCode(), equals() 재정의 필요
        */
        
        // 중복 x, 순서 x
        run(new HashMap<>()); // [A, 30] [1, 40] [B, 20] [2, 50] [C, 10]

        // 중복 x, 순서 o
        run(new LinkedHashMap<>()); // [C, 10] [B, 20] [A, 30] [1, 40] [2, 50]

        // 중복 x, 정렬 제공
        run(new TreeMap<>()); // [1, 40] [2, 50] [A, 30] [B, 20] [C, 10]
    }

    private static void run(Map<String, Integer> map) {
        System.out.println(map.getClass());
        map.put("C", 10);
        map.put("B", 20);
        map.put("A", 30);
        map.put("1", 40);
        map.put("2", 50);

        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
		for (String key : keySet) {
            sb.append("[").append(key).append(", ").append(map.get(key)).append("] ");
		}
        System.out.println(sb);
    }
}