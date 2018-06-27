public class Node<K, V> {
    V value;
    K key;
    Node next;
    int hash;

    public Node(K key, V value, int hash, Node next) {
        this.value = value;
        this.key = key;
        this.next = next;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "{ Key : " + key + " Value : " + value + " Hash : " + hash + " Next : " + next+ " }";
    }
}
