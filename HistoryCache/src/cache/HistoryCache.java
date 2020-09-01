package cache;

import java.util.*;
import java.util.stream.Collectors;

/*
* Problem Statement:
*   Implement a data structure to save the recently visited url without duplicate removed,
* and retrieve in reverse insertion order, having a fixed size and evict the entry when the data structure
* overflows
*  */
public class HistoryCache {
    private LinkedList<String> list;
    private HashSet<String> set;
    private int capacity;

    public HistoryCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.set = new HashSet<>();
    }

    public void saveUrl(String url) {
        if(list.size() == capacity) {
            evict();
        }

        if(set.contains(url)) {
            list.remove(url);
        }

        list.addFirst(url);
        set.add(url);
    }

    public List<String> getUrls() {
        return list;
    }

    private void evict() {
        String url = list.removeLast();
        set.remove(url);
    }
}
