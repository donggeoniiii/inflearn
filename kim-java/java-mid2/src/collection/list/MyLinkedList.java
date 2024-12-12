package collection.list;

// 컴파일 타임 의존 관계: 자바 컴파일러가 보는 의존관계, 소스 코드에서 정적으로 확인 가능
// 자식은 부모에 의존한다(코드 상에 extends, implements 키워드로 드러남)
public class MyLinkedList<E> implements MyList<E> {
    
    private int size;
    private Node<E> first;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
        }
    }

    public int size() { return size; }

    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getNode(first, size-1);
            lastNode.next = newNode;
        }
        size++;
    }

    public void add(int index, E item) {
        Node<E> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(first, index - 1);

            newNode.next = prev.next;
            prev.next = newNode;
        } // if-else

        size++;
    }

    private Node<E> getNode(Node<E> first, int index) {
        Node<E> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    public E get(int index) {
        return getNode(first, index).item;
    }

    public int indexOf(E item) {
        Node<E> cur = first;
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

    public E set(int index, E item) {
        Node<E> cur = getNode(first, index);

        E oldItem = cur.item;
        cur.item = item;

        return oldItem;
    }

    public E remove(int index) {
        E removedItem;
        if (index == 0) {
            removedItem = first.item;
            first = first.next;
        }
        else {
            Node<E> prev = getNode(first, index - 1);

            Node<E> removedNode = prev.next;

            // 이전과 다음 노드를 연결
            prev.next = prev.next.next;

            // 해당 노드 정보 삭제
            removedItem = removedNode.item;
            removedNode.item = null;
            removedNode.next = null;
        }

        size--;

        return removedItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = first;
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