package cache;

public class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Key : " + key + ", Value : " + value + " ]";
    }
}
