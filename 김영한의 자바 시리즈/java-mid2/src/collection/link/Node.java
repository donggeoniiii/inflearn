package collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

/*
    // IDE 생성 toString()으로는 연결 정보가 깔끔하게 안나옴
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = this;
        while (cur != null) {
            sb.append(cur.item);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        return sb.toString();
    }
}
