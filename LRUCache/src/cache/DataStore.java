package cache;

public class DataStore {
    private Node head;
    private Node tail;
    private int size;

    public void addAtHead(Node node) {
        removeReferences(node);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void removeAtTail() {
        if(tail.prev == null) {
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void moveToHead(Node node) {
        if(node == head) { return; }
        if(node == tail) {
            removeAtTail();
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        removeReferences(node);
        addAtHead(node);
    }

    private void removeReferences(Node node) {
        node.next = null;
        node.prev = null;
    }

    public int getSize() { return size; }

    public void increaseSize() { size ++; }

    public void decreaseSize() { size --; }

    public Node getHead() { return head; }

    public Node getTail() { return tail; }
}
