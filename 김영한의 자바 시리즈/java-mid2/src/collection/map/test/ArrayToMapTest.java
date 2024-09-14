package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        // 주어진 배열로부터 Map 생성
        Map<String, String> map = new HashMap<>();
        for (String[] product : productArr) {
            map.put(product[0], product[1]);
        }

        // Map의 모든 데이터 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("제품: ").append(entry.getKey())
                .append(", 가격: ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}