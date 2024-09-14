package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/** LinkedList는 Deque와 List를 모두 구현한 클래스
 ArrayDeque vs LinkedList -> ArrayList와 LinkedList의 차이와 동일
 이론적으론 LinkedList가 더 좋은 부분이 있을 수 있어도 ArrayDeque가 최적화에 유리
 */
public class DequeQueueMain {

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        // 데이터 추가
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // 꺼내질 순서대로 정렬
        System.out.println(queue); // [1, 2, 3]

        // 다음 꺼낼 데이터 조회
        System.out.println(queue.peek()); // 1

        // 데이터 꺼내기
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.poll()); // 3
        System.out.println(queue.isEmpty()); // true
    }
}