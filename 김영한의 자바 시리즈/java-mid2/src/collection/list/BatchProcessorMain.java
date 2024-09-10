package collection.list;

public class BatchProcessorMain {
    public static void main(String[] args) {
        // 런타임 의존관계: 생성된 인스턴스와 이를 참조하는 의존관계
        // 실행 중 계속 변할 수 있음
        // 의존관계 주입: LinkedList (맨 앞에 입력 (O(1))
        BatchProcessor processor1 = new BatchProcessor(new MyArrayList<>());
        processor1.logic(50_000); // 1432ms

        // 의존관계 주입: LinkedList (맨 앞에 입력 (O(1))
        BatchProcessor processor2 = new BatchProcessor(new MyLinkedList<>());
        processor2.logic(50_000); // 3ms
    }
}