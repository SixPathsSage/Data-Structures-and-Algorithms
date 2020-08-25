package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache {
    private Map<Integer, Node> map = new HashMap<>();
    private DataStore store = new DataStore();
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        store.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key) && map.get(key).value == value) {
            Node node = map.get(key);
            store.moveToHead(node);
            return;
        }
        if(map.containsKey(key)) {
            Node node = map.get(key);
            map.get(key).value = value;
            store.moveToHead(node);
            return;
        }
        if(store.getSize() == capacity) {
            evict();
        }
        Node node = new Node(key, value);
        store.addAtHead(node);
        map.put(key, node);
        store.increaseSize();
    }

    private void evict() {
        Node tail = store.getTail();
        store.removeAtTail();
        map.remove(tail.key);
        store.decreaseSize();
        System.out.println("Evicted : " + tail);
    }
}