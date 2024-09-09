package collection.link;

public class MyLinkedListV2 {

    private int size;
    private Node first;

    public int size() { return size; }

    public void add(Object item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getNode(first, size-1);
            lastNode.next = newNode;
        }
        size++;
    }

    public void add(int index, Object item) {
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node prev = getNode(first, index - 1);

            newNode.next = prev.next;
            prev.next = newNode;
        } // if-else

        size++;
    }

    private Node getNode(Node first, int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    public Object get(int index) {
        return getNode(first, index).item;
    }

    public int indexOf(Object item) {
        Node cur = first;
        int idx = 0;
        while (cur != null) {
            if (cur.item.equals(item)) {
                return idx;
            }
            cur = cur.next;
            idx++;
        }

        return -1;
    }

    public Object set(int index, Object item) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Object oldItem = cur.item;
        cur.item = item;

        return oldItem;
    }

    public Object remove(int index) {
        Object removedItem;
        if (index == 0) {
            removedItem = first.item;
            first = first.next;
        }
        else {
            Node prev = getNode(first, index - 1);

            // 객체가 참조되지 못하게 변경
            Node cur = prev.next;
            removedItem = cur.item;
            cur.item = null;
            cur.next = null;

            // 이전과 다음 노드를 연결
            prev.next = prev.next.next;
        }

        size--;
        return removedItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = first;
        sb.append("Node: [");
        while (cur != null) {
            sb.append(cur.item);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("], ");

        sb.append("size = ").append(size);

        return sb.toString();
    }
}