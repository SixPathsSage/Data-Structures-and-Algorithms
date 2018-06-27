public class HashMap<K, V> {
    private Node<K, V>[] hashMap = new Node[50];

    public <K> int hash(K key)
    {
        return key.hashCode()%32;
    }

    public Node get(K key)
    {
        int hash = hash(key);
        Node<K, V> node = hashMap[hash];
        if(node == null)
        {
            return null;
        }
        if(node.key == key)
        {
            return node;
        }
        else {
            while(node.next != null)
            {
                Node newNode = node.next;
                if(newNode.key == key)
                {
                    return newNode;
                }
            }
        }
        return null;
    }

    public void put(K key,V value)
    {
        int hash = hash(key);
        Node<K, V> node = new Node(key, value, hash, null);
        if(hash < hashMap.length)
        {
            if(hashMap[hash] == null)
            {
                hashMap[hash] = node;
            }
            else if (hashMap[hash].key == key )
            {
                node.next = hashMap[hash].next;
                hashMap[hash] = node;
            }
            else
            {
                hashMap[hash].next = node;
            }
        }
        else
        {
            System.out.println("Hash Out of Range");
        }
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('T', 24);
        System.out.println(hashMap.get('T'));
    }
}
