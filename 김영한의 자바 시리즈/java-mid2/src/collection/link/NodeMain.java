package collection.link;

public class NodeMain {

    public static void main(String[] args) {
        // 노드 생성하고 연결: A -> B -> C
        Node first = new Node("A");
        // 참조값을 타고 이런 식으로도 가능
        first.next = new Node("B");
        first.next.next = new Node("C");

        // 모든 노드 탐색
        System.out.println("모든 노트 탐색하기");
        printAll(first); // A B C

        // 마지막 노드 조회
        Node lastNode = getLastNode(first);
        System.out.println(lastNode); // C

        // 특정 index의 노드 조회
        int index = 2;
        Node index2Node = getNode(first, index);
        System.out.println(index2Node.item); // C

        // 데이터 추가
        add(first, "D");
        System.out.println(first); // A -> B -> C -> D
        add(first, "E");
        System.out.println(first); // A -> B -> C -> D -> E
        add(first, "F");
        System.out.println(first); // A -> B -> C -> D -> E -> F
    }

    private static void printAll(Node first) {
        StringBuilder sb = new StringBuilder();

        Node cur = first;
        while (cur != null) {
            sb.append(cur.item).append(" ");
            cur = cur.next;
        }

        System.out.println(sb);
    }

    private static Node getLastNode(Node first) {
        Node cur = first;

		while (cur.next != null) {
			cur = cur.next;
		}

        return cur;
    }

    private static void add(Node first, String item) {
        Node lastNode = getLastNode(first);
		lastNode.next = new Node(item);
    }

    private static Node getNode(Node first, int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur;
    }
}