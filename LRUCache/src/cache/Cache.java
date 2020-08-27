package cache;

public interface Cache {
    public int get(int key);
    public void put(int key, int value);
}
