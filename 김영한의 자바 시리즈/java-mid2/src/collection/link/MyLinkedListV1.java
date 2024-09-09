package collection.link;

public class MyLinkedListV1 {

    private int size;
    private Node first;

    public int size() { return size; }

    public void add(Object item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getLastNode(first);
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getLastNode(Node first) {
        Node cur = first;
        while (cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }

    public Object get(int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.item;
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