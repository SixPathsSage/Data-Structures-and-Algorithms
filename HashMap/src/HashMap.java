public class HashMap<K, V> {
    Node<K, V>[] hashMap = new Node[50];

    public int hash(String key)
    {
        return key.hashCode()%32;
    }

    public Node get(String key)
    {
        int hash = hash(key);
        Node<K, V> node = hashMap[hash];
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

    public void put(String key, int value)
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
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Test", 24);
        System.out.println(hashMap.get("Test").toString());
    }
}
