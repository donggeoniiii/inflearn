package collection.list;

public class BatchProcessor {

    // 구체적인 클래스를 사용: 특정 클래스에 의존함
    // private final MyArrayList<Integer> list;
    // private final MyLinkedList<Integer> list;

    // 추상적인 인터페이스에 의존해 특정 클래스 의존성 탈피
    private final MyList<Integer> list;

    // 의존관계 주입(DI): 외부에서 의존 관계가 주입됨
    // 생성자를 통한 의존관계 주입
    // 구체적인 사안을 런타임 시점으로 결정하게 미루는 것이 재사용성을 높인다
    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i); // 앞에 추가
        }
        long endTime = System.currentTimeMillis();
        System.out.println("계산 시간: " + (endTime - startTime) + "ms");
    }

}